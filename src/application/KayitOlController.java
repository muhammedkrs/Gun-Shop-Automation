/**
 * Sample Skeleton for 'KayitOl.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class KayitOlController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button btnKayitOl;

    @FXML // fx:id="txtAd"
    private TextField txtAd; // Value injected by FXMLLoader

    @FXML // fx:id="txtEposta"
    private TextField txtEposta; // Value injected by FXMLLoader

    @FXML // fx:id="txtSifre"
    private TextField txtSifre; // Value injected by FXMLLoader

    @FXML // fx:id="txtSoyad"
    private TextField txtSoyad; // Value injected by FXMLLoader
    @FXML
    void btnKayitOlOnClick(ActionEvent event) throws SQLException {
    	String ADI = txtAd.getText();
    	String SOYADI = txtSoyad.getText();
    	String EPOSTA = txtEposta.getText();
    	String SIFRE = txtSifre.getText();
    	if (ADI == "" ||SOYADI == "" ||EPOSTA == "" ||SIFRE == "" ) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Hata!");
			alert.setContentText("Alanlar boş bırakılamaz!");
			alert.show();
		}
    	new KULLANICI().Insert(ADI, SOYADI, SIFRE, EPOSTA);
    	try {
    		Stage stage1=new Stage();
			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("AnaSayfa.fxml"));
			Scene scene = new Scene(pane1,670,500);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    }

}
