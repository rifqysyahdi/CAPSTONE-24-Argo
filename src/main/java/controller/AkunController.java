package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.Pengguna;
import repository.DBConnection;
import util.FotoProfil;
import util.PasswordHasher;

/** Profil akun yang sedang login: lihat, ubah nama, ganti foto, ganti password. */
public class AkunController {

    public static final class Profil {
        public String nama, username, peran, status, wilayah;
        public Timestamp dibuat;
        public byte[] foto;
    }

    private static int idAkun(Pengguna p) throws Exception {
        if (p == null) throw new Exception("Sesi login tidak aktif. Silakan login ulang.");
        try { return Integer.parseInt(p.getIdPengguna()); }
        catch (NumberFormatException ex) { throw new Exception("ID akun tidak valid. Silakan login ulang."); }
    }

    public Profil ambilProfil(Pengguna p) throws Exception {
        int id = idAkun(p);
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "SELECT nama_lengkap,username,peran,status_akun,dibuat_pada,foto_profil,wilayah FROM akun_aplikasi WHERE id_akun=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new Exception("Akun tidak ditemukan.");
                Profil r = new Profil();
                r.nama = rs.getString(1); r.username = rs.getString(2); r.peran = rs.getString(3);
                r.status = rs.getString(4); r.dibuat = rs.getTimestamp(5); r.foto = rs.getBytes(6); r.wilayah = rs.getString(7);
                return r;
            }
        }
    }

    public void ubahNama(Pengguna p, String namaBaru) throws Exception {
        int id = idAkun(p);
        String nama = namaBaru == null ? "" : namaBaru.trim().replaceAll("\\s+", " ");
        if (nama.length() < 3) throw new Exception("Nama lengkap minimal 3 karakter.");
        if (nama.length() > 100) throw new Exception("Nama lengkap maksimal 100 karakter.");
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "UPDATE akun_aplikasi SET nama_lengkap=? WHERE id_akun=?")) {
            ps.setString(1, nama); ps.setInt(2, id); ps.executeUpdate();
        }
        p.setNama(nama);
    }

    /** Foto diperkecil jadi PNG 256x256 sebelum disimpan di kolom foto_profil. */
    public void ubahFoto(Pengguna p, File berkas) throws Exception {
        int id = idAkun(p);
        byte[] png = FotoProfil.proses(berkas);
        simpanFoto(id, png);
        p.setFoto(png);
    }

    public void hapusFoto(Pengguna p) throws Exception {
        int id = idAkun(p);
        simpanFoto(id, null);
        p.setFoto(null);
    }

    private void simpanFoto(int id, byte[] png) throws SQLException {
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(
                "UPDATE akun_aplikasi SET foto_profil=? WHERE id_akun=?")) {
            if (png == null) ps.setNull(1, java.sql.Types.BLOB); else ps.setBytes(1, png);
            ps.setInt(2, id); ps.executeUpdate();
        }
    }

    /** Wajib memasukkan password lama. Setelah berhasil, penanda "wajib ganti password" dibersihkan. */
    public void ubahPassword(Pengguna p, String lama, String baru, String konfirmasi) throws Exception {
        int id = idAkun(p);
        if (lama == null || lama.isEmpty()) throw new Exception("Password saat ini wajib diisi.");
        if (baru == null || baru.length() < 8) throw new Exception("Password baru minimal 8 karakter.");
        if (!baru.equals(konfirmasi)) throw new Exception("Konfirmasi password baru tidak sama.");
        if (baru.equals(lama)) throw new Exception("Password baru harus berbeda dari password saat ini.");
        try (Connection c = DBConnection.getConnection()) {
            String salt, hash;
            try (PreparedStatement ps = c.prepareStatement("SELECT salt,password_hash FROM akun_aplikasi WHERE id_akun=?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) throw new Exception("Akun tidak ditemukan.");
                    salt = rs.getString(1); hash = rs.getString(2);
                }
            }
            if (!PasswordHasher.verify(lama, salt, hash)) throw new Exception("Password saat ini salah.");
            String saltBaru = PasswordHasher.saltBaru();
            try (PreparedStatement ps = c.prepareStatement(
                    "UPDATE akun_aplikasi SET password_hash=?,salt=?,wajib_ganti_sandi=0 WHERE id_akun=?")) {
                ps.setString(1, PasswordHasher.hash(baru, saltBaru)); ps.setString(2, saltBaru); ps.setInt(3, id);
                ps.executeUpdate();
            }
        }
        p.setWajibGantiSandi(false);
    }
}
