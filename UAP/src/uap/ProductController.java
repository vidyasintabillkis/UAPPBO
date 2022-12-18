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
public class ProductController implements Initializable {

    @FXML
    private Button btnbarang;
    @FXML
    private Button btnmakanan;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openbarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnbarang.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Barang");
    }

    @FXML
    private void openmakanan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnmakanan.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Makanan");
    }

    @FXML
    private void openback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Kasir PBO");
    }
    
}
