package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Pembatasan data per wilayah (Bontang, Balikpapan, Samarinda, Berau, Tanah Grogot).
 * Akun admin dan operator terikat satu wilayah dan hanya melihat/mengubah data wilayahnya.
 * Akun dengan wilayah null (akun pusat) tidak dibatasi.
 */
public final class Wilayah {
    public static final String[] DAFTAR = {"Bontang", "Balikpapan", "Samarinda", "Berau", "Tanah Grogot"};
    private Wilayah() {}

    /** Wilayah akun yang login, null bila akun pusat. */
    public static String aktif() { return DBConnection.getActiveWilayah(); }

    /** Potongan SQL " AND kolom=?" bila sesi dibatasi wilayah, selain itu string kosong. */
    public static String dan(String kolom) { return aktif() == null ? "" : " AND " + kolom + "=?"; }

    /** Mengikat nilai wilayah ke parameter idx bila dibatasi; mengembalikan indeks parameter berikutnya. */
    public static int ikat(PreparedStatement ps, int idx) throws SQLException {
        String w = aktif();
        if (w == null) return idx;
        ps.setString(idx, w);
        return idx + 1;
    }

    /** Untuk query yang satu-satunya parameternya adalah wilayah. */
    public static ResultSet jalankan(PreparedStatement ps) throws SQLException {
        ikat(ps, 1);
        return ps.executeQuery();
    }

    /** Wilayah untuk data baru (dermaga, blok gudang, kapal). Akun pusat tidak punya wilayah, jadi ditolak. */
    public static String wajib() throws Exception {
        String w = aktif();
        if (w == null) throw new Exception("Akun pusat tidak terikat wilayah. Gunakan akun admin/operator wilayah untuk menambah data.");
        return w;
    }
}
