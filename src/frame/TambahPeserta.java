package frame;

import db.Koneksi;
import form.Form_1;
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
import model.Peserta;
import main.Main;


public class TambahPeserta extends javax.swing.JFrame {

    int status;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    String query = "SELECT * FROM calon_siswa ORDER BY id_calon ASC";
    Form_1 form1;
    
    private final int SEDANG_TAMBAH = 101;
    private final int SEDANG_UBAH = 102;
    
    public TambahPeserta(){
        initComponents();
        setBackground(new Color(0,0,0,0));
        header.initMoving(this);
    }
    
    public TambahPeserta(Form_1 form1) {
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        header.initMoving(this);
        header.setStatusText("FORM TAMBAH DATA");
        tfId.setVisible(false);
        jLabel2.setVisible(false);
        tfNama.requestFocus();
        status = SEDANG_TAMBAH;
        this.form1 = form1;
    }
    
    public TambahPeserta(Peserta peserta, Form_1 form1){
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        header.initMoving(this);
        header.setStatusText("FORM UBAH DATA");
        tfId.setVisible(true);
        jLabel2.setVisible(true);
        tfId.setText(String.valueOf(peserta.getId()));
        tfId.setEnabled(false);
        tfNama.requestFocus();
        tfNama.setText(peserta.getNamaPeserta());
        rbJenisKelaminSetSelected(peserta.getJenisKelamin());
        taAlamat.setText(peserta.getAlamat());
        cbAgama.setSelectedItem(peserta.getAgama());
        tfSekolah.setText(peserta.getAsalSekolah());
        status = SEDANG_UBAH;
        this.form1 = form1;
        
    }
    
    
    public void rbJenisKelaminSetSelected(String jenisKelamin){
        if(jenisKelamin.equals("Laki-Laki")){
            rbLaki.setSelected(true);
        } else {
            rbPerempuan.setSelected(true);
        }
    }
    
    public String rbJenisKelaminGetSelected(){
        if(rbLaki.isSelected()){
            return "Laki-Laki";
        } else if(rbPerempuan.isSelected()){
            return "Perempuan";
        } else
            return "";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBorder1 = new swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        cbAgama = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tfSekolah = new javax.swing.JTextField();
        bSimpan = new swing.CustomButton();
        bBatal = new swing.CustomButton();
        header = new component.HeaderTambahPeserta();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID");

        tfId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfId.setForeground(new java.awt.Color(0, 0, 0));

        tfNama.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfNama.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Jenis Kelamin");

        rbLaki.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbLaki);
        rbLaki.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbLaki.setForeground(new java.awt.Color(0, 0, 0));
        rbLaki.setText("Laki-Laki");

        rbPerempuan.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbPerempuan);
        rbPerempuan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbPerempuan.setForeground(new java.awt.Color(0, 0, 0));
        rbPerempuan.setText("Perempuan");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Alamat");

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane1.setViewportView(taAlamat);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Agama");

        cbAgama.setBackground(new java.awt.Color(255, 255, 255));
        cbAgama.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbAgama.setForeground(new java.awt.Color(0, 0, 0));
        cbAgama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Agama -", "Islam", "Kristen Protestan", "Kristen Katolik", "Hindu", "Buddha", "Kong Hu Chu" }));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Asal Sekolah");

        tfSekolah.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfSekolah.setForeground(new java.awt.Color(0, 0, 0));

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
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNama)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(rbLaki)
                                        .addGap(42, 42, 42)
                                        .addComponent(rbPerempuan))
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(cbAgama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfSekolah))))
                .addGap(20, 20, 20))
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        Peserta peserta = new Peserta();
        peserta.setNamaPeserta(tfNama.getText());
        peserta.setJenisKelamin(rbJenisKelaminGetSelected());
        peserta.setAlamat(taAlamat.getText());
        peserta.setAgama(cbAgama.getSelectedItem().toString());
        peserta.setAsalSekolah(tfSekolah.getText());
        
        if(peserta.getNamaPeserta().equalsIgnoreCase("") ||
           peserta.getJenisKelamin().equalsIgnoreCase("") ||
           peserta.getAlamat().equalsIgnoreCase("") ||
           peserta.getAgama().equalsIgnoreCase("- Pilih Agama -") ||
           peserta.getAsalSekolah().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        } else {
            
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();
            PreparedStatement ps;
            
            try {
                if(status == SEDANG_TAMBAH) {
                    String qry = "INSERT INTO calon_siswa VALUES (NULL,?,?,?,?,?)";
                    
                        ps = con.prepareStatement(qry);
                        ps.setString(1, peserta.getNamaPeserta());
                        ps.setString(2, peserta.getJenisKelamin());
                        ps.setString(3, peserta.getAlamat());
                        ps.setString(4, peserta.getAgama());
                        ps.setString(5, peserta.getAsalSekolah());
                        ps.executeUpdate();
                } else {
                    String qry = "UPDATE calon_siswa SET "
                                + "nama_calon_siswa = ?, jenis_kelamin = ?,"
                                + "alamat = ?, agama = ?,"
                                + "asal_sekolah = ? WHERE id_calon = ?";
                    
                        ps = con.prepareStatement(qry);
                        ps.setString(1, tfNama.getText());
                        ps.setString(2, rbJenisKelaminGetSelected());
                        ps.setString(3, taAlamat.getText());
                        ps.setString(4, cbAgama.getSelectedItem().toString());
                        ps.setString(5, tfSekolah.getText());
                        ps.setInt(6, Integer.parseInt(tfId.getText()));
                        ps.executeUpdate();
                }
            } catch (SQLException ex) {
                System.err.println("Error Insert/Update TambahPeserta : " + ex);
            }
        form1.resetTable("");
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
            java.util.logging.Logger.getLogger(TambahPeserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahPeserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahPeserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahPeserta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahPeserta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.CustomButton bBatal;
    private swing.CustomButton bSimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbAgama;
    private component.HeaderTambahPeserta header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfSekolah;
    // End of variables declaration//GEN-END:variables
}
