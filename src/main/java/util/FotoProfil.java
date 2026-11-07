package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/** Pengolahan foto profil: validasi, potong persegi, perkecil, dan tampilan avatar bulat. */
public final class FotoProfil {
    public static final int UKURAN_SIMPAN = 256;
    private static final long MAKS_BYTE = 5L * 1024 * 1024;
    private static final Color LATAR_INISIAL = new Color(0, 140, 160);

    private FotoProfil() {}

    /** Membaca berkas gambar (JPG/PNG/GIF/BMP), memotong tengahnya jadi persegi, lalu menyimpannya sebagai PNG 256x256. */
    public static byte[] proses(File berkas) throws Exception {
        if (berkas == null || !berkas.isFile()) throw new Exception("Berkas foto tidak ditemukan.");
        if (berkas.length() > MAKS_BYTE) throw new Exception("Ukuran foto maksimal 5 MB.");
        BufferedImage src = ImageIO.read(berkas);
        if (src == null) throw new Exception("Berkas bukan gambar yang valid. Gunakan JPG atau PNG.");
        int sisi = Math.min(src.getWidth(), src.getHeight());
        BufferedImage potong = src.getSubimage((src.getWidth() - sisi) / 2, (src.getHeight() - sisi) / 2, sisi, sisi);
        BufferedImage out = new BufferedImage(UKURAN_SIMPAN, UKURAN_SIMPAN, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.drawImage(potong, 0, 0, UKURAN_SIMPAN, UKURAN_SIMPAN, null);
        g.dispose();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(out, "png", bos);
        return bos.toByteArray();
    }

    /** Avatar bulat dari foto tersimpan; bila foto kosong/rusak dipakai lingkaran berisi inisial nama. */
    public static Icon avatar(byte[] foto, String nama, int ukuran) {
        BufferedImage img = null;
        if (foto != null && foto.length > 0) {
            try { img = ImageIO.read(new ByteArrayInputStream(foto)); } catch (Exception ignored) { }
        }
        BufferedImage out = new BufferedImage(ukuran, ukuran, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setClip(new Ellipse2D.Float(0, 0, ukuran, ukuran));
        if (img != null) {
            g.drawImage(img, 0, 0, ukuran, ukuran, null);
        } else {
            g.setColor(LATAR_INISIAL);
            g.fillRect(0, 0, ukuran, ukuran);
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, Math.round(ukuran * 0.42f)));
            FontMetrics fm = g.getFontMetrics();
            String t = inisial(nama);
            g.drawString(t, (ukuran - fm.stringWidth(t)) / 2f, (ukuran - fm.getHeight()) / 2f + fm.getAscent());
        }
        g.setClip(null);
        g.setColor(new Color(255, 255, 255, 200));
        g.setStroke(new java.awt.BasicStroke(Math.max(1f, ukuran / 40f)));
        g.draw(new Ellipse2D.Float(0.5f, 0.5f, ukuran - 1f, ukuran - 1f));
        g.dispose();
        return new ImageIcon(out);
    }

    /** Maksimal dua huruf awal dari kata pertama dan kedua nama. */
    static String inisial(String nama) {
        if (nama == null || nama.isBlank()) return "?";
        String[] k = nama.trim().split("\\s+");
        String s = k[0].substring(0, 1);
        if (k.length > 1) s += k[1].substring(0, 1);
        return s.toUpperCase();
    }
}
