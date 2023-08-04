package com.har.spMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.har.spMVC.beans.User;

@Repository
public class UserDAO {
	public boolean searchUSer(User user) throws ClassNotFoundException {
		int count =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con  = DriverManager.getConnection(DBCreds.url, DBCreds.unam, DBCreds.pass);
			pst = con.prepareStatement("select count(*) from users where username=? and password=?");
			
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
				
				rs = pst.executeQuery();
				if(rs.next()) count = rs.getInt(1);
				System.out.println(user);
				rs.close();
				pst.close();
				con.close();
				
				
		}catch (Exception e) {
			System.out.println(e);
		}
	
	return count == 1;
	}
}
