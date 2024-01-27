/**
 * Sample Skeleton for 'Admin.fxml' Controller Class
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnEkle"
    private Button btnEkle; // Value injected by FXMLLoader

    @FXML // fx:id="btnGuncelle"
    private Button btnGuncelle; // Value injected by FXMLLoader

    @FXML // fx:id="btnSeciliSil"
    private Button btnSeciliSil; // Value injected by FXMLLoader

    @FXML // fx:id="colAciklama"
    private TableColumn<URUN, String> colAciklama; // Value injected by FXMLLoader

    @FXML // fx:id="colFiyat"
    private TableColumn<URUN, Integer> colFiyat; // Value injected by FXMLLoader

    @FXML // fx:id="colSilahAdi"
    private TableColumn<URUN, String> colSilahAdi; // Value injected by FXMLLoader

    @FXML // fx:id="colStok"
    private TableColumn<URUN, Integer> colStok; // Value injected by FXMLLoader

    @FXML // fx:id="colUrunId"
    private TableColumn<URUN, Integer> colUrunId; // Value injected by FXMLLoader

    @FXML // fx:id="tblAdmin"
    private TableView<URUN> tblAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="txtAciklama"
    private TextField txtAciklama; // Value injected by FXMLLoader

    @FXML // fx:id="txtFiyat"
    private TextField txtFiyat; // Value injected by FXMLLoader

    @FXML // fx:id="txtSilahAd"
    private TextField txtSilahAd; // Value injected by FXMLLoader

    @FXML // fx:id="txtStok"
    private TextField txtStok; // Value injected by FXMLLoader

    @FXML // fx:id="txtUrunId"
    private TextField txtUrunId; // Value injected by FXMLLoader

    @FXML
    void btnEkleOnClick(ActionEvent event) throws SQLException {
    	String URUN_ADI = txtSilahAd.getText();
    	String URUN_ACIKLAMA = txtAciklama.getText();
    	Integer FIYATI = Integer.parseInt(txtFiyat.getText());
    	Integer STOK_MIKTARI = Integer.parseInt(txtStok.getText());
    	
    	new URUN().Insert(URUN_ADI, URUN_ACIKLAMA, STOK_MIKTARI, FIYATI);
    	initialize();
    }

    @FXML
    void btnGuncelleOnClick(ActionEvent event)throws SQLException {
    	String URUN_ADI = txtSilahAd.getText();
    	String URUN_ACIKLAMA = txtAciklama.getText();
    	Integer FIYATI = Integer.parseInt(txtFiyat.getText());
    	Integer URUN_ID = Integer.parseInt(txtUrunId.getText());
    	Integer STOK_MIKTARI = Integer.parseInt(txtStok.getText());
    	
    	new URUN().Update(URUN_ID, URUN_ADI, URUN_ACIKLAMA, STOK_MIKTARI, FIYATI);
    	initialize();
    }

    @FXML
    void btnSeciliSilOnClick(ActionEvent event) throws SQLException  {
    	if(tblAdmin.getSelectionModel().getSelectedIndex() > -1) {
        	Integer URUN_ID = colUrunId.getCellData(tblAdmin.getSelectionModel().getSelectedIndex());
        	new URUN().Delete(URUN_ID);
        	initialize();
    	}
    }

    @FXML
    void tblAdminOnClick(MouseEvent event) {
    	if(tblAdmin.getSelectionModel().getSelectedIndex() > -1) {
        	String URUN_ADI = colSilahAdi.getCellData(tblAdmin.getSelectionModel().getSelectedIndex());
        	String URUN_ACIKLAMA = colAciklama.getCellData(tblAdmin.getSelectionModel().getSelectedIndex());
        	Integer FIYATI = colFiyat.getCellData(tblAdmin.getSelectionModel().getSelectedIndex());
        	Integer STOK_MIKTARI = colStok.getCellData(tblAdmin.getSelectionModel().getSelectedIndex());
        	Integer URUN_ID = colStok.getCellData(tblAdmin.getSelectionModel().getSelectedIndex());
        	
        	txtSilahAd.setText(URUN_ADI);
        	txtAciklama.setText(URUN_ACIKLAMA);
        	txtUrunId.setText(URUN_ID.toString());
        	txtFiyat.setText(FIYATI.toString());
        	txtStok.setText(STOK_MIKTARI.toString());
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException {
    	tblAdmin.getItems().clear();
    	List<URUN> uruns = new URUN().getUrunList();
    	colUrunId.setCellValueFactory(new PropertyValueFactory<>("UrunId"));
    	colSilahAdi.setCellValueFactory(new PropertyValueFactory<>("UrunAdi"));
    	colAciklama.setCellValueFactory(new PropertyValueFactory<>("UrunAciklama"));
    	colFiyat.setCellValueFactory(new PropertyValueFactory<>("Fiyati"));
    	colStok.setCellValueFactory(new PropertyValueFactory<>("StokMiktari"));
    	tblAdmin.getItems().addAll(uruns);
    }

}
