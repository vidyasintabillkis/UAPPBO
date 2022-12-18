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
public class PenjualanModel {
    private final Connection CONN;

    public PenjualanModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addPenjualan(Penjualan penjualan) throws SQLException{
        String insertPenjualan = "INSERT INTO tabel_penjualan VALUES ('"
                 + penjualan.getId_penjualan() + "', '" + penjualan.getStok()
                 + "', '" + penjualan.getBarcode() + "');";
         
        try { 
            if (CONN.createStatement().executeUpdate(insertPenjualan) > 0) {
                System.out.println("Berhasil Memasukkan Data");
            } else {
                System.out.println("Gagal Memasukan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data ");
        }
    }
    
    public void addPenjualanMakanan(Penjualan penjualan) throws SQLException{
        String insertPenjualanMakanan = "INSERT INTO tabel_penjualanmakanan VALUES ('"
                 + penjualan.getId_penjualan() + "', '" + penjualan.getStok()
                 + "', '" + penjualan.getId_makanan() + "');";
         
        try { 
            if (CONN.createStatement().executeUpdate(insertPenjualanMakanan) > 0) {
                System.out.println("Berhasil Memasukkan Data");
            } else {
                System.out.println("Gagal Memasukan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data ");
        }
    }
    
    public void deletePenjualan(Penjualan penjualan){
        String deletePenjualan = "DELETE FROM tabel_penjualan WHERE id_penjualan = '" + penjualan.getId_penjualan() + "';"; 
        
        try { 
            if (CONN.createStatement().executeUpdate(deletePenjualan) > 0) {
                System.out.println("Berhasil Menghapus Data");
            } else {
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data ");
        }
    }
    
    public void deletePenjualanMakanan(Penjualan penjualan){
        String deletePenjualan = "DELETE FROM tabel_penjualanmakanan WHERE id_penjualan = '" + penjualan.getId_penjualan() + "';"; 
        
        try { 
            if (CONN.createStatement().executeUpdate(deletePenjualan) > 0) {
                System.out.println("Berhasil Menghapus Data");
            } else {
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data ");
        }
    }
    
    public ObservableList<Penjualan> getPenjualan(){
        ObservableList<Penjualan> penjualan = FXCollections.observableArrayList();
        
        try{
            String sql = "SELECT * FROM tabel_penjualan";
            ResultSet rs = CONN.createStatement().executeQuery(sql);
            while(rs.next()){
                Penjualan p = new Penjualan(rs.getInt(1), rs.getInt(2), rs.getString(3));
                penjualan.add(p);
            }
           
        }catch(SQLException e){
            
        }
        return penjualan;
    }
    
    public ObservableList<Penjualan> getPenjualanMakanan(){
        ObservableList<Penjualan> penjualan = FXCollections.observableArrayList();
        
        try{
            String sql = "SELECT * FROM tabel_penjualanmakanan";
            ResultSet rs = CONN.createStatement().executeQuery(sql);
            while(rs.next()){
                Penjualan p = new Penjualan(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                penjualan.add(p);
            }
           
        }catch(SQLException e){
            
        }
        return penjualan;
    }
}
