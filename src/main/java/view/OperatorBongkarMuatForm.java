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
 * ArgoPort | Operator Workspace - Bongkar Muat Kargo.
 * Tampilan diatur lewat NetBeans Design (OperatorBongkarMuatForm.form); logika ada di luar blok GEN.
 */
public class OperatorBongkarMuatForm extends javax.swing.JFrame {
    private final OperatorController controller = new OperatorController();

    public OperatorBongkarMuatForm() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
        jalankan(this::muatBongkar, "Gagal memuat data");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlBongkar = new javax.swing.JPanel();
        lblSandarTitle = new javax.swing.JLabel();
        lblSlotTitle = new javax.swing.JLabel();
        scrollSandar = new javax.swing.JScrollPane();
        tblSandar = new javax.swing.JTable();
        scrollSlotBm = new javax.swing.JScrollPane();
        tblSlotBm = new javax.swing.JTable();
        jLabelNamaBrg = new javax.swing.JLabel();
        jLabelBeratTon = new javax.swing.JLabel();
        jLabelVolumeM3 = new javax.swing.JLabel();
        txtNamaBrg = new javax.swing.JTextField();
        txtBeratTon = new javax.swing.JTextField();
        txtVolumeM3 = new javax.swing.JTextField();
        btnBongkar = new javax.swing.JButton();
        btnMuatBongkar = new javax.swing.JButton();
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
        setTitle("ArgoPort | Operator Workspace - Bongkar Muat Kargo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Bongkar Muat Kargo");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 800, 40));

        pnlBongkar.setBackground(new java.awt.Color(255, 255, 255));
        pnlBongkar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSandarTitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblSandarTitle.setForeground(new java.awt.Color(34, 55, 77));
        lblSandarTitle.setText("PILIH KAPAL (SANDAR)");
        pnlBongkar.add(lblSandarTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 300, 22));

        lblSlotTitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblSlotTitle.setForeground(new java.awt.Color(34, 55, 77));
        lblSlotTitle.setText("PILIH SLOT GUDANG");
        pnlBongkar.add(lblSlotTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 300, 22));

        scrollSandar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblSandar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblSandar.setGridColor(new java.awt.Color(237, 241, 245));
        tblSandar.setRowHeight(30);
        tblSandar.setForeground(new java.awt.Color(43, 57, 73));
        tblSandar.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblSandar.setSelectionForeground(new java.awt.Color(25, 53, 78));
        tblSandar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID KAPAL", "NAMA KAPAL", "JENIS", "GT", "KEDATANGAN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollSandar.setViewportView(tblSandar);

        pnlBongkar.add(scrollSandar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 450, 290));

        scrollSlotBm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblSlotBm.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblSlotBm.setGridColor(new java.awt.Color(237, 241, 245));
        tblSlotBm.setRowHeight(30);
        tblSlotBm.setForeground(new java.awt.Color(43, 57, 73));
        tblSlotBm.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblSlotBm.setSelectionForeground(new java.awt.Color(25, 53, 78));
        tblSlotBm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID SLOT", "KODE BLOK", "KAP. (M3)", "SISA (M3)", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollSlotBm.setViewportView(tblSlotBm);

        pnlBongkar.add(scrollSlotBm, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 440, 290));

        jLabelNamaBrg.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelNamaBrg.setForeground(new java.awt.Color(93, 108, 125));
        jLabelNamaBrg.setText("Nama barang");
        pnlBongkar.add(jLabelNamaBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 18));

        jLabelBeratTon.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelBeratTon.setForeground(new java.awt.Color(93, 108, 125));
        jLabelBeratTon.setText("Berat (ton)");
        pnlBongkar.add(jLabelBeratTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 150, 18));

        jLabelVolumeM3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelVolumeM3.setForeground(new java.awt.Color(93, 108, 125));
        jLabelVolumeM3.setText("Volume (m3)");
        pnlBongkar.add(jLabelVolumeM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 150, 18));

        txtNamaBrg.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNamaBrg.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlBongkar.add(txtNamaBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 290, 36));

        txtBeratTon.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBeratTon.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlBongkar.add(txtBeratTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 290, 36));

        txtVolumeM3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtVolumeM3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlBongkar.add(txtVolumeM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 290, 36));

        btnBongkar.setBackground(new java.awt.Color(24, 116, 108));
        btnBongkar.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnBongkar.setForeground(new java.awt.Color(255, 255, 255));
        btnBongkar.setText("Simpan muatan");
        btnBongkar.setBorderPainted(false);
        btnBongkar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBongkar.setFocusPainted(false);
        btnBongkar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBongkarActionPerformed(evt);
            }
        });
        pnlBongkar.add(btnBongkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, 36));

        btnMuatBongkar.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatBongkar.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatBongkar.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatBongkar.setText("Muat ulang");
        btnMuatBongkar.setBorderPainted(false);
        btnMuatBongkar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatBongkar.setFocusPainted(false);
        btnMuatBongkar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatBongkarActionPerformed(evt);
            }
        });
        pnlBongkar.add(btnMuatBongkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 120, 36));

        pnlMain.add(pnlBongkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 950, 640));

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

    private void btnBongkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBongkarActionPerformed
        jalankan(this::bongkarMuat, "Bongkar muat gagal");
    }//GEN-LAST:event_btnBongkarActionPerformed

    private void btnMuatBongkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatBongkarActionPerformed
        jalankan(this::muatBongkar, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatBongkarActionPerformed

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
        gayaTabel(tblSandar, scrollSandar);
        gayaTabel(tblSlotBm, scrollSlotBm);
    }

    private void muatBongkar() throws Exception {
        isi(tblSandar, controller.getKapalByStatus("Sandar"));
        isi(tblSlotBm, controller.getSlotTersedia());
    }

    private void bongkarMuat() throws Exception {
        String kapal = dipilih(tblSandar, 0, "Pilih kapal yang sudah sandar terlebih dahulu.");
        String slot = dipilih(tblSlotBm, 0, "Pilih slot gudang terlebih dahulu.");
        controller.prosesBongkarMuat(kapal, txtNamaBrg.getText(), angka(txtBeratTon, "Berat"), angka(txtVolumeM3, "Volume"), slot);
        info("Bongkar Muat Berhasil!");
        txtNamaBrg.setText("");
        txtBeratTon.setText("");
        txtVolumeM3.setText("");
        muatBongkar();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBongkar;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnMuatBongkar;
    private javax.swing.JLabel jLabelBeratTon;
    private javax.swing.JLabel jLabelNamaBrg;
    private javax.swing.JLabel jLabelVolumeM3;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSandarTitle;
    private javax.swing.JLabel lblSlotTitle;
    private javax.swing.JPanel pnlBongkar;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JScrollPane scrollSandar;
    private javax.swing.JScrollPane scrollSlotBm;
    private javax.swing.JTable tblSandar;
    private javax.swing.JTable tblSlotBm;
    private javax.swing.JTextField txtBeratTon;
    private javax.swing.JTextField txtNamaBrg;
    private javax.swing.JTextField txtVolumeM3;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
