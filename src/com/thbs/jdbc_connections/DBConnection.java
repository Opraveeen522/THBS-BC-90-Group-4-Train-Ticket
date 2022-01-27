package com.thbs.jdbc_connections;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	private static Connection con;
	private DBConnection() {};
	static {
		
		try{  
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			String url ="jdbc:mysql://localhost:3306/opraveen";
			String userName="root";
			String password="root";
			
			con=DriverManager.getConnection(url,userName,password);
			
			
			}catch(Exception e){ System.out.println(e);}  
			}  
			 
	public static Connection getCon()
	{
		return con;
	}
}
