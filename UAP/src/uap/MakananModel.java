/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap;

import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Vidya
 */
public class MakananModel {
    private final Connection CONN;

    public MakananModel() {
        this.CONN = DBHelper.getConnection();
    }
    
   public void addMakanan(Makanan makanan) throws SQLException{
        String insertMakanan = "INSERT INTO tabel_makanan VALUES ('"
                 + makanan.getId_makanan() + "', '" + makanan.getDaya_tahan()
                 + "', '" + makanan.getNama_produk() + "', '" + makanan.getHarga()
                 + "', '" + makanan.getJumlah() + "', '" + makanan.getDiskon()
                 + "');";
         
        try { 
            if (CONN.createStatement().executeUpdate(insertMakanan) > 0) {
                System.out.println("Berhasil Memasukkan Data");
            } else {
                System.out.println("Gagal Memasukan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data ");
        }
    }
   
   
    public void deleteMakanan(Makanan makanan){
        String deleteMakanan = "DELETE FROM tabel_makanan WHERE id_makanan = '" + makanan.getId_makanan() + "';"; 
        
        try { 
            if (CONN.createStatement().executeUpdate(deleteMakanan) > 0) {
                System.out.println("Berhasil Menghapus Data");
            } else {
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data ");
        }
    }
    
    public ObservableList<Makanan> getMakanan(){
        ObservableList<Makanan> makanan = FXCollections.observableArrayList();
        
        try{
            String sql = "SELECT * FROM tabel_makanan";
            ResultSet rs = CONN.createStatement().executeQuery(sql);
            while(rs.next()){
                Makanan m = new Makanan(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getDouble(6));
                makanan.add(m);
            }
           
        }catch(SQLException e){
            
        }
        return makanan;
    }
   
}
