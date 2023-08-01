package com.har.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
    	Connection con =null;
    	ResultSet rs = null;
    	PreparedStatement pst2 = null;
    	PreparedStatement pst3 = null;
    	String url ="jdbc:mysql://localhost:3306/prolifics";
        try {
        	con = DriverManager.getConnection(url, Credentials.getUnam(), Credentials.getPass());
    		
        	/*
        	//con.setAutoCommit(false);
        	PreparedStatement pst = con.prepareStatement("Insert into emp values(?,?,?,?)");
    		pst.setInt(1, 112);
    		pst.setString(2, "Naina");
    		pst.setDouble(3, 5600);
    		pst.setInt(4, 40);
    		int count = pst.executeUpdate();
    		System.out.println("Rows Affected: "+count);
    		
        	
        	
        	
        	
        	pst3 = con.prepareStatement("delete from emp where emp_name = 'Shubh'");
        	int count2 = pst3.executeUpdate();
        	System.out.println("Rows Deleted"+ count);
        	
        	con.rollback();
        	
        	*/
        	
        	
        	
        	
        	/*
        	
        	
        	pst2 = con.prepareStatement("Select * from emp", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
    		rs = pst2.executeQuery();
    		
        	for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
        		System.out.print(rs.getMetaData().getColumnName(i)+"\t      ");
			System.out.println();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t	"+rs.getString(2)+"\t	"+rs.getString(3)+"\t	"+rs.getString(4));
			}
			System.out.println("--------------------------------------------------");
			while(rs.previous()) {
				System.out.println(rs.getString(1)+"\t	"+rs.getString(2)+"\t	"+rs.getString(3)+"\t	"+rs.getString(4));
			}
			*/
			
			pst3 = con.prepareStatement("Select * from department", rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_UPDATABLE);
    		
			rs = pst3.executeQuery();
			//rs.absolute(5);
    		//rs.deleteRow();
    		
    		
    		/*
    		rs.moveToInsertRow();
    		rs.updateInt(1, 60);
    		rs.updateString(2, "Human Resource");
    		rs.updateString(3, "Bhopal");
    		rs.insertRow();
    		*/
    		
    		/*
    		if(rs.rowInserted())
    			System.out.println("Row Inserted");
    		*/
			//rs = con.prepareStatement("Select * from department").executeQuery();
    		
    		
			rs.absolute(0);
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
        		System.out.print(rs.getMetaData().getColumnName(i)+"\t      ");
			System.out.println();
    		while(rs.next()) {
				System.out.println(rs.getString(1)+"\t	"+rs.getString(2)+"\t	"+rs.getString(3));
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				
				if(rs!=null)rs.close();
				if(pst2!=null)pst2.close();
				if(con!=null)con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
        
        
    }
}


/*
   Connection con =null;
    	String url ="jdbc:mysql://localhost:3306/prolifics";
    	PreparedStatement pst =null;
    	ResultSet rs = null;
        try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, Credentials.unam, Credentials.pass);
			pst = con.prepareStatement("Select * from emp");
			rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t       "+rs.getString(2)+"\t       "+rs.getString(3)+"\t       "+rs.getString(4));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				
				if(rs!=null)rs.close();
				if(pst!=null)pst.close();
				if(con!=null)con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
 */


