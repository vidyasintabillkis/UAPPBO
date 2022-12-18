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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vidya
 */
public class HapusKategoriController implements Initializable {

    @FXML
    private Button btnback;
    @FXML
    private TextField fieldkategori;
    @FXML
    private Button btndelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Kategori");
    }

    @FXML
    private void deleteData(ActionEvent event) {
        KategoriModel km = new KategoriModel(); 
        Kategori k = new Kategori(fieldkategori.getText()); 
        
        km.deleteKategori(k);
        fieldkategori.clear();
    }
    
}
