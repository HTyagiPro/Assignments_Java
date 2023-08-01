package com.har.jdbc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.har.jdbc.Credentials;
import com.har.jdbc.bean.Book;


public class BookDAO {
	private static String url = "jdbc:mysql://localhost:3306/prolifics";
	
	public boolean insertBook(Book book) {
		
		int count =0;
		try(Connection con = DriverManager.getConnection(url, Credentials.getUnam(), Credentials.getPass());
			PreparedStatement pst = con.prepareStatement("insert into book values(?,?,?,?,?,?)");){
			pst.setString(1, book.getBookID());
			pst.setString(2, book.getBookTitle());
			pst.setString(3, book.getBookAuthor());
			pst.setString(4, book.getBookCategoy());
			pst.setDouble(5, book.getBookPrice());
			pst.setInt(6, book.getCopies());
			count = pst.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return count !=0;
	}
	
	public ArrayList<Book> getBookByCategory(String b_category){
		ArrayList<Book> book = new ArrayList<Book>();
			try(Connection con = DriverManager.getConnection(url, Credentials.getUnam(), Credentials.getPass());
				PreparedStatement pst = con.prepareStatement("Select * from book where book_category =?");){
				pst.setString(1, b_category);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6)));
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		
		return book;
	}
	
	public ArrayList<Book> getAllBook(){
		ArrayList<Book> book = new ArrayList<Book>();
			try(Connection con = DriverManager.getConnection(url, Credentials.getUnam(), Credentials.getPass());
				PreparedStatement pst = con.prepareStatement("Select * from book");){
				
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6)));
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		
		return book;
	}
	
	
	public Book getBookByTitle(String b_title){
		
		
			Book book = null;
			try(Connection con = DriverManager.getConnection(url, Credentials.getUnam(), Credentials.getPass());
				PreparedStatement pst = con.prepareStatement("Select * from book where book_title =?");){
				pst.setString(1, b_title);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					book = new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		
		return book;
	}
	
	
	public boolean deleteBookByTitle(String b_title) {
		int count = 0;
		try(Connection con = DriverManager.getConnection(url, Credentials.getUnam(), Credentials.getPass());
				PreparedStatement pst = con.prepareStatement("delete from book where book_title =?");){
				pst.setString(1, b_title);
				count = pst.executeUpdate();
			}catch(Exception e) {
				System.out.println(e);
			}
		return count !=0;
	}

}
