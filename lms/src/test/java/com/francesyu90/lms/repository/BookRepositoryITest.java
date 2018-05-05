package com.francesyu90.lms.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;

import com.francesyu90.lms.configuration.DBConfig;
import com.francesyu90.lms.configuration.PicoConfig;
import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.repository.impl.BookRepository;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * 
 * Note: only run these tests after connecting to real database server
 * 
 */
public class BookRepositoryITest {
	
	private BookRepository bookRepo;
	
	public BookRepositoryITest() {
		PicoConfig pico = new PicoConfig();
		pico.addPicoComponent(Book.class);
		pico.addPicoComponent(BookRepository.class);
		this.bookRepo =  (BookRepository) pico.getPicoComponent(BookRepository.class);
	}
	
	@Test
	public void testBookRepoNotNull() {
		assertNotNull(this.bookRepo);
	}
	
	@Test
	public void testGetAllBooks() throws SQLException {
		List<Book> books = this.bookRepo.getAllBooks();
		assertNotNull(books);
		assertTrue(books.isEmpty());
	}
	
	@Test
	public void testBookRepoWithConnPool() throws SQLException {
		DataSource dataSource = DBConfig.setUpPool();
		this.bookRepo = new BookRepository(dataSource);
		List<Book> books = this.bookRepo.getAllBooks();
		assertNotNull(books);
		assertTrue(books.isEmpty());
	}
	
	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void testSaveBook() throws SQLException {
		Book book = new Book("Hello", "World");
		boolean res = this.bookRepo.saveBook(book);
		assertTrue(res);
	}

}
