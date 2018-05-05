package com.francesyu90.lms.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.francesyu90.lms.configuration.DBConfig;
import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.ILibraryRepository;

public class LibraryRepository implements ILibraryRepository {
	
	private Connection conn;
	
	public LibraryRepository() throws SQLException {
		this.conn = DBConfig.getDBConn();
	}
	
	public LibraryRepository(DataSource dataSource) throws SQLException {
		this.conn = dataSource.getConnection();
	}
	
	public int saveLibrary(Library library) throws SQLException {
		
		String sql = "INSERT INTO library (name) VALUES(?)";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setString(1, library.getName());
		
		return preparedStatement.executeUpdate();
	}

	public List<Library> getAllLibraries() throws SQLException {
		String sql = "SELECT * FROM library";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		
		List<Library> libraries = new ArrayList<Library>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Library library = new Library(name);
			library.setId(id);
			libraries.add(library);
		}
		
		return libraries;
	}
	
	

}
