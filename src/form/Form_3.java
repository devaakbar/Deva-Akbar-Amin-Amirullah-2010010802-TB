package form;

import component.OpsiSearch;
import model.Pendaftaran;
import db.Koneksi;
import event.EventOpsiSearch;
import frame.TambahPendaftaran;
import java.util.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Peserta;
import model.Sekolah;

public class Form_3 extends javax.swing.JPanel {

    Pendaftaran pendaftaran;
    
    public Form_3() {
        initComponents();
        tPendaftaran.fixTable(jScrollPane1);
        resetTable("");
        
        // Menampilkan Search Hint pada SearchField
        eCari.addEventOptionSelected(new EventOpsiSearch() {
            @Override
            public void optionSelected(OpsiSearch option, int index) {
                eCari.setHint("Cari Berdasarkan " + option.getName() + "...");
            }
        });
        
        // Menambahkan Icon pada SearchField
        eCari.addOption(new OpsiSearch("ID Pendaftaran", new ImageIcon(getClass().getResource("/icon/id.png"))));
        eCari.addOption(new OpsiSearch("ID Peserta", new ImageIcon(getClass().getResource("/icon/user_id.png"))));
        eCari.addOption(new OpsiSearch("Nama Peserta", new ImageIcon(getClass().getResource("/icon/user.png"))));
        eCari.addOption(new OpsiSearch("ID Sekolah", new ImageIcon(getClass().getResource("/icon/school_id.png"))));
        eCari.addOption(new OpsiSearch("Nama Sekolah", new ImageIcon(getClass().getResource("/icon/school.png"))));
        eCari.addOption(new OpsiSearch("Status", new ImageIcon(getClass().getResource("/icon/status.png"))));
        loadData("");
    }
    
    // Method untuk Menampilkan Data yang Dicari
     private void loadData(String where, Object... search){
        try{
            DefaultTableModel model = (DefaultTableModel)tPendaftaran.getModel();
            model.setRowCount(0);
            PreparedStatement ps = Koneksi.getInstance().openConnection().prepareStatement("SELECT pendaftaran.*, calon_siswa.*, sekolah_pilihan.* FROM ((pendaftaran " 
                    + "INNER JOIN calon_siswa ON pendaftaran.id_siswa = calon_siswa.id_calon) " 
                    + "INNER JOIN sekolah_pilihan ON pendaftaran.id_sekolah = sekolah_pilihan.id_sekolah) "
                    + where);
            for (int i = 0; i < search.length; i++) {
                ps.setObject(i+1, search[i]);
               
            }
            ResultSet rs = ps.executeQuery();
            
            int tempNo = 1;
            while(rs.next()){
                int no = tempNo;
                String idPendaftaran = rs.getString("id_pendaftaran");
                String idPeserta = rs.getString("id_siswa");
                String namaPeserta = rs.getString("calon_siswa.nama_calon_siswa");
                String idSekolah =  rs.getString("id_sekolah");
                String namaSekolah = rs.getString("sekolah_pilihan.nama_sekolah");
                String status = rs.getString("status_pendaftaran");
                model.addRow(new Object[]{no, idPendaftaran, idPeserta, namaPeserta, idSekolah, namaSekolah, status});
                tempNo++;
            }
            rs.close();
            ps.close();
        } catch (Exception e){
            System.out.println("Koneksi Gagal pada Form_3 method loadData()");
        }
    }

    public ArrayList<Pendaftaran> getPendaftaranList(String keyword){
        ArrayList<Pendaftaran> pendaftaranList = new ArrayList<Pendaftaran>();
        Koneksi koneksi = new Koneksi();
        Connection connection = koneksi.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT pendaftaran.*, calon_siswa.*, sekolah_pilihan.* FROM ((pendaftaran "
                    + "INNER JOIN calon_siswa ON pendaftaran.id_siswa = calon_siswa.id_calon) "
                    + "INNER JOIN sekolah_pilihan ON pendaftaran.id_sekolah = sekolah_pilihan.id_sekolah)";
        String order = " ORDER BY pendaftaran.id_pendaftaran";
        
        query = query + order;
        
        try {
            ps = connection.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                pendaftaran = new Pendaftaran(
                        rs.getInt("id_pendaftaran"),
                        rs.getInt("id_siswa"),
                        rs.getString("calon_siswa.nama_calon_siswa"),
                        rs.getInt("id_sekolah"),
                        rs.getString("sekolah_pilihan.nama_sekolah"),
                        rs.getString("status_pendaftaran"));
                pendaftaranList.add(pendaftaran);
            }
        } catch (SQLException ex){
            System.err.println("ERROR getAnggotaList : " + ex);
        }
        
        return pendaftaranList;
    }
    
    
    public void selectPendaftaran(String keyword){
        ArrayList<Pendaftaran> list = getPendaftaranList(keyword);
        DefaultTableModel model = (DefaultTableModel)tPendaftaran.getModel();
        Object[] row = new Object[7];
        
        int tempNo = 1;
        for (int i = 0; i < list.size(); i++) {
            row[0] = tempNo;
            row[1] = list.get(i).getIdDaftar();
            row[2] = list.get(i).getIdSiswa();
            row[3] = list.get(i).getPeserta().getNamaPeserta();
            row[4] = list.get(i).getIdSekolah();
            row[5] = list.get(i).getSekolah().getNamaSekolah();
            row[6] = list.get(i).getStatus();
            
            model.addRow(row);
            
            tempNo++;
        }
    }
    
    public final void resetTable(String keyword){
        DefaultTableModel model = (DefaultTableModel)tPendaftaran.getModel();
        model.setRowCount(0);
        selectPendaftaran(keyword);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tPendaftaran = new swing.Table();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        eCari = new swing.SearchTextField();
        bTambah = new swing.CustomGradientButton();
        bUbah = new swing.CustomGradientButton();
        bHapus = new swing.CustomGradientButton();
        bReset = new swing.CustomGradientButton();

        setBackground(new java.awt.Color(247, 188, 223));

        tPendaftaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor", "ID Pendaftaran", "ID Peserta", "Nama Peserta", "ID Sekolah", "Nama Sekolah", "Status"
            }
        ));
        jScrollPane1.setViewportView(tPendaftaran);
        if (tPendaftaran.getColumnModel().getColumnCount() > 0) {
            tPendaftaran.getColumnModel().getColumn(0).setMaxWidth(50);
            tPendaftaran.getColumnModel().getColumn(2).setMaxWidth(100);
            tPendaftaran.getColumnModel().getColumn(4).setMaxWidth(100);
            tPendaftaran.getColumnModel().getColumn(6).setMaxWidth(125);
        }

        panelBorder1.setBackground(new java.awt.Color(0, 0, 0));
        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data PPDB Tahun 2023");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eCariKeyReleased
        // TODO add your handling code here:
        if(eCari.isSelected()){
            int option = eCari.getSelectedIndex();
            String text = "%" + eCari.getText().trim()+"%";
            
            if(option == 0){
                loadData("WHERE id_pendaftaran LIKE ?", text);
            }else if(option == 1){
                loadData("WHERE id_siswa LIKE ?", text);
            }else if(option == 2){
                loadData("WHERE calon_siswa.nama_calon_siswa LIKE ?", text);
            }else if(option == 3){
                loadData("WHERE pendaftaran.id_sekolah LIKE ?", text);
            }else if(option == 4){
                loadData("WHERE sekolah_pilihan.nama_sekolah LIKE ?", text);
            }else if(option == 5){
                loadData("WHERE status_pendaftaran LIKE ?", text);
            }
        }
    }//GEN-LAST:event_eCariKeyReleased

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        TambahPendaftaran tambahPendaftaran = new TambahPendaftaran(this);
        tambahPendaftaran.setVisible(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        int i = tPendaftaran.getSelectedRow();
        if(i>=0){
            TableModel model = tPendaftaran.getModel();
            pendaftaran = new Pendaftaran();
            pendaftaran.setIdDaftar(Integer.parseInt(model.getValueAt(i, 1).toString()));
            pendaftaran.setPeserta(new Peserta
                    (Integer.parseInt(model.getValueAt(i,2).toString()),
                    model.getValueAt(i, 3).toString()));
            pendaftaran.setSekolah(new Sekolah
                    (Integer.parseInt(model.getValueAt(i,4).toString()),
                    model.getValueAt(i, 5).toString()));
            pendaftaran.setStatus(model.getValueAt(i, 6).toString());
            
            TambahPendaftaran tambahPendaftaran = new TambahPendaftaran(pendaftaran, this);
            tambahPendaftaran.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Diubah");
        }
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int i = tPendaftaran.getSelectedRow();
        
        if(i>=0){
            try{
                int pilihan = JOptionPane.showConfirmDialog(
                    null,
                    "Yakin mau Hapus?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION);
                if(pilihan==0){
                    TableModel model = tPendaftaran.getModel();
                    Koneksi koneksi = new Koneksi();
                    Connection con = koneksi.getConnection();
                    String executeQuery = "DELETE FROM pendaftaran WHERE id_pendaftaran = ?";
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

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        // TODO add your handling code here:
        eCari.setText("");
        resetTable("");
    }//GEN-LAST:event_bResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.CustomGradientButton bHapus;
    private swing.CustomGradientButton bReset;
    private swing.CustomGradientButton bTambah;
    private swing.CustomGradientButton bUbah;
    private swing.SearchTextField eCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private swing.Table tPendaftaran;
    // End of variables declaration//GEN-END:variables
}
