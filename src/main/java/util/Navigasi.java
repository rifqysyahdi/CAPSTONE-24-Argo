package util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicButtonUI;

/** Aksi navigasi bersama untuk halaman awal, login, registrasi, dan sidebar dashboard. */
public final class Navigasi {
    private static final Color AKTIF = new Color(0, 140, 160);   
    private static final Color BIASA = new Color(204,255,255);  
    private static final Color HOVER = new Color(40, 120, 150);  
    private static final Color GARIS = new Color(52, 92, 140);

    private Navigasi() {}

    /** Konfirmasi lalu menutup aplikasi. */
    public static void keluar(Component parent) {
        int pilih = JOptionPane.showConfirmDialog(parent, "Yakin ingin keluar dari aplikasi?",
                "Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pilih == JOptionPane.YES_OPTION) System.exit(0);
    }

    /** Membuat tombol sidebar tampil sebagai tombol sungguhan: garis tepi + efek hover. */
    public static void gayaSidebar(JButton... tombol) {
        for (JButton b : tombol) {
            b.setUI(new BasicButtonUI());
            b.setContentAreaFilled(false);
            b.setOpaque(true);
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(GARIS, 1),
                    BorderFactory.createEmptyBorder(0, 14, 0, 8)));
            b.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override public void mouseEntered(java.awt.event.MouseEvent e) {
                    if (!AKTIF.equals(b.getBackground())) b.setBackground(HOVER);
                }
                @Override public void mouseExited(java.awt.event.MouseEvent e) {
                    if (!AKTIF.equals(b.getBackground())) b.setBackground(BIASA);
                }
            });
        }
    }

    /**
     * Memindahkan tombol Keluar tepat di bawah daftar menu sidebar dan memberinya tampilan tombol merah.
     * Posisi lama (y=735) terpotong di layar yang tingginya kurang dari ~850 px (laptop 768 px, atau Windows scaling 125%).
     */
    public static void pasangKeluar(JButton keluar, JButton... menu) {
        java.awt.Container sidebar = keluar.getParent();
        if (sidebar == null) return;
        int bawah = 0;
        for (JButton m : menu) bawah = Math.max(bawah, m.getY() + m.getHeight());
        sidebar.remove(keluar);
        sidebar.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, bawah + 28, 219, 39));
        keluar.setUI(new BasicButtonUI());
        keluar.setText("Keluar");
        keluar.setIcon(Branding.ikonKeluar(Color.WHITE, 16));
        keluar.setIconTextGap(10);
        keluar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        keluar.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        keluar.setForeground(Color.WHITE);
        keluar.setBackground(new Color(168, 50, 44));
        keluar.setContentAreaFilled(false);
        keluar.setOpaque(true);
        keluar.setBorderPainted(true);
        keluar.setFocusPainted(false);
        keluar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(196, 82, 74), 1),
                BorderFactory.createEmptyBorder(0, 14, 0, 8)));
        keluar.setToolTipText("Keluar dari akun ini dan kembali ke halaman awal");
        sidebar.revalidate();
        sidebar.repaint();
    }
}
