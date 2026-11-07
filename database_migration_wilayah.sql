-- ArgoPort v10: pembagian 5 wilayah (Bontang, Balikpapan, Samarinda, Berau, Tanah Grogot).
-- 24 dermaga (5 / 5 / 5 / 4 / 5), 1 admin + operator per wilayah. Jalankan sekali di phpMyAdmin
-- (database argoport_db) SETELAH database_migration_argoport.sql dan database_migration_akun_aplikasi.sql.
-- Aman dijalankan ulang (kolom dicek dulu, data awal memakai INSERT IGNORE).
USE argoport_db;

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

-- Profil dan reset password
CALL argoport_add_column('akun_aplikasi', 'foto_profil', 'MEDIUMBLOB NULL');
CALL argoport_add_column('akun_aplikasi', 'wajib_ganti_sandi', 'TINYINT(1) NOT NULL DEFAULT 0');
-- Wilayah (NULL pada akun_aplikasi = akun pusat, tidak dibatasi wilayah)
CALL argoport_add_column('akun_aplikasi', 'wilayah', 'VARCHAR(30) NULL');
CALL argoport_add_column('dermaga', 'wilayah', "VARCHAR(30) NOT NULL DEFAULT ''");
CALL argoport_add_column('slot_gudang', 'wilayah', "VARCHAR(30) NOT NULL DEFAULT ''");
CALL argoport_add_column('kapal', 'wilayah', "VARCHAR(30) NOT NULL DEFAULT ''");
CALL argoport_add_column('tarif_pelabuhan', 'wilayah', "VARCHAR(30) NOT NULL DEFAULT ''");
DROP PROCEDURE argoport_add_column;

-- 24 dermaga. Nama bisa diganti belakangan lewat menu Kelola Dermaga.
INSERT IGNORE INTO dermaga (id_dermaga, nama_dermaga, status_dermaga, kapasitas_maksimal, wilayah) VALUES
('BTG01','Dermaga Bontang 1','Tersedia',10000.00,'Bontang'),
('BTG02','Dermaga Bontang 2','Tersedia',10000.00,'Bontang'),
('BTG03','Dermaga Bontang 3','Tersedia',10000.00,'Bontang'),
('BTG04','Dermaga Bontang 4','Tersedia',10000.00,'Bontang'),
('BTG05','Dermaga Bontang 5','Tersedia',10000.00,'Bontang'),
('BPN01','Dermaga Balikpapan 1','Tersedia',10000.00,'Balikpapan'),
('BPN02','Dermaga Balikpapan 2','Tersedia',10000.00,'Balikpapan'),
('BPN03','Dermaga Balikpapan 3','Tersedia',10000.00,'Balikpapan'),
('BPN04','Dermaga Balikpapan 4','Tersedia',10000.00,'Balikpapan'),
('BPN05','Dermaga Balikpapan 5','Tersedia',10000.00,'Balikpapan'),
('SMD01','Dermaga Samarinda 1','Tersedia',10000.00,'Samarinda'),
('SMD02','Dermaga Samarinda 2','Tersedia',10000.00,'Samarinda'),
('SMD03','Dermaga Samarinda 3','Tersedia',10000.00,'Samarinda'),
('SMD04','Dermaga Samarinda 4','Tersedia',10000.00,'Samarinda'),
('SMD05','Dermaga Samarinda 5','Tersedia',10000.00,'Samarinda'),
('BRU01','Dermaga Berau 1','Tersedia',10000.00,'Berau'),
('BRU02','Dermaga Berau 2','Tersedia',10000.00,'Berau'),
('BRU03','Dermaga Berau 3','Tersedia',10000.00,'Berau'),
('BRU04','Dermaga Berau 4','Tersedia',10000.00,'Berau'),
('TGR01','Dermaga Tanah Grogot 1','Tersedia',10000.00,'Tanah Grogot'),
('TGR02','Dermaga Tanah Grogot 2','Tersedia',10000.00,'Tanah Grogot'),
('TGR03','Dermaga Tanah Grogot 3','Tersedia',10000.00,'Tanah Grogot'),
('TGR04','Dermaga Tanah Grogot 4','Tersedia',10000.00,'Tanah Grogot'),
('TGR05','Dermaga Tanah Grogot 5','Tersedia',10000.00,'Tanah Grogot');

-- 5 admin + 24 operator. Password awal semua akun: 123 (sementara, untuk uji coba).
-- wajib_ganti_sandi=1 sehingga tiap akun diminta ganti password saat login pertama
-- (password baru minimal 8 karakter). Untuk menonaktifkan paksaan itu:
--   UPDATE akun_aplikasi SET wajib_ganti_sandi=0 WHERE wilayah IS NOT NULL;
INSERT IGNORE INTO akun_aplikasi (nama_lengkap, username, password_hash, salt, peran, status_akun, wilayah, wajib_ganti_sandi) VALUES
('Admin Bontang','admin_bontang','mpUZSVaL+XZ+8QAP0sOu1IoXXMd0G0NN224S/A3oXcE=','ecxaRPgSzo1CSEABDBbdSA==','Admin','Aktif','Bontang',1),
('Operator Bontang 1','op_bontang_1','Kqq6Ww+R7jRJ8pmikrvaT7bHHrQloBaRkIO25kYyFVc=','7feTO7ZyWF1z7oA3NNpU2w==','Operator','Aktif','Bontang',1),
('Operator Bontang 2','op_bontang_2','iiti+GB9LgpZLo7v2S+exvFaFTDEdxr8HpP5806T5f8=','c5BKE1pyWaU1BwL8+Ais4Q==','Operator','Aktif','Bontang',1),
('Operator Bontang 3','op_bontang_3','bKkyDqhqbA3Rn2mazOOWhsb7WCC5ivdLKub0ZGEzm8I=','zNMycHnURDxy/VyAe9Krfw==','Operator','Aktif','Bontang',1),
('Operator Bontang 4','op_bontang_4','pUQU1lPlC75GvhR2f46vhwzJAHoHEuQCecrglPAEnl8=','+yeL1DIRafMDTumxwG+obA==','Operator','Aktif','Bontang',1),
('Operator Bontang 5','op_bontang_5','UI9jcNp5T9mCwFGGIlG/twRp89oP2Wqfp6p2UVVrzrg=','KoIa1oRpgeqYRTypBcS5gQ==','Operator','Aktif','Bontang',1),
('Admin Balikpapan','admin_balikpapan','bTYhFVgFzNaSUsQ9OgQI8v65EOpk6WS8/izaDKm8sqs=','aQRbDVaHmmCJSsiwfyQQBw==','Admin','Aktif','Balikpapan',1),
('Operator Balikpapan 1','op_balikpapan_1','SWsZtqwO4nzrf+Bhfb/HIN5e3EvhC/Ukg1fWWNTlT4k=','dv9u0yaYRSjtaOips9+5lQ==','Operator','Aktif','Balikpapan',1),
('Operator Balikpapan 2','op_balikpapan_2','IxBkoGdsXgAVdRCoXO+UcZrOrsei62Nw0++l+H3kexw=','Wk6Y8oPIK4EjOp2OAJ2dCg==','Operator','Aktif','Balikpapan',1),
('Operator Balikpapan 3','op_balikpapan_3','BxdXWC7tVvHs49zldRcah6LbpR/NIVHrLm8/JM29iEw=','GmcHEvl0UIiSK9Sla6TUMQ==','Operator','Aktif','Balikpapan',1),
('Operator Balikpapan 4','op_balikpapan_4','eHOQwyjNnNvtyljtxksqDxTKqH3BrK7uI2R3pkOnwmE=','Nz1K/R7ZxkizVCciEVf0yQ==','Operator','Aktif','Balikpapan',1),
('Operator Balikpapan 5','op_balikpapan_5','hEpxHtqpmZTIy6FwlpQwl84d0jmDEPIpTPbq5CpY3y0=','FK/EZ4OTfhcq3LQnrPgp/Q==','Operator','Aktif','Balikpapan',1),
('Admin Samarinda','admin_samarinda','NF256MVM5VLezsD1wNm1BiAf1ZW8AyhZqizXE8inGEg=','rG3Trtu5qxNnpRCUpJQygg==','Admin','Aktif','Samarinda',1),
('Operator Samarinda 1','op_samarinda_1','llLDx3rOmJdur4kIFGkbdUrdMjr0V4a559+a7u9DSnw=','Gc8DbWXtok+Cf10HNbIUlw==','Operator','Aktif','Samarinda',1),
('Operator Samarinda 2','op_samarinda_2','aFmDokMgKfK3lUEQugkkevJziQZj2IcxlHknZF17960=','C798hXrRMUz4H7iywdCaTQ==','Operator','Aktif','Samarinda',1),
('Operator Samarinda 3','op_samarinda_3','NVdd5fBuxjhKjV3VR6F7+4hnyLTXJwpNpvjZUkxfXxA=','BpAJFMhmHBfqAK3ZauKDzA==','Operator','Aktif','Samarinda',1),
('Operator Samarinda 4','op_samarinda_4','LzN3H3o/D74r1KWBpmqpizw8DhQeRnmDmzlGoPxjcFU=','89PrEwOsH20oj6u3OgcvoQ==','Operator','Aktif','Samarinda',1),
('Operator Samarinda 5','op_samarinda_5','nHnASvGvkFR0osEpQaGERNxMCLA0WwLozvikQv6zZLg=','KtFywAX/HZfnQV68UZ9OeQ==','Operator','Aktif','Samarinda',1),
('Admin Berau','admin_berau','XQAbXSH9Hd9Nx4LdmGCs2vLYc0ao+oXT0S/bRpcZxZs=','y8roOFA66YN7oLWIM+CMbQ==','Admin','Aktif','Berau',1),
('Operator Berau 1','op_berau_1','vk0mQt8SZLQ1z3b27YYonT1heTxpR6EY6FFwvFmoTHc=','g1/DgRYgiWiqTFWhQbUSaQ==','Operator','Aktif','Berau',1),
('Operator Berau 2','op_berau_2','l1BIvslW15k76biVQma0GIQu04+hQidv2lzMtCCoSQo=','FQFpN/R11/PfLtWFNBzXDg==','Operator','Aktif','Berau',1),
('Operator Berau 3','op_berau_3','mii18x+U31NBEzFzuD2P+kSLQQZySBj1wGy0rF+hCjI=','5bGR+h6g2AMDXX/WufzSEg==','Operator','Aktif','Berau',1),
('Operator Berau 4','op_berau_4','qRoPfBuA1CZLdH2C1zPnCa3kiselBR5MfSX241GwLnk=','u6oKKuEzYiXwFg9z6E6Czw==','Operator','Aktif','Berau',1),
('Admin Tanah Grogot','admin_tanahgrogot','Dibs5vqxn/PMl6hOALK4pLiQ4uzanCDB9ARiYwuZWio=','ObufWY/6DeGUhCCeOzU8Eg==','Admin','Aktif','Tanah Grogot',1),
('Operator Tanah Grogot 1','op_tanahgrogot_1','ggzpNtaeWbBAM1O4yCT8v78yhbGRC8LMhfixzQlgk2Q=','qBYD5jjR6QG+TX4PSC+Skg==','Operator','Aktif','Tanah Grogot',1),
('Operator Tanah Grogot 2','op_tanahgrogot_2','HhJjP5SJgqUbv5G2yy7L11vtZE+aM7r5N9VXSU7YpW4=','zufxMcPYuaZdm10oJ9t4LA==','Operator','Aktif','Tanah Grogot',1),
('Operator Tanah Grogot 3','op_tanahgrogot_3','Z+CmW0d4eSbEKZS4EiFi7YsPSUnCLLfklIZeYNa8TdY=','mgCgDH4L0QUx+SdaCVzzrA==','Operator','Aktif','Tanah Grogot',1),
('Operator Tanah Grogot 4','op_tanahgrogot_4','3e88vghyAxCIa05NQI0c2RUAmojmf8ephhLuG2EVAwI=','VDyQf9aADxe5jePf+9k6Kg==','Operator','Aktif','Tanah Grogot',1),
('Operator Tanah Grogot 5','op_tanahgrogot_5','LRuS5NxY5ZvZl9VFxzbV51aGHaH9B6FIoQRjtRgFBbU=','22C+EfIzhyUuHXx87cezfw==','Operator','Aktif','Tanah Grogot',1);

-- Tarif retribusi per wilayah: tiap wilayah mulai dari salinan tarif bawaan (baris id_tarif=1).
-- Admin tiap wilayah lalu mengubah tarifnya sendiri lewat menu Kelola Tarif.
INSERT IGNORE INTO tarif_pelabuhan (id_tarif, tarif_tambat_per_hari, tarif_muatan_per_ton, wilayah)
  SELECT 2,tarif_tambat_per_hari,tarif_muatan_per_ton,'Bontang' FROM tarif_pelabuhan WHERE id_tarif=1;
INSERT IGNORE INTO tarif_pelabuhan (id_tarif, tarif_tambat_per_hari, tarif_muatan_per_ton, wilayah)
  SELECT 3,tarif_tambat_per_hari,tarif_muatan_per_ton,'Balikpapan' FROM tarif_pelabuhan WHERE id_tarif=1;
INSERT IGNORE INTO tarif_pelabuhan (id_tarif, tarif_tambat_per_hari, tarif_muatan_per_ton, wilayah)
  SELECT 4,tarif_tambat_per_hari,tarif_muatan_per_ton,'Samarinda' FROM tarif_pelabuhan WHERE id_tarif=1;
INSERT IGNORE INTO tarif_pelabuhan (id_tarif, tarif_tambat_per_hari, tarif_muatan_per_ton, wilayah)
  SELECT 5,tarif_tambat_per_hari,tarif_muatan_per_ton,'Berau' FROM tarif_pelabuhan WHERE id_tarif=1;
INSERT IGNORE INTO tarif_pelabuhan (id_tarif, tarif_tambat_per_hari, tarif_muatan_per_ton, wilayah)
  SELECT 6,tarif_tambat_per_hari,tarif_muatan_per_ton,'Tanah Grogot' FROM tarif_pelabuhan WHERE id_tarif=1;

-- Dermaga/slot/kapal lama (sebelum pembagian wilayah) punya wilayah kosong sehingga tidak tampil
-- di akun wilayah mana pun. Tentukan wilayahnya, contoh:
--   UPDATE dermaga SET wilayah='Bontang' WHERE wilayah='' AND id_dermaga IN ('D01','D02');
--   UPDATE slot_gudang SET wilayah='Bontang' WHERE wilayah='';
--   UPDATE kapal SET wilayah='Bontang' WHERE wilayah='';
