/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uap;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vidya
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnproduk;
    @FXML
    private Button btnpenjualan;
    @FXML
    private Button btnkategori;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openproduk(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Product.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnproduk.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Produk");
    }

    @FXML
    private void openpenjualan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanBarang.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnpenjualan.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Data Penjualan");
    }

    @FXML
    private void openkategori(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnkategori.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Kategori");

    }

    
}
