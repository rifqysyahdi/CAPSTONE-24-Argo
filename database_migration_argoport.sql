-- Jalankan SETELAH mengimpor argoport_db_.sql (MySQL 8.0.x / MariaDB), sebagai root/administrator.
-- Script ini aman dijalankan berulang kali.
USE argoport_db;

-- Akun admin_argo dan operator_argo dibuat melalui CREATE USER (DCL) pada SQL praktikum.
-- Script ini tidak membuat akun MySQL/aplikasi baru.

-- Helper: tambah kolom hanya jika belum ada (kompatibel MySQL 8 & MariaDB).
DROP PROCEDURE IF EXISTS argoport_add_column;
DELIMITER $$
CREATE PROCEDURE argoport_add_column(IN p_table VARCHAR(64), IN p_column VARCHAR(64), IN p_definition VARCHAR(255))
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.COLUMNS
                   WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = p_table AND COLUMN_NAME = p_column) THEN
        SET @ddl = CONCAT('ALTER TABLE `', p_table, '` ADD COLUMN `', p_column, '` ', p_definition);
        PREPARE stmt FROM @ddl;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
    END IF;
END$$
DELIMITER ;

-- Flowchart Kelola Dermaga: kapasitas maksimal (ton).
CALL argoport_add_column('dermaga', 'kapasitas_maksimal', 'DECIMAL(12,2) NOT NULL DEFAULT 10000.00');
-- Flowchart Kelola Blok Gudang: kapasitas volume (m3) dan sisa kapasitas.
CALL argoport_add_column('slot_gudang', 'kapasitas_volume_m3', 'DECIMAL(12,2) NOT NULL DEFAULT 500.00');
CALL argoport_add_column('slot_gudang', 'sisa_volume_m3', 'DECIMAL(12,2) NOT NULL DEFAULT 500.00');
-- Volume kargo agar kapasitas blok gudang (m3) dapat divalidasi saat bongkar muat.
CALL argoport_add_column('kargo', 'volume_m3', 'DECIMAL(12,2) NOT NULL DEFAULT 0.00');
DROP PROCEDURE argoport_add_column;

-- Flowchart Docking: status dermaga yang ditempati kapal adalah "Terisi" (dump awal memakai "Sibuk").
UPDATE dermaga SET status_dermaga = 'Terisi' WHERE status_dermaga = 'Sibuk';

-- Sisa kapasitas dihitung dari volume kargo yang tersimpan (idempotent).
UPDATE slot_gudang s
SET s.sisa_volume_m3 = s.kapasitas_volume_m3 -
    COALESCE((SELECT SUM(k.volume_m3) FROM kargo k WHERE k.Slot_Gudang_id_slot = s.id_slot), 0);

-- Flowchart Billing: tarif tambat per hari dan tarif muatan per ton.
CREATE TABLE IF NOT EXISTS tarif_pelabuhan (
    id_tarif TINYINT NOT NULL PRIMARY KEY,
    tarif_tambat_per_hari DECIMAL(12,2) NOT NULL,
    tarif_muatan_per_ton DECIMAL(12,2) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO tarif_pelabuhan (id_tarif, tarif_tambat_per_hari, tarif_muatan_per_ton)
VALUES (1, 500000.00, 15000.00)
ON DUPLICATE KEY UPDATE id_tarif = id_tarif;

-- Kapal yang masih sandar belum punya waktu lepas; retribusi "Belum Lunas" belum punya tanggal bayar.
ALTER TABLE jadwal_sandar MODIFY COLUMN waktu_lepas DATETIME NULL;
ALTER TABLE retribusi MODIFY COLUMN tanggal_bayar DATE NULL;

-- Hak akses akun DCL yang dipakai aplikasi JDBC.
GRANT ALL PRIVILEGES ON argoport_db.* TO 'admin_argo'@'localhost';

GRANT SELECT ON argoport_db.pengguna      TO 'operator_argo'@'localhost';
GRANT SELECT ON argoport_db.operator      TO 'operator_argo'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON argoport_db.kapal        TO 'operator_argo'@'localhost';
GRANT SELECT, INSERT, UPDATE         ON argoport_db.jadwal_sandar TO 'operator_argo'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON argoport_db.kargo        TO 'operator_argo'@'localhost';
GRANT SELECT, UPDATE                 ON argoport_db.dermaga      TO 'operator_argo'@'localhost';
GRANT SELECT, UPDATE                 ON argoport_db.slot_gudang  TO 'operator_argo'@'localhost';
FLUSH PRIVILEGES;
