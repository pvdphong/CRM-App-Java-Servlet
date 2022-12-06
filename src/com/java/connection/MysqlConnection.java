package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * KẾT NỐI DATABASE
 * 	
 * */

public class MysqlConnection {
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	private final static String URL = "jdbc:mysql://localhost:3306/crm_app"; 
	private final static String USERNAME = "root"; 
	private final static String PASSWORD = "phongpham98";	
	
	public static Connection getConnection() {  // static : xai truc tiep k can khoi tao doi tuong mysqlconnection		
		try {
			Class.forName(DRIVER); 
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null; 
	}
			
}
