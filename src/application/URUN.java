package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class URUN {
	private Integer UrunId;
	private String UrunAdi;
	private String UrunAciklama;
	private Integer StokMiktari;
	private Integer Fiyati;
	private Button button;
	
	
	public URUN() {
		super();
	}
	public URUN(Integer UrunId, String UrunAdi, String UrunAciklama, Integer StokMiktari, Integer Fiyati, Button button) {
		super();
		this.UrunId = UrunId;
		this.UrunAdi = UrunAdi;
		this.UrunAciklama = UrunAciklama;
		this.StokMiktari = StokMiktari;
		this.Fiyati = Fiyati;
		this.button = button;
	}
	
	public Integer getUrunId() {
		return UrunId;
	}
	public void setUrunId(Integer UrunId) {
		this.UrunId = UrunId;
	}
	public String getUrunAdi() {
		return UrunAdi;
	}
	public void setUrunAdi(String UrunAdi) {
		this.UrunAdi = UrunAdi;
	}
	public String getUrunAciklama() {
		return UrunAciklama;
	}
	public void setUrunAciklama(String UrunAciklama) {
		this.UrunAciklama = UrunAciklama;
	}
	public Integer getStokMiktari() {
		return StokMiktari;
	}
	public void setStokMiktari(Integer StokMiktari) {
		this.StokMiktari = StokMiktari;
	}
	public Integer getFiyati() {
		return Fiyati;
	}
	public void setFiyati(Integer Fiyati) {
		this.Fiyati = Fiyati;
	}
	
	public List<URUN> getUrunList() throws SQLException{
		List<URUN> uruns = new ArrayList<URUN>();
		Connection conn = new Veritabani().getConn();
		String QUERY = "SELECT * FROM urunler ";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
		ResultSet rs = preparedStatement.executeQuery();
    	while(rs.next())
    	{
    		Integer UrunId = rs.getInt("URUN_ID");
    		String UrunAdi = rs.getString("URUN_ADI");
    		String UrunAciklama = rs.getString("URUN_ACIKLAMA");
    		Integer StokMiktari = rs.getInt("STOK_MIKTARI");
    		Integer Fiyati = rs.getInt("FIYATI");
    		Button btn =new Button();
    		btn.setText("Ekle");
    		btn.setId("btn" + UrunId);
    		btn.setOnAction(e -> {
    			try {
					new SATIS().Insert(UrunId, Main.GirisYapan.getKULLANICI_ID());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    		});
    		URUN urun = new URUN(UrunId, UrunAdi, UrunAciklama, StokMiktari, Fiyati, btn);
    		uruns.add(urun);
    	}
    	return uruns;
    }
	public URUN getUrunById(Integer URUN_ID) throws SQLException{
		Connection conn = new Veritabani().getConn();
		String QUERY = "SELECT * FROM urunler WHERE URUN_ID = ? ";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, URUN_ID);
		ResultSet rs = preparedStatement.executeQuery();
		URUN urun = new URUN();
    	while(rs.next())
    	{
    		Integer UrunId = rs.getInt("URUN_ID");
    		String UrunAdi = rs.getString("URUN_ADI");
    		String UrunAciklama = rs.getString("URUN_ACIKLAMA");
    		Integer StokMiktari = rs.getInt("STOK_MIKTARI");
    		Integer Fiyati = rs.getInt("FIYATI");
    		Button btn =new Button();
    		btn.setText("Ekle");
    		btn.setId("btn" + UrunId);
    		btn.setOnAction(e -> {
    			try {
					new SATIS().Insert(UrunId, Main.GirisYapan.getKULLANICI_ID());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    		});
    		urun = new URUN(UrunId, UrunAdi, UrunAciklama, StokMiktari, Fiyati, btn);
    	}
    	return urun;
    }
	public void Delete(Integer URUN_ID) throws SQLException{
		Connection conn = new Veritabani().getConn();
		String QUERY = "DELETE FROM urunler WHERE URUN_ID = ? ";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, URUN_ID);
		preparedStatement.execute();
    }
	public void Update(Integer URUN_ID, String URUN_ADI,String URUN_ACIKLAMA,Integer STOK_MIKTARI,Integer FIYATI) throws SQLException{
		Connection conn = new Veritabani().getConn();
		String QUERY = "UPDATE urunler SET URUN_ADI = ?, URUN_ACIKLAMA = ?, STOK_MIKTARI = ?, FIYATI = ? WHERE URUN_ID = ?  ";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(5, URUN_ID);
        preparedStatement.setString(1, URUN_ADI);
        preparedStatement.setString(2, URUN_ACIKLAMA);
        preparedStatement.setInt(3, STOK_MIKTARI);
        preparedStatement.setInt(4, FIYATI);
		preparedStatement.execute();
    }
	public void Insert(String URUN_ADI,String URUN_ACIKLAMA,Integer STOK_MIKTARI,Integer FIYATI) throws SQLException{
		Connection conn = new Veritabani().getConn();
		String QUERY = "INSERT INTO urunler VALUES(null, ?, ?, ?, ?)  ";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setString(1, URUN_ADI);
        preparedStatement.setString(2, URUN_ACIKLAMA);
        preparedStatement.setInt(3, STOK_MIKTARI);
        preparedStatement.setInt(4, FIYATI);
		preparedStatement.execute();
    }
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
}
