package com.francesyu90.lms.repository;

import java.sql.SQLException;
import java.util.List;

import com.francesyu90.lms.domain.Book;

public interface IBookRepository {
	
	public List<Book> getAllBooks() throws SQLException;
	
	public int saveBook(Book book) throws SQLException;
	
	public int removeAllBooks() throws SQLException;
	
	public List<Book> findBooksByLibraryId(int libraryId) throws SQLException;

}
