/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uap;

/**
 *
 * @author Vidya
 */
public class Penjualan implements ProductCounter{
    int id_penjualan; 
    private int stok;
    String barcode; 
    int id_makanan; 

    public Penjualan(int id_penjualan, int stok, String barcode) {
        this.id_penjualan = id_penjualan;
        this.stok = stok;
        this.barcode = barcode;
    }

    public Penjualan(int id_penjualan, int stok, int id_makanan) {
        this.id_penjualan = id_penjualan;
        this.stok = stok;
        this.id_makanan = id_makanan;
    }
    

    public int getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(int id_penjualan) {
        this.id_penjualan = id_penjualan;
    }
    
    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getId_makanan() {
        return id_makanan;
    }

    public void setId_makanan(int id_makanan) {
        this.id_makanan = id_makanan;
    }

    
    
    @Override
    public int hitungJumlahProduk() {
        return 0; 
    }

    @Override
    public double hitungHargaProduk() {
        return 0; 
    }
}
