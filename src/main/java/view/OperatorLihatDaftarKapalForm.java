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
 * ArgoPort | Operator Workspace - Lihat Daftar Kapal.
 * Tampilan diatur lewat NetBeans Design (OperatorDaftarKapalForm.form); logika ada di luar blok GEN.
 */
public class OperatorLihatDaftarKapalForm extends javax.swing.JFrame {
    private final OperatorController controller = new OperatorController();

    public OperatorLihatDaftarKapalForm() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
        jalankan(this::muatDaftar, "Gagal memuat data");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlDaftarKapal = new javax.swing.JPanel();
        scrollDaftarKapal = new javax.swing.JScrollPane();
        tblDaftarKapal = new javax.swing.JTable();
        btnHapusKapal = new javax.swing.JButton();
        btnMuatDaftar = new javax.swing.JButton();
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
        setTitle("ArgoPort | Operator Workspace - Lihat Daftar Kapal");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Lihat Daftar Kapal");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 40));

        pnlDaftarKapal.setBackground(new java.awt.Color(255, 255, 255));
        pnlDaftarKapal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollDaftarKapal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblDaftarKapal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblDaftarKapal.setGridColor(new java.awt.Color(237, 241, 245));
        tblDaftarKapal.setRowHeight(30);
        tblDaftarKapal.setForeground(new java.awt.Color(43, 57, 73));
        tblDaftarKapal.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblDaftarKapal.setSelectionForeground(new java.awt.Color(25, 53, 78));
        tblDaftarKapal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID KAPAL", "NAMA KAPAL", "JENIS", "GT", "DRAF", "KEDATANGAN", "STATUS", "DERMAGA", "WAKTU SANDAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollDaftarKapal.setViewportView(tblDaftarKapal);

        pnlDaftarKapal.add(scrollDaftarKapal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 920, 420));

        btnHapusKapal.setBackground(new java.awt.Color(253, 236, 234));
        btnHapusKapal.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnHapusKapal.setForeground(new java.awt.Color(176, 48, 38));
        btnHapusKapal.setText("Hapus kapal (Antre)");
        btnHapusKapal.setBorderPainted(false);
        btnHapusKapal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusKapal.setFocusPainted(false);
        btnHapusKapal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusKapalActionPerformed(evt);
            }
        });
        pnlDaftarKapal.add(btnHapusKapal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 220, 36));

        btnMuatDaftar.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatDaftar.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatDaftar.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatDaftar.setText("Muat ulang");
        btnMuatDaftar.setBorderPainted(false);
        btnMuatDaftar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatDaftar.setFocusPainted(false);
        btnMuatDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatDaftarActionPerformed(evt);
            }
        });
        pnlDaftarKapal.add(btnMuatDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 120, 36));

        pnlMain.add(pnlDaftarKapal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 980, 640));

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

    private void btnHapusKapalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusKapalActionPerformed
        jalankan(this::hapusKapal, "Kapal tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusKapalActionPerformed

    private void btnMuatDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatDaftarActionPerformed
        jalankan(this::muatDaftar, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatDaftarActionPerformed

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
        gayaTabel(tblDaftarKapal, scrollDaftarKapal);
    }

    private void muatDaftar() throws Exception { isi(tblDaftarKapal, controller.getDaftarKapal()); }

    private void hapusKapal() throws Exception {
        String id = dipilih(tblDaftarKapal, 0, "Pilih kapal dari tabel terlebih dahulu.");
        if (!konfirmasi("Hapus kapal " + id + "?")) return;
        controller.hapusKapal(id);
        info("Data kapal berhasil dihapus.");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapusKapal;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnMuatDaftar;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pnlDaftarKapal;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JScrollPane scrollDaftarKapal;
    private javax.swing.JTable tblDaftarKapal;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
