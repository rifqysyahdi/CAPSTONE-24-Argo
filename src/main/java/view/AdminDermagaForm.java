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
 * ArgoPort | Admin Workspace - Kelola Dermaga.
 * Tampilan diatur lewat NetBeans Design (AdminDermagaForm.form); logika ada di luar blok GEN.
 */
public class AdminDermagaForm extends javax.swing.JFrame {
    private final AdminController controller = new AdminController();

    public AdminDermagaForm() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
        jalankan(this::muatDermaga, "Gagal memuat data");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlDermaga = new javax.swing.JPanel();
        scrollDermaga = new javax.swing.JScrollPane();
        tblDermaga = new javax.swing.JTable();
        lblKodeDermaga = new javax.swing.JLabel();
        lblNamaDermaga = new javax.swing.JLabel();
        lblKapasitasDermaga = new javax.swing.JLabel();
        txtKodeDermaga = new javax.swing.JTextField();
        txtNamaDermaga = new javax.swing.JTextField();
        txtKapasitasDermaga = new javax.swing.JTextField();
        btnTambahDermaga = new javax.swing.JButton();
        btnUbahDermaga = new javax.swing.JButton();
        btnStatusDermaga = new javax.swing.JButton();
        btnHapusDermaga = new javax.swing.JButton();
        btnMuatDermaga = new javax.swing.JButton();
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
        setTitle("ArgoPort | Admin Workspace - Kelola Dermaga");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Kelola Dermaga");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 800, 40));

        pnlDermaga.setBackground(new java.awt.Color(255, 255, 255));
        pnlDermaga.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollDermaga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblDermaga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblDermaga.setForeground(new java.awt.Color(43, 57, 73));
        tblDermaga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID DERMAGA", "NAMA DERMAGA", "KAPASITAS MAKSIMAL (TON)", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDermaga.setGridColor(new java.awt.Color(237, 241, 245));
        tblDermaga.setRowHeight(30);
        tblDermaga.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblDermaga.setSelectionForeground(new java.awt.Color(25, 53, 78));
        scrollDermaga.setViewportView(tblDermaga);

        pnlDermaga.add(scrollDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 900, 360));

        lblKodeDermaga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblKodeDermaga.setForeground(new java.awt.Color(93, 108, 125));
        lblKodeDermaga.setText("Kode dermaga");
        pnlDermaga.add(lblKodeDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 220, 18));

        lblNamaDermaga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNamaDermaga.setForeground(new java.awt.Color(93, 108, 125));
        lblNamaDermaga.setText("Nama dermaga");
        pnlDermaga.add(lblNamaDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 220, 18));

        lblKapasitasDermaga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblKapasitasDermaga.setForeground(new java.awt.Color(93, 108, 125));
        lblKapasitasDermaga.setText("Kapasitas maksimal (ton)");
        pnlDermaga.add(lblKapasitasDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 220, 18));

        txtKodeDermaga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtKodeDermaga.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlDermaga.add(txtKodeDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 200, 36));

        txtNamaDermaga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNamaDermaga.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlDermaga.add(txtNamaDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 360, 36));

        txtKapasitasDermaga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtKapasitasDermaga.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlDermaga.add(txtKapasitasDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 260, 36));

        btnTambahDermaga.setBackground(new java.awt.Color(27, 93, 145));
        btnTambahDermaga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnTambahDermaga.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahDermaga.setText("Tambah");
        btnTambahDermaga.setBorderPainted(false);
        btnTambahDermaga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambahDermaga.setFocusPainted(false);
        btnTambahDermaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDermagaActionPerformed(evt);
            }
        });
        pnlDermaga.add(btnTambahDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, 36));

        btnUbahDermaga.setBackground(new java.awt.Color(235, 241, 247));
        btnUbahDermaga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnUbahDermaga.setForeground(new java.awt.Color(43, 73, 101));
        btnUbahDermaga.setText("Ubah nama & kapasitas");
        btnUbahDermaga.setBorderPainted(false);
        btnUbahDermaga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbahDermaga.setFocusPainted(false);
        btnUbahDermaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahDermagaActionPerformed(evt);
            }
        });
        pnlDermaga.add(btnUbahDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 190, 36));

        btnStatusDermaga.setBackground(new java.awt.Color(235, 241, 247));
        btnStatusDermaga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnStatusDermaga.setForeground(new java.awt.Color(43, 73, 101));
        btnStatusDermaga.setText("Ubah status");
        btnStatusDermaga.setBorderPainted(false);
        btnStatusDermaga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStatusDermaga.setFocusPainted(false);
        btnStatusDermaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusDermagaActionPerformed(evt);
            }
        });
        pnlDermaga.add(btnStatusDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 130, 36));

        btnHapusDermaga.setBackground(new java.awt.Color(253, 236, 234));
        btnHapusDermaga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnHapusDermaga.setForeground(new java.awt.Color(176, 48, 38));
        btnHapusDermaga.setText("Hapus");
        btnHapusDermaga.setBorderPainted(false);
        btnHapusDermaga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusDermaga.setFocusPainted(false);
        btnHapusDermaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusDermagaActionPerformed(evt);
            }
        });
        pnlDermaga.add(btnHapusDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 110, 36));

        btnMuatDermaga.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatDermaga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatDermaga.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatDermaga.setText("Muat ulang");
        btnMuatDermaga.setBorderPainted(false);
        btnMuatDermaga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatDermaga.setFocusPainted(false);
        btnMuatDermaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatDermagaActionPerformed(evt);
            }
        });
        pnlDermaga.add(btnMuatDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 120, 36));

        pnlMain.add(pnlDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 960, 640));

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

    private void btnHapusDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDermagaActionPerformed
        jalankan(this::hapusDermaga, "Dermaga tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusDermagaActionPerformed

    private void btnMuatDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatDermagaActionPerformed
        jalankan(this::muatDermaga, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatDermagaActionPerformed

    private void btnStatusDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusDermagaActionPerformed
        jalankan(this::ubahStatusDermaga, "Status dermaga gagal diubah");
    }//GEN-LAST:event_btnStatusDermagaActionPerformed

    private void btnTambahDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDermagaActionPerformed
        jalankan(this::tambahDermaga, "Data dermaga tidak valid");
    }//GEN-LAST:event_btnTambahDermagaActionPerformed

    private void btnUbahDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahDermagaActionPerformed
        jalankan(this::ubahDermaga, "Data dermaga tidak valid");
    }//GEN-LAST:event_btnUbahDermagaActionPerformed

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

    private void bukaMenu(int index) {
    dispose();
    switch (index) {
        case 0: new DashboardAdmin(util.Sesi.pengguna).setVisible(true); break;
        case 1: new AdminDermagaForm().setVisible(true); break;
        case 2: new AdminSlotForm().setVisible(true); break;
        case 3: new AdminTarifForm().setVisible(true); break;
        case 4: new AdminBillingForm().setVisible(true); break;
        case 5: new AdminAkunForm().setVisible(true); break;
        default: new AdminLaporanForm().setVisible(true);
    }
}
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
        util.ProfilHeader.pasang(this, userLabel, pnlHeader, "Administrator");
        util.Navigasi.gayaSidebar(btnMenuDashboard, btnMenuPendaftaran, btnMenuDaftarKapal, btnMenuPenambatan, btnMenuBongkarMuat, btnMenuKargo1, btnMenuKargo);
        util.Navigasi.pasangKeluar(btnLogout, btnMenuDashboard, btnMenuPendaftaran, btnMenuDaftarKapal, btnMenuPenambatan, btnMenuBongkarMuat, btnMenuKargo1, btnMenuKargo);
        gayaTabel(tblDermaga, scrollDermaga);
        tblDermaga.getSelectionModel().addListSelectionListener(e -> {
            int r = tblDermaga.getSelectedRow();
            if (e.getValueIsAdjusting() || r < 0) return;
            txtKodeDermaga.setText(String.valueOf(tblDermaga.getValueAt(r, 0)));
            txtNamaDermaga.setText(String.valueOf(tblDermaga.getValueAt(r, 1)));
            txtKapasitasDermaga.setText(String.valueOf(tblDermaga.getValueAt(r, 2)));
        });
    }

    private void muatDermaga() throws Exception { isi(tblDermaga, controller.getDaftarDermaga()); }

    private void tambahDermaga() throws Exception {
        controller.tambahDermaga(txtKodeDermaga.getText(), txtNamaDermaga.getText(), angka(txtKapasitasDermaga, "Kapasitas"));
        info("Data Dermaga Berhasil Disimpan!");
        muatDermaga();
    }

    private void ubahDermaga() throws Exception {
        String id = dipilih(tblDermaga, 0, "Pilih dermaga dari tabel terlebih dahulu.");
        controller.ubahDermaga(id, txtNamaDermaga.getText(), angka(txtKapasitasDermaga, "Kapasitas"));
        info("Data Dermaga Berhasil Diubah!");
        muatDermaga();
    }

    private void ubahStatusDermaga() throws Exception {
        String id = dipilih(tblDermaga, 0, "Pilih dermaga dari tabel terlebih dahulu.");
        Object status = JOptionPane.showInputDialog(this, "Status baru untuk dermaga " + id + ":", "Ubah status dermaga",
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Tersedia", "Terisi", "Perbaikan"}, "Tersedia");
        if (status == null) return;
        controller.ubahStatusDermaga(id, status.toString());
        info("Status dermaga berhasil diubah.");
        muatDermaga();
    }

    private void hapusDermaga() throws Exception {
        String id = dipilih(tblDermaga, 0, "Pilih dermaga dari tabel terlebih dahulu.");
        if (!konfirmasi("Hapus dermaga " + id + "?")) return;
        controller.hapusDermaga(id);
        info("Data Dermaga Berhasil Dihapus!");
        muatDermaga();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusDermaga;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuKargo1;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnMuatDermaga;
    private javax.swing.JButton btnStatusDermaga;
    private javax.swing.JButton btnTambahDermaga;
    private javax.swing.JButton btnUbahDermaga;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblKapasitasDermaga;
    private javax.swing.JLabel lblKodeDermaga;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNamaDermaga;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pnlDermaga;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JScrollPane scrollDermaga;
    private javax.swing.JTable tblDermaga;
    private javax.swing.JTextField txtKapasitasDermaga;
    private javax.swing.JTextField txtKodeDermaga;
    private javax.swing.JTextField txtNamaDermaga;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
