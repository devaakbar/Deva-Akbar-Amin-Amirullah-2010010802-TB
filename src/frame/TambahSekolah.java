package frame;

import db.Koneksi;
import form.Form_2;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.KeyValue;
import model.Sekolah;

public class TambahSekolah extends javax.swing.JFrame {

    int status;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    String query = "SELECT * FROM sekolah_pilihan ORDER BY id_sekolah ASC";
    Form_2 form2;
    
    private final int SEDANG_TAMBAH = 101;
    private final int SEDANG_UBAH = 102;
    
    public TambahSekolah(){
        initComponents();
        header.initMoving(this);
    }
    
    public TambahSekolah(Form_2 form2) {
        initComponents();
        setBackground(new Color(0,0,0,0));
        header.initMoving(this);
        
        tfId.setVisible(false);
        jLabel3.setVisible(false);
        tfNama.requestFocus();
        status = SEDANG_TAMBAH;
        this.form2 = form2;
        header.setStatusText("FORM TAMBAH DATA");
    }
    
    public TambahSekolah(Sekolah sekolah, Form_2 form2){
        initComponents();
        setBackground(new Color(0,0,0,0));
        header.initMoving(this);
        
        header.setStatusText("FORM UBAH DATA");
        tfId.setVisible(true);
        jLabel3.setVisible(true);
        tfId.setText(String.valueOf(sekolah.getIdSekolah()));
        tfId.setEnabled(false);
        tfNama.requestFocus();
        tfNama.setText(sekolah.getNamaSekolah());
        taAlamat.setText(sekolah.getAlamatSekolah());
        cbAkreditasi.setSelectedItem(sekolah.getAkreditasi());
        status = SEDANG_UBAH;
        this.form2 = form2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        tfId = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbAkreditasi = new javax.swing.JComboBox<>();
        bSimpan = new swing.CustomButton();
        bBatal = new swing.CustomButton();
        header = new component.HeaderTambahSekolah();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nama Sekolah");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID Sekolah");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Alamat Sekolah");

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane1.setViewportView(taAlamat);

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Akreditasi");

        cbAkreditasi.setBackground(new java.awt.Color(255, 255, 255));
        cbAkreditasi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbAkreditasi.setForeground(new java.awt.Color(0, 0, 0));
        cbAkreditasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Akreditasi --", "A", "B", "C" }));

        bSimpan.setForeground(new java.awt.Color(0, 0, 0));
        bSimpan.setText("Simpan");
        bSimpan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bBatal.setForeground(new java.awt.Color(0, 0, 0));
        bBatal.setText("Batal");
        bBatal.setBorderColor(new java.awt.Color(252, 173, 3));
        bBatal.setColorClick(new java.awt.Color(252, 227, 164));
        bBatal.setColorOver(new java.awt.Color(255, 201, 66));
        bBatal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNama)
                            .addComponent(jScrollPane1)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAkreditasi, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbAkreditasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        Sekolah sekolah = new Sekolah();
        sekolah.setNamaSekolah(tfNama.getText());
        sekolah.setAlamatSekolah(taAlamat.getText());
        sekolah.setAkreditasi(cbAkreditasi.getSelectedItem().toString());

        if(sekolah.getNamaSekolah().equalsIgnoreCase("") ||
           sekolah.getAlamatSekolah().equalsIgnoreCase("") ||
           sekolah.getAkreditasi().equalsIgnoreCase("-- Pilih Akreditasi --"))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        } else {

            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();
            PreparedStatement ps;

            try {
                if(status == SEDANG_TAMBAH) {
                    String qry = "INSERT INTO sekolah_pilihan VALUES (NULL,?,?,?)";

                    ps = con.prepareStatement(qry);
                    ps.setString(1, sekolah.getNamaSekolah());
                    ps.setString(2, sekolah.getAlamatSekolah());
                    ps.setString(3, sekolah.getAkreditasi());
                    ps.executeUpdate();
                } else {
                    String qry = "UPDATE sekolah_pilihan SET "
                    + "nama_sekolah = ?, alamat_sekolah = ?,"
                    + "akreditasi_sekolah = ? WHERE id_sekolah = ?";

                    ps = con.prepareStatement(qry);
                    ps.setString(1, tfNama.getText());
                    ps.setString(2, taAlamat.getText());
                    ps.setString(3, cbAkreditasi.getSelectedItem().toString());
                    ps.setInt(4, Integer.parseInt(tfId.getText()));
                    ps.executeUpdate();
                }
            } catch (SQLException ex) {
                System.err.println("Error Insert/Update TambahPeserta : " + ex);
            }
            form2.resetTable("");
            dispose();
        }
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bBatalActionPerformed

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
            java.util.logging.Logger.getLogger(TambahSekolah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahSekolah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahSekolah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahSekolah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahSekolah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.CustomButton bBatal;
    private swing.CustomButton bSimpan;
    private javax.swing.JComboBox<String> cbAkreditasi;
    private component.HeaderTambahSekolah header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNama;
    // End of variables declaration//GEN-END:variables
}
