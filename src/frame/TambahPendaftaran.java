/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import db.Koneksi;
import form.Form_3;
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
import model.Pendaftaran;
import model.Peserta;
import model.Sekolah;

/**
 *
 * @author Lenovo
 */
public class TambahPendaftaran extends javax.swing.JFrame {
    int status;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    String qrySekolah = "SELECT * FROM sekolah_pilihan ORDER BY id_sekolah ASC";
    String qryPeserta = "SELECT * FROM calon_siswa ORDER BY nama_calon_siswa ASC";
    Form_3 form3;
    
    private final int SEDANG_TAMBAH = 101;
    private final int SEDANG_UBAH = 102;
    
    public TambahPendaftaran(){
        initComponents();
    }
    
    public TambahPendaftaran(Form_3 form3) {
        initComponents();
        setBackground(new Color(0,0,0,0));
        header.initMoving(this);
        header.setStatusText("FORM TAMBAH DATA");
        
        tfId.setVisible(false);
        jLabel3.setVisible(false);
        cbPeserta.requestFocus();
        
        cbSetModel(qryPeserta, "id_calon", "nama_calon_siswa", cbPeserta);
        cbSetModel(qrySekolah, "id_sekolah", "nama_sekolah", cbSekolah);

        status = SEDANG_TAMBAH;
        this.form3 = form3;
    }
    
    public TambahPendaftaran(Pendaftaran pendaftaran, Form_3 form3){
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        header.initMoving(this);
        header.setStatusText("FORM UBAH DATA");
        tfId.setVisible(true);
        jLabel3.setVisible(true);
        tfId.setText(String.valueOf(pendaftaran.getIdDaftar()));
        tfId.setEnabled(false);
        cbPeserta.requestFocus();
        
        cbSetModel(qryPeserta, "id_calon", "nama_calon_siswa", cbPeserta);
        cbSetSelected(pendaftaran.getPeserta().getNamaPeserta(), cbPeserta);
        cbSetModel(qrySekolah, "id_sekolah", "nama_sekolah", cbSekolah);
        cbSetSelected(pendaftaran.getSekolah().getNamaSekolah(), cbSekolah);
        cbStatus.setSelectedItem(pendaftaran.getStatus());
        
        status = SEDANG_UBAH;
        this.form3 = form3;
    }


    public Vector getCbData(String qry, String key, String value){
        Vector v = new Vector();
        
        try{
            Koneksi koneksi = new Koneksi();
            Connection connection = koneksi.getConnection();
            
            st = connection.createStatement();
            rs = st.executeQuery(qry);
            
            while(rs.next()){
                v.addElement(new KeyValue(rs.getInt(key),
                                          rs.getString(value)));
            }
        }catch(SQLException ex){
            System.err.println("Error getCbData() TambahPendaftaran: " + ex);
        }
        
        return v;
    }
    
    public void cbSetModel(String qry, String key, String value, JComboBox<String> jcb){
        Vector v = getCbData(qry,key,value);
        DefaultComboBoxModel model;
        model = new DefaultComboBoxModel(v);
        jcb.setModel(model);
    }
    
     public void cbSetSelected(String data, JComboBox<String> cb){
        KeyValue item = new KeyValue();
        
        for (int i = 0; i < cb.getItemCount(); i++) {
            cb.setSelectedIndex(i);
            item.setValue(((KeyValue)cb.getSelectedItem()).getValue());
            
            if(item.getValue().equalsIgnoreCase(data))
            {
                cb.setSelectedIndex(i);
                break;
            }
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        cbPeserta = new javax.swing.JComboBox<>();
        cbSekolah = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        bSimpan = new swing.CustomButton();
        bBatal = new swing.CustomButton();
        header = new component.HeaderTambahPendaftaran();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID Pendaftaran");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Peserta");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Status");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sekolah");

        tfId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cbPeserta.setBackground(new java.awt.Color(255, 255, 255));
        cbPeserta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbPeserta.setForeground(new java.awt.Color(0, 0, 0));
        cbPeserta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbSekolah.setBackground(new java.awt.Color(255, 255, 255));
        cbSekolah.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbSekolah.setForeground(new java.awt.Color(0, 0, 0));
        cbSekolah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbStatus.setBackground(new java.awt.Color(255, 255, 255));
        cbStatus.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbStatus.setForeground(new java.awt.Color(0, 0, 0));
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Status Pendaftaran -", "DITERIMA", "DITOLAK", "DIPROSES" }));

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
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(39, 39, 39)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 34, Short.MAX_VALUE))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 44, Short.MAX_VALUE))
        );

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        Pendaftaran pendaftaran = new Pendaftaran();
        pendaftaran.setStatus(cbStatus.getSelectedItem().toString());
        
        Peserta peserta = new Peserta();
        peserta.setId(((KeyValue)cbPeserta.getSelectedItem()).getKey());
        pendaftaran.setPeserta(peserta);
        
        Sekolah sekolah = new Sekolah();
        sekolah.setIdSekolah(((KeyValue)cbSekolah.getSelectedItem()).getKey());
        pendaftaran.setSekolah(sekolah);

        if(pendaftaran.getStatus().equalsIgnoreCase("- Pilih Status Pendaftaran -"))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        } else {

            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();
            PreparedStatement ps;

            try {
                if(status == SEDANG_TAMBAH) {
                    String qry = "INSERT INTO pendaftaran VALUES (NULL,?,?,?)";

                    ps = con.prepareStatement(qry);
                    ps.setInt(1, pendaftaran.getPeserta().getId());
                    ps.setInt(2, pendaftaran.getSekolah().getIdSekolah());
                    ps.setString(3, pendaftaran.getStatus());
                    ps.executeUpdate();
                } else {
                    String qry = "UPDATE pendaftaran SET "
                    + "id_siswa = ?, id_sekolah = ?,"
                    + "status_pendaftaran = ? WHERE id_pendaftaran = ?";

                    ps = con.prepareStatement(qry);
                    ps.setInt(1, pendaftaran.getPeserta().getId());
                    ps.setInt(2, pendaftaran.getSekolah().getIdSekolah());
                    ps.setString(3, cbStatus.getSelectedItem().toString());
                    ps.setInt(4, Integer.parseInt(tfId.getText()));
                    ps.executeUpdate();
                }
            } catch (SQLException ex) {
                System.err.println("Error Insert/Update TambahPeserta : " + ex);
            }
            form3.resetTable("");
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
            java.util.logging.Logger.getLogger(TambahPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahPendaftaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.CustomButton bBatal;
    private swing.CustomButton bSimpan;
    private javax.swing.JComboBox<String> cbPeserta;
    private javax.swing.JComboBox<String> cbSekolah;
    private javax.swing.JComboBox<String> cbStatus;
    private component.HeaderTambahPendaftaran header;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JTextField tfId;
    // End of variables declaration//GEN-END:variables
}
