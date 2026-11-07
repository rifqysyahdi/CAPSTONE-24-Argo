package controller;

import repository.Wilayah;
import java.sql.*;

/**
 * Pembantu untuk skema argoport_db (tanpa kolom wilayah/kapasitas/foto).
 * Wilayah diturunkan dari huruf awal kode dermaga: N=Balikpapan, A=Samarinda, G=Bontang, T=Tanah Grogot, U=Berau.
 */
final class SkemaDb {
    private SkemaDb() {}

    private static final String[][] PETA = {
        {"N", "Balikpapan"}, {"A", "Samarinda"}, {"G", "Bontang"}, {"T", "Tanah Grogot"}, {"U", "Berau"}};

    static String huruf(String wilayah) {
        if (wilayah == null) return null;
        for (String[] p : PETA) if (p[1].equalsIgnoreCase(wilayah.trim())) return p[0];
        return null;
    }

    static String wilayahDariKode(String kode) {
        if (kode == null || kode.isBlank()) return null;
        String h = kode.trim().substring(0, 1).toUpperCase();
        for (String[] p : PETA) if (p[0].equals(h)) return p[1];
        return null;
    }

    private static boolean terbatas() { String w = Wilayah.aktif(); return w != null && !w.isBlank(); }

    /** " AND kolom LIKE 'N%'" untuk wilayah akun aktif; kosong untuk akun pusat. Wilayah tak dikenal -> tidak ada data. */
    static String dermagaDiWilayah(String kolom) {
        if (!terbatas()) return "";
        String h = huruf(Wilayah.aktif());
        return h == null ? " AND 1=0" : " AND " + kolom + " LIKE '" + h + "%'";
    }

    /** Kapal dianggap milik wilayah bila pernah punya jadwal sandar di dermaga wilayah itu (kapal Antre terlihat semua wilayah bila diminta). */
    static String kapalDiWilayah(String alias, boolean termasukAntre) {
        if (!terbatas()) return "";
        String h = huruf(Wilayah.aktif());
        if (h == null) return " AND 1=0";
        return " AND (EXISTS (SELECT 1 FROM jadwal_sandar jw WHERE jw.Kapal_id_kapal=" + alias + ".id_kapal AND jw.Dermaga_id_dermaga LIKE '" + h + "%')"
                + (termasukAntre ? " OR " + alias + ".status_kapal='Antre'" : "") + ")";
    }

    /** Slot milik wilayah bila operator penanggung jawabnya bertugas di dermaga wilayah itu. */
    static String slotDiWilayah(String kolomOperator) {
        if (!terbatas()) return "";
        String h = huruf(Wilayah.aktif());
        if (h == null) return " AND 1=0";
        return " AND EXISTS (SELECT 1 FROM operator ow WHERE ow.id_pengguna=" + kolomOperator + " AND ow.area_tugas LIKE '" + h + "%')";
    }

    static String kargoDiWilayah(String kolomSlot) {
        if (!terbatas()) return "";
        String h = huruf(Wilayah.aktif());
        if (h == null) return " AND 1=0";
        return " AND " + kolomSlot + " IN (SELECT s.id_slot FROM slot_gudang s JOIN operator ow ON ow.id_pengguna=s.Operator_id_pengguna WHERE ow.area_tugas LIKE '" + h + "%')";
    }

    /** ID berikutnya, mis. awalan "K" + 3 digit -> K025. Nama tabel/kolom hanya konstanta internal. */
    static String idBerikutnya(Connection c, String tabel, String kolom, String awalan, int digit) throws SQLException {
        String sql = "SELECT COALESCE(MAX(CAST(SUBSTRING(" + kolom + "," + (awalan.length() + 1) + ") AS UNSIGNED)),0) FROM " + tabel + " WHERE " + kolom + " LIKE ?";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, awalan + "%");
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return awalan + String.format("%0" + digit + "d", rs.getLong(1) + 1);
            }
        }
    }

    /** Dermaga sedang dipakai bila jadwal sandar terakhir sebuah kapal berstatus Sandar ada di dermaga itu. */
    static boolean dermagaDipakai(Connection c, String idDermaga) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement(
                "SELECT COUNT(*) FROM jadwal_sandar j JOIN kapal k ON k.id_kapal=j.Kapal_id_kapal " +
                "WHERE j.Dermaga_id_dermaga=? AND k.status_kapal='Sandar' AND j.waktu_sandar=" +
                "(SELECT MAX(j2.waktu_sandar) FROM jadwal_sandar j2 WHERE j2.Kapal_id_kapal=k.id_kapal)")) {
            ps.setString(1, idDermaga);
            try (ResultSet rs = ps.executeQuery()) { rs.next(); return rs.getInt(1) > 0; }
        }
    }

    /** Status slot mengikuti isi: tanpa kargo = Kosong, ada kargo = Terisi (Penuh hanya diatur manual lewat ubahStatusSlot). */
    static void segarkanSlot(Connection c, String idSlot) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement(
                "UPDATE slot_gudang SET status_slot=IF((SELECT COUNT(*) FROM kargo WHERE Slot_Gudang_id_slot=?)=0,'Kosong','Terisi') WHERE id_slot=?")) {
            ps.setString(1, idSlot); ps.setString(2, idSlot); ps.executeUpdate();
        }
    }
}