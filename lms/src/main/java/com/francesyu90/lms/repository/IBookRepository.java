package com.francesyu90.lms.repository;

import java.sql.SQLException;
import java.util.List;

import com.francesyu90.lms.domain.Book;

public interface IBookRepository {
	
	public List<Book> getAllBooks() throws SQLException;
	
	public boolean saveBook(Book book) throws SQLException;

}
