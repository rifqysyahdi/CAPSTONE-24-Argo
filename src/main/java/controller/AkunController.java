package controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import model.Pengguna;
import repository.DBConnection;
import util.FotoProfil;

/**
 * Profil akun yang sedang login. Data di tabel pengguna; tabel itu tidak punya kolom foto,
 * jadi foto disimpan sebagai berkas PNG di folder ~/.argoport/foto/ (per id pengguna).
 */
public class AkunController {

    public static final class Profil {
        public String nama, username, peran, status, wilayah;
        public Timestamp dibuat;   // tidak ada kolomnya di database: selalu null
        public byte[] foto;
    }

    private static final Path FOLDER_FOTO = Paths.get(System.getProperty("user.home"), ".argoport", "foto");

    private static String idAkun(Pengguna p) throws Exception {
        if (p == null || p.getIdPengguna() == null || p.getIdPengguna().isBlank())
            throw new Exception("Sesi login tidak aktif. Silakan login ulang.");
        return p.getIdPengguna();
    }

    private static Path berkasFoto(String id) { return FOLDER_FOTO.resolve(id.replaceAll("[^A-Za-z0-9_-]", "_") + ".png"); }

    /** Dipakai AuthController saat login; null bila belum ada foto. */
    static byte[] muatFoto(String id) {
        try { Path f = berkasFoto(id); return Files.isRegularFile(f) ? Files.readAllBytes(f) : null; }
        catch (Exception ex) { return null; }
    }

    public Profil ambilProfil(Pengguna p) throws Exception {
        String id = idAkun(p);
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT p.nama_lengkap,p.username,p.status,a.id_pengguna,a.wilayah,o.id_pengguna,o.area_tugas " +
                "FROM pengguna p LEFT JOIN admin a ON a.id_pengguna=p.id_pengguna " +
                "LEFT JOIN operator o ON o.id_pengguna=p.id_pengguna WHERE p.id_pengguna=?")) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new Exception("Akun tidak ditemukan.");
                Profil r = new Profil();
                r.nama = rs.getString(1); r.username = rs.getString(2); r.status = rs.getString(3);
                if (rs.getString(4) != null) { r.peran = "Admin"; r.wilayah = rs.getString(5); }
                else if (rs.getString(6) != null) { r.peran = "Operator"; r.wilayah = SkemaDb.wilayahDariKode(rs.getString(7)); }
                else r.peran = "-";
                r.foto = muatFoto(id);
                return r;
            }
        }
    }

    public void ubahNama(Pengguna p, String namaBaru) throws Exception {
        String id = idAkun(p);
        String nama = namaBaru == null ? "" : namaBaru.trim().replaceAll("\\s+", " ");
        if (nama.length() < 3) throw new Exception("Nama lengkap minimal 3 karakter.");
        if (nama.length() > 100) throw new Exception("Nama lengkap maksimal 100 karakter.");
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "UPDATE pengguna SET nama_lengkap=? WHERE id_pengguna=?")) {
            ps.setString(1, nama); ps.setString(2, id);
            if (ps.executeUpdate() == 0) throw new Exception("Akun tidak ditemukan.");
        }
        p.setNama(nama);
    }

    /** Foto diperkecil jadi PNG 256x256 lalu disimpan sebagai berkas lokal. */
    public void ubahFoto(Pengguna p, File berkas) throws Exception {
        String id = idAkun(p);
        byte[] png = FotoProfil.proses(berkas);
        Files.createDirectories(FOLDER_FOTO);
        Files.write(berkasFoto(id), png);
        p.setFoto(png);
    }

    public void hapusFoto(Pengguna p) throws Exception {
        String id = idAkun(p);
        Files.deleteIfExists(berkasFoto(id));
        p.setFoto(null);
    }

    /** Wajib memasukkan password lama; password baru disimpan di kolom pengguna.password. */
    public void ubahPassword(Pengguna p, String lama, String baru, String konfirmasi) throws Exception {
        String id = idAkun(p);
        if (lama == null || lama.isEmpty()) throw new Exception("Password saat ini wajib diisi.");
        if (baru == null || baru.length() < 8) throw new Exception("Password baru minimal 8 karakter.");
        if (baru.length() > 255) throw new Exception("Password baru terlalu panjang.");
        if (!baru.equals(konfirmasi)) throw new Exception("Konfirmasi password baru tidak sama.");
        if (baru.equals(lama)) throw new Exception("Password baru harus berbeda dari password saat ini.");
        try (Connection c = DBConnection.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("SELECT password FROM pengguna WHERE id_pengguna=?")) {
                ps.setString(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) throw new Exception("Akun tidak ditemukan.");
                    if (!lama.equals(rs.getString(1))) throw new Exception("Password saat ini salah.");
                }
            }
            try (PreparedStatement ps = c.prepareStatement("UPDATE pengguna SET password=? WHERE id_pengguna=?")) {
                ps.setString(1, baru); ps.setString(2, id); ps.executeUpdate();
            }
        }
        p.setWajibGantiSandi(false);
    }
}