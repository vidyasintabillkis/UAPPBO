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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vidya
 */
public class EditPenjualanMakananController implements Initializable {
    
    PenjualanModel pm = new PenjualanModel(); 

    @FXML
    private Button btntambah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnback1;
    @FXML
    private TextField fieldstok;
    @FXML
    private TextField fieldIDM;
    @FXML
    private TextField fieldIDP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    void clear(){
        fieldIDP.clear();
        fieldIDM.clear();
        fieldstok.clear();
    }

    @FXML
    private void sendData(ActionEvent event) throws SQLException {
        int idp = Integer.parseInt(fieldIDP.getText());
        int stok = Integer.parseInt(fieldstok.getText());
        int idm = Integer.parseInt(fieldIDM.getText());
        
        Penjualan p = new Penjualan(idp, stok,idm);
        pm.addPenjualanMakanan(p);
        clear(); 
    }

    @FXML
    private void deleteData(ActionEvent event) {
        int idp = Integer.parseInt(fieldIDP.getText());
        int stok = Integer.parseInt(fieldstok.getText());
        int idm = Integer.parseInt(fieldIDM.getText());
        
        Penjualan p = new Penjualan(idp, stok,idm);
        pm.deletePenjualanMakanan(p);
        clear(); 
        
    }

    @FXML
    private void openback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanBarang.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnback1.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Data Penjualan");
        
    }
    
}
