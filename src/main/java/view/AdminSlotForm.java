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
 * ArgoPort | Admin Workspace - Kelola Slot Gudang.
 * Tampilan diatur lewat NetBeans Design (AdminSlotForm.form); logika ada di luar blok GEN.
 */
public class AdminSlotForm extends javax.swing.JFrame {
    private final AdminController controller = new AdminController();

    public AdminSlotForm() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
        jalankan(this::muatSlot, "Gagal memuat data");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlSlot = new javax.swing.JPanel();
        lblKodeBlok = new javax.swing.JLabel();
        lblKapasitasSlot = new javax.swing.JLabel();
        lblOperatorSlot = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtKapasitasSlot = new javax.swing.JTextField();
        btnTambahSlot = new javax.swing.JButton();
        btnUbahSlot = new javax.swing.JButton();
        btnHapusSlot = new javax.swing.JButton();
        btnMuatSlot = new javax.swing.JButton();
        scrollSlot = new javax.swing.JScrollPane();
        tblSlot = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
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
        setTitle("ArgoPort | Admin Workspace - Kelola Slot Gudang");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Kelola Slot Gudang");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 800, 40));

        pnlSlot.setBackground(new java.awt.Color(255, 255, 255));
        pnlSlot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblKodeBlok.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblKodeBlok.setForeground(new java.awt.Color(93, 108, 125));
        lblKodeBlok.setText("Kode blok");
        pnlSlot.add(lblKodeBlok, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 220, 18));

        lblKapasitasSlot.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblKapasitasSlot.setForeground(new java.awt.Color(93, 108, 125));
        lblKapasitasSlot.setText("Kapasitas volume (m3)");
        pnlSlot.add(lblKapasitasSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 220, 18));

        lblOperatorSlot.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblOperatorSlot.setForeground(new java.awt.Color(93, 108, 125));
        lblOperatorSlot.setText("ID operator penanggung jawab");
        pnlSlot.add(lblOperatorSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 240, 18));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        pnlSlot.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 270, 40));

        txtKapasitasSlot.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtKapasitasSlot.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlSlot.add(txtKapasitasSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 280, 36));

        btnTambahSlot.setBackground(new java.awt.Color(27, 93, 145));
        btnTambahSlot.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnTambahSlot.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahSlot.setText("Tambah");
        btnTambahSlot.setBorderPainted(false);
        btnTambahSlot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambahSlot.setFocusPainted(false);
        btnTambahSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahSlotActionPerformed(evt);
            }
        });
        pnlSlot.add(btnTambahSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 36));

        btnUbahSlot.setBackground(new java.awt.Color(235, 241, 247));
        btnUbahSlot.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnUbahSlot.setForeground(new java.awt.Color(43, 73, 101));
        btnUbahSlot.setText("Ubah kapasitas");
        btnUbahSlot.setBorderPainted(false);
        btnUbahSlot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbahSlot.setFocusPainted(false);
        btnUbahSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahSlotActionPerformed(evt);
            }
        });
        pnlSlot.add(btnUbahSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 150, 36));

        btnHapusSlot.setBackground(new java.awt.Color(253, 236, 234));
        btnHapusSlot.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnHapusSlot.setForeground(new java.awt.Color(176, 48, 38));
        btnHapusSlot.setText("Hapus");
        btnHapusSlot.setBorderPainted(false);
        btnHapusSlot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusSlot.setFocusPainted(false);
        btnHapusSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusSlotActionPerformed(evt);
            }
        });
        pnlSlot.add(btnHapusSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 110, 36));

        btnMuatSlot.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatSlot.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatSlot.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatSlot.setText("Muat ulang");
        btnMuatSlot.setBorderPainted(false);
        btnMuatSlot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatSlot.setFocusPainted(false);
        btnMuatSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatSlotActionPerformed(evt);
            }
        });
        pnlSlot.add(btnMuatSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 120, 36));

        scrollSlot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblSlot.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblSlot.setGridColor(new java.awt.Color(237, 241, 245));
        tblSlot.setRowHeight(30);
        tblSlot.setForeground(new java.awt.Color(43, 57, 73));
        tblSlot.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblSlot.setSelectionForeground(new java.awt.Color(25, 53, 78));
        tblSlot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID SLOT", "KODE BLOK", "KAPASITAS (M3)", "SISA (M3)", "STATUS", "ID OPERATOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollSlot.setViewportView(tblSlot);

        pnlSlot.add(scrollSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 900, 300));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        pnlSlot.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, 40));

        pnlMain.add(pnlSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 960, 600));

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

    private void btnHapusSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusSlotActionPerformed
        jalankan(this::hapusSlot, "Slot gudang tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusSlotActionPerformed

    private void btnMuatSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatSlotActionPerformed
        jalankan(this::muatSlot, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatSlotActionPerformed

    private void btnTambahSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahSlotActionPerformed
        jalankan(this::tambahSlot, "Data slot gudang tidak valid");
    }//GEN-LAST:event_btnTambahSlotActionPerformed

    private void btnUbahSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahSlotActionPerformed
        jalankan(this::ubahSlot, "Data slot gudang tidak valid");
    }//GEN-LAST:event_btnUbahSlotActionPerformed

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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
        gayaTabel(tblSlot, scrollSlot);
        tblSlot.getSelectionModel().addListSelectionListener(e -> {
            int r = tblSlot.getSelectedRow();
            if (e.getValueIsAdjusting() || r < 0) return;
            jComboBox2.setSelectedItem(String.valueOf(tblSlot.getValueAt(r, 1)));
            txtKapasitasSlot.setText(String.valueOf(tblSlot.getValueAt(r, 2)));
            jComboBox1.setSelectedItem(String.valueOf(tblSlot.getValueAt(r, 5)));
        });
    }

    private void muatSlot() throws Exception { isi(tblSlot, controller.getDaftarSlot()); }

    private void tambahSlot() throws Exception {
        controller.tambahSlotGudang(String.valueOf(jComboBox2.getSelectedItem()), angka(txtKapasitasSlot, "Kapasitas"), String.valueOf(jComboBox1.getSelectedItem()));
        info("Data Slot Gudang Berhasil Disimpan!");
        muatSlot();
    }

    private void ubahSlot() throws Exception {
        String id = dipilih(tblSlot, 0, "Pilih slot gudang dari tabel terlebih dahulu.");
        controller.ubahKapasitasSlot(id, angka(txtKapasitasSlot, "Kapasitas"));
        info("Data Slot Gudang Berhasil Disimpan!");
        muatSlot();
    }

    private void hapusSlot() throws Exception {
        String id = dipilih(tblSlot, 0, "Pilih slot gudang dari tabel terlebih dahulu.");
        if (!konfirmasi("Hapus slot gudang " + id + "?")) return;
        controller.hapusSlotGudang(id);
        info("Data Slot Gudang Berhasil Dihapus!");
        muatSlot();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusSlot;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuKargo1;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnMuatSlot;
    private javax.swing.JButton btnTambahSlot;
    private javax.swing.JButton btnUbahSlot;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblKapasitasSlot;
    private javax.swing.JLabel lblKodeBlok;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblOperatorSlot;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlSlot;
    private javax.swing.JScrollPane scrollSlot;
    private javax.swing.JTable tblSlot;
    private javax.swing.JTextField txtKapasitasSlot;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
