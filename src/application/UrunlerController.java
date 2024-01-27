/**
 * Sample Skeleton for 'Urunler.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UrunlerController {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="colAciklama"
    private TableColumn<URUN, String> colAciklama; // Value injected by FXMLLoader

    @FXML // fx:id="colEkle"
    private TableColumn<?, ?> colEkle; // Value injected by FXMLLoader

    @FXML // fx:id="colFiyat"
    private TableColumn<URUN, Integer> colFiyat; // Value injected by FXMLLoader

    @FXML // fx:id="colSilahAdi"
    private TableColumn<URUN, String> colSilahAdi; // Value injected by FXMLLoader

    @FXML // fx:id="colStok"
    private TableColumn<URUN, Integer> colStok; // Value injected by FXMLLoader

    @FXML // fx:id="tblUrun"
    private TableView<URUN> tblUrun; // Value injected by FXMLLoader
        
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException {

    	List<URUN> uruns = new URUN().getUrunList();
    	colSilahAdi.setCellValueFactory(new PropertyValueFactory<>("UrunAdi"));
    	colAciklama.setCellValueFactory(new PropertyValueFactory<>("UrunAciklama"));
    	colFiyat.setCellValueFactory(new PropertyValueFactory<>("Fiyati"));
    	colStok.setCellValueFactory(new PropertyValueFactory<>("StokMiktari"));
    	colEkle.setCellValueFactory(new PropertyValueFactory<>("Button"));
    	tblUrun.getItems().addAll(uruns);
    }
}

