package form;

import component.OpsiSearch;
import db.Koneksi;
import event.EventOpsiSearch;
import frame.TambahSekolah;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Sekolah;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Form_2 extends javax.swing.JPanel {

    Sekolah sekolah;
    
    public Form_2() {
        initComponents();
        tSekolah.fixTable(jScrollPane1);
        
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
        
        eCari.addOption(new OpsiSearch("ID Sekolah", new ImageIcon(getClass().getResource("/icon/id.png"))));
        eCari.addOption(new OpsiSearch("Nama Sekolah", new ImageIcon(getClass().getResource("/icon/school.png"))));
        eCari.addOption(new OpsiSearch("Alamat", new ImageIcon(getClass().getResource("/icon/address.png"))));
        eCari.addOption(new OpsiSearch("Akreditasi", new ImageIcon(getClass().getResource("/icon/akreditasi.png"))));
        loadData("");
    }

    // Method untuk Menampilkan Data yang Dicari
    private void loadData(String where, Object... search){
        try{
            DefaultTableModel model = (DefaultTableModel)tSekolah.getModel();
            model.setRowCount(0);
            PreparedStatement ps = Koneksi.getInstance().openConnection().prepareStatement("SELECT * FROM sekolah_pilihan " + where);
            for (int i = 0; i < search.length; i++) {
                ps.setObject(i+1, search[i]);
               
            }
            ResultSet rs = ps.executeQuery();
            
            int tempNo = 1;
            while(rs.next()){
                int no = tempNo;
                int id = rs.getInt("id_sekolah");
                String nama = rs.getString("nama_sekolah");
                String alamat = rs.getString("alamat_sekolah");
                String akreditasi = rs.getString("akreditasi_sekolah");
                model.addRow(new Object[]{no, id, nama, alamat, akreditasi});
                tempNo++;
            }
            rs.close();
            ps.close();
        } catch (Exception e){
            System.out.println("Koneksi Gagal pada Form_2 method loadData()");
        }
    }
    
    // Method untuk Mendapatkan Data (Record) dari tabel sekolah_pilihan
    public ArrayList<Sekolah> getSekolahList(String keyword){
        ArrayList<Sekolah> sekolahList = new ArrayList<Sekolah>();
        Koneksi koneksi = new Koneksi();
        Connection connection =koneksi.getConnection();
        
        String query = "SELECT * FROM sekolah_pilihan " + keyword;
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                sekolah = new Sekolah(
                        rs.getInt("id_sekolah"),
                        rs.getString("nama_sekolah"),
                        rs.getString("alamat_sekolah"),
                        rs.getString("akreditasi_sekolah"));
                sekolahList.add(sekolah);
            }
        } catch(SQLException | NullPointerException ex) {
            System.err.println("Koneksi Null Gagal");
        }
        return sekolahList;
    }
    
    // Method untuk menampilkan Data sekolah_pilihan ke Tabel yang ada di Program
    public void selectSekolah(String keyword){
       ArrayList<Sekolah> list = getSekolahList(keyword);
       DefaultTableModel model = (DefaultTableModel)tSekolah.getModel();
       Object[] row = new Object[9];

       int tempNo = 1;
       for (int i = 0; i < list.size(); i++) {
           row[0] = tempNo;
           row[1] = list.get(i).getIdSekolah();
           row[2] = list.get(i).getNamaSekolah();
           row[3] = list.get(i).getAlamatSekolah();
           row[4] = list.get(i).getAkreditasi();

           model.addRow(row);
           tempNo++;
       }
    }
    
    
    // Method untuk Reset Table
    public final void resetTable(String keyword){
        DefaultTableModel model = (DefaultTableModel)tSekolah.getModel();
        model.setRowCount(0);
        selectSekolah(keyword);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tSekolah = new swing.Table();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        eCari = new swing.SearchTextField();
        bTambah = new swing.CustomGradientButton();
        bUbah = new swing.CustomGradientButton();
        bHapus = new swing.CustomGradientButton();
        bCetak = new swing.CustomGradientButton();
        bReset = new swing.CustomGradientButton();

        setBackground(new java.awt.Color(247, 188, 223));

        tSekolah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor", "ID Sekolah", "Nama Sekolah", "Alamat", "Akreditasi"
            }
        ));
        jScrollPane1.setViewportView(tSekolah);
        if (tSekolah.getColumnModel().getColumnCount() > 0) {
            tSekolah.getColumnModel().getColumn(0).setMaxWidth(75);
            tSekolah.getColumnModel().getColumn(1).setMaxWidth(125);
            tSekolah.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        panelBorder1.setBackground(new java.awt.Color(0, 0, 0));
        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data SMA Tahun 2023");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eCariKeyReleased
        // TODO add your handling code here:
        if(eCari.isSelected()){
            int option = eCari.getSelectedIndex();
            String text = "%" + eCari.getText().trim()+"%";
            
            if(option == 0){
                loadData("WHERE id_sekolah LIKE ?", text);
            }else if(option == 1){
                loadData("WHERE nama_sekolah LIKE ?", text);
            }else if(option == 2){
                loadData("WHERE alamat_sekolah LIKE ?", text);
            }else if(option == 3){
                loadData("WHERE akreditasi_sekolah LIKE ?", text);
            }
        }
    }//GEN-LAST:event_eCariKeyReleased

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        TambahSekolah tambahSekolah = new TambahSekolah(this);
        tambahSekolah.setVisible(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        int i = tSekolah.getSelectedRow();
        if(i>=0){
            TableModel model = tSekolah.getModel();
            sekolah = new Sekolah();
            sekolah.setIdSekolah(Integer.parseInt(model.getValueAt(i, 1).toString()));
            sekolah.setNamaSekolah(model.getValueAt(i, 2).toString());
            sekolah.setAlamatSekolah(model.getValueAt(i, 3).toString());
            sekolah.setAkreditasi(model.getValueAt(i, 4).toString());
            
            TambahSekolah tambahSekolah = new TambahSekolah(sekolah, this);
            tambahSekolah.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Diubah");
        }
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int i = tSekolah.getSelectedRow();
        
        if(i>=0){
            try{
                int pilihan = JOptionPane.showConfirmDialog(
                    null,
                    "Yakin mau Hapus?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION);
                if(pilihan==0){
                    TableModel model = tSekolah.getModel();
                    Koneksi koneksi = new Koneksi();
                    Connection con = koneksi.getConnection();
                    String executeQuery = "DELETE FROM sekolah_pilihan WHERE id_sekolah = ?";
                    PreparedStatement ps = con.prepareStatement(executeQuery);
                    ps.setString(1, model.getValueAt(i, 1).toString()); //getValueAt(IndexRow, IndexColumn)
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
        String query = "SELECT * FROM sekolah_pilihan";

        try {
            Statement stat = con.createStatement();
            dirr = reportFile.getCanonicalPath() + "/src/form/data/";
            JasperDesign design = JRXmlLoader.load(dirr + "reportSekolah.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(design);
            ResultSet rs = stat.executeQuery(query);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), rsDataSource);
            JasperViewer.viewReport(jp);
        } catch (SQLException | IOException | JRException ex) {
            System.out.println("Gagal Mencetak Laporan Sekolah : " + ex);
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
    private swing.Table tSekolah;
    // End of variables declaration//GEN-END:variables
}
