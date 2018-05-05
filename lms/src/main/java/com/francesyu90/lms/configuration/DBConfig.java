package com.francesyu90.lms.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	
	public static final String PORT = "3306";
	public static final String DB_NAME = "lms";
	public static final String USER = "root";
	public static final String PWD = "root";
	
	public static Connection getDBConn() throws SQLException {
		String url = String.format("jdbc:mysql://localhost:%s/%s", PORT, DB_NAME);
		return DriverManager.getConnection(url, USER, PWD);
	}

}
