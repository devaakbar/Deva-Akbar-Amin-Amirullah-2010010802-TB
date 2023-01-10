package form;

import javax.swing.ImageIcon;
import swing.SearchTextField;
import component.OpsiSearch;
import event.EventOpsiSearch;
import db.Koneksi;
import frame.TambahPeserta;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Peserta;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Form_1 extends javax.swing.JPanel {

    Peserta peserta;
    
    public Form_1() {
       initComponents();
       tPeserta.fixTable(jScrollPane1);
       
       try{
           Koneksi.getInstance().connectDatabase();
       } catch (Exception e){
           e.printStackTrace();
       }
           
       
       resetTable("");
       
       eCari.addEventOptionSelected(new EventOpsiSearch() {
            @Override
            public void optionSelected(OpsiSearch option, int index) {
                eCari.setHint("Cari Berdasarkan " + option.getName() + "...");
            }
        });
        eCari.addOption(new OpsiSearch("ID", new ImageIcon(getClass().getResource("/icon/id.png"))));
        eCari.addOption(new OpsiSearch("Nama", new ImageIcon(getClass().getResource("/icon/user.png"))));
        eCari.addOption(new OpsiSearch("Gender", new ImageIcon(getClass().getResource("/icon/gender.png"))));
        eCari.addOption(new OpsiSearch("Alamat", new ImageIcon(getClass().getResource("/icon/address.png"))));
        eCari.addOption(new OpsiSearch("Agama", new ImageIcon(getClass().getResource("/icon/religion.png"))));
        eCari.addOption(new OpsiSearch("Sekolah", new ImageIcon(getClass().getResource("/icon/school.png"))));
        loadData("");
    }
    
    // Method untuk Menampilkan Data yang Dicari
    private void loadData(String where, Object... search){
        try{
            DefaultTableModel model = (DefaultTableModel)tPeserta.getModel();
            model.setRowCount(0);
            PreparedStatement ps = Koneksi.getInstance().openConnection().prepareStatement("SELECT * FROM calon_siswa " + where);
            for (int i = 0; i < search.length; i++) {
                ps.setObject(i+1, search[i]);
               
            }
            ResultSet rs = ps.executeQuery();
            
            int noTemp = 1;
            while(rs.next()){
                int no = noTemp;
                int id = rs.getInt("id_calon");
                String nama = rs.getString("nama_calon_siswa");
                String kelamin = rs.getString("jenis_kelamin");
                String alamat = rs.getString("alamat");
                String agama = rs.getString("agama");
                String sekolah = rs.getString("asal_sekolah");
                model.addRow(new Object[]{no, id, nama, kelamin, alamat, agama, sekolah});
                noTemp++;
            }
            rs.close();
            ps.close();
        } catch (Exception e){
            System.out.println("Koneksi Gagal pada Form_1 method loadData()");
        }
    }
    
     public ArrayList<Peserta> getPesertaList(String keyword){
        ArrayList<Peserta> pesertaList = new ArrayList<Peserta>();
        Koneksi koneksi = new Koneksi();
        Connection connection =koneksi.getConnection();
        
        String query = "SELECT * FROM calon_siswa " + keyword;
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                peserta = new Peserta(
                        rs.getInt("id_calon"),
                        rs.getString("nama_calon_siswa"),
                        rs.getString("jenis_kelamin"),
                        rs.getString("alamat"),
                        rs.getString("agama"),
                        rs.getString("asal_sekolah"));
                pesertaList.add(peserta);
            }
        } catch(SQLException | NullPointerException ex) {
            System.err.println("Koneksi Null Gagal");
        }
        return pesertaList;
    }
     
    public void selectPeserta(String keyword){
       ArrayList<Peserta> list = getPesertaList(keyword);
       DefaultTableModel model = (DefaultTableModel)tPeserta.getModel();
       Object[] row = new Object[7];

       int tempNo = 1;
       for (int i = 0; i < list.size(); i++) {
           row[0] = tempNo;
           row[1] = list.get(i).getId();
           row[2] = list.get(i).getNamaPeserta();
           row[3] = list.get(i).getJenisKelamin();
           row[4] = list.get(i).getAlamat();
           row[5] = list.get(i).getAgama();
           row[6] = list.get(i).getAsalSekolah();
           model.addRow(row);
           tempNo++;
       }
   }
    
    // Reset Table
    public final void resetTable(String keyword){
        DefaultTableModel model = (DefaultTableModel)tPeserta.getModel();
        model.setRowCount(0);
        selectPeserta(keyword);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tPeserta = new swing.Table();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        eCari = new swing.SearchTextField();
        bTambah = new swing.CustomGradientButton();
        bUbah = new swing.CustomGradientButton();
        bHapus = new swing.CustomGradientButton();
        bCetak = new swing.CustomGradientButton();
        bReset = new swing.CustomGradientButton();

        setBackground(new java.awt.Color(247, 188, 223));
        setForeground(new java.awt.Color(242, 242, 242));

        tPeserta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor", "ID", "Nama", "Jenis Kelamin", "Alamat", "Agama", "Asal Sekolah"
            }
        ));
        jScrollPane1.setViewportView(tPeserta);
        if (tPeserta.getColumnModel().getColumnCount() > 0) {
            tPeserta.getColumnModel().getColumn(0).setMaxWidth(60);
            tPeserta.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        panelBorder1.setBackground(new java.awt.Color(0, 0, 0));
        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Peserta PPDB SMA Tahun 2023");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        eCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eCariKeyReleased(evt);
            }
        });

        bTambah.setText("Tambah");
        bTambah.setColor1(new java.awt.Color(0, 252, 0));
        bTambah.setColor2(new java.awt.Color(0, 153, 0));
        bTambah.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUbah.setText("Ubah");
        bUbah.setColor1(new java.awt.Color(255, 102, 0));
        bUbah.setColor2(new java.awt.Color(255, 153, 0));
        bUbah.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.setColor1(new java.awt.Color(255, 0, 0));
        bHapus.setColor2(new java.awt.Color(255, 4, 117));
        bHapus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bCetak.setText("Cetak");
        bCetak.setColor1(new java.awt.Color(0, 0, 255));
        bCetak.setColor2(new java.awt.Color(0, 204, 204));
        bCetak.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetakActionPerformed(evt);
            }
        });

        bReset.setText("Reset");
        bReset.setColor1(new java.awt.Color(255, 0, 194));
        bReset.setColor2(new java.awt.Color(255, 51, 51));
        bReset.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eCariKeyReleased
        // TODO add your handling code here:
        if(eCari.isSelected()){
            int option = eCari.getSelectedIndex();
            String text = "%" + eCari.getText().trim()+"%";
            
            if(option == 0){
                loadData("WHERE id_calon LIKE ?", text);
            }else if(option == 1){
                loadData("WHERE nama_calon_siswa LIKE ?", text);
            }else if(option == 2){
                loadData("WHERE jenis_kelamin LIKE ?", text);
            }else if(option == 3){
                loadData("WHERE alamat LIKE ?", text);
            }else if(option == 4){
                loadData("WHERE agama LIKE ?", text);
            }else if(option == 5){
                loadData("WHERE asal_sekolah LIKE ?", text);
            }
        }
    }//GEN-LAST:event_eCariKeyReleased

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        TambahPeserta tambahPeserta = new TambahPeserta(this);
        tambahPeserta.setVisible(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        int i = tPeserta.getSelectedRow();
        if(i>=0){
            TableModel model = tPeserta.getModel();
            peserta = new Peserta();
            peserta.setId(Integer.parseInt(model.getValueAt(i, 1).toString()));
            peserta.setNamaPeserta(model.getValueAt(i, 2).toString());
            peserta.setJenisKelamin(model.getValueAt(i, 3).toString());
            peserta.setAlamat(model.getValueAt(i, 4).toString());
            peserta.setAgama(model.getValueAt(i, 5).toString());
            peserta.setAsalSekolah(model.getValueAt(i, 6).toString());

            TambahPeserta tambahPeserta = new TambahPeserta(peserta, this);
            tambahPeserta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Diubah");
        }
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int i = tPeserta.getSelectedRow();
        
        if(i>=0){
            try{
                int pilihan = JOptionPane.showConfirmDialog(
                        null,
                        "Yakin mau Hapus?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION);
                if(pilihan==0){
                    TableModel model = tPeserta.getModel();
                    Koneksi koneksi = new Koneksi();
                    Connection con = koneksi.getConnection();
                    String executeQuery = "DELETE FROM calon_siswa WHERE id_calon = ?";
                    PreparedStatement ps = con.prepareStatement(executeQuery);
                    ps.setString(1, model.getValueAt(i, 1).toString());
                    ps.executeUpdate();
                    System.out.println("Data Berhasil Dihapus");
                }
            } catch(SQLException ex) {
                System.err.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Dihapus");
        }
        
        resetTable("");
    }//GEN-LAST:event_bHapusActionPerformed

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
        // TODO add your handling code here:
        File reportFile = new File(".");
        String dirr = "";
        
        Koneksi koneksi = new Koneksi();
        Connection con = koneksi.getConnection();
        String query = "SELECT * FROM calon_siswa";
        
        
        try {
            Statement stat = con.createStatement();
            dirr = reportFile.getCanonicalPath() + "/src/form/data/";
            JasperDesign design = JRXmlLoader.load(dirr + "reportPeserta.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(design);
            ResultSet rs = stat.executeQuery(query);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), rsDataSource);
            JasperViewer.viewReport(jp);
        } catch (SQLException | IOException | JRException ex) {
            System.out.println("Gagal Mencetak Laporan Peserta : " + ex);
        }
    }//GEN-LAST:event_bCetakActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        // TODO add your handling code here:
        eCari.setText("");
        resetTable("");
    }//GEN-LAST:event_bResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.CustomGradientButton bCetak;
    private swing.CustomGradientButton bHapus;
    private swing.CustomGradientButton bReset;
    private swing.CustomGradientButton bTambah;
    private swing.CustomGradientButton bUbah;
    private swing.SearchTextField eCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private swing.Table tPeserta;
    // End of variables declaration//GEN-END:variables
}
