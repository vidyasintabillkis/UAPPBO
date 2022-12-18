/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uap;

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
public class EditMakananController implements Initializable {
    
    MakananModel mm = new MakananModel(); 

    @FXML
    private Button btntambah;
    @FXML
    private Button btnback;
    @FXML
    private TextField fieldjumlah;
    @FXML
    private TextField fielddiskon;
    @FXML
    private TextField fieldid;
    @FXML
    private TextField fielddt;
    @FXML
    private TextField fieldnama;
    @FXML
    private TextField fieldharga;
    @FXML
    private Label lblinformation;
    @FXML
    private Button btnhapus;

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
        int id = Integer.parseInt(fieldid.getText());
        int dt = Integer.parseInt(fielddt.getText());
        
        Makanan m = new Makanan(id, dt, fieldnama.getText(), harga, jumlah, diskon);
        mm.addMakanan(m);
        clear(); 
    }
    
    @FXML
    private void deleteData(ActionEvent event) throws IOException {
        double harga = Double.parseDouble(fieldharga.getText());
        int jumlah = Integer.parseInt(fieldjumlah.getText());
        double diskon=Double.parseDouble(fielddiskon.getText()); 
        int id = Integer.parseInt(fieldid.getText());
        int dt = Integer.parseInt(fielddt.getText());
        
        Makanan m = new Makanan(id, dt, fieldnama.getText(), harga, jumlah, diskon);
        mm.deleteMakanan(m);
        clear(); 
    }
    
    @FXML
    private void openback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Makanan");
    }
    
    void clear(){
        fieldid.clear();
        fielddt.clear();
        fieldnama.clear();
        fieldharga.clear();
        fieldjumlah.clear();
        fielddiskon.clear();
    }

    
    
}
