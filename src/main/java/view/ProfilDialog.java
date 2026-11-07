package view;

import controller.AkunController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.io.File;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Pengguna;
import util.FotoProfil;
import util.Sesi;

/**
 * Menu Profil: dibuka dengan mengklik nama pengguna di header.
 * Isi: foto profil (ganti/hapus), nama lengkap (ubah), info akun, dan ganti password.
 * Dibangun lewat kode (bukan NetBeans Design) supaya sama untuk Admin dan Operator.
 */
public class ProfilDialog extends JDialog {
    private static final Color NAVY = new Color(17, 39, 67);
    private static final Color TEAL = new Color(0, 140, 160);
    private static final Color LATAR = new Color(246, 248, 251);
    private static final Color GARIS = new Color(224, 231, 238);
    private static final Color TEKS = new Color(37, 54, 74);
    private static final Color TEKS_PUDAR = new Color(105, 121, 140);
    private static final int AVATAR = 104;

    private final AkunController controller = new AkunController();
    private final Pengguna pengguna = Sesi.pengguna;
    private final boolean wajibGanti;
    private boolean selesai;

    private final JLabel lblFoto = new JLabel();
    private final JLabel lblNamaBesar = new JLabel();
    private final JLabel lblPeranBadge = new JLabel();
    private final JTextField txtNama = new JTextField();
    private final JLabel valUsername = new JLabel("-"), valPeran = new JLabel("-"), valStatus = new JLabel("-"), valWilayah = new JLabel("-"), valDibuat = new JLabel("-");
    private final JPasswordField pwLama = new JPasswordField(), pwBaru = new JPasswordField(), pwKonfirmasi = new JPasswordField();
    private final JButton btnHapusFoto = tombol("Hapus Foto", false);
    private final JButton btnTutup = tombol("Tutup", false);

    /**
     * Menampilkan dialog dan menunggu sampai ditutup.
     * @param wajibGanti true bila password baru direset admin: pengguna harus menggantinya dulu.
     * @return false hanya bila mode wajibGanti dibatalkan (pemanggil sebaiknya logout).
     */
    public static boolean tampilkan(Window owner, boolean wajibGanti) {
        if (Sesi.pengguna == null) return true;
        ProfilDialog d = new ProfilDialog(owner, wajibGanti);
        d.setVisible(true);
        return d.selesai;
    }

    private ProfilDialog(Window owner, boolean wajibGanti) {
        super(owner, wajibGanti ? "Ganti Password Wajib" : "Profil Saya", ModalityType.APPLICATION_MODAL);
        this.wajibGanti = wajibGanti;
        this.selesai = !wajibGanti;
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override public void windowClosing(java.awt.event.WindowEvent e) { tutup(); }
        });
        util.Branding.pasangIkonJendela(this);
        bangun();
        muatProfil();
        pack();
        int maksTinggi = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 80; // layar kecil: sisanya bisa di-scroll
        setSize(new Dimension(560, Math.min(getHeight() + 24, maksTinggi)));
        setMinimumSize(new Dimension(520, 480));
        setLocationRelativeTo(owner);
        if (wajibGanti) pwLama.requestFocusInWindow();
    }

    // ---------- tampilan ----------
    private void bangun() {
        JPanel akar = new JPanel(new BorderLayout());
        akar.setBackground(LATAR);
        setContentPane(akar);

        if (wajibGanti) {
            JLabel b = new JLabel("<html><b>Password Anda baru direset oleh admin.</b> Ganti dengan password pribadi sebelum melanjutkan.</html>");
            b.setFont(new Font("SansSerif", Font.PLAIN, 12));
            b.setForeground(new Color(120, 72, 0));
            b.setOpaque(true);
            b.setBackground(new Color(255, 244, 214));
            b.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            akar.add(b, BorderLayout.NORTH);
        }

        JPanel isi = new JPanel();
        isi.setLayout(new BoxLayout(isi, BoxLayout.Y_AXIS));
        isi.setOpaque(false);
        isi.setBorder(BorderFactory.createEmptyBorder(18, 20, 8, 20));
        isi.add(kartuFoto());
        isi.add(Box.createVerticalStrut(14));
        isi.add(kartuInfo());
        isi.add(Box.createVerticalStrut(14));
        isi.add(kartuPassword());

        JScrollPane sp = new JScrollPane(isi, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBorder(null);
        sp.getViewport().setBackground(LATAR);
        sp.getVerticalScrollBar().setUnitIncrement(16);
        akar.add(sp, BorderLayout.CENTER);

        JPanel bawah = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 12));
        bawah.setBackground(Color.WHITE);
        bawah.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, GARIS));
        btnTutup.setText(wajibGanti ? "Batal dan Keluar" : "Tutup");
        btnTutup.addActionListener(e -> tutup());
        bawah.add(btnTutup);
        akar.add(bawah, BorderLayout.SOUTH);
    }

    private JPanel kartu(String judul) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GARIS), BorderFactory.createEmptyBorder(14, 18, 16, 18)));
        p.setAlignmentX(LEFT_ALIGNMENT);
        JLabel t = new JLabel(judul);
        t.setFont(new Font("SansSerif", Font.BOLD, 10));
        t.setForeground(TEKS_PUDAR);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2; c.anchor = GridBagConstraints.WEST; c.insets = new Insets(0, 0, 10, 0);
        p.add(t, c);
        return p;
    }

    private JPanel kartuFoto() {
        JPanel p = kartu("FOTO PROFIL");
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setPreferredSize(new Dimension(AVATAR + 8, AVATAR + 8));

        lblNamaBesar.setFont(new Font("SansSerif", Font.BOLD, 19));
        lblNamaBesar.setForeground(NAVY);
        lblPeranBadge.setFont(new Font("SansSerif", Font.BOLD, 10));
        lblPeranBadge.setForeground(TEAL);
        lblPeranBadge.setOpaque(true);
        lblPeranBadge.setBackground(new Color(224, 244, 247));
        lblPeranBadge.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));

        JButton ganti = tombol("Ganti Foto", true);
        ganti.addActionListener(e -> gantiFoto());
        btnHapusFoto.addActionListener(e -> hapusFoto());

        JPanel kolomKanan = new JPanel();
        kolomKanan.setOpaque(false);
        kolomKanan.setLayout(new BoxLayout(kolomKanan, BoxLayout.Y_AXIS));
        JPanel baris1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); baris1.setOpaque(false); baris1.add(lblNamaBesar);
        JPanel baris2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); baris2.setOpaque(false); baris2.add(lblPeranBadge);
        JPanel baris3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0)); baris3.setOpaque(false); baris3.add(ganti); baris3.add(btnHapusFoto);
        JLabel petunjuk = kecil("JPG atau PNG, maksimal 5 MB. Foto dipotong persegi otomatis.");
        JPanel baris4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); baris4.setOpaque(false); baris4.add(petunjuk);
        kolomKanan.add(baris1); kolomKanan.add(Box.createVerticalStrut(6));
        kolomKanan.add(baris2); kolomKanan.add(Box.createVerticalStrut(12));
        kolomKanan.add(baris3); kolomKanan.add(Box.createVerticalStrut(6));
        kolomKanan.add(baris4);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 1; c.insets = new Insets(0, 0, 0, 18); c.anchor = GridBagConstraints.NORTHWEST;
        p.add(lblFoto, c);
        c.gridx = 1; c.weightx = 1; c.fill = GridBagConstraints.HORIZONTAL; c.insets = new Insets(4, 0, 0, 0);
        p.add(kolomKanan, c);
        return p;
    }

    private JPanel kartuInfo() {
        JPanel p = kartu("INFORMASI AKUN");
        int y = 1;
        txtNama.setFont(new Font("SansSerif", Font.PLAIN, 13));
        JButton simpan = tombol("Simpan Nama", true);
        simpan.addActionListener(e -> simpanNama());
        txtNama.addActionListener(e -> simpanNama());
        y = baris(p, y, "Nama Lengkap", txtNama);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1; c.gridy = y++; c.anchor = GridBagConstraints.EAST; c.insets = new Insets(2, 0, 10, 0);
        p.add(simpan, c);
        for (JLabel v : new JLabel[]{valUsername, valPeran, valWilayah, valStatus, valDibuat}) {
            v.setFont(new Font("SansSerif", Font.PLAIN, 13));
            v.setForeground(TEKS);
        }
        y = baris(p, y, "Username", valUsername);
        y = baris(p, y, "Peran", valPeran);
        y = baris(p, y, "Wilayah", valWilayah);
        y = baris(p, y, "Status", valStatus);
        baris(p, y, "Terdaftar", valDibuat);
        return p;
    }

    private JPanel kartuPassword() {
        JPanel p = kartu("GANTI PASSWORD");
        int y = 1;
        y = baris(p, y, "Password saat ini", pwLama);
        y = baris(p, y, "Password baru", pwBaru);
        y = baris(p, y, "Ulangi password baru", pwKonfirmasi);
        JLabel h = kecil("Minimal 8 karakter dan harus berbeda dari password saat ini.");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1; c.gridy = y++; c.anchor = GridBagConstraints.WEST; c.insets = new Insets(0, 0, 8, 0);
        p.add(h, c);
        JButton ubah = tombol("Ubah Password", true);
        ubah.addActionListener(e -> ubahPassword());
        pwKonfirmasi.addActionListener(e -> ubahPassword());
        c = new GridBagConstraints();
        c.gridx = 1; c.gridy = y; c.anchor = GridBagConstraints.EAST;
        p.add(ubah, c);
        return p;
    }

    private int baris(JPanel p, int y, String label, java.awt.Component isi) {
        JLabel l = new JLabel(label);
        l.setFont(new Font("SansSerif", Font.PLAIN, 12));
        l.setForeground(TEKS_PUDAR);
        l.setPreferredSize(new Dimension(130, 28));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy = y; c.anchor = GridBagConstraints.WEST; c.insets = new Insets(0, 0, 8, 12);
        p.add(l, c);
        c = new GridBagConstraints();
        c.gridx = 1; c.gridy = y; c.weightx = 1; c.fill = GridBagConstraints.HORIZONTAL; c.insets = new Insets(0, 0, 8, 0);
        if (isi instanceof javax.swing.text.JTextComponent) ((javax.swing.text.JTextComponent) isi).setFont(new Font("SansSerif", Font.PLAIN, 13));
        if (isi instanceof JTextField) isi.setPreferredSize(new Dimension(220, 30));
        p.add(isi, c);
        return y + 1;
    }

    private static JLabel kecil(String teks) {
        JLabel l = new JLabel(teks);
        l.setFont(new Font("SansSerif", Font.PLAIN, 11));
        l.setForeground(TEKS_PUDAR);
        return l;
    }

    private static JButton tombol(String teks, boolean utama) {
        JButton b = new JButton(teks);
        b.setFont(new Font("SansSerif", Font.BOLD, 11));
        b.setFocusPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setMargin(new Insets(6, 14, 6, 14));
        b.setOpaque(true);
        b.setContentAreaFilled(true);
        b.setBorderPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        b.setBackground(utama ? TEAL : new Color(235, 241, 247));
        b.setForeground(utama ? Color.WHITE : new Color(43, 73, 101));
        return b;
    }

    // ---------- data ----------
    private void muatProfil() {
        AkunController.Profil pr = null;
        try {
            pr = controller.ambilProfil(pengguna);
            pengguna.setNama(pr.nama);
            pengguna.setFoto(pr.foto);
            txtNama.setText(pr.nama);
            valUsername.setText(pr.username);
            valPeran.setText(pr.peran);
            valWilayah.setText(pr.wilayah == null || pr.wilayah.isBlank() ? "Pusat (semua wilayah)" : pr.wilayah);
            valStatus.setText(pr.status);
            valDibuat.setText(pr.dibuat == null ? "-" : pr.dibuat.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")));
        } catch (Exception ex) {
            galat(ex);
            txtNama.setText(pengguna.getNama());
            valUsername.setText(pengguna.getUsername());
            valPeran.setText(pengguna.getPeran());
            valWilayah.setText(pengguna.getWilayah() == null ? "Pusat (semua wilayah)" : pengguna.getWilayah());
        }
        segarkanTampilan();
    }

    private void segarkanTampilan() {
        lblFoto.setIcon(FotoProfil.avatar(pengguna.getFoto(), pengguna.getNama(), AVATAR));
        lblNamaBesar.setText(pengguna.getNama());
        lblPeranBadge.setText(pengguna.getPeran().toUpperCase());
        btnHapusFoto.setEnabled(pengguna.getFoto() != null);
    }

    // ---------- aksi ----------
    private void gantiFoto() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Pilih foto profil");
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Gambar (JPG, PNG, GIF, BMP)", "jpg", "jpeg", "png", "gif", "bmp"));
        if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File f = fc.getSelectedFile();
        try {
            controller.ubahFoto(pengguna, f);
            segarkanTampilan();
        } catch (Exception ex) { galat(ex); }
    }

    private void hapusFoto() {
        if (JOptionPane.showConfirmDialog(this, "Hapus foto profil? Tampilan akan kembali ke inisial nama.",
                "Konfirmasi", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try {
            controller.hapusFoto(pengguna);
            segarkanTampilan();
        } catch (Exception ex) { galat(ex); }
    }

    private void simpanNama() {
        try {
            controller.ubahNama(pengguna, txtNama.getText());
            txtNama.setText(pengguna.getNama());
            segarkanTampilan();
            JOptionPane.showMessageDialog(this, "Nama berhasil diperbarui.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) { galat(ex); }
    }

    private void ubahPassword() {
        char[] lama = pwLama.getPassword(), baru = pwBaru.getPassword(), konf = pwKonfirmasi.getPassword();
        try {
            controller.ubahPassword(pengguna, new String(lama), new String(baru), new String(konf));
            pwLama.setText(""); pwBaru.setText(""); pwKonfirmasi.setText("");
            selesai = true;
            btnTutup.setText(wajibGanti ? "Lanjutkan" : "Tutup");
            JOptionPane.showMessageDialog(this, "Password berhasil diubah.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            if (wajibGanti) dispose();
        } catch (Exception ex) {
            galat(ex);
        } finally {
            java.util.Arrays.fill(lama, '\0'); java.util.Arrays.fill(baru, '\0'); java.util.Arrays.fill(konf, '\0');
        }
    }

    private void tutup() {
        if (wajibGanti && !selesai) {
            if (JOptionPane.showConfirmDialog(this, "Password belum diganti, sesi login akan dibatalkan. Lanjutkan?",
                    "Batal", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        }
        dispose();
    }

    private void galat(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Profil", JOptionPane.ERROR_MESSAGE);
    }
}
