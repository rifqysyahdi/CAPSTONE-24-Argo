package controller;

import repository.DBConnection;
import repository.SlotRepository;
import repository.Wilayah;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/** Logika menu Operator sesuai flowchart: pendaftaran kapal, daftar kapal, docking, bongkar muat, kelola kargo. */
public class OperatorController {

    private static String fmt(Timestamp t) { return t == null ? "-" : t.toLocalDateTime().toString().replace('T', ' '); }

    /** Flowchart Pendaftaran Kapal Baru: data lengkap & valid -> simpan dengan status Antre. */
    public void daftarKapalBaru(String nama, String jenis, double tonnage, double draf, LocalDateTime kedatangan) throws Exception {
        if (nama == null || nama.isBlank() || jenis == null || jenis.isBlank()
                || tonnage <= 0 || draf <= 0 || kedatangan == null) {
            throw new Exception("Data kapal belum lengkap atau tidak valid.");
        }
        String wilayah = Wilayah.wajib();
        try (Connection c = DBConnection.getConnection()) {
            String id = SlotRepository.idBerikutnya(c, "kapal", "id_kapal", "K", 3);
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO kapal(id_kapal,nama_kapal,jenis_kapal,gross_tonnage,draf_kapal,status_kapal,waktu_kedatangan,wilayah) VALUES(?,?,?,?,?,'Antre',?,?)")) {
                ps.setString(1, id); ps.setString(2, nama.trim()); ps.setString(3, jenis.trim());
                ps.setDouble(4, tonnage); ps.setDouble(5, draf); ps.setTimestamp(6, Timestamp.valueOf(kedatangan)); ps.setString(7, wilayah);
                ps.executeUpdate();
            }
        }
    }

    /** Daftar kapal + jadwal sandar terakhir + status antrean. Kolom: id,nama,jenis,GT,draf,kedatangan,status,dermaga,waktu sandar. */
    public List<Object[]> getDaftarKapal() throws SQLException {
        String sql = "SELECT k.id_kapal,k.nama_kapal,k.jenis_kapal,k.gross_tonnage,k.draf_kapal,k.waktu_kedatangan,k.status_kapal," +
            "d.nama_dermaga,j.waktu_sandar FROM kapal k " +
            "LEFT JOIN jadwal_sandar j ON j.id_jadwal=(SELECT j2.id_jadwal FROM jadwal_sandar j2 WHERE j2.Kapal_id_kapal=k.id_kapal ORDER BY j2.waktu_sandar DESC LIMIT 1) " +
            "LEFT JOIN dermaga d ON d.id_dermaga=j.Dermaga_id_dermaga WHERE 1=1" + Wilayah.dan("k.wilayah") + " ORDER BY k.waktu_kedatangan DESC, k.id_kapal DESC";
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = Wilayah.jalankan(ps)) {
            while (rs.next()) {
                out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5),
                    fmt(rs.getTimestamp(6)), rs.getString(7), rs.getString(8) == null ? "-" : rs.getString(8), fmt(rs.getTimestamp(9))});
            }
        }
        return out;
    }

    public List<Object[]> getKapalByStatus(String status) throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_kapal,nama_kapal,jenis_kapal,gross_tonnage,waktu_kedatangan FROM kapal WHERE status_kapal=?" + Wilayah.dan("wilayah") + " ORDER BY waktu_kedatangan,id_kapal")) {
            ps.setString(1, status); Wilayah.ikat(ps, 2);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), fmt(rs.getTimestamp(5))});
            }
        }
        return out;
    }

    /** Hanya kapal Antre tanpa kargo/jadwal yang boleh dihapus (use case: Hapus Kapal). */
    public void hapusKapal(String idKapal) throws Exception {
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT status_kapal FROM kapal WHERE id_kapal=?" + Wilayah.dan("wilayah"))) {
                ps.setString(1, idKapal); Wilayah.ikat(ps, 2);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) throw new Exception("Data kapal tidak ditemukan.");
                    if (!"Antre".equalsIgnoreCase(rs.getString(1))) throw new Exception("Hanya kapal berstatus Antre yang dapat dihapus.");
                }
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "SELECT (SELECT COUNT(*) FROM kargo WHERE Kapal_id_kapal=?)+(SELECT COUNT(*) FROM jadwal_sandar WHERE Kapal_id_kapal=?)")) {
                ps.setString(1, idKapal); ps.setString(2, idKapal);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); if (rs.getInt(1) > 0) throw new Exception("Kapal memiliki data kargo/jadwal sandar terkait."); }
            }
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM kapal WHERE id_kapal=?")) { ps.setString(1, idKapal); ps.executeUpdate(); }
        }
    }

    /** Dermaga berstatus Tersedia: id, nama, kapasitas maksimal (ton). */
    public List<Object[]> getDermagaKosong() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_dermaga,nama_dermaga,kapasitas_maksimal FROM dermaga WHERE status_dermaga='Tersedia'" + Wilayah.dan("wilayah") + " ORDER BY id_dermaga");
             ResultSet rs = Wilayah.jalankan(ps)) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getDouble(3)});
        }
        return out;
    }

    /** Flowchart Docking: kapal Antre + dermaga kosong -> dermaga Terisi, kapal Sandar, jadwal sandar dibuat. */
    public void prosesDocking(String idKapal, String idDermaga) throws Exception {
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                double gt;
                try (PreparedStatement ps = c.prepareStatement("SELECT gross_tonnage,status_kapal FROM kapal WHERE id_kapal=?" + Wilayah.dan("wilayah") + " FOR UPDATE")) {
                    ps.setString(1, idKapal); Wilayah.ikat(ps, 2);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new Exception("Data kapal tidak ditemukan.");
                        if (!"Antre".equalsIgnoreCase(rs.getString(2))) throw new Exception("Hanya kapal berstatus Antre yang dapat ditambatkan.");
                        gt = rs.getDouble(1);
                    }
                }
                try (PreparedStatement ps = c.prepareStatement("SELECT kapasitas_maksimal,status_dermaga FROM dermaga WHERE id_dermaga=?" + Wilayah.dan("wilayah") + " FOR UPDATE")) {
                    ps.setString(1, idDermaga); Wilayah.ikat(ps, 2);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new Exception("Dermaga tidak ditemukan.");
                        if (!"Tersedia".equalsIgnoreCase(rs.getString(2))) throw new Exception("Dermaga penuh atau tidak tersedia. Kapal tetap di antrean.");
                        if (gt > rs.getDouble(1)) throw new Exception("Kapasitas dermaga (" + rs.getDouble(1) + " ton) tidak mencukupi untuk kapal ini.");
                    }
                }
                try (PreparedStatement ps = c.prepareStatement("UPDATE kapal SET status_kapal='Sandar' WHERE id_kapal=?")) { ps.setString(1, idKapal); ps.executeUpdate(); }
                try (PreparedStatement ps = c.prepareStatement("UPDATE dermaga SET status_dermaga='Terisi' WHERE id_dermaga=?")) { ps.setString(1, idDermaga); ps.executeUpdate(); }
                String idJadwal = SlotRepository.idBerikutnya(c, "jadwal_sandar", "id_jadwal", "JS", 2);
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO jadwal_sandar(id_jadwal,waktu_sandar,waktu_lepas,Kapal_id_kapal,Dermaga_id_dermaga) VALUES(?,NOW(),NULL,?,?)")) {
                    ps.setString(1, idJadwal); ps.setString(2, idKapal); ps.setString(3, idDermaga); ps.executeUpdate();
                }
                c.commit();
            } catch (Exception ex) { c.rollback(); throw ex; } finally { c.setAutoCommit(true); }
        }
    }

    /** Slot yang masih punya sisa kapasitas: id, kode blok, kapasitas, sisa, status. */
    public List<Object[]> getSlotTersedia() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_slot,kode_blok,kapasitas_volume_m3,sisa_volume_m3,status_slot FROM slot_gudang WHERE status_slot IN ('Kosong','Terisi') AND sisa_volume_m3>0" + Wilayah.dan("wilayah") + " ORDER BY id_slot");
             ResultSet rs = Wilayah.jalankan(ps)) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5)});
        }
        return out;
    }

    /** Flowchart Bongkar Muat: kapal harus Sandar, kapasitas slot harus mencukupi, lalu sisa kapasitas diperbarui. */
    public void prosesBongkarMuat(String idKapal, String namaBarang, double beratTon, double volumeM3, String idSlot) throws Exception {
        if (idKapal == null || idKapal.isBlank()) throw new Exception("Pilih kapal terlebih dahulu.");
        if (idSlot == null || idSlot.isBlank()) throw new Exception("Pilih slot gudang terlebih dahulu.");
        if (namaBarang == null || namaBarang.isBlank() || beratTon <= 0 || volumeM3 <= 0)
            throw new Exception("Nama barang, berat, dan volume kargo harus valid.");
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("SELECT status_kapal FROM kapal WHERE id_kapal=?" + Wilayah.dan("wilayah") + " FOR UPDATE")) {
                    ps.setString(1, idKapal); Wilayah.ikat(ps, 2);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next() || !"Sandar".equalsIgnoreCase(rs.getString(1))) throw new Exception("Kapal Belum Sandar.");
                    }
                }
                try (PreparedStatement ps = c.prepareStatement("SELECT sisa_volume_m3,status_slot FROM slot_gudang WHERE id_slot=?" + Wilayah.dan("wilayah") + " FOR UPDATE")) {
                    ps.setString(1, idSlot); Wilayah.ikat(ps, 2);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new Exception("Slot gudang tidak ditemukan.");
                        String st = rs.getString(2);
                        if (!"Kosong".equalsIgnoreCase(st) && !"Terisi".equalsIgnoreCase(st)) throw new Exception("Slot gudang tidak tersedia.");
                        if (volumeM3 > rs.getDouble(1)) throw new Exception("Kapasitas Blok Gudang Tidak Mencukupi! Sisa: " + rs.getDouble(1) + " m3.");
                    }
                }
                String idKargo = SlotRepository.idBerikutnya(c, "kargo", "id_kargo", "KG", 2);
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO kargo(id_kargo,nama_barang,berat_ton,volume_m3,status_kargo,Kapal_id_kapal,Slot_Gudang_id_slot) VALUES(?,?,?,?,'Disimpan',?,?)")) {
                    ps.setString(1, idKargo); ps.setString(2, namaBarang.trim()); ps.setDouble(3, beratTon);
                    ps.setDouble(4, volumeM3); ps.setString(5, idKapal); ps.setString(6, idSlot); ps.executeUpdate();
                }
                SlotRepository.hitungUlang(c, idSlot);
                c.commit();
            } catch (Exception ex) { c.rollback(); throw ex; } finally { c.setAutoCommit(true); }
        }
    }

    /** Daftar kargo: id, nama, berat, volume, status, kapal, slot. */
    public List<Object[]> getDaftarKargo() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_kargo,nama_barang,berat_ton,volume_m3,status_kargo,Kapal_id_kapal,Slot_Gudang_id_slot FROM kargo WHERE Kapal_id_kapal IN (SELECT id_kapal FROM kapal WHERE 1=1" + Wilayah.dan("wilayah") + ") ORDER BY id_kargo");
             ResultSet rs = Wilayah.jalankan(ps)) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4),
                rs.getString(5), rs.getString(6), rs.getString(7)});
        }
        return out;
    }

    /** Flowchart Kelola Data Kargo - ubah: nama barang baru dan berat ton baru. */
    public void ubahKargo(String idKargo, String namaBaru, double beratBaru) throws Exception {
        if (idKargo == null || idKargo.isBlank()) throw new Exception("Pilih kargo terlebih dahulu.");
        if (namaBaru == null || namaBaru.isBlank() || beratBaru <= 0) throw new Exception("Nama barang dan berat harus valid.");
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "UPDATE kargo SET nama_barang=?,berat_ton=? WHERE id_kargo=?" +
                " AND Kapal_id_kapal IN (SELECT id_kapal FROM kapal WHERE 1=1" + Wilayah.dan("wilayah") + ")")) {
            ps.setString(1, namaBaru.trim()); ps.setDouble(2, beratBaru); ps.setString(3, idKargo); Wilayah.ikat(ps, 4);
            if (ps.executeUpdate() == 0) throw new Exception("Data kargo tidak ditemukan.");
        }
    }

    /** Flowchart Kelola Data Kargo - hapus: hapus kargo lalu perbarui sisa kapasitas & status slot gudang. */
    public void hapusKargo(String idKargo) throws Exception {
        if (idKargo == null || idKargo.isBlank()) throw new Exception("Pilih kargo terlebih dahulu.");
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                String slot;
                try (PreparedStatement ps = c.prepareStatement("SELECT Slot_Gudang_id_slot FROM kargo WHERE id_kargo=? AND Kapal_id_kapal IN (SELECT id_kapal FROM kapal WHERE 1=1" + Wilayah.dan("wilayah") + ") FOR UPDATE")) {
                    ps.setString(1, idKargo); Wilayah.ikat(ps, 2);
                    try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) throw new Exception("Data kargo tidak ditemukan."); slot = rs.getString(1); }
                }
                try (PreparedStatement ps = c.prepareStatement("DELETE FROM kargo WHERE id_kargo=?")) { ps.setString(1, idKargo); ps.executeUpdate(); }
                SlotRepository.hitungUlang(c, slot);
                c.commit();
            } catch (Exception ex) { c.rollback(); throw ex; } finally { c.setAutoCommit(true); }
        }
    }
}
