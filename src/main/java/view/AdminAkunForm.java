package view;

import controller.AdminController;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.table.DefaultTableModel;
import model.Pengguna;
import repository.DBConnection;

/**
 * ArgoPort | Admin Workspace - Kelola Akun Operator.
 * Tampilan diatur lewat NetBeans Design (AdminAkunForm.form); logika ada di luar blok GEN.
 */
public class AdminAkunForm extends javax.swing.JFrame {
    private final AdminController controller = new AdminController();

    public AdminAkunForm() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
        jalankan(this::muatAkun, "Gagal memuat data");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlAkun = new javax.swing.JPanel();
        scrollAkun = new javax.swing.JScrollPane();
        tblAkun = new javax.swing.JTable();
        btnHapusAkun = new javax.swing.JButton();
        btnMuatAkun = new javax.swing.JButton();
        pnlSidebar = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblBrand = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        btnMenuDashboard = new javax.swing.JButton();
        btnMenuPendaftaran = new javax.swing.JButton();
        btnMenuDaftarKapal = new javax.swing.JButton();
        btnMenuPenambatan = new javax.swing.JButton();
        btnMenuBongkarMuat = new javax.swing.JButton();
        btnMenuKargo = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnMenuKargo1 = new javax.swing.JButton();
        pnlHeader = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArgoPort | Admin Workspace - Kelola Akun Operator");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Kelola Akun Operator");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 40));

        pnlAkun.setBackground(new java.awt.Color(255, 255, 255));
        pnlAkun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollAkun.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblAkun.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblAkun.setForeground(new java.awt.Color(43, 57, 73));
        tblAkun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PENGGUNA", "NAMA", "DIVISI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAkun.setGridColor(new java.awt.Color(237, 241, 245));
        tblAkun.setRowHeight(30);
        tblAkun.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblAkun.setSelectionForeground(new java.awt.Color(25, 53, 78));
        scrollAkun.setViewportView(tblAkun);

        pnlAkun.add(scrollAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 930, 400));

        btnHapusAkun.setBackground(new java.awt.Color(253, 236, 234));
        btnHapusAkun.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnHapusAkun.setForeground(new java.awt.Color(176, 48, 38));
        btnHapusAkun.setText("Hapus akun operator");
        btnHapusAkun.setBorderPainted(false);
        btnHapusAkun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusAkun.setFocusPainted(false);
        btnHapusAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusAkunActionPerformed(evt);
            }
        });
        pnlAkun.add(btnHapusAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 200, 36));

        btnMuatAkun.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatAkun.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatAkun.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatAkun.setText("Muat ulang");
        btnMuatAkun.setBorderPainted(false);
        btnMuatAkun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatAkun.setFocusPainted(false);
        btnMuatAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatAkunActionPerformed(evt);
            }
        });
        pnlAkun.add(btnMuatAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 120, 36));

        pnlMain.add(pnlAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 970, 600));

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 1020, 760));

        pnlSidebar.setBackground(new java.awt.Color(17, 39, 67));
        pnlSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sidebar.png"))); // NOI18N
        pnlSidebar.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 31, 42, 42));

        lblBrand.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(255, 255, 255));
        lblBrand.setText("Argoport System");
        pnlSidebar.add(lblBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 175, 35));

        lblRole.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("Menu Admin");
        pnlSidebar.add(lblRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 200, 22));

        btnMenuDashboard.setBackground(new java.awt.Color(204, 255, 255));
        btnMenuDashboard.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMenuDashboard.setForeground(new java.awt.Color(0, 0, 51));
        btnMenuDashboard.setText("Dashboard");
        btnMenuDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 8));
        btnMenuDashboard.setBorderPainted(false);
        btnMenuDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuDashboard.setFocusPainted(false);
        btnMenuDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuDashboard.setOpaque(true);
        btnMenuDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuDashboardActionPerformed(evt);
            }
        });
        pnlSidebar.add(btnMenuDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 240, 39));

        btnMenuPendaftaran.setBackground(new java.awt.Color(204, 255, 255));
        btnMenuPendaftaran.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMenuPendaftaran.setForeground(new java.awt.Color(0, 0, 51));
        btnMenuPendaftaran.setText("Kelola Dermaga");
        btnMenuPendaftaran.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 8));
        btnMenuPendaftaran.setBorderPainted(false);
        btnMenuPendaftaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuPendaftaran.setFocusPainted(false);
        btnMenuPendaftaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuPendaftaran.setOpaque(true);
        btnMenuPendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPendaftaranActionPerformed(evt);
            }
        });
        pnlSidebar.add(btnMenuPendaftaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 240, 39));

        btnMenuDaftarKapal.setBackground(new java.awt.Color(204, 255, 255));
        btnMenuDaftarKapal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMenuDaftarKapal.setForeground(new java.awt.Color(0, 0, 51));
        btnMenuDaftarKapal.setText("Kelola Slot Gudang");
        btnMenuDaftarKapal.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 8));
        btnMenuDaftarKapal.setBorderPainted(false);
        btnMenuDaftarKapal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuDaftarKapal.setFocusPainted(false);
        btnMenuDaftarKapal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuDaftarKapal.setOpaque(true);
        btnMenuDaftarKapal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuDaftarKapalActionPerformed(evt);
            }
        });
        pnlSidebar.add(btnMenuDaftarKapal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 240, 39));

        btnMenuPenambatan.setBackground(new java.awt.Color(204, 255, 255));
        btnMenuPenambatan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMenuPenambatan.setForeground(new java.awt.Color(0, 0, 51));
        btnMenuPenambatan.setText("Kelola Tarif Retribusi");
        btnMenuPenambatan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 8));
        btnMenuPenambatan.setBorderPainted(false);
        btnMenuPenambatan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuPenambatan.setFocusPainted(false);
        btnMenuPenambatan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuPenambatan.setOpaque(true);
        btnMenuPenambatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPenambatanActionPerformed(evt);
            }
        });
        pnlSidebar.add(btnMenuPenambatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 240, 39));

        btnMenuBongkarMuat.setBackground(new java.awt.Color(204, 255, 255));
        btnMenuBongkarMuat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMenuBongkarMuat.setForeground(new java.awt.Color(0, 0, 51));
        btnMenuBongkarMuat.setText("Billing & Pembayaran");
        btnMenuBongkarMuat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 8));
        btnMenuBongkarMuat.setBorderPainted(false);
        btnMenuBongkarMuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuBongkarMuat.setFocusPainted(false);
        btnMenuBongkarMuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuBongkarMuat.setOpaque(true);
        btnMenuBongkarMuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuBongkarMuatActionPerformed(evt);
            }
        });
        pnlSidebar.add(btnMenuBongkarMuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 240, 39));

        btnMenuKargo.setBackground(new java.awt.Color(204, 255, 255));
        btnMenuKargo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMenuKargo.setForeground(new java.awt.Color(0, 0, 51));
        btnMenuKargo.setText("Laporan");
        btnMenuKargo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 8));
        btnMenuKargo.setBorderPainted(false);
        btnMenuKargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuKargo.setFocusPainted(false);
        btnMenuKargo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuKargo.setOpaque(true);
        btnMenuKargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuKargoActionPerformed(evt);
            }
        });
        pnlSidebar.add(btnMenuKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 240, 39));

        btnLogout.setBackground(new java.awt.Color(0, 0, 51));
        btnLogout.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(204, 255, 255));
        btnLogout.setText("Keluar");
        btnLogout.setContentAreaFilled(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        pnlSidebar.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 730, 205, 35));

        btnMenuKargo1.setBackground(new java.awt.Color(204, 255, 255));
        btnMenuKargo1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnMenuKargo1.setForeground(new java.awt.Color(0, 0, 51));
        btnMenuKargo1.setText("Kelola Akun Operator");
        btnMenuKargo1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 8));
        btnMenuKargo1.setBorderPainted(false);
        btnMenuKargo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuKargo1.setFocusPainted(false);
        btnMenuKargo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuKargo1.setOpaque(true);
        btnMenuKargo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuKargo1ActionPerformed(evt);
            }
        });
        pnlSidebar.add(btnMenuKargo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 240, 39));

        getContentPane().add(pnlSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 820));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        userLabel.setForeground(new java.awt.Color(37, 54, 74));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userLabel.setText("Pengguna");
        pnlHeader.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(965, 18, 80, 25));

        getContentPane().add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 0, 1065, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHapusAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusAkunActionPerformed
        jalankan(this::hapusAkun, "Akun tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusAkunActionPerformed

    private void btnMuatAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatAkunActionPerformed
        jalankan(this::muatAkun, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatAkunActionPerformed

    private void btnMenuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuDashboardActionPerformed
        bukaMenu(0);
    }//GEN-LAST:event_btnMenuDashboardActionPerformed

    private void btnMenuPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPendaftaranActionPerformed
        bukaMenu(1);
    }//GEN-LAST:event_btnMenuPendaftaranActionPerformed

    private void btnMenuDaftarKapalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuDaftarKapalActionPerformed
        bukaMenu(2);
    }//GEN-LAST:event_btnMenuDaftarKapalActionPerformed

    private void btnMenuPenambatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPenambatanActionPerformed
        bukaMenu(3);
    }//GEN-LAST:event_btnMenuPenambatanActionPerformed

    private void btnMenuBongkarMuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuBongkarMuatActionPerformed
        bukaMenu(4);
    }//GEN-LAST:event_btnMenuBongkarMuatActionPerformed

    private void btnMenuKargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuKargoActionPerformed
        bukaMenu(5);
    }//GEN-LAST:event_btnMenuKargoActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        DBConnection.logout();
        dispose();
        new WelcomeView().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnMenuKargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuKargo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuKargo1ActionPerformed

    // ---------- util ----------
    private interface Aksi { void jalankan() throws Exception; }

    private void jalankan(Aksi a, String judulError) {
        try {
            a.jalankan();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), judulError, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void isi(JTable tabel, List<Object[]> baris) {
        DefaultTableModel m = (DefaultTableModel) tabel.getModel();
        m.setRowCount(0);
        for (Object[] r : baris) m.addRow(r);
    }

    private String dipilih(JTable tabel, int kolom, String pesan) throws Exception {
        int r = tabel.getSelectedRow();
        if (r < 0) throw new Exception(pesan);
        return String.valueOf(tabel.getModel().getValueAt(tabel.convertRowIndexToModel(r), kolom));
    }

    private double angka(JTextField f, String nama) throws Exception {
        try {
            return Double.parseDouble(f.getText().trim().replace(',', '.'));
        } catch (NumberFormatException ex) {
            throw new Exception(nama + " harus berupa angka.");
        }
    }

    private boolean konfirmasi(String pesan) {
        return JOptionPane.showConfirmDialog(this, pesan, "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    private void info(String pesan) {
        JOptionPane.showMessageDialog(this, pesan, "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }

    private void gayaTabel(JTable t, JScrollPane sp) {
        t.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 10));
        t.getTableHeader().setBackground(new java.awt.Color(246, 248, 251));
        sp.getViewport().setBackground(java.awt.Color.WHITE);
    }

    // ---------- inisialisasi (di luar Design) ----------
    // Tambahan komponen dipasang lewat kode di sini (bukan di blok GEN) supaya aman bila form dibuka di NetBeans Design.
    private JButton btnResetSandi;
    private JButton btnToggleStatus;

    private void siapkan() {
        util.ProfilHeader.pasang(this, userLabel, pnlHeader, "Administrator");
        util.Navigasi.gayaSidebar(btnMenuDashboard, btnMenuDermaga, btnMenuSlot, btnMenuTarif, btnMenuBilling, btnMenuAkun, btnMenuLaporan);
        util.Navigasi.pasangKeluar(btnLogout, btnMenuDashboard, btnMenuDermaga, btnMenuSlot, btnMenuTarif, btnMenuBilling, btnMenuAkun, btnMenuLaporan);
        gayaTabel(tblAkun, scrollAkun);

        lblSubheading.setText("Akun login operator. Reset password, nonaktifkan akses, atau hapus permanen.");
        btnHapusAkun.setText("Hapus permanen");

        // Tabel mengikuti kolom akun_aplikasi (tabel yang dipakai saat login).
        tblAkun.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"ID AKUN", "NAMA LENGKAP", "USERNAME", "STATUS", "TERDAFTAR"}) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        });
        tblAkun.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAkun.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblAkun.getColumnModel().getColumn(1).setPreferredWidth(260);
        tblAkun.getColumnModel().getColumn(2).setPreferredWidth(170);
        tblAkun.getColumnModel().getColumn(3).setPreferredWidth(90);
        tblAkun.getColumnModel().getColumn(4).setPreferredWidth(160);
        tblAkun.getColumnModel().getColumn(3).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override public java.awt.Component getTableCellRendererComponent(JTable t, Object v, boolean sel, boolean foc, int r, int c) {
                java.awt.Component k = super.getTableCellRendererComponent(t, v, sel, foc, r, c);
                boolean aktif = "Aktif".equals(String.valueOf(v));
                k.setFont(k.getFont().deriveFont(Font.BOLD));
                if (!sel) k.setForeground(aktif ? new Color(26, 122, 74) : new Color(176, 48, 38));
                return k;
            }
        });

        btnResetSandi = tombolAksi("Reset password", new Color(255, 244, 214), new Color(120, 72, 0));
        btnResetSandi.addActionListener(e -> jalankan(this::resetSandi, "Password tidak dapat direset"));
        pnlAkun.add(btnResetSandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 150, 36));

        btnToggleStatus = tombolAksi("Nonaktifkan", new Color(235, 241, 247), new Color(43, 73, 101));
        btnToggleStatus.addActionListener(e -> jalankan(this::ubahStatus, "Status akun tidak dapat diubah"));
        pnlAkun.add(btnToggleStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 150, 36));

        tblAkun.getSelectionModel().addListSelectionListener(e -> { if (!e.getValueIsAdjusting()) segarkanTombol(); });
        segarkanTombol();
        pnlAkun.revalidate();
        pnlAkun.repaint();
    }

    private JButton tombolAksi(String teks, Color latar, Color teksWarna) {
        JButton b = new JButton(teks);
        b.setBackground(latar);
        b.setForeground(teksWarna);
        b.setFont(new Font("SansSerif", Font.BOLD, 11));
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        return b;
    }

    /** Label tombol status mengikuti akun yang dipilih: Nonaktifkan atau Aktifkan kembali. */
    private void segarkanTombol() {
        int r = tblAkun.getSelectedRow();
        boolean ada = r >= 0;
        boolean aktif = !ada || "Aktif".equals(String.valueOf(tblAkun.getModel().getValueAt(tblAkun.convertRowIndexToModel(r), 3)));
        btnToggleStatus.setText(aktif ? "Nonaktifkan" : "Aktifkan kembali");
        btnToggleStatus.setEnabled(ada);
        btnResetSandi.setEnabled(ada);
        btnHapusAkun.setEnabled(ada);
    }

    private void muatAkun() throws Exception { isi(tblAkun, controller.getDaftarOperator()); segarkanTombol(); }

    private String namaDipilih() {
        int r = tblAkun.convertRowIndexToModel(tblAkun.getSelectedRow());
        return tblAkun.getModel().getValueAt(r, 1) + " (" + tblAkun.getModel().getValueAt(r, 2) + ")";
    }

    private void resetSandi() throws Exception {
        String id = dipilih(tblAkun, 0, "Pilih akun operator dari tabel terlebih dahulu.");
        String nama = namaDipilih();
        if (!konfirmasi("Reset password " + nama + "?\nPassword lama tidak berlaku lagi. Operator wajib menggantinya saat login berikutnya.")) return;
        String sementara = controller.resetPasswordOperator(id);
        javax.swing.JTextField f = new javax.swing.JTextField(sementara);
        f.setEditable(false);
        f.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        f.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel p = new JPanel(new java.awt.BorderLayout(0, 8));
        p.add(new JLabel("<html>Password sementara untuk <b>" + nama.replace("<", "&lt;") + "</b>:</html>"), java.awt.BorderLayout.NORTH);
        p.add(f, java.awt.BorderLayout.CENTER);
        p.add(new JLabel("<html><font color='#a03020'>Catat sekarang. Password ini tidak akan ditampilkan lagi.</font></html>"), java.awt.BorderLayout.SOUTH);
        int pilih = JOptionPane.showOptionDialog(this, p, "Reset Password Berhasil", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Salin", "Tutup"}, "Salin");
        if (pilih == 0) {
            java.awt.Toolkit.getDefaultToolkit().getSystemClipboard()
                    .setContents(new java.awt.datatransfer.StringSelection(sementara), null);
        }
    }

    private void ubahStatus() throws Exception {
        String id = dipilih(tblAkun, 0, "Pilih akun operator dari tabel terlebih dahulu.");
        boolean sedangAktif = "Aktif".equals(dipilih(tblAkun, 3, ""));
        String nama = namaDipilih();
        String pesan = sedangAktif
                ? "Nonaktifkan akun " + nama + "?\nOperator tidak bisa login, tetapi datanya tetap tersimpan dan bisa diaktifkan lagi."
                : "Aktifkan kembali akun " + nama + "?";
        if (!konfirmasi(pesan)) return;
        controller.ubahStatusAkunOperator(id, !sedangAktif);
        info(sedangAktif ? "Akun berhasil dinonaktifkan." : "Akun berhasil diaktifkan kembali.");
        muatAkun();
    }

    private void hapusAkun() throws Exception {
        String id = dipilih(tblAkun, 0, "Pilih akun operator dari tabel terlebih dahulu.");
        String nama = namaDipilih();
        if (!konfirmasi("HAPUS PERMANEN akun " + nama + "?\nTindakan ini tidak bisa dibatalkan.\nJika hanya ingin menutup akses, pilih Nonaktifkan.")) return;
        controller.hapusAkunOperator(id);
        info("Akun Operator Berhasil Dihapus!");
        muatAkun();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusAkun;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuKargo1;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnMuatAkun;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pnlAkun;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JScrollPane scrollAkun;
    private javax.swing.JTable tblAkun;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
