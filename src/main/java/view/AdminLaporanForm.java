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
 * ArgoPort | Admin Workspace - Laporan.
 * Tampilan diatur lewat NetBeans Design (AdminLaporanForm.form); logika ada di luar blok GEN.
 */
public class AdminLaporanForm extends javax.swing.JFrame {
    private final AdminController controller = new AdminController();
    private AdminController.Laporan laporanTerakhir;
    private LocalDate laporanMulai, laporanAkhir;

    public AdminLaporanForm() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlLaporan = new javax.swing.JPanel();
        lblNilaiKapal = new javax.swing.JLabel();
        lblDari = new javax.swing.JLabel();
        lblSampai = new javax.swing.JLabel();
        txtDari = new javax.swing.JTextField();
        txtSampai = new javax.swing.JTextField();
        btnTampilLaporan = new javax.swing.JButton();
        btnEkspor = new javax.swing.JButton();
        lblKapalTitle = new javax.swing.JLabel();
        lblTonaseTitle = new javax.swing.JLabel();
        lblPendapatanTitle = new javax.swing.JLabel();
        lblNilaiTonase = new javax.swing.JLabel();
        lblNilaiPendapatan = new javax.swing.JLabel();
        scrollLaporan = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();
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
        setTitle("ArgoPort | Admin Workspace - Laporan");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Laporan");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 800, 40));

        pnlLaporan.setBackground(new java.awt.Color(255, 255, 255));
        pnlLaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNilaiKapal.setBackground(new java.awt.Color(0, 255, 0));
        lblNilaiKapal.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblNilaiKapal.setForeground(new java.awt.Color(0, 0, 51));
        lblNilaiKapal.setText("-");
        pnlLaporan.add(lblNilaiKapal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 240, 32));

        lblDari.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDari.setForeground(new java.awt.Color(93, 108, 125));
        lblDari.setText("Dari tanggal (yyyy-MM-dd)");
        pnlLaporan.add(lblDari, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 200, 18));

        lblSampai.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblSampai.setForeground(new java.awt.Color(93, 108, 125));
        lblSampai.setText("Sampai tanggal (yyyy-MM-dd)");
        pnlLaporan.add(lblSampai, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 200, 18));

        txtDari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDari.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlLaporan.add(txtDari, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 420, 36));

        txtSampai.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtSampai.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlLaporan.add(txtSampai, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 410, 36));

        btnTampilLaporan.setBackground(new java.awt.Color(27, 93, 145));
        btnTampilLaporan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTampilLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnTampilLaporan.setText("Tampilkan laporan");
        btnTampilLaporan.setBorderPainted(false);
        btnTampilLaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTampilLaporan.setFocusPainted(false);
        btnTampilLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilLaporanActionPerformed(evt);
            }
        });
        pnlLaporan.add(btnTampilLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 160, 36));

        btnEkspor.setBackground(new java.awt.Color(24, 116, 108));
        btnEkspor.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnEkspor.setForeground(new java.awt.Color(255, 255, 255));
        btnEkspor.setText("Ekspor ke EXCEL");
        btnEkspor.setBorderPainted(false);
        btnEkspor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEkspor.setFocusPainted(false);
        btnEkspor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEksporActionPerformed(evt);
            }
        });
        pnlLaporan.add(btnEkspor, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 140, 36));

        lblKapalTitle.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblKapalTitle.setForeground(new java.awt.Color(93, 108, 125));
        lblKapalTitle.setText("Jumlah kapal");
        pnlLaporan.add(lblKapalTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 200, 18));

        lblTonaseTitle.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTonaseTitle.setForeground(new java.awt.Color(93, 108, 125));
        lblTonaseTitle.setText("Total tonase muatan (ton)");
        pnlLaporan.add(lblTonaseTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 220, 18));

        lblPendapatanTitle.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPendapatanTitle.setForeground(new java.awt.Color(93, 108, 125));
        lblPendapatanTitle.setText("Total pendapatan (Rp)");
        pnlLaporan.add(lblPendapatanTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 220, 18));

        lblNilaiTonase.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblNilaiTonase.setForeground(new java.awt.Color(0, 0, 51));
        lblNilaiTonase.setText("-");
        pnlLaporan.add(lblNilaiTonase, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 240, 32));

        lblNilaiPendapatan.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblNilaiPendapatan.setForeground(new java.awt.Color(0, 0, 51));
        lblNilaiPendapatan.setText("-");
        pnlLaporan.add(lblNilaiPendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 330, 32));

        scrollLaporan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblLaporan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblLaporan.setForeground(new java.awt.Color(43, 57, 73));
        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID RETRIBUSI", "ID KAPAL", "NAMA KAPAL", "TANGGAL BAYAR", "TOTAL BIAYA (RP)", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLaporan.setGridColor(new java.awt.Color(237, 241, 245));
        tblLaporan.setRowHeight(30);
        tblLaporan.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblLaporan.setSelectionForeground(new java.awt.Color(25, 53, 78));
        scrollLaporan.setViewportView(tblLaporan);

        pnlLaporan.add(scrollLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 890, 300));

        pnlMain.add(pnlLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 950, 630));

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

    private void btnEksporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEksporActionPerformed
        jalankan(this::eksporLaporan, "Ekspor gagal");
    }//GEN-LAST:event_btnEksporActionPerformed

    private void btnTampilLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilLaporanActionPerformed
        jalankan(this::tampilLaporan, "Laporan gagal dibuat");
    }//GEN-LAST:event_btnTampilLaporanActionPerformed

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
        gayaTabel(tblLaporan, scrollLaporan);
        btnEkspor.setText("Ekspor ke Excel");
        txtDari.setText(LocalDate.now().withDayOfMonth(1).toString());
        txtSampai.setText(LocalDate.now().toString());
    }

    private void tampilLaporan() throws Exception {
        try {
            laporanMulai = LocalDate.parse(txtDari.getText().trim());
            laporanAkhir = LocalDate.parse(txtSampai.getText().trim());
        } catch (java.time.format.DateTimeParseException ex) {
            throw new Exception("Format tanggal harus yyyy-MM-dd, contoh 2026-10-31.");
        }
        laporanTerakhir = controller.buatLaporan(laporanMulai, laporanAkhir);
        lblNilaiKapal.setText(String.valueOf(laporanTerakhir.jumlahKapal));
        lblNilaiTonase.setText(String.format("%,.2f", laporanTerakhir.totalTonase));
        lblNilaiPendapatan.setText(String.format("%,.2f", laporanTerakhir.totalPendapatan));
        isi(tblLaporan, laporanTerakhir.detail);
    }

    private void eksporLaporan() throws Exception {
        if (laporanTerakhir == null) throw new Exception("Tampilkan laporan terlebih dahulu sebelum diekspor.");
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
        fc.setSelectedFile(new File("laporan_argoport_" + laporanMulai + "_" + laporanAkhir + ".xlsx"));
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File tujuan = fc.getSelectedFile();
        if (!tujuan.getName().toLowerCase().endsWith(".xlsx")) tujuan = new File(tujuan.getParentFile(), tujuan.getName() + ".xlsx");
        if (tujuan.exists() && !konfirmasi("File " + tujuan.getName() + " sudah ada. Timpa?")) return;
        controller.eksporLaporan(tujuan, laporanMulai, laporanAkhir, laporanTerakhir);
        info("File Laporan Berhasil Diunduh!\n" + tujuan.getAbsolutePath());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkspor;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuKargo1;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnTampilLaporan;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblDari;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblKapalTitle;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNilaiKapal;
    private javax.swing.JLabel lblNilaiPendapatan;
    private javax.swing.JLabel lblNilaiTonase;
    private javax.swing.JLabel lblPendapatanTitle;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSampai;
    private javax.swing.JLabel lblTonaseTitle;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlLaporan;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JScrollPane scrollLaporan;
    private javax.swing.JTable tblLaporan;
    private javax.swing.JTextField txtDari;
    private javax.swing.JTextField txtSampai;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
