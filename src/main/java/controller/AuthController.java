package controller;

import model.Pengguna;
import repository.DBConnection;
import repository.SkemaAkun;
import util.PasswordHasher;
import java.sql.*;

/** Autentikasi akun aplikasi (bukan akun MySQL per pengguna). */
public class AuthController {
    private static final int MAX_GAGAL = 3;
    private static long blockedUntil = 0L;
    private static int loginFailCount = 0;

    public Pengguna login(String username, String password) throws Exception {
        long now=System.currentTimeMillis();
        if (now < blockedUntil) throw new Exception("Login diblokir sementara. Coba lagi dalam " + ((blockedUntil-now+999)/1000) + " detik.");
        try (Connection c=DBConnection.authenticate(username,password)) {
            SkemaAkun.pastikan(c);
            try (PreparedStatement ps=c.prepareStatement("SELECT id_akun,nama_lengkap,username,password_hash,salt,peran,status_akun,foto_profil,wajib_ganti_sandi,wilayah FROM akun_aplikasi WHERE username=?")) {
            ps.setString(1,username);
            try(ResultSet rs=ps.executeQuery()) {
                if(!rs.next() || !"Aktif".equalsIgnoreCase(rs.getString("status_akun")) || !verify(password,rs.getString("salt"),rs.getString("password_hash"))) {
                    DBConnection.logout(); loginFailCount++;
                    if(loginFailCount>=MAX_GAGAL){blockedUntil=System.currentTimeMillis()+60000;loginFailCount=0;throw new Exception("Terlalu banyak percobaan. Coba lagi dalam 60 detik.");}
                    throw new Exception("Username atau password salah.");
                }
                loginFailCount=0; blockedUntil=0;
                String role=rs.getString("peran"); DBConnection.setActiveRole(role); DBConnection.setActiveWilayah(rs.getString("wilayah"));
                Pengguna p=new Pengguna(String.valueOf(rs.getInt("id_akun")),rs.getString("nama_lengkap"),username,"",role);
                p.setFoto(rs.getBytes("foto_profil")); p.setWajibGantiSandi(rs.getInt("wajib_ganti_sandi")==1); p.setWilayah(rs.getString("wilayah"));
                return p;
            }
            }
        } catch(SQLException ex) { DBConnection.logout(); throw new Exception("Database tidak dapat diakses. Pastikan MySQL aktif, migrasi akun sudah dijalankan, dan konfigurasi database benar. Detail: "+ex.getMessage()); }
    }

    private static boolean verify(String password,String salt,String expected) throws Exception { return PasswordHasher.verify(password,salt,expected); }
}
