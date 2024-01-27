package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KULLANICI {
	private Integer KULLANICI_ID;
	private String ADI;
	private String SOYADI;
	private String SIFRE;
	private String EPOSTA;
	private Integer YETKILI;
	
	
	public KULLANICI() {
		super();
	}
	
	public KULLANICI(Integer KULLANICI_ID, String ADI, String SOYADI, String SIFRE, String EPOSTA, Integer YETKILI) {
		this.KULLANICI_ID = KULLANICI_ID;
		this.ADI = ADI;
		this.SOYADI = SOYADI;
		this.SIFRE = SIFRE;
		this.EPOSTA = EPOSTA;
		this.YETKILI = YETKILI;
	}
	public Integer getKULLANICI_ID() {
		return KULLANICI_ID;
	}
	public void setKULLANICI_ID(Integer KULLANICI_ID) {
		this.KULLANICI_ID = KULLANICI_ID;
	}
	public String getADI() {
		return ADI;
	}
	public void setADI(String ADI) {
		this.ADI = ADI;
	}
	public String getSOYADI() {
		return SOYADI;
	}
	public void setSOYADI(String SOYADI) {
		this.SOYADI = SOYADI;
	}
	public String getSIFRE() {
		return SIFRE;
	}
	public void setSIFRE(String SIFRE) {
		this.SIFRE = SIFRE;
	}
	public String getEPOSTA() {
		return EPOSTA;
	}
	public void setEPOSTA(String EPOSTA) {
		this.EPOSTA = EPOSTA;
	}
	public Integer getYETKILI() {
		return YETKILI;
	}
	public void setYETKILI(Integer YETKILI) {
		this.YETKILI = YETKILI;
	}
	public KULLANICI getKullaniciById(Integer KULLANICI_ID) throws SQLException {
		Connection conn = new Veritabani().getConn();
		String QUERY = "SELECT * FROM kullanicilar WHERE KULLANICI_ID = ? ";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setInt(1, KULLANICI_ID);
		ResultSet rs = preparedStatement.executeQuery();
		KULLANICI kullanici = new KULLANICI();
    	while(rs.next())
    	{
    		Integer KullaniciId = rs.getInt("KULLANICI_ID");
    		String Adi = rs.getString("ADI");
    		String Soyadi = rs.getString("SOYADI");
    		String Sifre = rs.getString("SIFRE");
    		String Eposta = rs.getString("EPOSTA");
    		Integer Yetkili = rs.getInt("YETKILI");
    		kullanici = new KULLANICI(KullaniciId, Adi, Soyadi, Sifre, Eposta, Yetkili);
    	}
    	return kullanici;
	}
	public KULLANICI Login(String EPOSTA, String SIFRE) throws SQLException {
		Connection conn = new Veritabani().getConn();
		String QUERY = "SELECT * FROM kullanicilar WHERE EPOSTA = ? and SIFRE = ? ";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setString(1, EPOSTA);
        preparedStatement.setString(2, SIFRE);
		ResultSet rs = preparedStatement.executeQuery();
		KULLANICI kullanici = null;
    	while(rs.next())
    	{
    		Integer KullaniciId = rs.getInt("KULLANICI_ID");
    		String Adi = rs.getString("ADI");
    		String Soyadi = rs.getString("SOYADI");
    		String Sifre = rs.getString("SIFRE");
    		String Eposta = rs.getString("EPOSTA");
    		Integer Yetkili = rs.getInt("YETKILI");
    		kullanici = new KULLANICI(KullaniciId, Adi, Soyadi, Sifre, Eposta, Yetkili);
    	}
    	return kullanici;
	}
	public void Insert(String ADI,String SOYADI,String SIFRE,String EPOSTA) throws SQLException {
		Connection conn = new Veritabani().getConn();
		String QUERY = "INSERT INTO kullanicilar(ADI, SOYADI, SIFRE, EPOSTA) VALUES(?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
        preparedStatement.setString(1, ADI);
        preparedStatement.setString(2, SOYADI);
        preparedStatement.setString(3, SIFRE);
        preparedStatement.setString(4, EPOSTA);
        preparedStatement.execute();
	}
}
