/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uap;

import com.mysql.cj.conf.IntegerProperty;
import com.mysql.cj.conf.StringProperty;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vidya
 */
public class PenjualanBarangController implements Initializable {
    
    PenjualanModel pm = new PenjualanModel(); 

    @FXML
    private Button btnback;
    @FXML
    private TableColumn<Penjualan, IntegerProperty> colIDP;
    @FXML
    private TableColumn<Penjualan, StringProperty> colBarcode;
    @FXML
    private TableColumn<Penjualan, IntegerProperty> colIDM;
    @FXML
    private TableColumn<Penjualan, IntegerProperty> colStok;
    @FXML
    private Button btneditdpb;
    @FXML
    private TableView<Penjualan> tbDPB;
    @FXML
    private TableView<Penjualan> tbDPM;
    @FXML
    private TableColumn<Penjualan, IntegerProperty> colIDP1;
    @FXML
    private TableColumn<Penjualan, IntegerProperty> colStok1;
    @FXML
    private Button btneditdpm;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pm = new PenjualanModel();
        showData1(); 
        showData2(); 
    }    
    
    private void showData1(){
       ObservableList<Penjualan> penjualan = pm.getPenjualan(); 
        
        colIDP.setCellValueFactory(new PropertyValueFactory<>("id_penjualan"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        colBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        tbDPB.setItems(null);
        tbDPB.setItems(penjualan);
    }
    
    private void showData2(){
        ObservableList<Penjualan> penjualan = pm.getPenjualanMakanan(); 
        
        colIDP1.setCellValueFactory(new PropertyValueFactory<>("id_penjualan"));
        colStok1.setCellValueFactory(new PropertyValueFactory<>("stok"));
        colIDM.setCellValueFactory(new PropertyValueFactory<>("id_makanan"));
        tbDPM.setItems(null);
        tbDPM.setItems(penjualan);
        
    }

    @FXML
    private void openback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Kasir PBO");
    }

    @FXML
    private void openeditdpb(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPenjualan.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btneditdpb.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Edit Data Penjualan Barang");
    }

    @FXML
    private void openeditdpm(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPenjualanMakanan.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btneditdpm.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Edit Data Penjualan Makanan");
    }
    
}
