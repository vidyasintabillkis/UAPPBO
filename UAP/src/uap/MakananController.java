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
public class MakananController implements Initializable {
    MakananModel mm;

    @FXML
    private Button btnback;
    @FXML
    private Button btnedit;
    @FXML
    private TableColumn<Makanan, IntegerProperty> colID;
    @FXML
    private TableColumn<Makanan, IntegerProperty> colDT;
    @FXML
    private TableColumn<Makanan, StringProperty> colNama;
    @FXML
    private TableColumn<Makanan, DoubleProperty> colHarga;
    @FXML
    private TableColumn<Makanan, IntegerProperty> colJumlah;
    @FXML
    private TableColumn<Makanan, StringProperty> colDiskon;
    @FXML
    private TableView<Makanan> tbMakanan;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mm = new MakananModel(); 
        showData(); 
    }  
    
    private void showData(){
        ObservableList<Makanan> makanan = mm.getMakanan(); 
        
        colID.setCellValueFactory(new PropertyValueFactory<>("id_makanan"));
        colDT.setCellValueFactory(new PropertyValueFactory<>("daya_tahan"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colDiskon.setCellValueFactory(new PropertyValueFactory<>("diskon"));
        tbMakanan.setItems(null);
        tbMakanan.setItems(makanan);  
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditMakanan.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnedit.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Tambah Makanan");
    }
    
}
