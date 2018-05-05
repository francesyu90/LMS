package com.francesyu90.lms.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.francesyu90.lms.configuration.DBConfig;
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

	public Library findByName(String name) throws SQLException {
		
		String sql = "SELECT * FROM library l WHERE l.name = ?";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet rs = preparedStatement.executeQuery();
		
		List<Library> libraries = new ArrayList<Library>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nm = rs.getString("name");
			Library library = new Library(nm);
			library.setId(id);
			libraries.add(library);
		}
		
		return libraries.get(0);
	}

	public int removeLibraryByName(Library library) throws SQLException {
		
		String sql = "DELETE FROM library WHERE library.name = ?";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setString(1, library.getName());
		
		return preparedStatement.executeUpdate();
	}
	
	public int removeAllLibraies() throws SQLException {
		
		String sql = "DELETE FROM library";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		
		return preparedStatement.executeUpdate();
	}

	public int saveLibraryAndGetId(Library library) throws SQLException {
		
		String sql = "INSERT INTO library (name) VALUES(?)";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setString(1, library.getName());
		
		preparedStatement.executeUpdate();
		
		Library found = this.findByName(library.getName());
		
		return found.getId();
	}

	public Library findById(int id) throws SQLException {
		String sql = "SELECT * FROM library l WHERE l.id = ?";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		
		List<Library> libraries = new ArrayList<Library>();
		while(rs.next()) {
			int id1 = rs.getInt("id");
			String nm = rs.getString("name");
			Library library = new Library(nm);
			library.setId(id1);
			libraries.add(library);
		}
		
		return libraries.get(0);
	}
	
	

}
