package com.francesyu90.lms.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class DBConfig {
	
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	public static final String PORT = "3306";
	public static final String DB_NAME = "lms";
	public static final String USER = "root";
	public static final String PWD = "root";
	
	public static final int MAX_ACTIVE = 5;
	
	private static GenericObjectPool gPool = null;
	
	public static Connection getDBConn() throws SQLException {
		
		String url = String.format("jdbc:mysql://localhost:%s/%s", PORT, DB_NAME);
		return DriverManager.getConnection(url, USER, PWD);
	}
	
	public static DataSource setUpPool() {

		gPool = new GenericObjectPool();
		gPool.setMaxActive(MAX_ACTIVE);
		
		String url = String.format("jdbc:mysql://localhost:%s/%s", PORT, DB_NAME);
		ConnectionFactory cf = new DriverManagerConnectionFactory(url, USER, PWD);
		
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		
		return new PoolingDataSource(gPool);
		
	}
	
	public static GenericObjectPool getConnectionPool() {
		return gPool;
	}

}
