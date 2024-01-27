/**
 * Sample Skeleton for 'Sepetim.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SepetimController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnSatinAl"
    private Button btnSatinAl; // Value injected by FXMLLoader

    @FXML // fx:id="btnSepetiBosalt"
    private Button btnSepetiBosalt; // Value injected by FXMLLoader

    @FXML // fx:id="colFiyat"
    private TableColumn<SATIS, Integer> colFiyat; // Value injected by FXMLLoader

    @FXML // fx:id="colSil"
    private TableColumn<SATIS, String> colSil; // Value injected by FXMLLoader

    @FXML // fx:id="colSira"
    private TableColumn<SATIS, String> colSiraAdi; // Value injected by FXMLLoader

    @FXML
    private TableColumn<SATIS, Integer> colSatisId;
    
    @FXML // fx:id="tblSepet"
    private TableView<SATIS> tblSepet; // Value injected by FXMLLoader

    @FXML
    void btnSatinAlOnClick(ActionEvent event) throws SQLException {
    	for (SATIS t : tblSepet.getItems()) {
    		new SATIS().SatisaEkle(t.getSATIS_ID());	
    	}
    	initialize();
    }

    @FXML
    void btnSepetiBosaltOnClick(ActionEvent event) throws SQLException {
    	new SATIS().DeleteSepetByKullaniciId(Main.GirisYapan.getKULLANICI_ID());
    	initialize();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException {
    	tblSepet.getItems().clear();
    	List<SATIS> sepets = new SATIS().getSepetList();
    	colSatisId.setCellValueFactory(new PropertyValueFactory<>("SATIS_ID"));
    	colSiraAdi.setCellValueFactory(new PropertyValueFactory<>("URUN_ADI"));
    	colFiyat.setCellValueFactory(new PropertyValueFactory<>("FIYATI"));
    	colSil.setCellValueFactory(new PropertyValueFactory<>("Button"));
    	tblSepet.getItems().addAll(sepets);

    }

}
