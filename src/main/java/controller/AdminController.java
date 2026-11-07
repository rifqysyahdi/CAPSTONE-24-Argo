package controller;

import repository.DBConnection;
import repository.Wilayah;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/** Menu Admin: dermaga, slot gudang, tarif, billing, akun operator, laporan (sesuai skema argoport_db). */
public class AdminController {

    private static String fmt(Timestamp t) { return t == null ? "-" : t.toLocalDateTime().toString().replace('T', ' '); }

    // ===================== Kelola Dermaga =====================
    /** Kolom: id, nama, status. */
    public List<Object[]> getDaftarDermaga() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_dermaga,nama_dermaga,status_dermaga FROM dermaga WHERE 1=1" + SkemaDb.dermagaDiWilayah("id_dermaga") + " ORDER BY id_dermaga");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
        }
        return out;
    }

    /** Kompatibilitas: kapasitas tidak punya kolom di database sehingga diabaikan. */
    @Deprecated
    public void tambahDermaga(String kode, String nama, double kapasitasTon) throws Exception { tambahDermaga(kode, nama); }

    public void tambahDermaga(String kode, String nama) throws Exception {
        if (kode == null || kode.isBlank() || nama == null || nama.isBlank()) throw new Exception("Data tidak valid! Kode dan nama wajib diisi.");
        String k = kode.trim().toUpperCase();
        if (k.length() > 10) throw new Exception("Data tidak valid! Kode dermaga maksimal 10 karakter.");
        if (nama.trim().length() > 50) throw new Exception("Data tidak valid! Nama dermaga maksimal 50 karakter.");
        String w = Wilayah.aktif();
        if (w != null && !w.isBlank()) {
            String h = SkemaDb.huruf(w);
            if (h == null || !k.startsWith(h)) throw new Exception("Data tidak valid! Kode dermaga wilayah " + w + " harus diawali huruf " + h + ".");
        }
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM dermaga WHERE id_dermaga=?")) {
                ps.setString(1, k);
                try (ResultSet rs = ps.executeQuery()) { if (rs.next()) throw new Exception("Data tidak valid! Kode dermaga sudah dipakai."); }
            }
            try (PreparedStatement ps = c.prepareStatement("INSERT INTO dermaga(id_dermaga,nama_dermaga,status_dermaga) VALUES(?,?,'Tersedia')")) {
                ps.setString(1, k); ps.setString(2, nama.trim()); ps.executeUpdate();
            }
        }
    }

    @Deprecated
    public void ubahDermaga(String id, String namaBaru, double kapasitasBaru) throws Exception { ubahDermaga(id, namaBaru); }

    public void ubahDermaga(String id, String namaBaru) throws Exception {
        if (id == null || id.isBlank()) throw new Exception("Pilih dermaga terlebih dahulu.");
        if (namaBaru == null || namaBaru.isBlank()) throw new Exception("Data tidak valid!");
        if (namaBaru.trim().length() > 50) throw new Exception("Data tidak valid! Nama dermaga maksimal 50 karakter.");
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "UPDATE dermaga SET nama_dermaga=? WHERE id_dermaga=?" + SkemaDb.dermagaDiWilayah("id_dermaga"))) {
            ps.setString(1, namaBaru.trim()); ps.setString(2, id);
            if (ps.executeUpdate() == 0) throw new Exception("Dermaga tidak ditemukan.");
        }
    }

    /** Ubah Status Dermaga: Tersedia / Sibuk / Perbaikan. Dermaga yang sedang dipakai kapal hanya boleh Sibuk. */
    public void ubahStatusDermaga(String id, String status) throws Exception {
        if (id == null || id.isBlank()) throw new Exception("Pilih dermaga terlebih dahulu.");
        if (status == null || !List.of("Tersedia", "Sibuk", "Perbaikan").contains(status)) throw new Exception("Status dermaga tidak valid.");
        try (Connection c = DBConnection.getConnection()) {
            if (SkemaDb.dermagaDipakai(c, id) && !"Sibuk".equals(status))
                throw new Exception("Dermaga masih dipakai kapal, status tidak dapat diubah menjadi " + status + ".");
            try (PreparedStatement ps = c.prepareStatement("UPDATE dermaga SET status_dermaga=? WHERE id_dermaga=?" + SkemaDb.dermagaDiWilayah("id_dermaga"))) {
                ps.setString(1, status); ps.setString(2, id);
                if (ps.executeUpdate() == 0) throw new Exception("Dermaga tidak ditemukan.");
            }
        }
    }

    /** Cek dermaga tidak sedang dipakai kapal; bila kosong baru dihapus. */
    public void hapusDermaga(String id) throws Exception {
        if (id == null || id.isBlank()) throw new Exception("Pilih dermaga terlebih dahulu.");
        try (Connection c = DBConnection.getConnection()) {
            String status;
            try (PreparedStatement ps = c.prepareStatement("SELECT status_dermaga FROM dermaga WHERE id_dermaga=?" + SkemaDb.dermagaDiWilayah("id_dermaga"))) {
                ps.setString(1, id);
                try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) throw new Exception("Dermaga tidak ditemukan."); status = rs.getString(1); }
            }
            if (SkemaDb.dermagaDipakai(c, id) || "Sibuk".equalsIgnoreCase(status)) throw new Exception("Dermaga Masih Dipakai Kapal!");
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM dermaga WHERE id_dermaga=?")) {
                ps.setString(1, id); ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException ex) {
                throw new Exception("Dermaga memiliki riwayat jadwal sandar sehingga tidak dapat dihapus.");
            }
        }
    }

    // ===================== Kelola Slot Gudang =====================
    /** Kolom: id, kode blok, status, id operator penanggung jawab. */
    public List<Object[]> getDaftarSlot() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_slot,kode_blok,status_slot,Operator_id_pengguna FROM slot_gudang WHERE 1=1" +
                SkemaDb.slotDiWilayah("slot_gudang.Operator_id_pengguna") + " ORDER BY id_slot");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
        }
        return out;
    }

    @Deprecated
    public void tambahSlotGudang(String kodeBlok, double kapasitasM3, String idOperator) throws Exception { tambahSlotGudang(kodeBlok, idOperator); }

    public void tambahSlotGudang(String kodeBlok, String idOperator) throws Exception {
        if (kodeBlok == null || kodeBlok.isBlank()) throw new Exception("Data tidak valid!");
        if (kodeBlok.trim().length() > 20) throw new Exception("Data tidak valid! Kode blok maksimal 20 karakter.");
        if (idOperator == null || idOperator.isBlank()) throw new Exception("ID operator penanggung jawab wajib diisi.");
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM operator WHERE id_pengguna=?" + SkemaDb.dermagaDiWilayah("area_tugas"))) {
                ps.setString(1, idOperator.trim());
                try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) throw new Exception("Data tidak valid! ID operator tidak ditemukan."); }
            }
            try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM slot_gudang WHERE kode_blok=?")) {
                ps.setString(1, kodeBlok.trim());
                try (ResultSet rs = ps.executeQuery()) { if (rs.next()) throw new Exception("Data tidak valid! Kode blok sudah dipakai."); }
            }
            String id = SkemaDb.idBerikutnya(c, "slot_gudang", "id_slot", "SG", 2);
            try (PreparedStatement ps = c.prepareStatement("INSERT INTO slot_gudang(id_slot,kode_blok,status_slot,Operator_id_pengguna) VALUES(?,?,'Kosong',?)")) {
                ps.setString(1, id); ps.setString(2, kodeBlok.trim()); ps.setString(3, idOperator.trim()); ps.executeUpdate();
            }
        }
    }

    /** Database tidak menyimpan kapasitas slot; gunakan ubahStatusSlot (Kosong/Terisi/Penuh). */
    @Deprecated
    public void ubahKapasitasSlot(String idSlot, double kapasitasBaru) throws Exception {
        throw new Exception("Kapasitas slot tidak disimpan di database. Gunakan ubah status slot (Kosong/Terisi/Penuh).");
    }

    /** Status slot: Kosong / Terisi / Penuh. Slot yang masih berisi kargo tidak boleh dijadikan Kosong. */
    public void ubahStatusSlot(String idSlot, String status) throws Exception {
        if (idSlot == null || idSlot.isBlank()) throw new Exception("Pilih slot gudang terlebih dahulu.");
        if (status == null || !List.of("Kosong", "Terisi", "Penuh").contains(status)) throw new Exception("Status slot tidak valid.");
        try (Connection c = DBConnection.getConnection()) {
            if ("Kosong".equals(status)) {
                try (PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM kargo WHERE Slot_Gudang_id_slot=?")) {
                    ps.setString(1, idSlot);
                    try (ResultSet rs = ps.executeQuery()) { rs.next(); if (rs.getInt(1) > 0) throw new Exception("Slot masih berisi kargo, tidak dapat dijadikan Kosong."); }
                }
            }
            try (PreparedStatement ps = c.prepareStatement("UPDATE slot_gudang SET status_slot=? WHERE id_slot=?" + SkemaDb.slotDiWilayah("slot_gudang.Operator_id_pengguna"))) {
                ps.setString(1, status); ps.setString(2, idSlot);
                if (ps.executeUpdate() == 0) throw new Exception("Slot gudang tidak ditemukan.");
            }
        }
    }

    public void hapusSlotGudang(String idSlot) throws Exception {
        if (idSlot == null || idSlot.isBlank()) throw new Exception("Pilih slot gudang terlebih dahulu.");
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM kargo WHERE Slot_Gudang_id_slot=?")) {
                ps.setString(1, idSlot);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); if (rs.getInt(1) > 0) throw new Exception("Slot Gudang Masih Berisi Kargo!"); }
            }
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM slot_gudang WHERE id_slot=?" + SkemaDb.slotDiWilayah("slot_gudang.Operator_id_pengguna"))) {
                ps.setString(1, idSlot);
                if (ps.executeUpdate() == 0) throw new Exception("Slot gudang tidak ditemukan.");
            }
        }
    }

    // ===================== Kelola Tarif Retribusi =====================
    // Database tidak punya tabel tarif, jadi tarif per wilayah disimpan di ~/.argoport/tarif.properties.
    private static final double[] TARIF_BAWAAN = {500000.0, 15000.0}; // {tambat per hari, muatan per ton}
    private static final Path BERKAS_TARIF = Paths.get(System.getProperty("user.home"), ".argoport", "tarif.properties");

    private static String kunci(String wilayah) { return wilayah == null || wilayah.isBlank() ? "bawaan" : wilayah.trim().toLowerCase(); }

    private static double angka(Properties p, String k, double def) {
        try { String v = p.getProperty(k); return v == null ? def : Double.parseDouble(v); } catch (NumberFormatException ex) { return def; }
    }

    private static Properties muatTarif() {
        Properties p = new Properties();
        if (Files.isRegularFile(BERKAS_TARIF)) {
            try (InputStream in = Files.newInputStream(BERKAS_TARIF)) { p.load(in); } catch (Exception ignored) { }
        }
        return p;
    }

    private static synchronized double[] bacaTarif(String wilayah) {
        Properties p = muatTarif();
        double t = angka(p, "bawaan.tambat", TARIF_BAWAAN[0]), m = angka(p, "bawaan.muatan", TARIF_BAWAAN[1]);
        String k = kunci(wilayah);
        return new double[]{angka(p, k + ".tambat", t), angka(p, k + ".muatan", m)};
    }

    /** @return {tarif tambat per hari, tarif muatan per ton} untuk wilayah akun yang login (akun pusat: tarif bawaan) */
    public double[] getTarif() throws SQLException { return bacaTarif(Wilayah.aktif()); }

    public synchronized void updateTarif(double tarifTambat, double tarifMuatan) throws Exception {
        if (tarifTambat <= 0 || tarifMuatan <= 0) throw new Exception("Input Tarif Tidak Valid! Tarif harus lebih dari 0.");
        String k = kunci(Wilayah.wajib());
        Properties p = muatTarif();
        p.setProperty(k + ".tambat", String.valueOf(tarifTambat));
        p.setProperty(k + ".muatan", String.valueOf(tarifMuatan));
        Files.createDirectories(BERKAS_TARIF.getParent());
        try (OutputStream out = Files.newOutputStream(BERKAS_TARIF)) { p.store(out, "Tarif Argoport"); }
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

    /** Kapal yang sedang sandar: id, nama, status kapal, status bayar, total tagihan. */
    public List<Object[]> getKapalSandar() throws Exception {
        List<String[]> kapal = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT k.id_kapal,k.nama_kapal,k.status_kapal FROM kapal k WHERE 1=1" +
                SkemaDb.kapalDiWilayah("k", false) + " ORDER BY k.id_kapal");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) kapal.add(new String[]{rs.getString(1), rs.getString(2), rs.getString(3)});
        }
        List<Object[]> out = new ArrayList<>();
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
        Timestamp sandar = null; String dermaga = null;
        try (PreparedStatement ps = c.prepareStatement(
                "SELECT js.Dermaga_id_dermaga,js.waktu_sandar," +
                "GREATEST(1,DATEDIFF(CASE WHEN k.status_kapal='Sandar' THEN NOW() ELSE js.waktu_lepas END,js.waktu_sandar)) " +
                "FROM jadwal_sandar js JOIN kapal k ON k.id_kapal=js.Kapal_id_kapal WHERE js.Kapal_id_kapal=? ORDER BY js.waktu_sandar DESC LIMIT 1")) {
            ps.setString(1, idKapal);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) { dermaga = rs.getString(1); sandar = rs.getTimestamp(2); t.hariTambat = rs.getLong(3); } else t.hariTambat = 1;
            }
        }
        double[] tarif = bacaTarif(SkemaDb.wilayahDariKode(dermaga)); // tarif mengikuti wilayah dermaga tempat sandar
        t.tarifTambat = tarif[0]; t.tarifMuatan = tarif[1];
        try (PreparedStatement ps = c.prepareStatement("SELECT COALESCE(SUM(berat_ton),0) FROM kargo WHERE Kapal_id_kapal=?")) {
            ps.setString(1, idKapal);
            try (ResultSet rs = ps.executeQuery()) { rs.next(); t.tonKargo = rs.getDouble(1); }
        }
        t.total = t.tonKargo * t.tarifMuatan + t.hariTambat * t.tarifTambat;
        // Status bayar masa sandar saat ini: retribusi terakhir pada/setelah tanggal sandar.
        String sql = "SELECT id_retribusi,status_bayar FROM retribusi WHERE Kapal_id_kapal=? " +
                (sandar != null ? "AND tanggal_bayar>=? " : "") + "ORDER BY id_retribusi DESC LIMIT 1";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, idKapal);
            if (sandar != null) ps.setDate(2, new java.sql.Date(sandar.getTime()));
            try (ResultSet rs = ps.executeQuery()) { if (rs.next()) { t.idRetribusi = rs.getString(1); t.statusBayar = rs.getString(2); } }
        }
        return t;
    }

    /**
     * Billing. lunas=true: retribusi Lunas, jadwal sandar ditutup (waktu_lepas=sekarang), kapal Berlayar, dermaga Tersedia.
     * lunas=false: dicatat Belum Lunas, kapal tetap Sandar. Atomik; gagal -> rollback.
     * tanggal_bayar wajib terisi di database, jadi untuk Belum Lunas berisi tanggal pencatatan.
     */
    public void prosesPembayaran(String idKapal, String idAdmin, boolean lunas) throws Exception {
        if (idKapal == null || idKapal.isBlank()) throw new Exception("Pilih kapal terlebih dahulu.");
        if (idAdmin == null || idAdmin.isBlank()) throw new Exception("Sesi admin tidak valid. Silakan login ulang.");
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM admin WHERE id_pengguna=?")) {
                    ps.setString(1, idAdmin);
                    try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) throw new Exception("Hanya Admin yang dapat memproses pembayaran."); }
                }
                try (PreparedStatement ps = c.prepareStatement("SELECT status_kapal FROM kapal WHERE id_kapal=?" + SkemaDb.kapalDiWilayah("kapal", false) + " FOR UPDATE")) {
                ps.setString(1, idKapal);
                try (ResultSet rs = ps.executeQuery()) { 
                    if (!rs.next()) 
                        throw new Exception("Data kapal tidak ditemukan."); 
                }
            }
                Tagihan t = hitungRincian(c, idKapal);
                if ("Lunas".equalsIgnoreCase(t.statusBayar)) throw new Exception("Retribusi kapal ini sudah lunas.");
                String status = lunas ? "Lunas" : "Belum Lunas";
                if (t.idRetribusi != null) {
                    try (PreparedStatement ps = c.prepareStatement(
                            "UPDATE retribusi SET total_biaya=?,tarif=?,tanggal_bayar=CURDATE(),status_bayar=?,Admin_id_pengguna=? WHERE id_retribusi=?")) {
                        ps.setDouble(1, t.total); ps.setDouble(2, t.tarifTambat); ps.setString(3, status); ps.setString(4, idAdmin); ps.setString(5, t.idRetribusi); ps.executeUpdate();
                    }
                } else {
                    String id = SkemaDb.idBerikutnya(c, "retribusi", "id_retribusi", "R", 3);
                    try (PreparedStatement ps = c.prepareStatement(
                            "INSERT INTO retribusi(id_retribusi,total_biaya,tarif,tanggal_bayar,status_bayar,Admin_id_pengguna,Kapal_id_kapal) VALUES(?,?,?,CURDATE(),?,?,?)")) {
                        ps.setString(1, id); ps.setDouble(2, t.total); ps.setDouble(3, t.tarifTambat); ps.setString(4, status); ps.setString(5, idAdmin); ps.setString(6, idKapal); ps.executeUpdate();
                    }
                }
                if (lunas) {
                    String dermaga = null;
                    try (PreparedStatement ps = c.prepareStatement(
                            "SELECT id_jadwal,Dermaga_id_dermaga FROM jadwal_sandar WHERE Kapal_id_kapal=? ORDER BY waktu_sandar DESC LIMIT 1")) {
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
                        try (PreparedStatement ps = c.prepareStatement("UPDATE dermaga SET status_dermaga='Tersedia' WHERE id_dermaga=? AND status_dermaga='Sibuk'")) {
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
    // Sumber data: pengguna JOIN operator. Wilayah operator mengikuti huruf awal area_tugas (kode dermaga).

    private static void wajibAdmin() throws Exception {
        if (!DBConnection.isAdminSession()) throw new Exception("Hanya Admin yang dapat mengelola akun operator.");
    }

    private static String parseId(String id) throws Exception {
        if (id == null || id.isBlank()) throw new Exception("Pilih akun operator terlebih dahulu.");
        return id.trim();
    }

    /** Kolom: id, nama lengkap, username, status, shift kerja, area tugas. */
    public List<Object[]> getDaftarOperator() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT p.id_pengguna,p.nama_lengkap,p.username,p.status,o.shift_kerja,o.area_tugas FROM pengguna p " +
                "JOIN operator o ON o.id_pengguna=p.id_pengguna WHERE 1=1" + SkemaDb.dermagaDiWilayah("o.area_tugas") + " ORDER BY p.id_pengguna");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
        }
        return out;
    }

    private void pastikanOperator(Connection c, String id) throws Exception {
        try (PreparedStatement ps = c.prepareStatement("SELECT 1 FROM operator WHERE id_pengguna=?" + SkemaDb.dermagaDiWilayah("area_tugas"))) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) throw new Exception("Akun operator tidak ditemukan."); }
        }
    }

    /** Nonaktifkan / aktifkan kembali. Akun nonaktif tidak bisa login, datanya tetap utuh. */
    public void ubahStatusAkunOperator(String idAkun, boolean aktif) throws Exception {
        wajibAdmin();
        String id = parseId(idAkun);
        try (Connection c = DBConnection.getConnection()) {
            pastikanOperator(c, id);
            try (PreparedStatement ps = c.prepareStatement("UPDATE pengguna SET status=? WHERE id_pengguna=?")) {
                ps.setString(1, aktif ? "Aktif" : "Nonaktif"); ps.setString(2, id); ps.executeUpdate();
            }
        }
    }

    /** Reset password: dibuat password sementara acak (8 karakter), disimpan ke pengguna.password, dikembalikan ke admin. */
    public String resetPasswordOperator(String idAkun) throws Exception {
        wajibAdmin();
        String id = parseId(idAkun);
        String abjad = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";
        SecureRandom r = new SecureRandom(); StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) sb.append(abjad.charAt(r.nextInt(abjad.length())));
        String sementara = sb.toString();
        try (Connection c = DBConnection.getConnection()) {
            pastikanOperator(c, id);
            try (PreparedStatement ps = c.prepareStatement("UPDATE pengguna SET password=? WHERE id_pengguna=?")) {
                ps.setString(1, sementara); ps.setString(2, id); ps.executeUpdate();
            }
        }
        return sementara;
    }

    /** Hapus permanen akun operator (baris operator ikut terhapus via CASCADE). Gagal bila masih menjadi penanggung jawab slot gudang. */
    public void hapusAkunOperator(String idAkun) throws Exception {
        wajibAdmin();
        String id = parseId(idAkun);
        try (Connection c = DBConnection.getConnection()) {
            pastikanOperator(c, id);
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM pengguna WHERE id_pengguna=?")) {
                ps.setString(1, id);
                if (ps.executeUpdate() == 0) throw new Exception("Akun operator tidak ditemukan.");
            } catch (SQLIntegrityConstraintViolationException ex) {
                throw new Exception("Operator masih menjadi penanggung jawab slot gudang sehingga tidak dapat dihapus. Gunakan Nonaktifkan.");
            }
        }
    }

    // ===================== Laporan =====================
    public static final class Laporan {
        public long jumlahKapal; public double totalTonase, totalPendapatan;
        public List<Object[]> detail = new ArrayList<>(); // id retribusi, id kapal, nama kapal, tanggal, total, status
    }

    /** Jumlah kapal & tonase berdasarkan tanggal kedatangan; pendapatan berdasarkan retribusi Lunas pada periode. */
    public Laporan buatLaporan(LocalDate mulai, LocalDate akhir) throws Exception {
        if (mulai == null || akhir == null || akhir.isBefore(mulai)) throw new Exception("Periode laporan tidak valid.");
        Laporan l = new Laporan();
        java.sql.Date m = java.sql.Date.valueOf(mulai), a = java.sql.Date.valueOf(akhir);
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement(
                    "SELECT COUNT(*) FROM kapal k WHERE DATE(k.waktu_kedatangan) BETWEEN ? AND ?" + SkemaDb.kapalDiWilayah("k", false))) {
                ps.setDate(1, m); ps.setDate(2, a);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); l.jumlahKapal = rs.getLong(1); }
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "SELECT COALESCE(SUM(g.berat_ton),0) FROM kargo g JOIN kapal k ON k.id_kapal=g.Kapal_id_kapal " +
                    "WHERE DATE(k.waktu_kedatangan) BETWEEN ? AND ?" + SkemaDb.kapalDiWilayah("k", false))) {
                ps.setDate(1, m); ps.setDate(2, a);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); l.totalTonase = rs.getDouble(1); }
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "SELECT r.id_retribusi,r.Kapal_id_kapal,k.nama_kapal,r.tanggal_bayar,r.total_biaya,r.status_bayar FROM retribusi r " +
                    "JOIN kapal k ON k.id_kapal=r.Kapal_id_kapal WHERE r.status_bayar='Lunas' AND r.tanggal_bayar BETWEEN ? AND ?" +
                    SkemaDb.kapalDiWilayah("k", false) + " ORDER BY r.tanggal_bayar,r.id_retribusi")) {
                ps.setDate(1, m); ps.setDate(2, a);
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

    /** Generate file laporan (.xlsx), lalu rekap periode dicatat ke tabel laporan. */
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

        try (Connection c = DBConnection.getConnection()) {
            String id = SkemaDb.idBerikutnya(c, "laporan", "id_laporan", "L", 3);
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO laporan(id_laporan,periode_mulai,periode_selesai,jumlah_kapal,total_tonase,total_pendapatan) VALUES(?,?,?,?,?,?)")) {
                ps.setString(1, id); ps.setDate(2, java.sql.Date.valueOf(mulai)); ps.setDate(3, java.sql.Date.valueOf(akhir));
                ps.setLong(4, l.jumlahKapal); ps.setDouble(5, l.totalTonase); ps.setDouble(6, l.totalPendapatan); ps.executeUpdate();
            }
        }
    }
}