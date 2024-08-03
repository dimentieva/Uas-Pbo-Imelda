/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package toko;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class penjualan extends javax.swing.JFrame {
    String Tanggal;
    private DefaultTableModel model;
     public void totalBiaya(){
        int jumlahBaris = tabel1.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(tabel1.getValueAt(i, 3).toString());
            hargaBarang = Integer.parseInt(tabel1.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        ttlbayar.setText(String.valueOf(totalBiaya));
        tampil.setText("Rp "+ totalBiaya +",00");
    }

    private void autonumber(){
        try {
            koneksi c = new koneksi();
            Connection con = c.getKoneksi();
            Statement s = con.createStatement();
            String sql = "SELECT * FROM penjualan ORDER BY nofak DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("nofak").substring(2);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                notransaksi.setText("TR" + Nol + TR);
            } else {
                notransaksi.setText("TR0001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error"+ e.getMessage());
        }
    }
    
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) tabel1.getModel();
        model.addRow(new Object[]{
            notransaksi.getText(),
            idbrg.getText(),
            namabrg.getText(),
            jumlah.getText(),
            harga.getText(),
            ttlbayar.getText()
        });
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) tabel1.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void utama(){
        notransaksi.setText("");
        idbrg.setText("");
        namabrg.setText("");
        harga.setText("");
        jumlah.setText("");
        autonumber();
    }
    
    public void clear(){
        ttlbayar.setText("0");
        bayar.setText("0");
        kembalian.setText("0");
        tampil.setText("0");
    }
    
    public void clear2(){
        idbrg.setText("");
        namabrg.setText("");
        harga.setText("");
        jumlah.setText("");
    }
    
    public void tambahTransaksi() {
    int jumlahh, hargaa, total;
    String idBarang = idbrg.getText();

    jumlahh = Integer.valueOf(jumlah.getText());
    hargaa = Integer.valueOf(harga.getText());
    total = jumlahh * hargaa;

    try {
        Connection c = koneksi.getKoneksi();
        String sql = "SELECT Stok FROM barang WHERE id_brg = ?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, idBarang);
        ResultSet rs = p.executeQuery();

        if (rs.next()) {
            int stok = rs.getInt("Stok");
            if (stok >= jumlahh) {
                ttlbayar.setText(String.valueOf(total));
                loadData();
                totalBiaya();
                clear2();
                idbrg.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Stok barang tidak mencukupi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Barang tidak ditemukan");
        }
        rs.close();
        p.close();
    } catch (Exception e) {
        System.out.println("Pengecekan stok error: " + e.getMessage());
    }
}
    /**
     * Creates new form penjualan
     */
    public penjualan() {
        initComponents();
         model = new DefaultTableModel();
        
        tabel1.setModel(model);
        
        model.addColumn("No Transaksi");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");
        
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        
        tanggal.setText(s.format(date));
        ttlbayar.setText("0");
        bayar.setText("0");
        kembalian.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        notransaksi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idbrg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        namabrg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        btambah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        ttlbayar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        tampil = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setText("No Transaksi");

        notransaksi.setEnabled(false);
        notransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notransaksiActionPerformed(evt);
            }
        });

        jLabel4.setText("Tanggal");

        tanggal.setEnabled(false);
        tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalActionPerformed(evt);
            }
        });

        jLabel6.setText("ID barang");

        idbrg.setEnabled(false);
        idbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idbrgActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Barang");

        namabrg.setEnabled(false);

        jLabel8.setText("Harga");

        harga.setEnabled(false);

        jLabel9.setText("Jumlah");

        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel1);

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Bayar");

        ttlbayar.setEnabled(false);

        jLabel11.setText("Bayar");

        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        jLabel12.setText("Kembalian");

        kembalian.setEnabled(false);
        kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalianActionPerformed(evt);
            }
        });

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tampil.setBackground(new java.awt.Color(255, 153, 153));
        tampil.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tampil.setText("Rp. 0");
        tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(notransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(60, 60, 60)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namabrg)
                            .addComponent(idbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btambah)
                                    .addComponent(bhapus)
                                    .addComponent(jButton1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tampil, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(simpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ttlbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(20, 20, 20)
                                .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(notransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(namabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btambah)
                        .addGap(18, 18, 18)
                        .addComponent(bhapus)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ttlbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void notransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notransaksiActionPerformed

    private void kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
          tambahTransaksi();
    }//GEN-LAST:event_jumlahActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabel1.getModel();
        int row = tabel1.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        bayar.setText("0");
        kembalian.setText("0");
    }//GEN-LAST:event_bhapusActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
        int total, bayyar, kembaliann;
        
        total = Integer.valueOf(ttlbayar.getText());
        bayyar = Integer.valueOf(bayar.getText());
        
        if (total > bayyar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembaliann = bayyar - total;
            kembalian.setText(String.valueOf(kembaliann));
        }
    }//GEN-LAST:event_bayarActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
      DefaultTableModel model = (DefaultTableModel) tabel1.getModel();
        
        String noTransaksi = notransaksi.getText();
        String tanggall = tanggal.getText();
        String total = ttlbayar.getText();
        
        try {
            koneksi c = new koneksi();
            Connection con = c.getKoneksi();
            Statement s = con.createStatement();
            String sql = "INSERT INTO penjualan VALUES (?, ?, ?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, noTransaksi);
            p.setString(2, tanggall);
            p.setString(3, total);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            System.out.println("simpan penjualan error"+ e.getMessage());
        }
        
        try {
            koneksi c = new koneksi();
            Connection con = c.getKoneksi();
            Statement s = con.createStatement();
            int baris = tabel1.getRowCount();
            
            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO detailpenjualan(nofaktur, idbarang, namabrg, jumlah, harga, total) VALUES('"
                        + tabel1.getValueAt(i, 0) +"','"+ tabel1.getValueAt(i, 1) +"','"+ tabel1.getValueAt(i, 2) 
                        +"','"+ tabel1.getValueAt(i, 3) +"','"+ tabel1.getValueAt(i, 4) +"','"+ tabel1.getValueAt(i, 5) 
                        +"')";
                PreparedStatement p = con.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            System.out.println("simpan detailpenjualan error"+ e.getMessage());
        }
        try {
            Connection c = koneksi.getKoneksi();
            int baris = tabel1.getRowCount();

            for (int i = 0; i < baris; i++) {
                String idBarang = (String) tabel1.getValueAt(i, 1);
                int jumlah = Integer.parseInt(tabel1.getValueAt(i, 3).toString());
                // Update stok barang
                String sqlUpdateStok = "UPDATE barang SET Stok = Stok - ? WHERE id_brg = ?";
                PreparedStatement pUpdateStok = c.prepareStatement(sqlUpdateStok);
                pUpdateStok.setInt(1, jumlah);
                pUpdateStok.setString(2, idBarang);
                pUpdateStok.executeUpdate();
                pUpdateStok.close();
            }
        } catch (Exception e) {
            System.out.println("Update stok error: "+ e.getMessage());
    }
        clear();
        utama();
        autonumber();
        kosong();
        tampil.setText("Rp. 0");
    }//GEN-LAST:event_simpanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ListBarang a = new ListBarang();
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idbrgActionPerformed

    private void tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalActionPerformed

    private void tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tampilActionPerformed

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
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton btambah;
    public static javax.swing.JTextField harga;
    public static javax.swing.JTextField idbrg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kembalian;
    public static javax.swing.JTextField namabrg;
    private javax.swing.JTextField notransaksi;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel1;
    private javax.swing.JTextField tampil;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField ttlbayar;
    // End of variables declaration//GEN-END:variables
}
