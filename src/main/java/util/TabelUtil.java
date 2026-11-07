package util;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/** Mengatur ulang header tabel agar sama dengan kolom yang dikirim controller. */
public final class TabelUtil {
    private TabelUtil() {}
    public static void kolom(JTable t, String... judul) {
        t.setModel(new DefaultTableModel(new Object[][]{}, judul) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        });
    }
}