package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** Operasi bersama untuk slot gudang agar sisa kapasitas selalu konsisten dengan kargo yang tersimpan. */
public final class SlotRepository {
    private SlotRepository() {}

    /**
     * Menghitung ulang sisa kapasitas dan status slot dari volume kargo yang ada.
     * Status: Kosong (tanpa kargo), Penuh (sisa <= 0), selain itu Terisi.
     * Kolom status tidak bergantung pada nilai sisa lama, sehingga urutan SET tidak berpengaruh.
     */
    public static void hitungUlang(Connection c, String idSlot) throws SQLException {
        String sql = "UPDATE slot_gudang s SET " +
            "s.status_slot = CASE " +
            "  WHEN (SELECT COUNT(*) FROM kargo k WHERE k.Slot_Gudang_id_slot = s.id_slot) = 0 THEN 'Kosong' " +
            "  WHEN s.kapasitas_volume_m3 - COALESCE((SELECT SUM(k.volume_m3) FROM kargo k WHERE k.Slot_Gudang_id_slot = s.id_slot),0) <= 0 THEN 'Penuh' " +
            "  ELSE 'Terisi' END, " +
            "s.sisa_volume_m3 = s.kapasitas_volume_m3 - COALESCE((SELECT SUM(k.volume_m3) FROM kargo k WHERE k.Slot_Gudang_id_slot = s.id_slot),0) " +
            "WHERE s.id_slot = ?";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, idSlot);
            ps.executeUpdate();
        }
    }

    public static String idBerikutnya(Connection c, String tabel, String kolom, String prefix, int lebar) throws SQLException {
        String sql = "SELECT COALESCE(MAX(CAST(SUBSTRING(" + kolom + "," + (prefix.length() + 1) + ") AS UNSIGNED)),0)+1 FROM " + tabel;
        try (PreparedStatement ps = c.prepareStatement(sql); java.sql.ResultSet rs = ps.executeQuery()) {
            rs.next();
            return prefix + String.format("%0" + lebar + "d", rs.getLong(1));
        }
    }
}
