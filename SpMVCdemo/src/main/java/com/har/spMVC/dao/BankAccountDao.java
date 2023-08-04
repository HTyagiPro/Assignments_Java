package com.har.spMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.har.spMVC.beans.User;

@Repository
public class BankAccountDao {
	public boolean updateBalance(String username, double amount) throws ClassNotFoundException {
		int count =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con  = DriverManager.getConnection(DBCreds.url, DBCreds.unam, DBCreds.pass);
			pst = con.prepareStatement("update bankaccount set acc_bal = acc_bal-? where acc_uname=? ");
			
			pst.setDouble(1, amount);
			pst.setString(2, username);
				
				count = pst.executeUpdate();
				
				//rs.close();
				pst.close();
				con.close();
				
				
		}catch (Exception e) {
			System.out.println(e);
		}
	
	return count == 1;
	}
}
