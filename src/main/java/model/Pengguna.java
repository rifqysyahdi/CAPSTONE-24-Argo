package model;

public class Pengguna {
    private String idPengguna;
    private String nama;
    private String username;
    private String password;
    private String peran;
    private byte[] foto;                 // PNG foto profil, null jika belum diatur
    private boolean wajibGantiSandi;     // true setelah password direset admin
    private String wilayah;              // null = akun pusat (semua wilayah)

    public Pengguna(String idPengguna, String nama, String username, String password, String peran) {
        this.idPengguna = idPengguna;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.peran = peran;
    }

    public String getIdPengguna() { return idPengguna; }
    public String getNama() { return nama; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getPeran() { return peran; }
    public byte[] getFoto() { return foto; }
    public boolean isWajibGantiSandi() { return wajibGantiSandi; }
    public String getWilayah() { return wilayah; }
    public void setWilayah(String wilayah) { this.wilayah = wilayah; }
    public void setPassword(String password) { this.password = password; }
    public void setNama(String nama) { this.nama = nama; }
    public void setFoto(byte[] foto) { this.foto = foto; }
    public void setWajibGantiSandi(boolean wajibGantiSandi) { this.wajibGantiSandi = wajibGantiSandi; }
}
