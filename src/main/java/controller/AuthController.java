package controller;

import model.Pengguna;
import repository.DBConnection;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;

/** Autentikasi memakai tabel pengguna (+ admin / operator untuk menentukan peran). */
public class AuthController {
    private static final int MAX_GAGAL = 3;
    private static long blockedUntil = 0L;
    private static int loginFailCount = 0;

    private static final String SQL =
        "SELECT p.id_pengguna,p.nama_lengkap,p.username,p.password,p.status," +
        "a.id_pengguna AS id_admin,a.wilayah AS wilayah_admin,o.id_pengguna AS id_op,o.area_tugas " +
        "FROM pengguna p LEFT JOIN admin a ON a.id_pengguna=p.id_pengguna " +
        "LEFT JOIN operator o ON o.id_pengguna=p.id_pengguna WHERE p.username=?";

    public Pengguna login(String username, String password) throws Exception {
        long now = System.currentTimeMillis();
        if (now < blockedUntil) throw new Exception("Login diblokir sementara. Coba lagi dalam " + ((blockedUntil - now + 999) / 1000) + " detik.");
        if (username == null || username.isBlank() || password == null || password.isEmpty())
            throw new Exception("Username dan password wajib diisi.");
        String user = username.trim();
        Pengguna hasil = null; String role = null, wilayah = null;
        try (Connection c = DBConnection.authenticate(user, password); PreparedStatement ps = c.prepareStatement(SQL)) {
            ps.setString(1, user);
            try (ResultSet rs = ps.executeQuery()) {
                // username di data awal ada yang kembar, jadi periksa semua baris sampai ada yang cocok
                while (hasil == null && rs.next()) {
                    if (!cocok(password, rs.getString("password"))) continue;
                    if (!"Aktif".equalsIgnoreCase(rs.getString("status"))) continue;
                    String r, w;
                    if (rs.getString("id_admin") != null) { r = "Admin"; w = rs.getString("wilayah_admin"); }
                    else if (rs.getString("id_op") != null) { r = "Operator"; w = SkemaDb.wilayahDariKode(rs.getString("area_tugas")); }
                    else continue; // akun tanpa peran tidak boleh masuk
                    role = r; wilayah = w;
                    hasil = new Pengguna(rs.getString("id_pengguna"), rs.getString("nama_lengkap"), user, "", r);
                }
            }
        } catch (SQLException ex) {
            DBConnection.logout();
            throw new Exception("Database tidak dapat diakses. Pastikan MySQL aktif dan database argoport_db sudah diimpor. Detail: " + ex.getMessage());
        }
        if (hasil == null) {
            DBConnection.logout(); loginFailCount++;
            if (loginFailCount >= MAX_GAGAL) {
                blockedUntil = System.currentTimeMillis() + 60000; loginFailCount = 0;
                throw new Exception("Terlalu banyak percobaan. Coba lagi dalam 60 detik.");
            }
            throw new Exception("Username atau password salah.");
        }
        loginFailCount = 0; blockedUntil = 0;
        DBConnection.setActiveRole(role); DBConnection.setActiveWilayah(wilayah);
        hasil.setWilayah(wilayah); hasil.setWajibGantiSandi(false);
        hasil.setFoto(AkunController.muatFoto(hasil.getIdPengguna()));
        return hasil;
    }

    private static boolean cocok(String input, String tersimpan) {
        if (input == null || tersimpan == null) return false;
        return MessageDigest.isEqual(input.getBytes(StandardCharsets.UTF_8), tersimpan.getBytes(StandardCharsets.UTF_8));
    }
}