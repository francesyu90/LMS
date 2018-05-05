package com.francesyu90.lms.configuration;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

/**
 * 
 * Note: only run these tests after connecting to real database server
 * 
 */
public class DBConfigITest {
	
	@Test
	public void testDBConn() throws SQLException {
		Connection conn = DBConfig.getDBConn();
		assertNotNull(conn);
	}
	
	@Test
	public void testConnPool() throws Exception {
		
		DataSource dataSource = DBConfig.setUpPool();
		assertNotNull(dataSource);
		Connection conn = dataSource.getConnection();
		assertNotNull(conn);
	
	}

}
