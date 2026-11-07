package view;

import controller.OperatorController;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
 * ArgoPort | Operator Workspace - Kelola Data Kargo.
 * Tampilan diatur lewat NetBeans Design (OperatorKargoForm.form); logika ada di luar blok GEN.
 */
public class OperatorKargoForm extends javax.swing.JFrame {
    private final OperatorController controller = new OperatorController();

    public OperatorKargoForm() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
        jalankan(this::muatKargo, "Gagal memuat data");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlKargo = new javax.swing.JPanel();
        scrollKargo = new javax.swing.JScrollPane();
        tblKargo = new javax.swing.JTable();
        jLabelNamaBaru = new javax.swing.JLabel();
        jLabelBeratBaru = new javax.swing.JLabel();
        txtNamaBaru = new javax.swing.JTextField();
        txtBeratBaru = new javax.swing.JTextField();
        btnUbahKargo = new javax.swing.JButton();
        btnMuatKargo = new javax.swing.JButton();
        btnHapusKargo = new javax.swing.JButton();
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
        pnlHeader = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArgoPort | Operator Workspace - Kelola Data Kargo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Kelola Data Kargo");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 40));

        pnlKargo.setBackground(new java.awt.Color(255, 255, 255));
        pnlKargo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollKargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblKargo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblKargo.setGridColor(new java.awt.Color(237, 241, 245));
        tblKargo.setRowHeight(30);
        tblKargo.setForeground(new java.awt.Color(43, 57, 73));
        tblKargo.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblKargo.setSelectionForeground(new java.awt.Color(25, 53, 78));
        tblKargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID KARGO", "NAMA BARANG", "BERAT (TON)", "VOLUME (M3)", "STATUS", "ID KAPAL", "ID SLOT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollKargo.setViewportView(tblKargo);

        pnlKargo.add(scrollKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 930, 330));

        jLabelNamaBaru.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelNamaBaru.setForeground(new java.awt.Color(93, 108, 125));
        jLabelNamaBaru.setText("Nama barang baru");
        pnlKargo.add(jLabelNamaBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 18));

        jLabelBeratBaru.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelBeratBaru.setForeground(new java.awt.Color(93, 108, 125));
        jLabelBeratBaru.setText("Berat ton baru");
        pnlKargo.add(jLabelBeratBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 150, 18));

        txtNamaBaru.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNamaBaru.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlKargo.add(txtNamaBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 430, 36));

        txtBeratBaru.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBeratBaru.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlKargo.add(txtBeratBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 430, 36));

        btnUbahKargo.setBackground(new java.awt.Color(235, 241, 247));
        btnUbahKargo.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnUbahKargo.setForeground(new java.awt.Color(43, 73, 101));
        btnUbahKargo.setText("Ubah data kargo");
        btnUbahKargo.setBorderPainted(false);
        btnUbahKargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbahKargo.setFocusPainted(false);
        btnUbahKargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahKargoActionPerformed(evt);
            }
        });
        pnlKargo.add(btnUbahKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 36));

        btnMuatKargo.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatKargo.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatKargo.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatKargo.setText("Muat ulang");
        btnMuatKargo.setBorderPainted(false);
        btnMuatKargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatKargo.setFocusPainted(false);
        btnMuatKargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatKargoActionPerformed(evt);
            }
        });
        pnlKargo.add(btnMuatKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 120, 36));

        btnHapusKargo.setBackground(new java.awt.Color(253, 236, 234));
        btnHapusKargo.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnHapusKargo.setForeground(new java.awt.Color(176, 48, 38));
        btnHapusKargo.setText("Hapus kargo");
        btnHapusKargo.setBorderPainted(false);
        btnHapusKargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusKargo.setFocusPainted(false);
        btnHapusKargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusKargoActionPerformed(evt);
            }
        });
        pnlKargo.add(btnHapusKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 580, 120, 36));

        pnlMain.add(pnlKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 980, 640));

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
        lblRole.setText("Menu Operator");
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
        btnMenuPendaftaran.setText("Pendaftaran Kapal Baru");
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
        btnMenuDaftarKapal.setText("Lihat Daftar Kapal");
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
        btnMenuPenambatan.setText("Penambatan Kapal");
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
        btnMenuBongkarMuat.setText("Bongkar Muat Kargo");
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
        btnMenuKargo.setText("Kelola Data Kargo");
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
        pnlSidebar.add(btnMenuKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 240, 39));

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

    private void btnHapusKargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusKargoActionPerformed
        jalankan(this::hapusKargo, "Kargo tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusKargoActionPerformed

    private void btnMuatKargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatKargoActionPerformed
        jalankan(this::muatKargo, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatKargoActionPerformed

    private void btnUbahKargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahKargoActionPerformed
        jalankan(this::ubahKargo, "Data kargo tidak valid");
    }//GEN-LAST:event_btnUbahKargoActionPerformed

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
    private void siapkan() {
        util.ProfilHeader.pasang(this, userLabel, pnlHeader, "Operator");
        util.Navigasi.gayaSidebar(btnMenuDashboard, btnMenuPendaftaran, btnMenuDaftarKapal, btnMenuPenambatan, btnMenuBongkarMuat, btnMenuKargo);
        util.Navigasi.pasangKeluar(btnLogout, btnMenuDashboard, btnMenuPendaftaran, btnMenuDaftarKapal, btnMenuPenambatan, btnMenuBongkarMuat, btnMenuKargo);
        gayaTabel(tblKargo, scrollKargo);
        tblKargo.getSelectionModel().addListSelectionListener(e -> {
            int r = tblKargo.getSelectedRow();
            if (e.getValueIsAdjusting() || r < 0) return;
            txtNamaBaru.setText(String.valueOf(tblKargo.getValueAt(r, 1)));
            txtBeratBaru.setText(String.valueOf(tblKargo.getValueAt(r, 2)));
        });
    }

    private void muatKargo() throws Exception { isi(tblKargo, controller.getDaftarKargo()); }

    private void ubahKargo() throws Exception {
        String id = dipilih(tblKargo, 0, "Pilih kargo dari tabel terlebih dahulu.");
        controller.ubahKargo(id, txtNamaBaru.getText(), angka(txtBeratBaru, "Berat"));
        info("Data Kargo Berhasil Diubah!");
        muatKargo();
    }

    private void hapusKargo() throws Exception {
        String id = dipilih(tblKargo, 0, "Pilih kargo dari tabel terlebih dahulu.");
        if (!konfirmasi("Hapus data kargo " + id + "?")) return;
        controller.hapusKargo(id);
        info("Data Kargo Berhasil Dihapus!");
        muatKargo();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusKargo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnMuatKargo;
    private javax.swing.JButton btnUbahKargo;
    private javax.swing.JLabel jLabelBeratBaru;
    private javax.swing.JLabel jLabelNamaBaru;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlKargo;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JScrollPane scrollKargo;
    private javax.swing.JTable tblKargo;
    private javax.swing.JTextField txtBeratBaru;
    private javax.swing.JTextField txtNamaBaru;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
