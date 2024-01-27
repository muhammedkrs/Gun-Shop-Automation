/**
 * Sample Skeleton for 'AnaSayfa.fxml' Controller Class
 */

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AnaSayfaController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="anchorSag"
    private AnchorPane anchorSag; // Value injected by FXMLLoader

    @FXML // fx:id="anchorSol"
    private AnchorPane anchorSol; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdmin"
    private Button btnAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnaSayfa"
    private Button btnAnaSayfa; // Value injected by FXMLLoader

    @FXML // fx:id="btnSatınAldiklarim"
    private Button btnSatınAldiklarim; // Value injected by FXMLLoader

    @FXML // fx:id="btnSepetim"
    private Button btnSepetim; // Value injected by FXMLLoader

    @FXML // fx:id="btnUrunler"
    private Button btnUrunler; // Value injected by FXMLLoader

    @FXML // fx:id="bttnCikisYap"
    private Button bttnCikisYap; // Value injected by FXMLLoader
    @FXML
    private AnchorPane anchorTum;
    
    @FXML
    void btnAdminOnClick(ActionEvent event) {
		try {
			AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("Admin.fxml"));
			anchorSag.getChildren().setAll(pane1);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnAnaSayfaOnClick(ActionEvent event) {
    	anchorSag.getChildren().clear();
    }

    @FXML
    void btnCikisYapOnClick(ActionEvent event) {
    	  System.exit(0);

    }

    @FXML
    void btnSatınAldiklarimOnClick(ActionEvent event) {
    	try {
			AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("SatinAlinanlar.fxml"));
			anchorSag.getChildren().setAll(pane1);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnSepetimOnClick(ActionEvent event) {
    	try {
			AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("Sepetim.fxml"));
			anchorSag.getChildren().setAll(pane1);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnUrunlerOnClick(ActionEvent event) {
    	try {
			AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("Urunler.fxml"));
			anchorSag.getChildren().setAll(pane1);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        if (Main.GirisYapan.getYETKILI() != 1) {
        	btnAdmin.setVisible(false);
		}

    }

}
