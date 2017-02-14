/*
 * Author: Leonardo Mazuran
 * Start up project for CSCI3300
 * 
 */
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	private static final String CONN_STRING = "";

	
	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	}


	public static void displayException(SQLException ex){

		System.err.println("Error Message: " + ex.getMessage());
		System.err.println("Error Code: " + ex.getErrorCode());
		System.err.println("SQL Status: " + ex.getSQLState());

	}
}
