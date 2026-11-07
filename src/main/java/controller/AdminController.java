package controller;

import repository.DBConnection;
import repository.SlotRepository;
import repository.Wilayah;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Logika menu Admin sesuai flowchart: dermaga, slot gudang, tarif, billing, akun operator, laporan. */
public class AdminController {

    private static String fmt(Timestamp t) { return t == null ? "-" : t.toLocalDateTime().toString().replace('T', ' '); }

    // ===================== Kelola Dermaga =====================
    public List<Object[]> getDaftarDermaga() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_dermaga,nama_dermaga,kapasitas_maksimal,status_dermaga FROM dermaga WHERE 1=1" + Wilayah.dan("wilayah") + " ORDER BY id_dermaga");
             ResultSet rs = Wilayah.jalankan(ps)) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)});
        }
        return out;
    }

    public void tambahDermaga(String kode, String nama, double kapasitasTon) throws Exception {
        if (kode == null || kode.isBlank() || nama == null || nama.isBlank() || kapasitasTon <= 0)
            throw new Exception("Data tidak valid! Kode, nama, dan kapasitas (> 0) wajib diisi.");
        if (kode.trim().length() > 10) throw new Exception("Data tidak valid! Kode dermaga maksimal 10 karakter.");
        String wilayah = Wilayah.wajib();
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM dermaga WHERE id_dermaga=?")) {
                ps.setString(1, kode.trim());
                try (ResultSet rs = ps.executeQuery()) { if (rs.next()) throw new Exception("Data tidak valid! Kode dermaga sudah dipakai."); }
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO dermaga(id_dermaga,nama_dermaga,status_dermaga,kapasitas_maksimal,wilayah) VALUES(?,?,'Tersedia',?,?)")) {
                ps.setString(1, kode.trim()); ps.setString(2, nama.trim()); ps.setDouble(3, kapasitasTon); ps.setString(4, wilayah); ps.executeUpdate();
            }
        }
    }

    public void ubahDermaga(String id, String namaBaru, double kapasitasBaru) throws Exception {
        if (id == null || id.isBlank()) throw new Exception("Pilih dermaga terlebih dahulu.");
        if (namaBaru == null || namaBaru.isBlank() || kapasitasBaru <= 0) throw new Exception("Data tidak valid!");
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "UPDATE dermaga SET nama_dermaga=?,kapasitas_maksimal=? WHERE id_dermaga=?" + Wilayah.dan("wilayah"))) {
            ps.setString(1, namaBaru.trim()); ps.setDouble(2, kapasitasBaru); ps.setString(3, id); Wilayah.ikat(ps, 4);
            if (ps.executeUpdate() == 0) throw new Exception("Dermaga tidak ditemukan.");
        }
    }

    /** Use case "Ubah Status Dermaga": Tersedia / Terisi / Perbaikan. Tidak boleh bertentangan dengan kapal yang sedang sandar. */
    public void ubahStatusDermaga(String id, String status) throws Exception {
        if (id == null || id.isBlank()) throw new Exception("Pilih dermaga terlebih dahulu.");
        if (!List.of("Tersedia", "Terisi", "Perbaikan").contains(status)) throw new Exception("Status dermaga tidak valid.");
        try (Connection c = DBConnection.getConnection()) {
            if (dipakaiKapal(c, id) && !"Terisi".equals(status))
                throw new Exception("Dermaga masih dipakai kapal, status tidak dapat diubah menjadi " + status + ".");
            try (PreparedStatement ps = c.prepareStatement("UPDATE dermaga SET status_dermaga=? WHERE id_dermaga=?" + Wilayah.dan("wilayah"))) {
                ps.setString(1, status); ps.setString(2, id); Wilayah.ikat(ps, 3);
                if (ps.executeUpdate() == 0) throw new Exception("Dermaga tidak ditemukan.");
            }
        }
    }

    private boolean dipakaiKapal(Connection c, String idDermaga) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement(
                "SELECT COUNT(*) FROM jadwal_sandar j JOIN kapal k ON k.id_kapal=j.Kapal_id_kapal " +
                "WHERE j.Dermaga_id_dermaga=? AND j.waktu_lepas IS NULL AND k.status_kapal='Sandar'")) {
            ps.setString(1, idDermaga);
            try (ResultSet rs = ps.executeQuery()) { rs.next(); return rs.getInt(1) > 0; }
        }
    }

    /** Flowchart: cek dermaga tidak sedang dipakai kapal; bila kosong baru dihapus. */
    public void hapusDermaga(String id) throws Exception {
        if (id == null || id.isBlank()) throw new Exception("Pilih dermaga terlebih dahulu.");
        try (Connection c = DBConnection.getConnection()) {
            String status;
            try (PreparedStatement ps = c.prepareStatement("SELECT status_dermaga FROM dermaga WHERE id_dermaga=?" + Wilayah.dan("wilayah"))) {
                ps.setString(1, id); Wilayah.ikat(ps, 2);
                try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) throw new Exception("Dermaga tidak ditemukan."); status = rs.getString(1); }
            }
            if (dipakaiKapal(c, id) || "Terisi".equalsIgnoreCase(status)) throw new Exception("Dermaga Masih Dipakai Kapal!");
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM dermaga WHERE id_dermaga=?")) {
                ps.setString(1, id); ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException ex) {
                throw new Exception("Dermaga memiliki riwayat jadwal sandar sehingga tidak dapat dihapus.");
            }
        }
    }

    // ===================== Kelola Slot Gudang =====================
    public List<Object[]> getDaftarSlot() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_slot,kode_blok,kapasitas_volume_m3,sisa_volume_m3,status_slot,Operator_id_pengguna FROM slot_gudang WHERE 1=1" + Wilayah.dan("wilayah") + " ORDER BY id_slot");
             ResultSet rs = Wilayah.jalankan(ps)) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5), rs.getString(6)});
        }
        return out;
    }

    public void tambahSlotGudang(String kodeBlok, double kapasitasM3, String idOperator) throws Exception {
        if (kodeBlok == null || kodeBlok.isBlank() || kapasitasM3 <= 0) throw new Exception("Data tidak valid!");
        if (idOperator == null || idOperator.isBlank()) throw new Exception("ID operator penanggung jawab wajib diisi.");
        String wilayah = Wilayah.wajib();
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM operator WHERE id_pengguna=?")) {
                ps.setString(1, idOperator.trim());
                try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) throw new Exception("Data tidak valid! ID operator tidak ditemukan."); }
            }
            try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM slot_gudang WHERE kode_blok=?")) {
                ps.setString(1, kodeBlok.trim());
                try (ResultSet rs = ps.executeQuery()) { if (rs.next()) throw new Exception("Data tidak valid! Kode blok sudah dipakai."); }
            }
            String id = SlotRepository.idBerikutnya(c, "slot_gudang", "id_slot", "SG", 2);
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO slot_gudang(id_slot,kode_blok,status_slot,Operator_id_pengguna,kapasitas_volume_m3,sisa_volume_m3,wilayah) VALUES(?,?,'Kosong',?,?,?,?)")) {
                ps.setString(1, id); ps.setString(2, kodeBlok.trim()); ps.setString(3, idOperator.trim());
                ps.setDouble(4, kapasitasM3); ps.setDouble(5, kapasitasM3); ps.setString(6, wilayah); ps.executeUpdate();
            }
        }
    }

    public void ubahKapasitasSlot(String idSlot, double kapasitasBaru) throws Exception {
        if (idSlot == null || idSlot.isBlank()) throw new Exception("Pilih slot gudang terlebih dahulu.");
        if (kapasitasBaru <= 0) throw new Exception("Data tidak valid! Kapasitas harus lebih dari 0.");
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                double terpakai;
                try (PreparedStatement ps = c.prepareStatement(
                        "SELECT COALESCE(SUM(volume_m3),0) FROM kargo WHERE Slot_Gudang_id_slot=?")) {
                    ps.setString(1, idSlot);
                    try (ResultSet rs = ps.executeQuery()) { rs.next(); terpakai = rs.getDouble(1); }
                }
                if (kapasitasBaru < terpakai) throw new Exception("Data tidak valid! Kapasitas baru lebih kecil dari volume terpakai (" + terpakai + " m3).");
                try (PreparedStatement ps = c.prepareStatement("UPDATE slot_gudang SET kapasitas_volume_m3=? WHERE id_slot=?" + Wilayah.dan("wilayah"))) {
                    ps.setDouble(1, kapasitasBaru); ps.setString(2, idSlot); Wilayah.ikat(ps, 3);
                    if (ps.executeUpdate() == 0) throw new Exception("Slot gudang tidak ditemukan.");
                }
                SlotRepository.hitungUlang(c, idSlot);
                c.commit();
            } catch (Exception ex) { c.rollback(); throw ex; } finally { c.setAutoCommit(true); }
        }
    }

    public void hapusSlotGudang(String idSlot) throws Exception {
        if (idSlot == null || idSlot.isBlank()) throw new Exception("Pilih slot gudang terlebih dahulu.");
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM kargo WHERE Slot_Gudang_id_slot=?")) {
                ps.setString(1, idSlot);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); if (rs.getInt(1) > 0) throw new Exception("Slot Gudang Masih Berisi Kargo!"); }
            }
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM slot_gudang WHERE id_slot=?" + Wilayah.dan("wilayah"))) {
                ps.setString(1, idSlot); Wilayah.ikat(ps, 2);
                if (ps.executeUpdate() == 0) throw new Exception("Slot gudang tidak ditemukan.");
            }
        }
    }

    // ===================== Kelola Tarif Retribusi =====================
    // Tarif disimpan per wilayah (tarif_pelabuhan.wilayah). Baris id_tarif=1 (wilayah kosong) jadi tarif bawaan.
    private static final double[] TARIF_BAWAAN = {500000.0, 15000.0};

    /** Tarif untuk satu wilayah; bila belum ada dipakai tarif bawaan (id_tarif=1), lalu nilai default. */
    private double[] bacaTarif(Connection c, String wilayah) throws SQLException {
        if (wilayah != null && !wilayah.isBlank()) {
            try (PreparedStatement ps = c.prepareStatement(
                    "SELECT tarif_tambat_per_hari,tarif_muatan_per_ton FROM tarif_pelabuhan WHERE wilayah=?")) {
                ps.setString(1, wilayah);
                try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return new double[]{rs.getDouble(1), rs.getDouble(2)}; }
            }
        }
        try (PreparedStatement ps = c.prepareStatement(
                "SELECT tarif_tambat_per_hari,tarif_muatan_per_ton FROM tarif_pelabuhan WHERE id_tarif=1");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return new double[]{rs.getDouble(1), rs.getDouble(2)};
        }
        return TARIF_BAWAAN.clone();
    }

    /** @return {tarif tambat per hari, tarif muatan per ton} untuk wilayah akun yang login (akun pusat: tarif bawaan) */
    public double[] getTarif() throws SQLException {
        try (Connection c = DBConnection.getConnection()) { return bacaTarif(c, Wilayah.aktif()); }
    }

    public void updateTarif(double tarifTambat, double tarifMuatan) throws Exception {
        if (tarifTambat <= 0 || tarifMuatan <= 0) throw new Exception("Input Tarif Tidak Valid! Tarif harus lebih dari 0.");
        String wilayah = Wilayah.wajib();
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement(
                    "UPDATE tarif_pelabuhan SET tarif_tambat_per_hari=?,tarif_muatan_per_ton=? WHERE wilayah=?")) {
                ps.setDouble(1, tarifTambat); ps.setDouble(2, tarifMuatan); ps.setString(3, wilayah);
                if (ps.executeUpdate() > 0) return;
            }
            int idBaru;
            try (PreparedStatement ps = c.prepareStatement("SELECT COALESCE(MAX(id_tarif),0)+1 FROM tarif_pelabuhan");
                 ResultSet rs = ps.executeQuery()) { rs.next(); idBaru = rs.getInt(1); }
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO tarif_pelabuhan(id_tarif,tarif_tambat_per_hari,tarif_muatan_per_ton,wilayah) VALUES(?,?,?,?)")) {
                ps.setInt(1, idBaru); ps.setDouble(2, tarifTambat); ps.setDouble(3, tarifMuatan); ps.setString(4, wilayah);
                ps.executeUpdate();
            }
        }
    }

    // ===================== Billing & Pembayaran =====================
    public static final class Tagihan {
        public double tonKargo, tarifMuatan, tarifTambat, total;
        public long hariTambat;
        public String statusBayar = "Belum Ditagih";
        public String idRetribusi;

        public String rincian() {
            return String.format("Muatan : %,.2f ton x Rp %,.2f = Rp %,.2f%nTambat : %d hari x Rp %,.2f = Rp %,.2f%n%nTOTAL  : Rp %,.2f%nStatus : %s",
                    tonKargo, tarifMuatan, tonKargo * tarifMuatan, hariTambat, tarifTambat, hariTambat * tarifTambat, total, statusBayar);
        }
    }

    /** Kapal yang sedang sandar: id, nama, jenis, status bayar. */
    public List<Object[]> getKapalSandar() throws Exception {
        List<Object[]> out = new ArrayList<>();
        List<String[]> kapal = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_kapal,nama_kapal,status_kapal FROM kapal WHERE status_kapal='Sandar'" + Wilayah.dan("wilayah") + " ORDER BY id_kapal");
             ResultSet rs = Wilayah.jalankan(ps)) {
            while (rs.next()) kapal.add(new String[]{rs.getString(1), rs.getString(2), rs.getString(3)});
        }
        try (Connection c = DBConnection.getConnection()) {
            for (String[] k : kapal) {
                Tagihan t = hitungRincian(c, k[0]);
                out.add(new Object[]{k[0], k[1], k[2], t.statusBayar, String.format("%,.2f", t.total)});
            }
        }
        return out;
    }

    /** Rincian otomatis: (Ton Kargo x Tarif Muatan) + (Hari Tambat x Tarif Tambat). */
    public Tagihan hitungRincian(String idKapal) throws Exception {
        try (Connection c = DBConnection.getConnection()) { return hitungRincian(c, idKapal); }
    }

    private Tagihan hitungRincian(Connection c, String idKapal) throws SQLException {
        Tagihan t = new Tagihan();
        String wilayahKapal = null;
        try (PreparedStatement ps = c.prepareStatement("SELECT wilayah FROM kapal WHERE id_kapal=?")) {
            ps.setString(1, idKapal);
            try (ResultSet rs = ps.executeQuery()) { if (rs.next()) wilayahKapal = rs.getString(1); }
        }
        double[] tarif = bacaTarif(c, wilayahKapal); // tarif mengikuti wilayah kapal
        t.tarifTambat = tarif[0]; t.tarifMuatan = tarif[1];
        try (PreparedStatement ps = c.prepareStatement("SELECT COALESCE(SUM(berat_ton),0) FROM kargo WHERE Kapal_id_kapal=?")) {
            ps.setString(1, idKapal);
            try (ResultSet rs = ps.executeQuery()) { rs.next(); t.tonKargo = rs.getDouble(1); }
        }
        Timestamp sandar = null;
        try (PreparedStatement ps = c.prepareStatement(
                "SELECT waktu_sandar,GREATEST(1,DATEDIFF(COALESCE(waktu_lepas,NOW()),waktu_sandar)) FROM jadwal_sandar " +
                "WHERE Kapal_id_kapal=? ORDER BY waktu_sandar DESC LIMIT 1")) {
            ps.setString(1, idKapal);
            try (ResultSet rs = ps.executeQuery()) { if (rs.next()) { sandar = rs.getTimestamp(1); t.hariTambat = rs.getLong(2); } else t.hariTambat = 1; }
        }
        t.total = t.tonKargo * t.tarifMuatan + t.hariTambat * t.tarifTambat;
        // Status bayar untuk masa sandar saat ini: retribusi terakhir pada/ setelah tanggal sandar.
        String sql = "SELECT id_retribusi,status_bayar FROM retribusi WHERE Kapal_id_kapal=? " +
                (sandar != null ? "AND (tanggal_bayar IS NULL OR tanggal_bayar>=?) " : "") + "ORDER BY id_retribusi DESC LIMIT 1";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, idKapal);
            if (sandar != null) ps.setDate(2, new java.sql.Date(sandar.getTime()));
            try (ResultSet rs = ps.executeQuery()) { if (rs.next()) { t.idRetribusi = rs.getString(1); t.statusBayar = rs.getString(2); } }
        }
        return t;
    }

    /**
     * Flowchart Billing. lunas=true: proses transaksi (retribusi Lunas, kapal Berlayar, dermaga Tersedia).
     * lunas=false: status pembayaran dicatat Belum Lunas. Semua perubahan atomik; gagal -> rollback.
     */
    public void prosesPembayaran(String idKapal, String idAdmin, boolean lunas) throws Exception {
        if (idKapal == null || idKapal.isBlank()) throw new Exception("Pilih kapal terlebih dahulu.");
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("SELECT status_kapal FROM kapal WHERE id_kapal=?" + Wilayah.dan("wilayah") + " FOR UPDATE")) {
                    ps.setString(1, idKapal); Wilayah.ikat(ps, 2);
                    try (ResultSet rs = ps.executeQuery()) { if (!rs.next() || !"Sandar".equalsIgnoreCase(rs.getString(1))) throw new Exception("Kapal tidak sedang sandar."); }
                }
                Tagihan t = hitungRincian(c, idKapal);
                if ("Lunas".equalsIgnoreCase(t.statusBayar)) throw new Exception("Retribusi kapal ini sudah lunas.");
                String status = lunas ? "Lunas" : "Belum Lunas";
                if (t.idRetribusi != null) {
                    try (PreparedStatement ps = c.prepareStatement(
                            "UPDATE retribusi SET total_biaya=?,tarif=?,tanggal_bayar=?,status_bayar=?,Admin_id_pengguna=? WHERE id_retribusi=?")) {
                        ps.setDouble(1, t.total); ps.setDouble(2, t.tarifTambat);
                        if (lunas) ps.setDate(3, java.sql.Date.valueOf(LocalDate.now())); else ps.setNull(3, Types.DATE);
                        ps.setString(4, status); ps.setString(5, idAdmin); ps.setString(6, t.idRetribusi); ps.executeUpdate();
                    }
                } else {
                    String id = SlotRepository.idBerikutnya(c, "retribusi", "id_retribusi", "R", 3);
                    try (PreparedStatement ps = c.prepareStatement(
                            "INSERT INTO retribusi(id_retribusi,total_biaya,tarif,tanggal_bayar,status_bayar,Admin_id_pengguna,Kapal_id_kapal) VALUES(?,?,?,?,?,?,?)")) {
                        ps.setString(1, id); ps.setDouble(2, t.total); ps.setDouble(3, t.tarifTambat);
                        if (lunas) ps.setDate(4, java.sql.Date.valueOf(LocalDate.now())); else ps.setNull(4, Types.DATE);
                        ps.setString(5, status); ps.setString(6, idAdmin); ps.setString(7, idKapal); ps.executeUpdate();
                    }
                }
                if (lunas) {
                    String dermaga = null;
                    try (PreparedStatement ps = c.prepareStatement(
                            "SELECT id_jadwal,Dermaga_id_dermaga FROM jadwal_sandar WHERE Kapal_id_kapal=? AND waktu_lepas IS NULL ORDER BY waktu_sandar DESC LIMIT 1")) {
                        ps.setString(1, idKapal);
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                dermaga = rs.getString(2);
                                try (PreparedStatement up = c.prepareStatement("UPDATE jadwal_sandar SET waktu_lepas=NOW() WHERE id_jadwal=?")) {
                                    up.setString(1, rs.getString(1)); up.executeUpdate();
                                }
                            }
                        }
                    }
                    try (PreparedStatement ps = c.prepareStatement("UPDATE kapal SET status_kapal='Berlayar' WHERE id_kapal=?")) { ps.setString(1, idKapal); ps.executeUpdate(); }
                    if (dermaga != null) {
                        try (PreparedStatement ps = c.prepareStatement("UPDATE dermaga SET status_dermaga='Tersedia' WHERE id_dermaga=? AND status_dermaga='Terisi'")) {
                            ps.setString(1, dermaga); ps.executeUpdate();
                        }
                    }
                }
                c.commit();
            } catch (Exception ex) {
                c.rollback();
                throw new Exception("Transaksi Gagal, Data Dikembalikan ke Kondisi Semula! (" + ex.getMessage() + ")");
            } finally { c.setAutoCommit(true); }
        }
    }

    // ===================== Kelola Akun Operator =====================
    // Sumber data: tabel akun_aplikasi (akun yang dipakai login), bukan tabel pengguna/operator lama.

    private static void wajibAdmin() throws Exception {
        if (!DBConnection.isAdminSession()) throw new Exception("Hanya Admin yang dapat mengelola akun operator.");
    }

    private static int parseId(String id) throws Exception {
        try { return Integer.parseInt(id.trim()); }
        catch (Exception ex) { throw new Exception("Pilih akun operator terlebih dahulu."); }
    }

    /** Daftar akun peran Operator: id, nama lengkap, username, status, tanggal daftar. */
    public List<Object[]> getDaftarOperator() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_akun,nama_lengkap,username,status_akun,dibuat_pada FROM akun_aplikasi WHERE peran='Operator'" + Wilayah.dan("wilayah") + " ORDER BY id_akun");
             ResultSet rs = Wilayah.jalankan(ps)) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), fmt(rs.getTimestamp(5))});
        }
        return out;
    }

    /** Memastikan akun ada dan berperan Operator (Admin tidak bisa diubah dari menu ini). */
    private void pastikanOperator(Connection c, int id) throws Exception {
        try (PreparedStatement ps = c.prepareStatement("SELECT peran,wilayah FROM akun_aplikasi WHERE id_akun=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new Exception("Akun operator tidak ditemukan.");
                if (!"Operator".equalsIgnoreCase(rs.getString(1))) throw new Exception("Hanya akun berperan Operator yang dapat dikelola di menu ini.");
                String w = Wilayah.aktif();
                if (w != null && !w.equals(rs.getString(2))) throw new Exception("Akun operator tidak ditemukan.");
            }
        }
    }

    /** Nonaktifkan (aktif=false) atau aktifkan kembali (aktif=true). Akun nonaktif tidak bisa login, datanya tetap utuh. */
    public void ubahStatusAkunOperator(String idAkun, boolean aktif) throws Exception {
        wajibAdmin();
        int id = parseId(idAkun);
        try (Connection c = DBConnection.getConnection()) {
            pastikanOperator(c, id);
            try (PreparedStatement ps = c.prepareStatement("UPDATE akun_aplikasi SET status_akun=? WHERE id_akun=? AND peran='Operator'")) {
                ps.setString(1, aktif ? "Aktif" : "Nonaktif"); ps.setInt(2, id); ps.executeUpdate();
            }
        }
    }

    /**
     * Reset password: dibuat password sementara acak, disimpan sebagai hash baru, dan operator
     * dipaksa menggantinya saat login berikutnya.
     * @return password sementara (teks asli) untuk diberikan admin ke operator; tidak disimpan di mana pun.
     */
    public String resetPasswordOperator(String idAkun) throws Exception {
        wajibAdmin();
        int id = parseId(idAkun);
        String sementara = util.PasswordHasher.passwordSementara();
        String salt = util.PasswordHasher.saltBaru();
        String hash = util.PasswordHasher.hash(sementara, salt);
        try (Connection c = DBConnection.getConnection()) {
            pastikanOperator(c, id);
            try (PreparedStatement ps = c.prepareStatement(
                    "UPDATE akun_aplikasi SET password_hash=?,salt=?,wajib_ganti_sandi=1 WHERE id_akun=? AND peran='Operator'")) {
                ps.setString(1, hash); ps.setString(2, salt); ps.setInt(3, id); ps.executeUpdate();
            }
        }
        return sementara;
    }

    /** Hapus permanen akun operator dari akun_aplikasi. Sebaiknya gunakan Nonaktifkan bila hanya ingin menutup akses. */
    public void hapusAkunOperator(String idAkun) throws Exception {
        wajibAdmin();
        int id = parseId(idAkun);
        try (Connection c = DBConnection.getConnection()) {
            pastikanOperator(c, id);
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM akun_aplikasi WHERE id_akun=? AND peran='Operator'")) {
                ps.setInt(1, id);
                if (ps.executeUpdate() == 0) throw new Exception("Akun operator tidak ditemukan.");
            } catch (SQLIntegrityConstraintViolationException ex) {
                throw new Exception("Akun masih direferensikan data lain sehingga tidak dapat dihapus. Gunakan Nonaktifkan.");
            }
        }
    }

    // ===================== Laporan =====================
    public static final class Laporan {
        public long jumlahKapal; public double totalTonase, totalPendapatan;
        public List<Object[]> detail = new ArrayList<>(); // id retribusi, id kapal, nama kapal, tanggal, total, status
    }

    /** Periode berdasarkan tanggal kedatangan kapal (jumlah kapal, tonase) dan tanggal bayar Lunas (pendapatan). */
    public Laporan buatLaporan(LocalDate mulai, LocalDate akhir) throws Exception {
        if (mulai == null || akhir == null || akhir.isBefore(mulai)) throw new Exception("Periode laporan tidak valid.");
        Laporan l = new Laporan();
        Date m = Date.valueOf(mulai), a = Date.valueOf(akhir);
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement(
                    "SELECT COUNT(*), COALESCE((SELECT SUM(g.berat_ton) FROM kargo g JOIN kapal k2 ON k2.id_kapal=g.Kapal_id_kapal " +
                    "WHERE DATE(k2.waktu_kedatangan) BETWEEN ? AND ?" + Wilayah.dan("k2.wilayah") + "),0) FROM kapal k WHERE DATE(k.waktu_kedatangan) BETWEEN ? AND ?" + Wilayah.dan("k.wilayah"))) {
                int i = 1;
                ps.setDate(i++, m); ps.setDate(i++, a); i = Wilayah.ikat(ps, i);
                ps.setDate(i++, m); ps.setDate(i++, a); Wilayah.ikat(ps, i);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); l.jumlahKapal = rs.getLong(1); l.totalTonase = rs.getDouble(2); }
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "SELECT r.id_retribusi,r.Kapal_id_kapal,k.nama_kapal,r.tanggal_bayar,r.total_biaya,r.status_bayar FROM retribusi r " +
                    "JOIN kapal k ON k.id_kapal=r.Kapal_id_kapal WHERE r.status_bayar='Lunas' AND r.tanggal_bayar BETWEEN ? AND ?" + Wilayah.dan("k.wilayah") + " ORDER BY r.tanggal_bayar,r.id_retribusi")) {
                ps.setDate(1, m); ps.setDate(2, a); Wilayah.ikat(ps, 3);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        l.totalPendapatan += rs.getDouble(5);
                        l.detail.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), String.valueOf(rs.getDate(4)), rs.getDouble(5), rs.getString(6)});
                    }
                }
            }
        }
        return l;
    }

    /** Flowchart: Proses Generate File Laporan (Excel .xlsx). */
    public void eksporLaporan(File file, LocalDate mulai, LocalDate akhir, Laporan l) throws Exception {
        util.XlsxWriter x = new util.XlsxWriter("Laporan", 16, 14, 30, 16, 20, 14);
        String w = Wilayah.aktif();
        x.baris(util.XlsxWriter.sel(util.XlsxWriter.JUDUL, "LAPORAN ARGOPORT"));
        x.baris(util.XlsxWriter.sel(util.XlsxWriter.TEBAL, "Wilayah"), w == null ? "Semua wilayah" : w);
        x.baris(util.XlsxWriter.sel(util.XlsxWriter.TEBAL, "Periode"), mulai + " s/d " + akhir);
        x.baris(util.XlsxWriter.sel(util.XlsxWriter.TEBAL, "Jumlah kapal"), l.jumlahKapal);
        x.baris(util.XlsxWriter.sel(util.XlsxWriter.TEBAL, "Total tonase muatan (ton)"), util.XlsxWriter.sel(util.XlsxWriter.ANGKA, l.totalTonase));
        x.baris(util.XlsxWriter.sel(util.XlsxWriter.TEBAL, "Total pendapatan (Rp)"), util.XlsxWriter.sel(util.XlsxWriter.ANGKA, l.totalPendapatan));
        x.baris();
        String[] kepala = {"ID Retribusi", "ID Kapal", "Nama Kapal", "Tanggal Bayar", "Total Biaya (Rp)", "Status"};
        Object[] hdr = new Object[kepala.length];
        for (int i = 0; i < kepala.length; i++) hdr[i] = util.XlsxWriter.sel(util.XlsxWriter.HEADER, kepala[i]);
        x.baris(hdr);
        for (Object[] r : l.detail)
            x.baris(r[0], r[1], r[2], r[3], util.XlsxWriter.sel(util.XlsxWriter.ANGKA, r[4]), r[5]);
        x.simpan(file);
    }
}
