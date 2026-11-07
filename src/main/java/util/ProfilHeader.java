package util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Pengguna;

/**
 * Menjadikan nama pengguna di header (userLabel) tombol menuju menu Profil.
 * Dipanggil dari siapkan() tiap form, jadi tidak menyentuh blok Generated Code NetBeans.
 */
public final class ProfilHeader {
    private static final Color WARNA_NORMAL = new Color(37, 54, 74);
    private static final Color WARNA_HOVER = new Color(0, 140, 160);
    private static final int UKURAN_AVATAR = 34;

    private ProfilHeader() {}

    /**
     * @param frame     form yang memiliki header
     * @param userLabel label nama di pojok kanan header
     * @param pnlHeader panel header (AbsoluteLayout)
     * @param peran     teks peran di samping nama, mis. "Administrator" atau "Operator"
     */
    public static void pasang(JFrame frame, JLabel userLabel, JPanel pnlHeader, String peran) {
        Pengguna p = Sesi.pengguna;
        if (p == null) return;

        // Label dibesarkan sedikit ke atas/bawah supaya muat avatar bulat di sampingnya.
        pnlHeader.remove(userLabel);
        pnlHeader.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 10, 400, 44));
        userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        userLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        userLabel.setIconTextGap(12);
        userLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userLabel.setToolTipText("Klik untuk membuka Profil");

        Runnable segarkan = () -> {
            userLabel.setText(p.getNama() + "   ·   " + peran + (p.getWilayah() == null ? "" : " " + p.getWilayah()));
            userLabel.setIcon(FotoProfil.avatar(p.getFoto(), p.getNama(), UKURAN_AVATAR));
        };
        segarkan.run();

        userLabel.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { userLabel.setForeground(WARNA_HOVER); }
            @Override public void mouseExited(MouseEvent e) { userLabel.setForeground(WARNA_NORMAL); }
            @Override public void mouseClicked(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON1) return;
                view.ProfilDialog.tampilkan(frame, false);
                segarkan.run();
            }
        });
        pnlHeader.revalidate();
        pnlHeader.repaint();
    }
}
