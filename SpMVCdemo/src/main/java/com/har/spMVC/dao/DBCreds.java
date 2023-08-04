package com.har.spMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCreds {
	static String unam = "root";
	static String pass = "Cheeko@1234";
	static String url = "jdbc:mysql://localhost:3306/prolifics";
	
	/*
	public static Connection getConnect() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, unam, pass);
		} catch (SQLException| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return con;
	}
	*/
}
