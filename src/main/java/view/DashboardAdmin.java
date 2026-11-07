package view;

import controller.AdminController;
import model.Pengguna;
import repository.DBConnection;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JFileChooser;
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
 * Dashboard Admin (sesuai flowchart: 6 menu + logout). Tampilan diatur lewat NetBeans Design
 * (AdminView.form); logika ada di luar blok GEN.
 */
public class DashboardAdmin extends javax.swing.JFrame {
    private final AdminController controller = new AdminController();
    private final Pengguna admin;
    private AdminController.Laporan laporanTerakhir;
    private LocalDate laporanMulai, laporanAkhir;
    private JPanel dashboardPanel;
    private JLabel[] dashboardValues;
    private JTable dashboardTable;
    private final java.util.List<JButton> navButtons = new java.util.ArrayList<>();

    public DashboardAdmin(Pengguna admin) {
        this.admin = admin;
        initComponents();
        util.Branding.pasangIkonJendela(this);
        siapkan();
        jalankan(this::muatSemua, "Gagal memuat data");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
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
        pnlSlot = new javax.swing.JPanel();
        scrollSlot = new javax.swing.JScrollPane();
        tblSlot = new javax.swing.JTable();
        lblKodeBlok = new javax.swing.JLabel();
        lblKapasitasSlot = new javax.swing.JLabel();
        lblOperatorSlot = new javax.swing.JLabel();
        txtKodeBlok = new javax.swing.JTextField();
        txtKapasitasSlot = new javax.swing.JTextField();
        txtOperatorSlot = new javax.swing.JTextField();
        btnTambahSlot = new javax.swing.JButton();
        btnUbahSlot = new javax.swing.JButton();
        btnHapusSlot = new javax.swing.JButton();
        btnMuatSlot = new javax.swing.JButton();
        pnlTarif = new javax.swing.JPanel();
        lblTarifTitle = new javax.swing.JLabel();
        lblTarifTambat = new javax.swing.JLabel();
        lblTarifBongkar = new javax.swing.JLabel();
        txtTarifTambat = new javax.swing.JTextField();
        txtTarifBongkar = new javax.swing.JTextField();
        btnSimpanTarif = new javax.swing.JButton();
        btnMuatTarif = new javax.swing.JButton();
        pnlBilling = new javax.swing.JPanel();
        scrollBilling = new javax.swing.JScrollPane();
        tblBilling = new javax.swing.JTable();
        btnBayar = new javax.swing.JButton();
        btnMuatBilling = new javax.swing.JButton();
        pnlAkun = new javax.swing.JPanel();
        scrollAkun = new javax.swing.JScrollPane();
        tblAkun = new javax.swing.JTable();
        btnHapusAkun = new javax.swing.JButton();
        btnMuatAkun = new javax.swing.JButton();
        pnlLaporan = new javax.swing.JPanel();
        lblDari = new javax.swing.JLabel();
        lblSampai = new javax.swing.JLabel();
        txtDari = new javax.swing.JTextField();
        txtSampai = new javax.swing.JTextField();
        btnTampilLaporan = new javax.swing.JButton();
        btnEkspor = new javax.swing.JButton();
        lblKapalTitle = new javax.swing.JLabel();
        lblTonaseTitle = new javax.swing.JLabel();
        lblPendapatanTitle = new javax.swing.JLabel();
        lblNilaiKapal = new javax.swing.JLabel();
        lblNilaiTonase = new javax.swing.JLabel();
        lblNilaiPendapatan = new javax.swing.JLabel();
        scrollLaporan = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();
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
        setTitle("ArgoPort | Admin Workspace");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(246, 248, 251));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblHeading.setText("Dashboard Admin");
        pnlMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 800, 40));

        pnlContent.setBackground(new java.awt.Color(246, 248, 251));
        pnlContent.setLayout(new java.awt.CardLayout());

        pnlDermaga.setBackground(new java.awt.Color(255, 255, 255));
        pnlDermaga.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollDermaga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblDermaga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblDermaga.setGridColor(new java.awt.Color(237, 241, 245));
        tblDermaga.setRowHeight(30);
        tblDermaga.setForeground(new java.awt.Color(43, 57, 73));
        tblDermaga.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblDermaga.setSelectionForeground(new java.awt.Color(25, 53, 78));
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
        scrollDermaga.setViewportView(tblDermaga);

        pnlDermaga.add(scrollDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 961, 300));

        lblKodeDermaga.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKodeDermaga.setForeground(new java.awt.Color(93, 108, 125));
        lblKodeDermaga.setText("Kode dermaga");
        pnlDermaga.add(lblKodeDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 335, 220, 18));

        lblNamaDermaga.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblNamaDermaga.setForeground(new java.awt.Color(93, 108, 125));
        lblNamaDermaga.setText("Nama dermaga");
        pnlDermaga.add(lblNamaDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 335, 220, 18));

        lblKapasitasDermaga.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKapasitasDermaga.setForeground(new java.awt.Color(93, 108, 125));
        lblKapasitasDermaga.setText("Kapasitas maksimal (ton)");
        pnlDermaga.add(lblKapasitasDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 335, 220, 18));

        txtKodeDermaga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtKodeDermaga.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlDermaga.add(txtKodeDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 357, 200, 36));

        txtNamaDermaga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtNamaDermaga.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlDermaga.add(txtNamaDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 357, 360, 36));

        txtKapasitasDermaga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtKapasitasDermaga.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlDermaga.add(txtKapasitasDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 357, 200, 36));

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
        pnlDermaga.add(btnTambahDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 415, 130, 36));

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
        pnlDermaga.add(btnUbahDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 415, 190, 36));

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
        pnlDermaga.add(btnStatusDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 415, 130, 36));

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
        pnlDermaga.add(btnHapusDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 415, 110, 36));

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
        pnlDermaga.add(btnMuatDermaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 415, 120, 36));

        pnlContent.add(pnlDermaga, "card1");

        pnlSlot.setBackground(new java.awt.Color(255, 255, 255));
        pnlSlot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pnlSlot.add(scrollSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 961, 300));

        lblKodeBlok.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKodeBlok.setForeground(new java.awt.Color(93, 108, 125));
        lblKodeBlok.setText("Kode blok");
        pnlSlot.add(lblKodeBlok, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 335, 220, 18));

        lblKapasitasSlot.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKapasitasSlot.setForeground(new java.awt.Color(93, 108, 125));
        lblKapasitasSlot.setText("Kapasitas volume (m3)");
        pnlSlot.add(lblKapasitasSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 335, 220, 18));

        lblOperatorSlot.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblOperatorSlot.setForeground(new java.awt.Color(93, 108, 125));
        lblOperatorSlot.setText("ID operator penanggung jawab");
        pnlSlot.add(lblOperatorSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 335, 240, 18));

        txtKodeBlok.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtKodeBlok.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlSlot.add(txtKodeBlok, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 357, 200, 36));

        txtKapasitasSlot.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtKapasitasSlot.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlSlot.add(txtKapasitasSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 357, 200, 36));

        txtOperatorSlot.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtOperatorSlot.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlSlot.add(txtOperatorSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 357, 200, 36));

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
        pnlSlot.add(btnTambahSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 415, 130, 36));

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
        pnlSlot.add(btnUbahSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 415, 150, 36));

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
        pnlSlot.add(btnHapusSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 415, 110, 36));

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
        pnlSlot.add(btnMuatSlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 415, 120, 36));

        pnlContent.add(pnlSlot, "card2");

        pnlTarif.setBackground(new java.awt.Color(255, 255, 255));
        pnlTarif.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTarifTitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblTarifTitle.setForeground(new java.awt.Color(34, 55, 77));
        lblTarifTitle.setText("TARIF SAAT INI");
        pnlTarif.add(lblTarifTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, 22));

        lblTarifTambat.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblTarifTambat.setForeground(new java.awt.Color(93, 108, 125));
        lblTarifTambat.setText("Tarif tambat per hari (Rp)");
        pnlTarif.add(lblTarifTambat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 18));

        lblTarifBongkar.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblTarifBongkar.setForeground(new java.awt.Color(93, 108, 125));
        lblTarifBongkar.setText("Tarif muatan per ton (Rp)");
        pnlTarif.add(lblTarifBongkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 240, 18));

        txtTarifTambat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtTarifTambat.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlTarif.add(txtTarifTambat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 82, 240, 36));

        txtTarifBongkar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtTarifBongkar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlTarif.add(txtTarifBongkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 82, 240, 36));

        btnSimpanTarif.setBackground(new java.awt.Color(27, 93, 145));
        btnSimpanTarif.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnSimpanTarif.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanTarif.setText("Simpan tarif");
        btnSimpanTarif.setBorderPainted(false);
        btnSimpanTarif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpanTarif.setFocusPainted(false);
        btnSimpanTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanTarifActionPerformed(evt);
            }
        });
        pnlTarif.add(btnSimpanTarif, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 82, 140, 36));

        btnMuatTarif.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatTarif.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatTarif.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatTarif.setText("Muat ulang");
        btnMuatTarif.setBorderPainted(false);
        btnMuatTarif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatTarif.setFocusPainted(false);
        btnMuatTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatTarifActionPerformed(evt);
            }
        });
        pnlTarif.add(btnMuatTarif, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 82, 120, 36));

        pnlContent.add(pnlTarif, "card3");

        pnlBilling.setBackground(new java.awt.Color(255, 255, 255));
        pnlBilling.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollBilling.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblBilling.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblBilling.setGridColor(new java.awt.Color(237, 241, 245));
        tblBilling.setRowHeight(30);
        tblBilling.setForeground(new java.awt.Color(43, 57, 73));
        tblBilling.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblBilling.setSelectionForeground(new java.awt.Color(25, 53, 78));
        tblBilling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID KAPAL", "NAMA KAPAL", "STATUS KAPAL", "STATUS BAYAR", "TOTAL TAGIHAN (RP)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollBilling.setViewportView(tblBilling);

        pnlBilling.add(scrollBilling, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 961, 400));

        btnBayar.setBackground(new java.awt.Color(27, 93, 145));
        btnBayar.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Lihat rincian & proses pembayaran");
        btnBayar.setBorderPainted(false);
        btnBayar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBayar.setFocusPainted(false);
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        pnlBilling.add(btnBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 280, 36));

        btnMuatBilling.setBackground(new java.awt.Color(235, 241, 247));
        btnMuatBilling.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnMuatBilling.setForeground(new java.awt.Color(43, 73, 101));
        btnMuatBilling.setText("Muat ulang");
        btnMuatBilling.setBorderPainted(false);
        btnMuatBilling.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMuatBilling.setFocusPainted(false);
        btnMuatBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatBillingActionPerformed(evt);
            }
        });
        pnlBilling.add(btnMuatBilling, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 440, 120, 36));

        pnlContent.add(pnlBilling, "card4");

        pnlAkun.setBackground(new java.awt.Color(255, 255, 255));
        pnlAkun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollAkun.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblAkun.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblAkun.setGridColor(new java.awt.Color(237, 241, 245));
        tblAkun.setRowHeight(30);
        tblAkun.setForeground(new java.awt.Color(43, 57, 73));
        tblAkun.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblAkun.setSelectionForeground(new java.awt.Color(25, 53, 78));
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
        scrollAkun.setViewportView(tblAkun);

        pnlAkun.add(scrollAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 961, 400));

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
        pnlAkun.add(btnHapusAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 200, 36));

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
        pnlAkun.add(btnMuatAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 440, 120, 36));

        pnlContent.add(pnlAkun, "card5");

        pnlLaporan.setBackground(new java.awt.Color(255, 255, 255));
        pnlLaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDari.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblDari.setForeground(new java.awt.Color(93, 108, 125));
        lblDari.setText("Dari tanggal (yyyy-MM-dd)");
        pnlLaporan.add(lblDari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 18));

        lblSampai.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblSampai.setForeground(new java.awt.Color(93, 108, 125));
        lblSampai.setText("Sampai tanggal (yyyy-MM-dd)");
        pnlLaporan.add(lblSampai, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 200, 18));

        txtDari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDari.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlLaporan.add(txtDari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 42, 200, 36));

        txtSampai.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtSampai.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(5, 9, 5, 9)));
        pnlLaporan.add(txtSampai, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 42, 200, 36));

        btnTampilLaporan.setBackground(new java.awt.Color(27, 93, 145));
        btnTampilLaporan.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
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
        pnlLaporan.add(btnTampilLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 42, 160, 36));

        btnEkspor.setBackground(new java.awt.Color(24, 116, 108));
        btnEkspor.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        btnEkspor.setForeground(new java.awt.Color(255, 255, 255));
        btnEkspor.setText("Ekspor ke CSV");
        btnEkspor.setBorderPainted(false);
        btnEkspor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEkspor.setFocusPainted(false);
        btnEkspor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEksporActionPerformed(evt);
            }
        });
        pnlLaporan.add(btnEkspor, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 42, 140, 36));

        lblKapalTitle.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKapalTitle.setForeground(new java.awt.Color(93, 108, 125));
        lblKapalTitle.setText("Jumlah kapal");
        pnlLaporan.add(lblKapalTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 18));

        lblTonaseTitle.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblTonaseTitle.setForeground(new java.awt.Color(93, 108, 125));
        lblTonaseTitle.setText("Total tonase muatan (ton)");
        pnlLaporan.add(lblTonaseTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 220, 18));

        lblPendapatanTitle.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblPendapatanTitle.setForeground(new java.awt.Color(93, 108, 125));
        lblPendapatanTitle.setText("Total pendapatan (Rp)");
        pnlLaporan.add(lblPendapatanTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 220, 18));

        lblNilaiKapal.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblNilaiKapal.setForeground(new java.awt.Color(34, 55, 77));
        lblNilaiKapal.setText("-");
        pnlLaporan.add(lblNilaiKapal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 32));

        lblNilaiTonase.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblNilaiTonase.setForeground(new java.awt.Color(34, 55, 77));
        lblNilaiTonase.setText("-");
        pnlLaporan.add(lblNilaiTonase, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 240, 32));

        lblNilaiPendapatan.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblNilaiPendapatan.setForeground(new java.awt.Color(34, 55, 77));
        lblNilaiPendapatan.setText("-");
        pnlLaporan.add(lblNilaiPendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 400, 32));

        scrollLaporan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 231, 238)));

        tblLaporan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblLaporan.setGridColor(new java.awt.Color(237, 241, 245));
        tblLaporan.setRowHeight(30);
        tblLaporan.setForeground(new java.awt.Color(43, 57, 73));
        tblLaporan.setSelectionBackground(new java.awt.Color(222, 237, 249));
        tblLaporan.setSelectionForeground(new java.awt.Color(25, 53, 78));
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
        scrollLaporan.setViewportView(tblLaporan);

        pnlLaporan.add(scrollLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 961, 400));

        pnlContent.add(pnlLaporan, "card6");

        pnlDashboard.setBackground(new java.awt.Color(246, 248, 251));
        pnlDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCard1.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlCard1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardTitle1.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblCardTitle1.setForeground(new java.awt.Color(105, 121, 140));
        lblCardTitle1.setText("TOTAL DERMAGA");
        pnlCard1.add(lblCardTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 12, 190, 18));

        lblCardValue1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCardValue1.setForeground(new java.awt.Color(0, 0, 51));
        lblCardValue1.setText("-");
        pnlCard1.add(lblCardValue1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 34, 190, 35));

        pnlDashboard.add(pnlCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 222, 82));

        pnlCard2.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlCard2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardTitle2.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblCardTitle2.setForeground(new java.awt.Color(105, 121, 140));
        lblCardTitle2.setText("TOTAL SLOT GUDANG");
        pnlCard2.add(lblCardTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 12, 190, 18));

        lblCardValue2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCardValue2.setForeground(new java.awt.Color(0, 0, 51));
        lblCardValue2.setText("-");
        pnlCard2.add(lblCardValue2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 34, 190, 35));

        pnlDashboard.add(pnlCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 222, 82));

        pnlCard3.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlCard3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardTitle3.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblCardTitle3.setForeground(new java.awt.Color(105, 121, 140));
        lblCardTitle3.setText("KAPAL SANDAR");
        pnlCard3.add(lblCardTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 12, 190, 18));

        lblCardValue3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCardValue3.setForeground(new java.awt.Color(0, 0, 51));
        lblCardValue3.setText("-");
        pnlCard3.add(lblCardValue3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 34, 190, 35));

        pnlDashboard.add(pnlCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 222, 82));

        pnlCard4.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlCard4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardTitle4.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblCardTitle4.setForeground(new java.awt.Color(105, 121, 140));
        lblCardTitle4.setText("OPERATOR AKTIF");
        pnlCard4.add(lblCardTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 12, 190, 18));

        lblCardValue4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCardValue4.setForeground(new java.awt.Color(0, 0, 51));
        lblCardValue4.setText("-");
        pnlCard4.add(lblCardValue4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 34, 190, 35));

        pnlDashboard.add(pnlCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 222, 82));

        lblRecent.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblRecent.setForeground(new java.awt.Color(34, 55, 77));
        lblRecent.setText("Preview Data Pembayaran / Kapal Terbaru");
        pnlDashboard.add(lblRecent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 600, 25));

        scrollDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));

        tblDashboard.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        tblDashboard.setRowHeight(27);
        tblDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID KAPAL", "NAMA KAPAL", "STATUS KAPAL", "STATUS BAYAR", "TOTAL TAGIHAN (RP)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollDashboard.setViewportView(tblDashboard);

        pnlDashboard.add(scrollDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 940, 390));

        pnlContent.add(pnlDashboard, "card0");

        pnlMain.add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 100, 1001, 640));

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

    private void btnTambahDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDermagaActionPerformed
        jalankan(this::tambahDermaga, "Data dermaga tidak valid");
    }//GEN-LAST:event_btnTambahDermagaActionPerformed

    private void btnUbahDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahDermagaActionPerformed
        jalankan(this::ubahDermaga, "Data dermaga tidak valid");
    }//GEN-LAST:event_btnUbahDermagaActionPerformed

    private void btnStatusDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusDermagaActionPerformed
        jalankan(this::ubahStatusDermaga, "Status dermaga gagal diubah");
    }//GEN-LAST:event_btnStatusDermagaActionPerformed

    private void btnHapusDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDermagaActionPerformed
        jalankan(this::hapusDermaga, "Dermaga tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusDermagaActionPerformed

    private void btnMuatDermagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatDermagaActionPerformed
        jalankan(this::muatDermaga, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatDermagaActionPerformed

    private void btnTambahSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahSlotActionPerformed
        jalankan(this::tambahSlot, "Data slot gudang tidak valid");
    }//GEN-LAST:event_btnTambahSlotActionPerformed

    private void btnUbahSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahSlotActionPerformed
        jalankan(this::ubahSlot, "Data slot gudang tidak valid");
    }//GEN-LAST:event_btnUbahSlotActionPerformed

    private void btnHapusSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusSlotActionPerformed
        jalankan(this::hapusSlot, "Slot gudang tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusSlotActionPerformed

    private void btnMuatSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatSlotActionPerformed
        jalankan(this::muatSlot, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatSlotActionPerformed

    private void btnSimpanTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanTarifActionPerformed
        jalankan(this::simpanTarif, "Input tarif tidak valid");
    }//GEN-LAST:event_btnSimpanTarifActionPerformed

    private void btnMuatTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatTarifActionPerformed
        jalankan(this::muatTarif, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatTarifActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        jalankan(this::prosesBayar, "Pembayaran gagal");
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnMuatBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatBillingActionPerformed
        jalankan(this::muatBilling, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatBillingActionPerformed

    private void btnHapusAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusAkunActionPerformed
        jalankan(this::hapusAkun, "Akun tidak dapat dihapus");
    }//GEN-LAST:event_btnHapusAkunActionPerformed

    private void btnMuatAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatAkunActionPerformed
        jalankan(this::muatAkun, "Gagal memuat data");
    }//GEN-LAST:event_btnMuatAkunActionPerformed

    private void btnTampilLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilLaporanActionPerformed
        jalankan(this::tampilLaporan, "Laporan gagal dibuat");
    }//GEN-LAST:event_btnTampilLaporanActionPerformed

    private void btnEksporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEksporActionPerformed
        jalankan(this::eksporLaporan, "Ekspor gagal");
    }//GEN-LAST:event_btnEksporActionPerformed

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
        userLabel.setText(admin.getNama() + "   \u00b7   Administrator");
        gayaTabel(tblDermaga, scrollDermaga);
        gayaTabel(tblSlot, scrollSlot);
        gayaTabel(tblBilling, scrollBilling);
        gayaTabel(tblAkun, scrollAkun);
        gayaTabel(tblLaporan, scrollLaporan);
        siapkanNavigasi();
        // Dashboard disiapkan bersama navigasi sidebar.
        txtDari.setText(LocalDate.now().withDayOfMonth(1).toString());
        txtSampai.setText(LocalDate.now().toString());
        tblDermaga.getSelectionModel().addListSelectionListener(e -> {
            int r = tblDermaga.getSelectedRow();
            if (e.getValueIsAdjusting() || r < 0) return;
            txtKodeDermaga.setText(String.valueOf(tblDermaga.getValueAt(r, 0)));
            txtNamaDermaga.setText(String.valueOf(tblDermaga.getValueAt(r, 1)));
            txtKapasitasDermaga.setText(String.valueOf(tblDermaga.getValueAt(r, 2)));
        });
        tblSlot.getSelectionModel().addListSelectionListener(e -> {
            int r = tblSlot.getSelectedRow();
            if (e.getValueIsAdjusting() || r < 0) return;
            txtKodeBlok.setText(String.valueOf(tblSlot.getValueAt(r, 1)));
            txtKapasitasSlot.setText(String.valueOf(tblSlot.getValueAt(r, 2)));
            txtOperatorSlot.setText(String.valueOf(tblSlot.getValueAt(r, 5)));
        });
    }

    private void muatSemua() throws Exception {
        muatDermaga(); muatSlot(); muatTarif(); muatBilling(); muatAkun();
        perbaruiDashboard();
    }

    private void siapkanNavigasi() {
        dashboardValues = new JLabel[]{lblCardValue1, lblCardValue2, lblCardValue3, lblCardValue4};
        dashboardTable = tblDashboard;
        navButtons.addAll(java.util.Arrays.asList(btnMenuDashboard, btnMenuPendaftaran, btnMenuDaftarKapal, btnMenuPenambatan, btnMenuBongkarMuat, btnMenuKargo1, btnMenuKargo));
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
        String[] menu = {"Dashboard", "Kelola Dermaga", "Kelola Slot Gudang", "Kelola Tarif", "Billing & Pembayaran", "Kelola Akun Operator", "Laporan"};
        ((java.awt.CardLayout) pnlContent.getLayout()).show(pnlContent, "card" + index);
        lblHeading.setText(index == 0 ? "Dashboard Admin" : menu[index]);
        tandaiNavigasi(index);
    }

    private void tandaiNavigasi(int selected) {
        for (int i = 0; i < navButtons.size(); i++)
            navButtons.get(i).setBackground(i == selected ? new Color(0, 140, 160) : new Color(17, 39, 67));
    }

    private void perbaruiDashboard() {
        if (dashboardValues==null) return;
        dashboardValues[0].setText(String.valueOf(tblDermaga.getRowCount()));
        dashboardValues[1].setText(String.valueOf(tblSlot.getRowCount()));
        dashboardValues[2].setText(String.valueOf(tblBilling.getRowCount()));
        dashboardValues[3].setText(String.valueOf(tblAkun.getRowCount()));
        javax.swing.table.DefaultTableModel source=(javax.swing.table.DefaultTableModel)tblBilling.getModel();
        javax.swing.table.DefaultTableModel copy=new javax.swing.table.DefaultTableModel(){ @Override public boolean isCellEditable(int r,int c){return false;} };
        for(int c=0;c<source.getColumnCount();c++) copy.addColumn(source.getColumnName(c));
        for(int r=0;r<Math.min(8,source.getRowCount());r++){
            Object[] row=new Object[source.getColumnCount()]; for(int c=0;c<row.length;c++) row[c]=source.getValueAt(r,c); copy.addRow(row);
        }
        dashboardTable.setModel(copy);
        dashboardTable.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,10));
    }

    private void muatDermaga() throws Exception { isi(tblDermaga, controller.getDaftarDermaga()); }
    private void muatSlot() throws Exception { isi(tblSlot, controller.getDaftarSlot()); }
    private void muatBilling() throws Exception { isi(tblBilling, controller.getKapalSandar()); }
    private void muatAkun() throws Exception { isi(tblAkun, controller.getDaftarOperator()); }
    private void muatTarif() throws Exception {
        double[] t = controller.getTarif();
        txtTarifTambat.setText(String.valueOf(t[0]));
        txtTarifBongkar.setText(String.valueOf(t[1]));
    }

    // ---------- Menu 1: Kelola Dermaga ----------
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

    // ---------- Menu 2: Kelola Slot Gudang ----------
    private void tambahSlot() throws Exception {
        controller.tambahSlotGudang(txtKodeBlok.getText(), angka(txtKapasitasSlot, "Kapasitas"), txtOperatorSlot.getText());
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

    // ---------- Menu 3: Kelola Tarif ----------
    private void simpanTarif() throws Exception {
        controller.updateTarif(angka(txtTarifTambat, "Tarif tambat"), angka(txtTarifBongkar, "Tarif muatan"));
        info("Tarif Pelabuhan Berhasil Diubah!");
        muatTarif();
    }

    // ---------- Menu 4: Billing & Pembayaran ----------
    private void prosesBayar() throws Exception {
        String id = dipilih(tblBilling, 0, "Pilih kapal dari tabel terlebih dahulu.");
        AdminController.Tagihan t = controller.hitungRincian(id);
        if ("Lunas".equalsIgnoreCase(t.statusBayar)) {
            info("Retribusi kapal " + id + " sudah lunas.\n\n" + t.rincian());
            return;
        }
        int pilih = JOptionPane.showConfirmDialog(this,
                "Rincian tagihan kapal " + id + "\n\n" + t.rincian() + "\n\nApakah retribusi telah dibayar lunas?\n"
                + "(Ya = Lunas, Tidak = catat Belum Lunas)",
                "Rincian Tagihan", JOptionPane.YES_NO_CANCEL_OPTION);
        if (pilih == JOptionPane.CANCEL_OPTION || pilih == JOptionPane.CLOSED_OPTION) return;
        boolean lunas = pilih == JOptionPane.YES_OPTION;
        controller.prosesPembayaran(id, admin.getIdPengguna(), lunas);
        info(lunas ? "Pembayaran Lunas & Transaksi Berhasil!" : "Status pembayaran diperbarui menjadi Belum Lunas.");
        muatBilling();
        muatDermaga();
    }

    // ---------- Menu 5: Kelola Akun Operator ----------
    private void hapusAkun() throws Exception {
        String id = dipilih(tblAkun, 0, "Pilih akun operator dari tabel terlebih dahulu.");
        if (!konfirmasi("Hapus akun operator " + id + "?")) return;
        controller.hapusAkunOperator(id);
        info("Akun Operator Berhasil Dihapus!");
        muatAkun();
    }

    // ---------- Menu 6: Laporan ----------
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
        fc.setSelectedFile(new File("laporan_argoport_" + laporanMulai + "_" + laporanAkhir + ".csv"));
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
        controller.eksporLaporan(fc.getSelectedFile(), laporanMulai, laporanAkhir, laporanTerakhir);
        info("File Laporan Berhasil Diunduh!\n" + fc.getSelectedFile().getAbsolutePath());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnEkspor;
    private javax.swing.JButton btnHapusAkun;
    private javax.swing.JButton btnHapusDermaga;
    private javax.swing.JButton btnHapusSlot;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuBongkarMuat;
    private javax.swing.JButton btnMenuDaftarKapal;
    private javax.swing.JButton btnMenuDashboard;
    private javax.swing.JButton btnMenuKargo;
    private javax.swing.JButton btnMenuKargo1;
    private javax.swing.JButton btnMenuPenambatan;
    private javax.swing.JButton btnMenuPendaftaran;
    private javax.swing.JButton btnMuatAkun;
    private javax.swing.JButton btnMuatBilling;
    private javax.swing.JButton btnMuatDermaga;
    private javax.swing.JButton btnMuatSlot;
    private javax.swing.JButton btnMuatTarif;
    private javax.swing.JButton btnSimpanTarif;
    private javax.swing.JButton btnStatusDermaga;
    private javax.swing.JButton btnTambahDermaga;
    private javax.swing.JButton btnTambahSlot;
    private javax.swing.JButton btnTampilLaporan;
    private javax.swing.JButton btnUbahDermaga;
    private javax.swing.JButton btnUbahSlot;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblCardTitle1;
    private javax.swing.JLabel lblCardTitle2;
    private javax.swing.JLabel lblCardTitle3;
    private javax.swing.JLabel lblCardTitle4;
    private javax.swing.JLabel lblCardValue1;
    private javax.swing.JLabel lblCardValue2;
    private javax.swing.JLabel lblCardValue3;
    private javax.swing.JLabel lblCardValue4;
    private javax.swing.JLabel lblDari;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblKapalTitle;
    private javax.swing.JLabel lblKapasitasDermaga;
    private javax.swing.JLabel lblKapasitasSlot;
    private javax.swing.JLabel lblKodeBlok;
    private javax.swing.JLabel lblKodeDermaga;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNamaDermaga;
    private javax.swing.JLabel lblNilaiKapal;
    private javax.swing.JLabel lblNilaiPendapatan;
    private javax.swing.JLabel lblNilaiTonase;
    private javax.swing.JLabel lblOperatorSlot;
    private javax.swing.JLabel lblPendapatanTitle;
    private javax.swing.JLabel lblRecent;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSampai;
    private javax.swing.JLabel lblTarifBongkar;
    private javax.swing.JLabel lblTarifTambat;
    private javax.swing.JLabel lblTarifTitle;
    private javax.swing.JLabel lblTonaseTitle;
    private javax.swing.JPanel pnlAkun;
    private javax.swing.JPanel pnlBilling;
    private javax.swing.JPanel pnlCard1;
    private javax.swing.JPanel pnlCard2;
    private javax.swing.JPanel pnlCard3;
    private javax.swing.JPanel pnlCard4;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JPanel pnlDermaga;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlLaporan;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlSlot;
    private javax.swing.JPanel pnlTarif;
    private javax.swing.JScrollPane scrollAkun;
    private javax.swing.JScrollPane scrollBilling;
    private javax.swing.JScrollPane scrollDashboard;
    private javax.swing.JScrollPane scrollDermaga;
    private javax.swing.JScrollPane scrollLaporan;
    private javax.swing.JScrollPane scrollSlot;
    private javax.swing.JTable tblAkun;
    private javax.swing.JTable tblBilling;
    private javax.swing.JTable tblDashboard;
    private javax.swing.JTable tblDermaga;
    private javax.swing.JTable tblLaporan;
    private javax.swing.JTable tblSlot;
    private javax.swing.JTextField txtDari;
    private javax.swing.JTextField txtKapasitasDermaga;
    private javax.swing.JTextField txtKapasitasSlot;
    private javax.swing.JTextField txtKodeBlok;
    private javax.swing.JTextField txtKodeDermaga;
    private javax.swing.JTextField txtNamaDermaga;
    private javax.swing.JTextField txtOperatorSlot;
    private javax.swing.JTextField txtSampai;
    private javax.swing.JTextField txtTarifBongkar;
    private javax.swing.JTextField txtTarifTambat;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
