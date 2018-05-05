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
import com.francesyu90.lms.repository.IBookRepository;

public class BookRepository implements IBookRepository {
	
	private Connection conn;
	
	public BookRepository() throws SQLException {
		this.conn = DBConfig.getDBConn();
	}
	
	public BookRepository(DataSource dataSource) throws SQLException {
		this.conn = dataSource.getConnection();
	}
	
	public List<Book> getAllBooks() throws SQLException {
		
		String sql = "SELECT * FROM book";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
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
		
		return books;
		
	}

	public boolean saveBook(Book book) throws SQLException {
		
		String sql = "INSERT INTO book VALUES(?, ?, ?, ?)";
		PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setInt(1, book.getId());
		preparedStatement.setString(2, book.getTitle());
		preparedStatement.setString(3, book.getAuthor());
		preparedStatement.setInt(4, book.getLibraryId());
		
		return preparedStatement.execute();

	}
	
	

}
