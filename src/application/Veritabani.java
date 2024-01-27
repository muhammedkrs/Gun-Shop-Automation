package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;

public class Veritabani {
	 private String url = "jdbc:mysql://localhost:3306/silahdukkani";
	 private String username = "root";
	 private String password = "";
	
	private Button ekle;
	 
	 private Connection conn;
	 
	 public Veritabani() {
		 this.ekle=new Button();
			this.ekle.setText("Mesaj yolla");
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     String unicode="?useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
	        
		 try {
			 Connection connection = DriverManager.getConnection(url +unicode, username, password);
			 this.conn = connection;
		 } catch (SQLException e) {
		     throw new IllegalStateException("Cannot connect the database!", e);
		 }
	 }

	public Connection getConn() {
		return conn;
	}
}
