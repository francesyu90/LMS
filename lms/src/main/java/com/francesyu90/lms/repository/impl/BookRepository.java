package com.francesyu90.lms.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.repository.IBookRepository;

public class BookRepository implements IBookRepository {
	
	private DataSource dataSource;
	
	public BookRepository(DataSource dataSource) throws SQLException {
		this.dataSource = dataSource;
	}
	
	public List<Book> getAllBooks() throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "SELECT * FROM book";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		
		List<Book> books = new ArrayList<Book>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			Book book = new Book(title, author);
			book.setId(id);
			books.add(book);
		}
		
		conn.close();
		
		return books;
		
	}

	public int saveBook(Book book) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "INSERT INTO book(title, author, library_id) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, book.getTitle());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setInt(3, book.getLibraryId());
		
		preparedStatement.executeUpdate();
		conn.close();
		
		return 1;

	}
	
	public int removeAllBooks() throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "DELETE FROM book";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		preparedStatement.executeUpdate();
		conn.close();
		
		return 1;
	}

	public List<Book> findBooksByLibraryId(int libraryId) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "SELECT * FROM book WHERE book.library_id = ?"; 
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, libraryId);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		List<Book> books = new ArrayList<Book>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			Book book = new Book(title, author);
			book.setId(id);
			books.add(book);
		}
		
		conn.close();
		
		return books;
	}

	public int removeBooksByLibraryId(int libraryId) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "DELETE FROM book WHERE book.library_id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, libraryId);
		
		preparedStatement.executeUpdate();
		conn.close();
		
		return 1;
	}

	public int removeBooksByLibraryName(String name) throws SQLException {
		
		Connection conn = this.dataSource.getConnection();
		
		String sql = "DELETE FROM book WHERE book.library_id IN ("
				+ "SELECT library.id FROM library WHERE library.name = ?"
				+ ")";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, name);
		
		preparedStatement.executeUpdate();
		conn.close();
		
		return 1;
	}
	

}
