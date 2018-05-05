package com.francesyu90.lms.configuration;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 
 * @author Beijia
 * 
 * Note: only run these tests after connecting to real database server
 * 
 */
public class DBConfigTest {
	
	@Test
	public void testDBConn() throws SQLException {
		Connection conn = DBConfig.getDBConn();
		assertNotNull(conn);
	}

}
