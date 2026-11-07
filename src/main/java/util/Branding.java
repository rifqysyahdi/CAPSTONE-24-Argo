package util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Pemasangan logo ArgoPort System. File gambar ada di
 * src/main/resources/images/ (dibaca lewat classpath, mis. /images/logo_login.png).
 */
public final class Branding {
    public static final String LOGO_APP = "/images/logo_app.png";
    public static final String LOGO_LOGIN = "/images/logo_login.png";
    public static final String LOGO_SIDEBAR = "/images/logo_sidebar.png";

    private Branding() {}

    /** Memuat gambar dari classpath; null jika file tidak ditemukan. */
    public static ImageIcon ikon(String path) {
        URL url = Branding.class.getResource(path);
        return url == null ? null : new ImageIcon(url);
    }

    /** Memasang logo sebagai ikon jendela (title bar / taskbar). */
    public static void pasangIkonJendela(java.awt.Window frame) {
        ImageIcon ic = ikon(LOGO_APP);
        if (ic != null) frame.setIconImage(ic.getImage());
    }

    /** Label berisi logo siap pakai (untuk form yang dibuat manual). */
    public static JLabel labelLogo(String path) {
        JLabel l = new JLabel();
        ImageIcon ic = ikon(path);
        if (ic != null) l.setIcon(ic);
        return l;
    }

    /** Ikon tombol keluar (pintu + anak panah) yang digambar langsung, tanpa file gambar. */
    public static Icon ikonKeluar(Color warna, int ukuran) {
        return new LogoutIcon(warna, ukuran);
    }

    private static final class LogoutIcon implements Icon {
        private final Color warna;
        private final int ukuran;

        LogoutIcon(Color warna, int ukuran) {
            this.warna = warna;
            this.ukuran = ukuran;
        }

        @Override public int getIconWidth() { return ukuran; }
        @Override public int getIconHeight() { return ukuran; }

        @Override public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.translate(x, y);
            g2.setColor(warna);
            g2.setStroke(new BasicStroke(Math.max(1.6f, ukuran / 9f), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            int pad = ukuran / 7;
            int doorW = (int) (ukuran * 0.52);
            g2.drawRoundRect(pad, pad, doorW - pad, ukuran - 2 * pad, 4, 4);
            int midY = ukuran / 2;
            int ax = doorW - pad / 2;
            int bx = ukuran - pad;
            g2.drawLine(ax, midY, bx, midY);
            g2.drawLine(bx, midY, bx - ukuran / 5, midY - ukuran / 5);
            g2.drawLine(bx, midY, bx - ukuran / 5, midY + ukuran / 5);
            g2.dispose();
        }
    }
}
