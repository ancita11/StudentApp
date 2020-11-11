package com.jspiders.studentapp.database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class ConnectionProvider {
    
	public static Connection giveConnection()
	{
		Connection con =null;
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/studentapp?user=root&password=root";
			
			con = DriverManager.getConnection(dburl);
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
		return con;
	}
}
