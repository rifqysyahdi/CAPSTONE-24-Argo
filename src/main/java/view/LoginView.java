package view;

import controller.AuthController;
import model.Pengguna;
import javax.swing.JOptionPane;

/**
 * ArgoPort | Login. Tampilan diatur lewat NetBeans Design (LoginView.form).
 */
public class LoginView extends javax.swing.JFrame {

    private final AuthController authController = new AuthController();

    public LoginView() {
        initComponents();
        util.Branding.pasangIkonJendela(this);
        setLocationRelativeTo(null);
        
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblCardLogo = new javax.swing.JLabel();
        lblLoginTitle = new javax.swing.JLabel();
        lblLoginSub = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLhtpw = new javax.swing.JCheckBox();
        pnlNav = new javax.swing.JPanel();
        lblNavLogo = new javax.swing.JLabel();
        lblBrandNav = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArgoPort | Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 231, 239)));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCardLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_card.png"))); // NOI18N
        pnlLogin.add(lblCardLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 28, 47, 48));

        lblLoginTitle.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblLoginTitle.setForeground(new java.awt.Color(24, 39, 58));
        lblLoginTitle.setText("Selamat Datang, User!");
        pnlLogin.add(lblLoginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 88, 340, 38));

        lblLoginSub.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblLoginSub.setForeground(new java.awt.Color(111, 126, 145));
        lblLoginSub.setText("Masukkan Username dan Password Anda");
        pnlLogin.add(lblLoginSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 128, 340, 22));

        lblUsername.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(75, 91, 110));
        lblUsername.setText("USERNAME");
        pnlLogin.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 178, 340, 18));

        btnLogin.setBackground(new java.awt.Color(27, 93, 145));
        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 340, 46));

        txtUsername.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUsername.setBackground(new java.awt.Color(249, 251, 253));
        txtUsername.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12)));
        pnlLogin.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 340, 44));

        lblPassword.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(75, 91, 110));
        lblPassword.setText("PASSWORD");
        pnlLogin.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 262, 340, 18));

        txtPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPassword.setBackground(new java.awt.Color(249, 251, 253));
        txtPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 226, 235)), javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12)));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        pnlLogin.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 284, 340, 44));

        btnLhtpw.setText("Lihat Password");
        btnLhtpw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLhtpwActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLhtpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

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

        pnlLogin.add(pnlNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(-350, -110, 1100, 72));

        btnKeluar.setBackground(new java.awt.Color(253, 236, 234));
        btnKeluar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(176, 48, 38));
        btnKeluar.setText("Keluar");
        btnKeluar.setBorderPainted(false);
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluar.setFocusPainted(false);
        btnKeluar.setOpaque(true);
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        pnlLogin.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        getContentPane().add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 115, 400, 470));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_main.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        doLogin();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        doLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLhtpwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLhtpwActionPerformed
        if (txtPassword.getEchoChar() == 0) {
            txtPassword.setEchoChar('*');
            btnLhtpw.setText("Lihat Password");
        } else {
            txtPassword.setEchoChar((char) 0);
            btnLhtpw.setText("Sembunyikan");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnLhtpwActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int konfirmasi = JOptionPane.showConfirmDialog(
            this,
            "Apakah Anda yakin ingin logout?",
            "Konfirmasi Logout",
            JOptionPane.YES_NO_OPTION
        );

        if (konfirmasi == JOptionPane.YES_OPTION) {
            new LoginView().setVisible(true);
            this.dispose();
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new LoginView().setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
    new WelcomeView().setVisible(true);
    dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed


    private void doLogin() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan password wajib diisi.", "Data belum lengkap", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Pengguna p = authController.login(username, password);
            util.Sesi.pengguna = p;
            if (p.isWajibGantiSandi() && !ProfilDialog.tampilkan(this, true)) {
                // Password sementara belum diganti: batalkan sesi, tetap di halaman login.
                repository.DBConnection.logout();
                util.Sesi.pengguna = null;
                txtPassword.setText("");
                return;
            }
            dispose();
            if (p.getPeran().equalsIgnoreCase("Admin")) new DashboardAdmin(p).setVisible(true);
            else new DashboardOperator(p).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Login tidak berhasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JCheckBox btnLhtpw;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBrandNav;
    private javax.swing.JLabel lblCardLogo;
    private javax.swing.JLabel lblLoginSub;
    private javax.swing.JLabel lblLoginTitle;
    private javax.swing.JLabel lblNavLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlNav;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
