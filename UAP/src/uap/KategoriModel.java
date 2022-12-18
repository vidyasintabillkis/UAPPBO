/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap;

import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Vidya
 */
public class KategoriModel {
    private final Connection CONN;

    public KategoriModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addKategori(Kategori kategori) throws SQLException{
        String insertKategori = "INSERT INTO tabel_kategori VALUES ('"
                 + kategori.getNama_kategori() + "');";
         
        try { 
            if (CONN.createStatement().executeUpdate(insertKategori) > 0) {
                System.out.println("Berhasil Memasukkan Data");
            } else {
                System.out.println("Gagal Memasukan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data ");
        }
    }
    
    public void deleteKategori(Kategori kategori){
        String deleteKategori = "DELETE FROM tabel_kategori WHERE nama_kategori = '" + kategori.getNama_kategori() + "';"; 
        
        try { 
            if (CONN.createStatement().executeUpdate(deleteKategori) > 0) {
                System.out.println("Berhasil Menghapus Data");
            } else {
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategoriModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data ");
        }
    }
    
    public ObservableList<Kategori> getKategori(){
        ObservableList<Kategori> kategori = FXCollections.observableArrayList();
        
        try{
            String sql = "SELECT * FROM tabel_kategori";
            ResultSet rs = CONN.createStatement().executeQuery(sql);
            while(rs.next()){
                Kategori k = new Kategori(rs.getString(1));
                kategori.add(k);
            }
           
        }catch(SQLException e){
            
        }
        return kategori;
    }
}
