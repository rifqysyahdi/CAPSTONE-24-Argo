package view;

import javax.swing.JOptionPane;
/**
 * ArgoPort | Beranda. Tampilan diatur lewat NetBeans Design (WelcomeView.form).
 */
public class WelcomeView extends javax.swing.JFrame {

    public WelcomeView() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNav = new javax.swing.JPanel();
        lblNavLogo = new javax.swing.JLabel();
        lblBrandNav = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        pnlAbout = new javax.swing.JPanel();
        lblAboutHeading = new javax.swing.JLabel();
        lblFitur1Judul = new javax.swing.JLabel();
        lblFitur2Judul = new javax.swing.JLabel();
        lblFitur3Judul = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArgoPort | Beranda");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNav.setBackground(new java.awt.Color(17, 39, 67));
        pnlNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNavLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sidebar.png"))); // NOI18N
        pnlNav.add(lblNavLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 16, 40, 40));

        lblBrandNav.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblBrandNav.setForeground(new java.awt.Color(255, 255, 255));
        lblBrandNav.setText("Argoport System");
        pnlNav.add(lblBrandNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, 30));

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlNav.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, -1, -1));

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlNav.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 255, 255));
        jButton3.setText("Home");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlNav.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        getContentPane().add(pnlNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 72));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("<html><div style=\"width:650px\">Argoport System hadir sebagai ekspedisi muatan kapal laut (EMKL) terbesar dan terpercaya se-Kalimantan Timur  yang mendukung efisiensi operasional pengiriman kargo.</div></html>");
        jLabel2.setMaximumSize(new java.awt.Dimension(1000, 550));
        jLabel2.setMinimumSize(new java.awt.Dimension(1000, 550));
        jLabel2.setPreferredSize(new java.awt.Dimension(1000, 550));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 860, 60));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Where Cargo Meets Its Destination");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_main.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, 1100, 430));

        pnlAbout.setBackground(new java.awt.Color(255, 255, 255));
        pnlAbout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAboutHeading.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        lblAboutHeading.setForeground(new java.awt.Color(24, 41, 61));
        lblAboutHeading.setText("About Us!");
        pnlAbout.add(lblAboutHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 500, 36));

        lblFitur1Judul.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblFitur1Judul.setForeground(new java.awt.Color(24, 41, 61));
        lblFitur1Judul.setText("Manajemen Dermaga & Slot Gudang");
        pnlAbout.add(lblFitur1Judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, 22));

        lblFitur2Judul.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblFitur2Judul.setForeground(new java.awt.Color(24, 41, 61));
        lblFitur2Judul.setText("Billing & Tarif Retribusi");
        pnlAbout.add(lblFitur2Judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 190, 22));

        lblFitur3Judul.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblFitur3Judul.setForeground(new java.awt.Color(24, 41, 61));
        lblFitur3Judul.setText("Laporan Real-time");
        pnlAbout.add(lblFitur3Judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 300, 22));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("<html><div style=\"width:200px\">Catat kapasitas dermaga dan slot gudang, pantau ketersediaan secara langsung.</div></html>");
        pnlAbout.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("<html><div style=\"width:200px\"Hitung tarif retribusi dan kelola status pembayaran kapal dalam satu tempat..</div></html>");
        pnlAbout.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("<html><div style=\"width:200px\">Hitung tarif retribusi dan kelola status pembayaran kapal dalam satu tempat.</div></html>");
        pnlAbout.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("<html><div style=\"width:200px\">Lihat ringkasan operasional pelabuhan dan ekspor laporan kapan saja.</div></html>");
        pnlAbout.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, -1, -1));

        getContentPane().add(pnlAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1100, 260));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new LoginView().setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAboutHeading;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBrandNav;
    private javax.swing.JLabel lblFitur1Judul;
    private javax.swing.JLabel lblFitur2Judul;
    private javax.swing.JLabel lblFitur3Judul;
    private javax.swing.JLabel lblNavLogo;
    private javax.swing.JPanel pnlAbout;
    private javax.swing.JPanel pnlNav;
    // End of variables declaration//GEN-END:variables
}
