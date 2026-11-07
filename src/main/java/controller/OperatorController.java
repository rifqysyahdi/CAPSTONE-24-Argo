package controller;

import repository.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Menu Operator: pendaftaran kapal, daftar kapal, docking, bongkar muat, kelola kargo.
 * Status kapal: Antre / Sandar / Berlayar. Status dermaga: Tersedia / Sibuk / Perbaikan.
 * Status slot: Kosong / Terisi / Penuh. Status kargo: Disimpan / Dalam Pengiriman / Selesai.
 */
public class OperatorController {

    private static String fmt(Timestamp t) { return t == null ? "-" : t.toLocalDateTime().toString().replace('T', ' '); }

    /** Pendaftaran Kapal Baru: data lengkap & valid -> simpan dengan status Antre. */
    public void daftarKapalBaru(String nama, String jenis, double tonnage, double draf, LocalDateTime kedatangan) throws Exception {
        if (nama == null || nama.isBlank() || jenis == null || jenis.isBlank() || tonnage <= 0 || draf <= 0 || kedatangan == null)
            throw new Exception("Data kapal belum lengkap atau tidak valid.");
        if (nama.trim().length() > 50) throw new Exception("Nama kapal maksimal 50 karakter.");
        if (jenis.trim().length() > 30) throw new Exception("Jenis kapal maksimal 30 karakter.");
        if (tonnage > 99999999.99) throw new Exception("Gross tonnage terlalu besar.");
        if (draf > 999.99) throw new Exception("Draf kapal terlalu besar (maks 999,99).");
        try (Connection c = DBConnection.getConnection()) {
            String id = SkemaDb.idBerikutnya(c, "kapal", "id_kapal", "K", 3);
            try (PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO kapal(id_kapal,nama_kapal,jenis_kapal,gross_tonnage,draf_kapal,status_kapal,waktu_kedatangan) VALUES(?,?,?,?,?,'Antre',?)")) {
                ps.setString(1, id); ps.setString(2, nama.trim()); ps.setString(3, jenis.trim());
                ps.setDouble(4, tonnage); ps.setDouble(5, draf); ps.setTimestamp(6, Timestamp.valueOf(kedatangan));
                ps.executeUpdate();
            }
        }
    }

    /** Kolom: id, nama, jenis, GT, draf, kedatangan, status, dermaga terakhir, waktu sandar terakhir. */
    public List<Object[]> getDaftarKapal() throws SQLException {
        String sql = "SELECT k.id_kapal,k.nama_kapal,k.jenis_kapal,k.gross_tonnage,k.draf_kapal,k.waktu_kedatangan,k.status_kapal," +
            "d.nama_dermaga,j.waktu_sandar FROM kapal k " +
            "LEFT JOIN jadwal_sandar j ON j.id_jadwal=(SELECT j2.id_jadwal FROM jadwal_sandar j2 WHERE j2.Kapal_id_kapal=k.id_kapal ORDER BY j2.waktu_sandar DESC LIMIT 1) " +
            "LEFT JOIN dermaga d ON d.id_dermaga=j.Dermaga_id_dermaga WHERE 1=1" + SkemaDb.kapalDiWilayah("k", true) +
            " ORDER BY k.waktu_kedatangan DESC, k.id_kapal DESC";
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5),
                fmt(rs.getTimestamp(6)), rs.getString(7), rs.getString(8) == null ? "-" : rs.getString(8), fmt(rs.getTimestamp(9))});
        }
        return out;
    }

    public List<Object[]> getKapalByStatus(String status) throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT k.id_kapal,k.nama_kapal,k.jenis_kapal,k.gross_tonnage,k.waktu_kedatangan FROM kapal k WHERE k.status_kapal=?" +
                SkemaDb.kapalDiWilayah("k", true) + " ORDER BY k.waktu_kedatangan,k.id_kapal")) {
            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), fmt(rs.getTimestamp(5))});
            }
        }
        return out;
    }

    /** Hanya kapal Antre tanpa kargo/jadwal yang boleh dihapus. */
    public void hapusKapal(String idKapal) throws Exception {
        if (idKapal == null || idKapal.isBlank()) throw new Exception("Pilih kapal terlebih dahulu.");
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT status_kapal FROM kapal WHERE id_kapal=?")) {
                ps.setString(1, idKapal);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) throw new Exception("Data kapal tidak ditemukan.");
                    if (!"Antre".equalsIgnoreCase(rs.getString(1))) throw new Exception("Hanya kapal berstatus Antre yang dapat dihapus.");
                }
            }
            try (PreparedStatement ps = c.prepareStatement(
                    "SELECT (SELECT COUNT(*) FROM kargo WHERE Kapal_id_kapal=?)+(SELECT COUNT(*) FROM jadwal_sandar WHERE Kapal_id_kapal=?)+(SELECT COUNT(*) FROM retribusi WHERE Kapal_id_kapal=?)")) {
                ps.setString(1, idKapal); ps.setString(2, idKapal); ps.setString(3, idKapal);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); if (rs.getInt(1) > 0) throw new Exception("Kapal memiliki data kargo/jadwal/retribusi terkait."); }
            }
            try (PreparedStatement ps = c.prepareStatement("DELETE FROM kapal WHERE id_kapal=?")) { ps.setString(1, idKapal); ps.executeUpdate(); }
        }
    }

    /** Dermaga berstatus Tersedia dan tidak sedang dipakai kapal: id, nama, status. */
    public List<Object[]> getDermagaKosong() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_dermaga,nama_dermaga,status_dermaga FROM dermaga WHERE status_dermaga='Tersedia'" +
                SkemaDb.dermagaDiWilayah("id_dermaga") + " ORDER BY id_dermaga");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                if (SkemaDb.dermagaDipakai(c, rs.getString(1))) continue;
                out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }
        }
        return out;
    }

    /** Docking dengan estimasi lepas bawaan 24 jam (waktu_lepas wajib terisi di database). */
    public void prosesDocking(String idKapal, String idDermaga) throws Exception {
        prosesDocking(idKapal, idDermaga, LocalDateTime.now().plusDays(1));
    }

    /** Docking: kapal Antre + dermaga Tersedia -> dermaga Sibuk, kapal Sandar, jadwal sandar dibuat (waktu_lepas = estimasi). */
    public void prosesDocking(String idKapal, String idDermaga, LocalDateTime estimasiLepas) throws Exception {
        if (idKapal == null || idKapal.isBlank()) throw new Exception("Pilih kapal terlebih dahulu.");
        if (idDermaga == null || idDermaga.isBlank()) throw new Exception("Pilih dermaga terlebih dahulu.");
        if (estimasiLepas == null || !estimasiLepas.isAfter(LocalDateTime.now())) throw new Exception("Estimasi waktu lepas harus setelah waktu sekarang.");
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("SELECT status_kapal FROM kapal WHERE id_kapal=? FOR UPDATE")) {
                    ps.setString(1, idKapal);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new Exception("Data kapal tidak ditemukan.");
                        if (!"Antre".equalsIgnoreCase(rs.getString(1))) throw new Exception("Hanya kapal berstatus Antre yang dapat ditambatkan.");
                    }
                }
                try (PreparedStatement ps = c.prepareStatement("SELECT status_dermaga FROM dermaga WHERE id_dermaga=?" + SkemaDb.dermagaDiWilayah("id_dermaga") + " FOR UPDATE")) {
                    ps.setString(1, idDermaga);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new Exception("Dermaga tidak ditemukan.");
                        if (!"Tersedia".equalsIgnoreCase(rs.getString(1)) || SkemaDb.dermagaDipakai(c, idDermaga))
                            throw new Exception("Dermaga penuh atau tidak tersedia. Kapal tetap di antrean.");
                    }
                }
                try (PreparedStatement ps = c.prepareStatement("UPDATE kapal SET status_kapal='Sandar' WHERE id_kapal=?")) { ps.setString(1, idKapal); ps.executeUpdate(); }
                try (PreparedStatement ps = c.prepareStatement("UPDATE dermaga SET status_dermaga='Sibuk' WHERE id_dermaga=?")) { ps.setString(1, idDermaga); ps.executeUpdate(); }
                String idJadwal = SkemaDb.idBerikutnya(c, "jadwal_sandar", "id_jadwal", "JS", 2);
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO jadwal_sandar(id_jadwal,waktu_sandar,waktu_lepas,Kapal_id_kapal,Dermaga_id_dermaga) VALUES(?,NOW(),?,?,?)")) {
                    ps.setString(1, idJadwal); ps.setTimestamp(2, Timestamp.valueOf(estimasiLepas)); ps.setString(3, idKapal); ps.setString(4, idDermaga); ps.executeUpdate();
                }
                c.commit();
            } catch (Exception ex) { c.rollback(); throw ex; } finally { c.setAutoCommit(true); }
        }
    }

    /** Slot yang belum Penuh: id, kode blok, status, operator penanggung jawab. */
    public List<Object[]> getSlotTersedia() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_slot,kode_blok,status_slot,Operator_id_pengguna FROM slot_gudang WHERE status_slot IN ('Kosong','Terisi')" +
                SkemaDb.slotDiWilayah("slot_gudang.Operator_id_pengguna") + " ORDER BY id_slot");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
        }
        return out;
    }

    /** Kompatibilitas: volume tidak punya kolom di database sehingga diabaikan. */
    @Deprecated
    public void prosesBongkarMuat(String idKapal, String namaBarang, double beratTon, double volumeM3, String idSlot) throws Exception {
        prosesBongkarMuat(idKapal, namaBarang, beratTon, idSlot);
    }

    /** Bongkar Muat: kapal harus Sandar, slot tidak boleh Penuh; kargo disimpan lalu status slot diperbarui. */
    public void prosesBongkarMuat(String idKapal, String namaBarang, double beratTon, String idSlot) throws Exception {
        if (idKapal == null || idKapal.isBlank()) throw new Exception("Pilih kapal terlebih dahulu.");
        if (idSlot == null || idSlot.isBlank()) throw new Exception("Pilih slot gudang terlebih dahulu.");
        if (namaBarang == null || namaBarang.isBlank() || beratTon <= 0) throw new Exception("Nama barang dan berat kargo harus valid.");
        if (namaBarang.trim().length() > 50) throw new Exception("Nama barang maksimal 50 karakter.");
        if (beratTon > 99999999.99) throw new Exception("Berat kargo terlalu besar.");
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("SELECT status_kapal FROM kapal WHERE id_kapal=?" + SkemaDb.kapalDiWilayah("kapal", false) + " FOR UPDATE")) {
                    ps.setString(1, idKapal);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next() || !"Sandar".equalsIgnoreCase(rs.getString(1))) throw new Exception("Kapal Belum Sandar.");
                    }
                }
                try (PreparedStatement ps = c.prepareStatement("SELECT status_slot FROM slot_gudang WHERE id_slot=?" + SkemaDb.slotDiWilayah("slot_gudang.Operator_id_pengguna") + " FOR UPDATE")) {
                    ps.setString(1, idSlot);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new Exception("Slot gudang tidak ditemukan.");
                        if ("Penuh".equalsIgnoreCase(rs.getString(1))) throw new Exception("Kapasitas Blok Gudang Tidak Mencukupi! Slot berstatus Penuh.");
                    }
                }
                String idKargo = SkemaDb.idBerikutnya(c, "kargo", "id_kargo", "KG", 2);
                try (PreparedStatement ps = c.prepareStatement(
                        "INSERT INTO kargo(id_kargo,nama_barang,berat_ton,status_kargo,Kapal_id_kapal,Slot_Gudang_id_slot) VALUES(?,?,?,'Disimpan',?,?)")) {
                    ps.setString(1, idKargo); ps.setString(2, namaBarang.trim()); ps.setDouble(3, beratTon);
                    ps.setString(4, idKapal); ps.setString(5, idSlot); ps.executeUpdate();
                }
                SkemaDb.segarkanSlot(c, idSlot);
                c.commit();
            } catch (Exception ex) { c.rollback(); throw ex; } finally { c.setAutoCommit(true); }
        }
    }

    /** Daftar kargo: id, nama, berat, status, kapal, slot. */
    public List<Object[]> getDaftarKargo() throws SQLException {
        List<Object[]> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT id_kargo,nama_barang,berat_ton,status_kargo,Kapal_id_kapal,Slot_Gudang_id_slot FROM kargo WHERE 1=1" +
                SkemaDb.kargoDiWilayah("kargo.Slot_Gudang_id_slot") + " ORDER BY id_kargo");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(new Object[]{rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6)});
        }
        return out;
    }

    /** Kelola Data Kargo - ubah: nama barang baru dan berat ton baru. */
    public void ubahKargo(String idKargo, String namaBaru, double beratBaru) throws Exception {
        if (idKargo == null || idKargo.isBlank()) throw new Exception("Pilih kargo terlebih dahulu.");
        if (namaBaru == null || namaBaru.isBlank() || beratBaru <= 0) throw new Exception("Nama barang dan berat harus valid.");
        if (namaBaru.trim().length() > 50) throw new Exception("Nama barang maksimal 50 karakter.");
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "UPDATE kargo SET nama_barang=?,berat_ton=? WHERE id_kargo=?" + SkemaDb.kargoDiWilayah("kargo.Slot_Gudang_id_slot"))) {
            ps.setString(1, namaBaru.trim()); ps.setDouble(2, beratBaru); ps.setString(3, idKargo);
            if (ps.executeUpdate() == 0) throw new Exception("Data kargo tidak ditemukan.");
        }
    }

    /** Kelola Data Kargo - hapus: hapus kargo lalu perbarui status slot gudang. */
    public void hapusKargo(String idKargo) throws Exception {
        if (idKargo == null || idKargo.isBlank()) throw new Exception("Pilih kargo terlebih dahulu.");
        try (Connection c = DBConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                String slot;
                try (PreparedStatement ps = c.prepareStatement("SELECT Slot_Gudang_id_slot FROM kargo WHERE id_kargo=?" + SkemaDb.kargoDiWilayah("kargo.Slot_Gudang_id_slot") + " FOR UPDATE")) {
                    ps.setString(1, idKargo);
                    try (ResultSet rs = ps.executeQuery()) { if (!rs.next()) throw new Exception("Data kargo tidak ditemukan."); slot = rs.getString(1); }
                }
                try (PreparedStatement ps = c.prepareStatement("DELETE FROM kargo WHERE id_kargo=?")) { ps.setString(1, idKargo); ps.executeUpdate(); }
                SkemaDb.segarkanSlot(c, slot);
                c.commit();
            } catch (Exception ex) { c.rollback(); throw ex; } finally { c.setAutoCommit(true); }
        }
    }
}