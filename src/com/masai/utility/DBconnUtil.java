package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnUtil {
	
	public static Connection provideConnection() {
		
		Connection conn = null;
		
		
		try {
			//Load the driver here
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//prepare the string connection
		String url = "jdbc:mysql://localhost:3306/jdbcproject";
		
		//establish the connection
		try {
			conn = DriverManager.getConnection(url,"root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}