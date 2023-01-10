package main;

import db.Koneksi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        header.initMoving(this);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new swing.PanelLogin();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        eUser = new javax.swing.JTextField();
        ePass = new javax.swing.JPasswordField();
        customGradientButton1 = new swing.CustomGradientButton();
        bLogin = new swing.CustomGradientButton();
        header = new component.HeaderLogin();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Password");

        eUser.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        eUser.setForeground(new java.awt.Color(0, 0, 0));
        eUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eUserKeyReleased(evt);
            }
        });

        ePass.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ePass.setForeground(new java.awt.Color(0, 0, 0));
        ePass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ePassKeyReleased(evt);
            }
        });

        customGradientButton1.setText("Exit");
        customGradientButton1.setColor1(new java.awt.Color(249, 8, 8));
        customGradientButton1.setColor2(new java.awt.Color(253, 255, 53));
        customGradientButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        customGradientButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customGradientButton1ActionPerformed(evt);
            }
        });

        bLogin.setText("Login");
        bLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLogin1Layout = new javax.swing.GroupLayout(panelLogin1);
        panelLogin1.setLayout(panelLogin1Layout);
        panelLogin1Layout.setHorizontalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogin1Layout.createSequentialGroup()
                .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(66, 66, 66)
                        .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ePass, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eUser, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customGradientButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLogin1Layout.setVerticalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogin1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)))
                .addGap(18, 39, Short.MAX_VALUE)
                .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customGradientButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void customGradientButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customGradientButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_customGradientButton1ActionPerformed

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        // TODO add your handling code here:
        Koneksi koneksi = new Koneksi();
        Connection con = koneksi.getConnection();
        
        String query = "SELECT * FROM admin WHERE username=? AND password=?";
        PreparedStatement ps;
        ResultSet rs;
        
        if(eUser.getText().trim().isEmpty() && ePass.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username & Password Harus Diisi!");
            eUser.requestFocus();
            eUser.setBackground(Color.red);
            ePass.setBackground(Color.red);
        } else if(eUser.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username Harus Diisi!");
            eUser.requestFocus();
            eUser.setBackground(Color.red);
        } else if(ePass.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password Harus Diisi!");
            ePass.requestFocus();
            ePass.setBackground(Color.red);
        } else {
            try {
                ps = con.prepareStatement(query);
                ps.setString(1, eUser.getText()); // Mengisi ? Pertama pada nilai variabel query
                ps.setString(2, ePass.getText()); // Mengisi ? Kedua pada nilai variabel query

                rs = ps.executeQuery();

                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    Main mainMenu = new Main();
                    mainMenu.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login GAGAL, Periksa Username/Password");
                    eUser.setText("");
                    ePass.setText("");
                    eUser.requestFocus();
                    eUser.setBackground(Color.red);
                    ePass.setBackground(Color.red);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println("Error Login : " + ex);
            }
        }
    }//GEN-LAST:event_bLoginActionPerformed

    private void eUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eUserKeyReleased
        // TODO add your handling code here:
        eUser.setBackground(Color.white);
    }//GEN-LAST:event_eUserKeyReleased

    private void ePassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ePassKeyReleased
        // TODO add your handling code here:
        ePass.setBackground(Color.white);
    }//GEN-LAST:event_ePassKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.CustomGradientButton bLogin;
    private swing.CustomGradientButton customGradientButton1;
    private javax.swing.JPasswordField ePass;
    private javax.swing.JTextField eUser;
    private component.HeaderLogin header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private swing.PanelLogin panelLogin1;
    // End of variables declaration//GEN-END:variables
}
