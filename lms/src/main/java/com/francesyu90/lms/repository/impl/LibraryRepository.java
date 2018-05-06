package com.francesyu90.lms.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.ILibraryRepository;

public class LibraryRepository implements ILibraryRepository {
	
	private DataSource dataSource;
	
	public LibraryRepository(DataSource dataSource) throws SQLException {
		this.dataSource = dataSource;
	}
	
	public int saveLibrary(Library library) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "INSERT INTO library (name) VALUES(?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, library.getName());
		
		preparedStatement.executeUpdate();
		
		conn.close();
		
		return 1;
	}
	
	public int saveLibraryAndGetId(Library library) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
	
		String sql = "INSERT INTO library (name) VALUES(?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, library.getName());
		
		preparedStatement.executeUpdate();
		
		conn.close();
		
		Library found = this.findByName(library.getName());
		return found.getId();
	}


	public List<Library> getAllLibraries() throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "SELECT * FROM library";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		
		List<Library> libraries = new ArrayList<Library>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Library library = new Library(name);
			library.setId(id);
			libraries.add(library);
		}
		
		conn.close();
		
		return libraries;
	}

	public Library findByName(String name) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "SELECT * FROM library l WHERE l.name = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
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
		
		conn.close();
		
		return libraries.get(0);
	}

	public int removeLibraryByName(Library library) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "DELETE FROM library WHERE library.name = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, library.getName());
		preparedStatement.executeUpdate();
		
		conn.close();
		
		return 1;
	}
	
	public int removeAllLibraies() throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "DELETE FROM library";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.executeUpdate();
		
		conn.close();
		
		return 1;
	}

	public Library findById(int id) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "SELECT * FROM library l WHERE l.id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
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
		
		conn.close();
		
		return (libraries.isEmpty())? null : libraries.get(0);
	}

	@Override
	public int removeLibraryById(int id) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "DELETE FROM library WHERE library.id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		
		conn.close();
		
		return 1;
	}
	
	

}
