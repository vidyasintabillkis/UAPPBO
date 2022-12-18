/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uap;

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
public class KategoriController implements Initializable {
    
    KategoriModel km = new KategoriModel(); 

    @FXML
    private Button btntambah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnback;
    @FXML
    private TableView<Kategori> tbKategori;
    @FXML
    private TableColumn<Kategori, StringProperty> colNK;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        km = new KategoriModel(); 
        showData(); 
    }
    
    private void showData(){
        ObservableList<Kategori> kategori = km.getKategori(); 
        
        colNK.setCellValueFactory(new PropertyValueFactory<>("nama_kategori"));
        tbKategori.setItems(null);
        tbKategori.setItems(kategori); 
    }

    @FXML
    private void opentambah(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TambahKategori.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btntambah.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Tambah Kategori");
    }

    @FXML
    private void openhapus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HapusKategori.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnhapus.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Hapus Kategori");
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
