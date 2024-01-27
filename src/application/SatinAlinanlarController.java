/**
 * Sample Skeleton for 'SatinAlinanlar.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SatinAlinanlarController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="colFiyati"
    private TableColumn<SATIS, Integer> colFiyati; // Value injected by FXMLLoader

    @FXML // fx:id="colSatinAlmaTarihi"
    private TableColumn<SATIS, Date> colSatinAlmaTarihi; // Value injected by FXMLLoader

    @FXML // fx:id="colSilahAdi"
    private TableColumn<SATIS, String> colSilahAdi; // Value injected by FXMLLoader

    @FXML // fx:id="tblSatinAlinanlar"
    private TableView<SATIS> tblSatinAlinanlar; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException {
    	List<SATIS> sepets = new SATIS().getSatisList();
    	colSilahAdi.setCellValueFactory(new PropertyValueFactory<>("URUN_ADI"));
    	colFiyati.setCellValueFactory(new PropertyValueFactory<>("FIYATI"));
    	colSatinAlmaTarihi.setCellValueFactory(new PropertyValueFactory<>("SATIN_ALMA_TARIHI"));
    	tblSatinAlinanlar.getItems().addAll(sepets);
    }

}
