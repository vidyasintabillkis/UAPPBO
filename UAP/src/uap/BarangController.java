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
import javafx.beans.property.DoubleProperty;
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
public class BarangController implements Initializable {
    BarangModel bm = new BarangModel(); 

    @FXML
    private Button btnback;
    @FXML
    private Button btnedit;
    @FXML
    private TableView<Barang> TbBarang;
    @FXML
    private TableColumn<Barang, StringProperty> colB;
    @FXML
    private TableColumn<Barang, StringProperty> colE;
    @FXML
    private TableColumn<Barang, StringProperty> colK;
    @FXML
    private TableColumn<Barang, StringProperty> colN;
    @FXML
    private TableColumn<Barang, DoubleProperty> colH;
    @FXML
    private TableColumn<Barang, IntegerProperty> colJ;
    @FXML
    private TableColumn<Barang, DoubleProperty> colD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bm = new BarangModel(); 
        showData(); 
    } 
    
    public void showData(){
        ObservableList<Barang> barang = bm.getBarang(); 
        
        colB.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        colE.setCellValueFactory(new PropertyValueFactory<>("expired"));
        colK.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        colN.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        colH.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colJ.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colD.setCellValueFactory(new PropertyValueFactory<>("diskon"));
        TbBarang.setItems(null);
        TbBarang.setItems(barang);
        
    }


    @FXML
    private void openback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Product.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Produk");
    }

    @FXML
    private void openedit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editBarang.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnedit.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Edit Barang");
    }
    
}
