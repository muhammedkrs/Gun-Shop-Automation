package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class SATIS {
	private Integer SATIS_ID;
	private String URUN_ADI;
	private Integer FIYATI;
	private String KULLANICI_ADI;
	private Integer SEPET;
	private Date SATIN_ALMA_TARIHI;
	private Date SEPETE_EKLEME_TARIHI;
	private Button button;
	public SATIS() {
		super();
	}
	public SATIS(Integer SATIS_ID, String URUN_ADI, Integer FIYATI, String KULLANICI_ADI, Integer SEPET,
			Date SATIN_ALMA_TARIHI, Date SEPETE_EKLEME_TARIHI, Button button) {
		this.SATIS_ID = SATIS_ID;
		this.URUN_ADI = URUN_ADI;
		this.FIYATI = FIYATI;
		this.KULLANICI_ADI = KULLANICI_ADI;
		this.SEPET = SEPET;
		this.SATIN_ALMA_TARIHI = SATIN_ALMA_TARIHI;
		this.SEPETE_EKLEME_TARIHI = SEPETE_EKLEME_TARIHI;
		this.button = button;
	}
	public Integer getSATIS_ID() {
		return SATIS_ID;
	}
	public void setSATIS_ID(Integer SATIS_ID) {
		this.SATIS_ID = SATIS_ID;
	}
	public int getSEPET() {
		return SEPET;
	}
	public void setSEPET(int SEPET) {
		this.SEPET = SEPET;
	}
	public Date getSATIN_ALMA_TARIHI() {
		return SATIN_ALMA_TARIHI;
	}
	public void setSATIN_ALMA_TARIHI(Date SATIN_ALMA_TARIHI) {
		this.SATIN_ALMA_TARIHI = SATIN_ALMA_TARIHI;
	}
	public Date getSEPETE_EKLEME_TARIHI() {
		return SEPETE_EKLEME_TARIHI;
	}
	public void setSEPETE_EKLEME_TARIHI(Date SEPETE_EKLEME_TARIHI) {
		this.SEPETE_EKLEME_TARIHI = SEPETE_EKLEME_TARIHI;
	}
	
	public String getURUN_ADI() {
		return URUN_ADI;
	}
	public void setURUN_ADI(String URUN_ADI) {
		this.URUN_ADI = URUN_ADI;
	}
	public Integer getFIYATI() {
		return FIYATI;
	}
	public void setFIYATI(Integer FIYATI) {
		this.FIYATI = FIYATI;
	}
	public String getKULLANICI_ADI() {
		return KULLANICI_ADI;
	}
	public void setKULLANICI_ADI(String KULLANICI_ADI) {
		this.KULLANICI_ADI = KULLANICI_ADI;
	}
	public void setSEPET(Integer SEPET) {
		this.SEPET = SEPET;
	}
	
	public List<SATIS> getSepetList() throws SQLException{
		List<SATIS> sepets = new ArrayList<SATIS>();
		Connection conn = new Veritabani().getConn();
		String QUERY = "SELECT * FROM satis s  INNER JOIN urunler u ON u.URUN_ID = s.URUN_ID INNER JOIN kullanicilar k ON k.KULLANICI_ID = s.KULLANICI_ID  WHERE SEPET = 1 AND k.KULLANICI_ID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, Main.GirisYapan.getKULLANICI_ID());
		ResultSet rs = preparedStatement.executeQuery();
    	while(rs.next())
    	{
    		Integer SATIS_ID = rs.getInt("SATIS_ID");
    		String URUN_ADI = rs.getString("URUN_ADI");
    		Integer FIYATI = rs.getInt("FIYATI");
    		String KULLANCI_ADI = rs.getString("ADI") + " " + rs.getString("SOYADI");
    		Integer SEPET = rs.getInt("SEPET");
    		Date SATIN_ALMA_TARIHI = rs.getDate("SATIN_ALMA_TARIHI");
    		Date SEPETE_EKLEME_TARIHI = rs.getDate("SEPETE_EKLEME_TARIHI");
    		Button btn =new Button();
    		btn.setText("Sil");
    		btn.setId("btn" + SATIS_ID);
    		btn.setOnAction(e -> {
    			try {
					new SATIS().DeleteById(SATIS_ID);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    		});
    		SATIS satis = new SATIS(SATIS_ID, URUN_ADI,FIYATI, KULLANCI_ADI, SEPET,SATIN_ALMA_TARIHI, SEPETE_EKLEME_TARIHI, btn);
    		sepets.add(satis);
    	}
    	return sepets;
    }
	public List<SATIS> getSatisList() throws SQLException{
		List<SATIS> satiss = new ArrayList<SATIS>();
		Connection conn = new Veritabani().getConn();
		String QUERY = "SELECT * FROM satis s INNER JOIN urunler u ON u.URUN_ID = s.URUN_ID INNER JOIN kullanicilar k ON k.KULLANICI_ID = s.KULLANICI_ID  WHERE SEPET = 0 AND k.KULLANICI_ID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, Main.GirisYapan.getKULLANICI_ID());
		ResultSet rs = preparedStatement.executeQuery();
    	while(rs.next())
    	{
    		Integer SATIS_ID = rs.getInt("SATIS_ID");
    		String URUN_ADI = rs.getString("URUN_ADI");
    		Integer FIYATI = rs.getInt("FIYATI");
    		String KULLANCI_ADI = rs.getString("ADI") + " " + rs.getString("SOYADI");
    		Integer SEPET = rs.getInt("SEPET");
    		Date SATIN_ALMA_TARIHI = rs.getDate("SATIN_ALMA_TARIHI");
    		Date SEPETE_EKLEME_TARIHI = rs.getDate("SEPETE_EKLEME_TARIHI");
    		SATIS satis = new SATIS(SATIS_ID, URUN_ADI,FIYATI, KULLANCI_ADI, SEPET,SATIN_ALMA_TARIHI, SEPETE_EKLEME_TARIHI, null);
    		satiss.add(satis);
    	}
    	return satiss;
    }
	public void Insert(Integer URUN_ID,Integer KULLANICI_ID) throws SQLException{
		Connection conn = new Veritabani().getConn();
		String QUERY = "INSERT INTO satis(URUN_ID, KULLANICI_ID, SEPET) VALUES( ?, ?, ?)  ";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, URUN_ID);
        preparedStatement.setInt(2, KULLANICI_ID);
        preparedStatement.setInt(3, 1);
		preparedStatement.execute();
    }
	public void DeleteSepetByKullaniciId(Integer KULLANICI_ID) throws SQLException{
		Connection conn = new Veritabani().getConn();
		String QUERY = "DELETE FROM satis WHERE KULLANICI_ID = ? AND SEPET = 1";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, KULLANICI_ID);
		preparedStatement.execute();
    }
	public void DeleteById(Integer SATIS_ID) throws SQLException{
		Connection conn = new Veritabani().getConn();
		String QUERY = "DELETE FROM satis WHERE SATIS_ID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, SATIS_ID);
		preparedStatement.execute();
    }
	
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
	public void SatisaEkle(Integer SATIS_ID) throws SQLException {
		Connection conn = new Veritabani().getConn();
		String QUERY = "SELECT u.URUN_ID, STOK_MIKTARI FROM URUNLER u INNER JOIN SATIS s ON s.URUN_ID = u.URUN_ID WHERE s.SATIS_ID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, SATIS_ID);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next())
    	{
    		Integer STOK_MIKTARI = rs.getInt("STOK_MIKTARI");
    		Integer URUN_ID = rs.getInt("URUN_ID");
    		if (STOK_MIKTARI > 0) {
    			QUERY = "UPDATE satis SET SEPET = 0, SATIN_ALMA_TARIHI = current_timestamp() WHERE SATIS_ID = ?";
    			preparedStatement = conn.prepareStatement(QUERY);
    	        preparedStatement.setInt(1, SATIS_ID);
    			preparedStatement.execute();				
    			
    			QUERY = "UPDATE urunler SET STOK_MIKTARI = ? WHERE URUN_ID = ?";
    			preparedStatement = conn.prepareStatement(QUERY);
    	        preparedStatement.setInt(1, (STOK_MIKTARI-1));
    	        preparedStatement.setInt(2, URUN_ID);
    			preparedStatement.execute();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Hata");
				alert.setContentText("Stokta yeterli miktarda ürün bulunmamaktadır.");
				alert.show();
			}
    	}
	}
}
