/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uap;

import static com.sun.deploy.config.JREInfo.clear;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vidya
 */
public class EditBarangController_1 implements Initializable {
    
    BarangModel bm = new BarangModel();
    
    @FXML
    private Button btntambah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnback;
    @FXML
    private TextField fieldharga;
    @FXML
    private TextField fieldjumlah;
    @FXML
    private TextField fieldbarcode;
    @FXML
    private TextField fieldex;
    @FXML
    private TextField fieldkategori;
    @FXML
    private TextField fieldnama;
    @FXML
    private TextField fielddiskon;
    @FXML
    private Label lblinformation1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendData(ActionEvent event) throws SQLException {
        double harga = Double.parseDouble(fieldharga.getText());
        int jumlah = Integer.parseInt(fieldjumlah.getText());
        double diskon=Double.parseDouble(fielddiskon.getText()); 
        Barang b = new Barang(fieldbarcode.getText(), fieldex.getText(), fieldkategori.getText(), fieldnama.getText(), harga, jumlah, diskon);
        bm.addBarang(b);        
       
        clear(); 
    }

    @FXML
    private void deleteData(ActionEvent event) {
        double harga = Double.parseDouble(fieldharga.getText());
        int jumlah = Integer.parseInt(fieldjumlah.getText());
        double diskon=Double.parseDouble(fielddiskon.getText()); 
        Barang b = new Barang(fieldbarcode.getText(), fieldex.getText(), fieldkategori.getText(), fieldnama.getText(), harga, jumlah, diskon);
        bm.deleteBarang(b);
       
        clear(); 
    }

    @FXML
    private void openback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Barang");
    }
    
    void clear(){
    fieldbarcode.clear();
    fieldex.clear();
    fieldkategori.clear();
    fieldnama.clear();
    fieldharga.clear();
    fieldjumlah.clear();
    fielddiskon.clear();  
  }

}
