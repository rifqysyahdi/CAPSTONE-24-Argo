package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Memastikan kolom tambahan ada: foto profil, penanda wajib ganti password, dan wilayah (akun, dermaga, slot gudang, kapal).
 * Setara dengan bagian ALTER di database_migration_wilayah.sql; dijalankan otomatis sekali per sesi aplikasi
 * supaya aplikasi tidak error kalau migrasi lupa dijalankan.
 */
public final class SkemaAkun {
    private static volatile boolean siap = false;
    private SkemaAkun() {}

    public static synchronized void pastikan(Connection c) throws SQLException {
        if (siap) return;
        tambahKolom(c, "akun_aplikasi", "foto_profil", "MEDIUMBLOB NULL");
        tambahKolom(c, "akun_aplikasi", "wajib_ganti_sandi", "TINYINT(1) NOT NULL DEFAULT 0");
        tambahKolom(c, "akun_aplikasi", "wilayah", "VARCHAR(30) NULL");
        for (String t : new String[]{"dermaga", "slot_gudang", "kapal", "tarif_pelabuhan"})
            tambahKolom(c, t, "wilayah", "VARCHAR(30) NOT NULL DEFAULT ''");
        siap = true;
    }

    private static void tambahKolom(Connection c, String tabel, String kolom, String definisi) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement(
                "SELECT 1 FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME=? AND COLUMN_NAME=?")) {
            ps.setString(1, tabel); ps.setString(2, kolom);
            try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return; }
        }
        try (Statement st = c.createStatement()) {
            st.executeUpdate("ALTER TABLE " + tabel + " ADD COLUMN " + kolom + " " + definisi);
        } catch (SQLException ex) {
            throw new SQLException("Kolom " + tabel + "." + kolom + " belum ada dan tidak bisa dibuat otomatis. "
                    + "Jalankan database_migration_wilayah.sql lewat phpMyAdmin. (" + ex.getMessage() + ")", ex);
        }
    }
}
