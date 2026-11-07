package view;

import controller.OperatorController;
import model.Pengguna;
import repository.DBConnection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Dashboard Operator (sesuai flowchart: 5 menu + logout). Tampilan diatur lewat NetBeans Design
 * (OperatorView.form); logika ada di luar blok GEN.
 */
public class DashboardOperator extends javax.swing.JFrame {
    private JPanel dashboardPanel;
    private JLabel[] dashboardValues;
    private JTable dashboardTable;
    private final java.util.List<JButton> navButtons = new java.util.ArrayList<>();
    private static final DateTimeFormatter FORMAT_WAKTU = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final OperatorController controller = new OperatorController();
    private final Pengguna operator;

    public DashboardOperator(Pengguna operator) {
        this.operator = operator;
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
        jalankan(this::muatSemua, "Gagal memuat data");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        operatorPendaftaranForm1 = new view.OperatorPendaftaranForm();
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
        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        pnlRegister = new javax.swing.JPanel();
        lblRegisterTitle = new javax.swing.JLabel();
        jLabelNamaK = new javax.swing.JLabel();
        txtNamaK = new javax.swing.JTextField();
        jLabelJenisK = new javax.swing.JLabel();
        txtJenisK = new javax.swing.JTextField();
        jLabelDrafK = new javax.swing.JLabel();
        txtDrafK = new javax.swing.JTextField();
        jLabelGrossT = new javax.swing.JLabel();
        txtGrossT = new javax.swing.JTextField();
        jLabelWaktuK = new javax.swing.JLabel();
        txtWaktuK = new javax.swing.JTextField();
        btnDaftar = new javax.swing.JButton();
        pnlDaftarKapal = new javax.swing.JPanel();
        scrollDaftarKapal = new javax.swing.JScrollPane();
        tblDaftarKapal = new javax.swing.JTable();
        btnHapusKapal = new javax.swing.JButton();
        btnMuatDaftar = new javax.swing.JButton();
        pnlDocking = new javax.swing.JPanel();
        lblAntreTitle = new javax.swing.JLabel();
        lblDermagaKosongTitle = new javax.swing.JLabel();
        scrollAntre = new javax.swing.JScrollPane();
        tblAntre = new javax.swing.JTable();
        scrollDermagaKosong = new javax.swing.JScrollPane();
        tblDermagaKosong = new javax.swing.JTable();
        btnDocking = new javax.swing.JButton();
        btnMuatDocking = new javax.swing.JButton();
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
        pnlKargo = new javax.swing.JPanel();
        scrollKargo = new javax.swing.JScrollPane();
        tblKargo = new javax.swing.JTable();
        jLabelNamaBaru = new javax.swing.JLabel();
        jLabelBeratBaru = new javax.swing.JLabel();
        txtNamaBaru = new javax.swing.JTextField();
        txtBeratBaru = new javax.swing.JTextField();
        btnUbahKargo = new javax.swing.JButton();
        btnHapusKargo = new javax.swing.JButton();
        btnMuatKargo = new javax.swing.JButton();
        pnlDashboard = new javax.swing.JPanel();
        pnlCard1 = new javax.swing.JPanel();
        lblCardTitle1 = new javax.swing.JLabel();
        lblCardValue1 = new javax.swing.JLabel();
        pnlCard2 = new javax.swing.JPanel();
        lblCardTitle2 = new javax.swing.JLabel();
        lblCardValue2 = new javax.swing.JLabel();
        pnlCard3 = new javax.swing.JPanel();
        lblCardTitle3 = new javax.swing.JLabel();
        lblCardValue3 = new javax.swing.JLabel();
        pnlCard4 = new javax.swing.JPanel();
        lblCardTitle4 = new javax.swing.JLabel();
        lblCardValue4 = new javax.swing.JLabel();
        lblRecent = new javax.swing.JLabel();
        scrollDashboard = new javax.swing.JScrollPane();
        tblDashboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArgoPort | Operator Workspace");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Dashboard Operator");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 800, 40));

        pnlContent.setBackground(new java.awt.Color(246, 248, 251));
        pnlContent.setLayout(new java.awt.CardLayout());

        pnlRegister.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegister.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegisterTitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblRegisterTitle.setForeground(new java.awt.Color(34, 55, 77));
        lblRegisterTitle.setText("DATA KAPAL BARU (STATUS AWAL: ANTRE)");
        pnlRegister.add(lblRegisterTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 400, 22));

        jLabelNamaK.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelNamaK.setForeground(new java.awt.Color(93, 108, 125));
        jLabelNamaK.setText("Nama kapal");
        pnlRegister.add(jLabelNamaK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 300, 18));

        txtNamaK.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNamaK.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlRegister.add(txtNamaK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 82, 400, 36));

        jLabelJenisK.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelJenisK.setForeground(new java.awt.Color(93, 108, 125));
        jLabelJenisK.setText("Jenis kapal");
        pnlRegister.add(jLabelJenisK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 300, 18));

        txtJenisK.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtJenisK.setText("Kargo");
        txtJenisK.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlRegister.add(txtJenisK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 152, 400, 36));

        jLabelDrafK.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelDrafK.setForeground(new java.awt.Color(93, 108, 125));
        jLabelDrafK.setText("Draf kapal (m)");
        pnlRegister.add(jLabelDrafK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 300, 18));

        txtDrafK.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDrafK.setText("6.5");
        txtDrafK.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlRegister.add(txtDrafK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 222, 400, 36));

        jLabelGrossT.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelGrossT.setForeground(new java.awt.Color(93, 108, 125));
        jLabelGrossT.setText("Gross tonnage (GT)");
        pnlRegister.add(jLabelGrossT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 300, 18));

        txtGrossT.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtGrossT.setText("5000");
        txtGrossT.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlRegister.add(txtGrossT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 292, 400, 36));

        jLabelWaktuK.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelWaktuK.setForeground(new java.awt.Color(93, 108, 125));
        jLabelWaktuK.setText("Waktu kedatangan (yyyy-MM-dd HH:mm)");
        pnlRegister.add(jLabelWaktuK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 350, 18));

        txtWaktuK.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtWaktuK.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlRegister.add(txtWaktuK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 362, 400, 36));

        btnDaftar.setBackground(new java.awt.Color(27, 93, 145));
        btnDaftar.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnDaftar.setForeground(new java.awt.Color(255, 255, 255));
        btnDaftar.setText("Daftarkan kapal");
        btnDaftar.setBorderPainted(false);
        btnDaftar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDaftar.setFocusPainted(false);
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });
        pnlRegister.add(btnDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 425, 400, 36));

        pnlContent.add(pnlRegister, "card1");

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

        pnlDaftarKapal.add(scrollDaftarKapal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 961, 420));

        btnHapusKapal.setBackground(new java.awt.Color(253, 236, 234));
        btnHapusKapal.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnHapusKapal.setForeground(new java.awt.Color(176, 48, 38));
        btnHapusKapal.setText("Hapus kapal (status Antre)");
        btnHapusKapal.setBorderPainted(false);
        btnHapusKapal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusKapal.setFocusPainted(false);
        btnHapusKapal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusKapalActionPerformed(evt);
            }
        });
        pnlDaftarKapal.add(btnHapusKapal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 220, 36));

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
        pnlDaftarKapal.add(btnMuatDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 460, 120, 36));

        pnlContent.add(pnlDaftarKapal, "card2");

        pnlDocking.setBackground(new java.awt.Color(255, 255, 255));
        pnlDocking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAntreTitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblAntreTitle.setForeground(new java.awt.Color(34, 55, 77));
        lblAntreTitle.setText("KAPAL BERSTATUS ANTRE");
        pnlDocking.add(lblAntreTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, 22));

        lblDermagaKosongTitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblDermagaKosongTitle.setForeground(new java.awt.Color(34, 55, 77));
        lblDermagaKosongTitle.setText("DERMAGA KOSONG");
        pnlDocking.add(lblDermagaKosongTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 300, 22));

        scrollAntre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblAntre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblAntre.setGridColor(new java.awt.Color(237, 241, 245));
        tblAntre.setRowHeight(30);
        tblAntre.setForeground(new java.awt.Color(43, 57, 73));
        tblAntre.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblAntre.setSelectionForeground(new java.awt.Color(25, 53, 78));
        tblAntre.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollAntre.setViewportView(tblAntre);

        pnlDocking.add(scrollAntre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 470, 380));

        scrollDermagaKosong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblDermagaKosong.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblDermagaKosong.setGridColor(new java.awt.Color(237, 241, 245));
        tblDermagaKosong.setRowHeight(30);
        tblDermagaKosong.setForeground(new java.awt.Color(43, 57, 73));
        tblDermagaKosong.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblDermagaKosong.setSelectionForeground(new java.awt.Color(25, 53, 78));
        tblDermagaKosong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID DERMAGA", "NAMA DERMAGA", "KAPASITAS (TON)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollDermagaKosong.setViewportView(tblDermagaKosong);

        pnlDocking.add(scrollDermagaKosong, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 471, 380));

        btnDocking.setBackground(new java.awt.Color(27, 93, 145));
        btnDocking.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnDocking.setForeground(new java.awt.Color(255, 255, 255));
        btnDocking.setText("Proses penambatan");
        btnDocking.setBorderPainted(false);
        btnDocking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDocking.setFocusPainted(false);
        btnDocking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDockingActionPerformed(evt);
            }
        });
        pnlDocking.add(btnDocking, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 220, 36));

        btnMuatDocking.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatDocking.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatDocking.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatDocking.setText("Muat ulang");
        btnMuatDocking.setBorderPainted(false);
        btnMuatDocking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatDocking.setFocusPainted(false);
        btnMuatDocking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatDockingActionPerformed(evt);
            }
        });
        pnlDocking.add(btnMuatDocking, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 450, 120, 36));

        pnlContent.add(pnlDocking, "card3");

        pnlBongkar.setBackground(new java.awt.Color(255, 255, 255));
        pnlBongkar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSandarTitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblSandarTitle.setForeground(new java.awt.Color(34, 55, 77));
        lblSandarTitle.setText("PILIH KAPAL (SANDAR)");
        pnlBongkar.add(lblSandarTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, 22));

        lblSlotTitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblSlotTitle.setForeground(new java.awt.Color(34, 55, 77));
        lblSlotTitle.setText("PILIH SLOT GUDANG");
        pnlBongkar.add(lblSlotTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 300, 22));

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

        pnlBongkar.add(scrollSandar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 470, 290));

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

        pnlBongkar.add(scrollSlotBm, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 471, 290));

        jLabelNamaBrg.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelNamaBrg.setForeground(new java.awt.Color(93, 108, 125));
        jLabelNamaBrg.setText("Nama barang");
        pnlBongkar.add(jLabelNamaBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 250, 18));

        jLabelBeratTon.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelBeratTon.setForeground(new java.awt.Color(93, 108, 125));
        jLabelBeratTon.setText("Berat (ton)");
        pnlBongkar.add(jLabelBeratTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 150, 18));

        jLabelVolumeM3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelVolumeM3.setForeground(new java.awt.Color(93, 108, 125));
        jLabelVolumeM3.setText("Volume (m3)");
        pnlBongkar.add(jLabelVolumeM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 150, 18));

        txtNamaBrg.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNamaBrg.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlBongkar.add(txtNamaBrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 382, 300, 36));

        txtBeratTon.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBeratTon.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlBongkar.add(txtBeratTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 382, 150, 36));

        txtVolumeM3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtVolumeM3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlBongkar.add(txtVolumeM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 382, 150, 36));

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
        pnlBongkar.add(btnBongkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 382, 170, 36));

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
        pnlBongkar.add(btnMuatBongkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 382, 120, 36));

        pnlContent.add(pnlBongkar, "card4");

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

        pnlKargo.add(scrollKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 961, 330));

        jLabelNamaBaru.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelNamaBaru.setForeground(new java.awt.Color(93, 108, 125));
        jLabelNamaBaru.setText("Nama barang baru");
        pnlKargo.add(jLabelNamaBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 250, 18));

        jLabelBeratBaru.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabelBeratBaru.setForeground(new java.awt.Color(93, 108, 125));
        jLabelBeratBaru.setText("Berat ton baru");
        pnlKargo.add(jLabelBeratBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 150, 18));

        txtNamaBaru.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNamaBaru.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlKargo.add(txtNamaBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 392, 400, 36));

        txtBeratBaru.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBeratBaru.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlKargo.add(txtBeratBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 392, 150, 36));

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
        pnlKargo.add(btnUbahKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 392, 160, 36));

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
        pnlKargo.add(btnHapusKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 392, 120, 36));

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
        pnlKargo.add(btnMuatKargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 440, 120, 36));

        pnlContent.add(pnlKargo, "card5");

        pnlDashboard.setBackground(new java.awt.Color(246, 248, 251));
        pnlDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCard1.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlCard1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardTitle1.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblCardTitle1.setForeground(new java.awt.Color(105, 121, 140));
        lblCardTitle1.setText("TOTAL KAPAL");
        pnlCard1.add(lblCardTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 18));

        lblCardValue1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCardValue1.setForeground(new java.awt.Color(0, 0, 51));
        lblCardValue1.setText("-");
        pnlCard1.add(lblCardValue1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 35));

        pnlDashboard.add(pnlCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 222, 82));

        pnlCard2.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlCard2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardTitle2.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblCardTitle2.setForeground(new java.awt.Color(105, 121, 140));
        lblCardTitle2.setText("KAPAL ANTRE");
        pnlCard2.add(lblCardTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 18));

        lblCardValue2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCardValue2.setForeground(new java.awt.Color(27, 93, 145));
        lblCardValue2.setText("-");
        pnlCard2.add(lblCardValue2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 35));

        pnlDashboard.add(pnlCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 222, 82));

        pnlCard3.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlCard3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardTitle3.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblCardTitle3.setForeground(new java.awt.Color(105, 121, 140));
        lblCardTitle3.setText("KAPAL SANDAR");
        pnlCard3.add(lblCardTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 18));

        lblCardValue3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCardValue3.setForeground(new java.awt.Color(25, 115, 105));
        lblCardValue3.setText("-");
        pnlCard3.add(lblCardValue3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 35));

        pnlDashboard.add(pnlCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 222, 82));

        pnlCard4.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlCard4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardTitle4.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblCardTitle4.setForeground(new java.awt.Color(105, 121, 140));
        lblCardTitle4.setText("TOTAL DATA KARGO");
        pnlCard4.add(lblCardTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 18));

        lblCardValue4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCardValue4.setForeground(new java.awt.Color(0, 115, 135));
        lblCardValue4.setText("-");
        pnlCard4.add(lblCardValue4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 35));

        pnlDashboard.add(pnlCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 222, 82));

        lblRecent.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblRecent.setForeground(new java.awt.Color(34, 55, 77));
        lblRecent.setText("Data Kapal Terbaru");
        pnlDashboard.add(lblRecent, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 600, 25));

        scrollDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));

        tblDashboard.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        tblDashboard.setRowHeight(27);
        tblDashboard.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollDashboard.setViewportView(tblDashboard);

        pnlDashboard.add(scrollDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 940, 380));

        pnlContent.add(pnlDashboard, "card0");

        pnlMain.add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 100, 1001, 640));

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 1065, 755));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        jalankan(this::daftarKapal, "Data kapal tidak valid");
    }//GEN-LAST:event_btnDaftarActionPerformed

    private void btnHapusKapalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusKapalActionPerformed
        jalankan(this::hapusKapal, "Kapal tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusKapalActionPerformed

    private void btnMuatDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatDaftarActionPerformed
        jalankan(this::muatSemua, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatDaftarActionPerformed

    private void btnDockingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDockingActionPerformed
        jalankan(this::prosesDocking, "Penambatan gagal");
    }//GEN-LAST:event_btnDockingActionPerformed

    private void btnMuatDockingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatDockingActionPerformed
        jalankan(this::muatSemua, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatDockingActionPerformed

    private void btnBongkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBongkarActionPerformed
        jalankan(this::bongkarMuat, "Bongkar muat gagal");
    }//GEN-LAST:event_btnBongkarActionPerformed

    private void btnMuatBongkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatBongkarActionPerformed
        jalankan(this::muatSemua, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatBongkarActionPerformed

    private void btnUbahKargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahKargoActionPerformed
        jalankan(this::ubahKargo, "Data kargo tidak valid");
    }//GEN-LAST:event_btnUbahKargoActionPerformed

    private void btnHapusKargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusKargoActionPerformed
        jalankan(this::hapusKargo, "Kargo tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusKargoActionPerformed

    private void btnMuatKargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatKargoActionPerformed
        jalankan(this::muatSemua, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatKargoActionPerformed

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

    /** Nilai kolom pada baris terpilih, atau pesan bila belum ada yang dipilih. */
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
        userLabel.setText(operator.getNama() + "   \u00b7   Operator");
        gayaTabel(tblDaftarKapal, scrollDaftarKapal);
        gayaTabel(tblAntre, scrollAntre);
        gayaTabel(tblDermagaKosong, scrollDermagaKosong);
        gayaTabel(tblSandar, scrollSandar);
        gayaTabel(tblSlotBm, scrollSlotBm);
        gayaTabel(tblKargo, scrollKargo);
        siapkanNavigasi();
        txtWaktuK.setText(LocalDateTime.now().withSecond(0).withNano(0).format(FORMAT_WAKTU));
        tblKargo.getSelectionModel().addListSelectionListener(e -> {
            int r = tblKargo.getSelectedRow();
            if (e.getValueIsAdjusting() || r < 0) return;
            txtNamaBaru.setText(String.valueOf(tblKargo.getValueAt(r, 1)));
            txtBeratBaru.setText(String.valueOf(tblKargo.getValueAt(r, 2)));
        });
    }

    private void muatSemua() throws Exception {
        muatDaftar(); muatDocking(); muatBongkar(); muatKargo();
        perbaruiDashboard();
    }

    private void siapkanNavigasi() {
        dashboardValues = new JLabel[]{lblCardValue1, lblCardValue2, lblCardValue3, lblCardValue4};
        dashboardTable = tblDashboard;
        navButtons.addAll(java.util.Arrays.asList(btnMenuDashboard, btnMenuPendaftaran, btnMenuDaftarKapal, btnMenuPenambatan, btnMenuBongkarMuat, btnMenuKargo));
        pasangHoverNavigasi();
        bukaMenu(0);
    }

    /** Efek hover pada tombol sidebar supaya terasa seperti tombol. */
    private void pasangHoverNavigasi() {
        for (JButton b : navButtons) {
            b.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override public void mouseEntered(java.awt.event.MouseEvent e) {
                    if (!b.getBackground().equals(new Color(0, 140, 160))) b.setBackground(new Color(30, 62, 100));
                }
                @Override public void mouseExited(java.awt.event.MouseEvent e) {
                    if (!b.getBackground().equals(new Color(0, 140, 160))) b.setBackground(new Color(17, 39, 67));
                }
            });
        }
    }

    /** Membuka halaman ke-index pada area kanan; sidebar tetap tampil. */
    private void bukaMenu(int index) {
        String[] menu = {"Dashboard", "Pendaftaran Kapal Baru", "Lihat Daftar Kapal", "Penambatan Kapal", "Bongkar Muat Kargo", "Kelola Data Kargo"};
        ((java.awt.CardLayout) pnlContent.getLayout()).show(pnlContent, "card" + index);
        lblHeading.setText(index == 0 ? "Dashboard Operator" : menu[index]);
        lblSubheading.setText(index == 0 ? "Ringkasan aktivitas kapal dan kargo." : "Kelola dan pantau data " + menu[index].toLowerCase() + ".");
        tandaiNavigasi(index);
    }

    private void tandaiNavigasi(int selected) {
        for (int i = 0; i < navButtons.size(); i++)
            navButtons.get(i).setBackground(i == selected ? new Color(0, 140, 160) : new Color(17, 39, 67));
    }

    private void perbaruiDashboard(){
        if(dashboardValues==null)return;
        dashboardValues[0].setText(String.valueOf(tblDaftarKapal.getRowCount()));
        dashboardValues[1].setText(String.valueOf(tblAntre.getRowCount()));
        dashboardValues[2].setText(String.valueOf(tblSandar.getRowCount()));
        dashboardValues[3].setText(String.valueOf(tblKargo.getRowCount()));
        javax.swing.table.DefaultTableModel source=(javax.swing.table.DefaultTableModel)tblDaftarKapal.getModel();
        javax.swing.table.DefaultTableModel copy=new javax.swing.table.DefaultTableModel(){ @Override public boolean isCellEditable(int r,int c){return false;} };
        for(int c=0;c<source.getColumnCount();c++)copy.addColumn(source.getColumnName(c));
        for(int r=0;r<Math.min(8,source.getRowCount());r++){Object[] row=new Object[source.getColumnCount()];for(int c=0;c<row.length;c++)row[c]=source.getValueAt(r,c);copy.addRow(row);}
        dashboardTable.setModel(copy); dashboardTable.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,10));
    }

    private void muatDaftar() throws Exception { isi(tblDaftarKapal, controller.getDaftarKapal()); }
    private void muatDocking() throws Exception {
        isi(tblAntre, controller.getKapalByStatus("Antre"));
        isi(tblDermagaKosong, controller.getDermagaKosong());
    }
    private void muatBongkar() throws Exception {
        isi(tblSandar, controller.getKapalByStatus("Sandar"));
        isi(tblSlotBm, controller.getSlotTersedia());
    }
    private void muatKargo() throws Exception { isi(tblKargo, controller.getDaftarKargo()); }

    // ---------- Menu 1: Pendaftaran Kapal Baru ----------
    private void daftarKapal() throws Exception {
        LocalDateTime waktu;
        try {
            waktu = LocalDateTime.parse(txtWaktuK.getText().trim(), FORMAT_WAKTU);
        } catch (DateTimeParseException ex) {
            throw new Exception("Data Kapal Belum Lengkap atau Tidak Valid: format waktu harus yyyy-MM-dd HH:mm.");
        }
        controller.daftarKapalBaru(txtNamaK.getText(), txtJenisK.getText(),
                angka(txtGrossT, "Gross tonnage"), angka(txtDrafK, "Draf kapal"), waktu);
        info("Kapal Masuk Antrean");
        txtNamaK.setText("");
        muatSemua();
    }

    // ---------- Menu 2: Lihat Daftar Kapal ----------
    private void hapusKapal() throws Exception {
        String id = dipilih(tblDaftarKapal, 0, "Pilih kapal dari tabel terlebih dahulu.");
        if (!konfirmasi("Hapus kapal " + id + "?")) return;
        controller.hapusKapal(id);
        info("Data kapal berhasil dihapus.");
        muatSemua();
    }

    // ---------- Menu 3: Penambatan Kapal (Docking) ----------
    private void prosesDocking() throws Exception {
        if (tblDermagaKosong.getRowCount() == 0) {
            info("Dermaga Penuh, Kapal Tetap di Antrean");
            return;
        }
        String kapal = dipilih(tblAntre, 0, "Pilih kapal berstatus Antre terlebih dahulu.");
        String dermaga = dipilih(tblDermagaKosong, 0, "Pilih dermaga kosong terlebih dahulu.");
        controller.prosesDocking(kapal, dermaga);
        info("Penambatan Kapal Berhasil");
        muatSemua();
    }

    // ---------- Menu 4: Bongkar Muat Kargo ----------
    private void bongkarMuat() throws Exception {
        String kapal = dipilih(tblSandar, 0, "Pilih kapal yang sudah sandar terlebih dahulu.");
        String slot = dipilih(tblSlotBm, 0, "Pilih slot gudang terlebih dahulu.");
        controller.prosesBongkarMuat(kapal, txtNamaBrg.getText(), angka(txtBeratTon, "Berat"), angka(txtVolumeM3, "Volume"), slot);
        info("Bongkar Muat Berhasil!");
        txtNamaBrg.setText("");
        txtBeratTon.setText("");
        txtVolumeM3.setText("");
        muatBongkar();
        muatKargo();
    }

    // ---------- Menu 5: Kelola Data Kargo ----------
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
        muatBongkar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBongkar;
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnDocking;
    private javax.swing.JButton btnHapusKapal;
    private javax.swing.JButton btnHapusKargo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnMuatBongkar;
    private javax.swing.JButton btnMuatDaftar;
    private javax.swing.JButton btnMuatDocking;
    private javax.swing.JButton btnMuatKargo;
    private javax.swing.JButton btnUbahKargo;
    private javax.swing.JLabel jLabelBeratBaru;
    private javax.swing.JLabel jLabelBeratTon;
    private javax.swing.JLabel jLabelDrafK;
    private javax.swing.JLabel jLabelGrossT;
    private javax.swing.JLabel jLabelJenisK;
    private javax.swing.JLabel jLabelNamaBaru;
    private javax.swing.JLabel jLabelNamaBrg;
    private javax.swing.JLabel jLabelNamaK;
    private javax.swing.JLabel jLabelVolumeM3;
    private javax.swing.JLabel jLabelWaktuK;
    private javax.swing.JLabel lblAntreTitle;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblCardTitle1;
    private javax.swing.JLabel lblCardTitle2;
    private javax.swing.JLabel lblCardTitle3;
    private javax.swing.JLabel lblCardTitle4;
    private javax.swing.JLabel lblCardValue1;
    private javax.swing.JLabel lblCardValue2;
    private javax.swing.JLabel lblCardValue3;
    private javax.swing.JLabel lblCardValue4;
    private javax.swing.JLabel lblDermagaKosongTitle;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRecent;
    private javax.swing.JLabel lblRegisterTitle;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSandarTitle;
    private javax.swing.JLabel lblSlotTitle;
    private view.OperatorPendaftaranForm operatorPendaftaranForm1;
    private javax.swing.JPanel pnlBongkar;
    private javax.swing.JPanel pnlCard1;
    private javax.swing.JPanel pnlCard2;
    private javax.swing.JPanel pnlCard3;
    private javax.swing.JPanel pnlCard4;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDaftarKapal;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JPanel pnlDocking;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlKargo;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRegister;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JScrollPane scrollAntre;
    private javax.swing.JScrollPane scrollDaftarKapal;
    private javax.swing.JScrollPane scrollDashboard;
    private javax.swing.JScrollPane scrollDermagaKosong;
    private javax.swing.JScrollPane scrollKargo;
    private javax.swing.JScrollPane scrollSandar;
    private javax.swing.JScrollPane scrollSlotBm;
    private javax.swing.JTable tblAntre;
    private javax.swing.JTable tblDaftarKapal;
    private javax.swing.JTable tblDashboard;
    private javax.swing.JTable tblDermagaKosong;
    private javax.swing.JTable tblKargo;
    private javax.swing.JTable tblSandar;
    private javax.swing.JTable tblSlotBm;
    private javax.swing.JTextField txtBeratBaru;
    private javax.swing.JTextField txtBeratTon;
    private javax.swing.JTextField txtDrafK;
    private javax.swing.JTextField txtGrossT;
    private javax.swing.JTextField txtJenisK;
    private javax.swing.JTextField txtNamaBaru;
    private javax.swing.JTextField txtNamaBrg;
    private javax.swing.JTextField txtNamaK;
    private javax.swing.JTextField txtVolumeM3;
    private javax.swing.JTextField txtWaktuK;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
