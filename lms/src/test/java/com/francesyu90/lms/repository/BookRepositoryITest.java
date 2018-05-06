package com.francesyu90.lms.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;

import com.francesyu90.lms.configuration.DBConfig;
import com.francesyu90.lms.configuration.PicoConfig;
import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.impl.BookRepository;
import com.francesyu90.lms.repository.impl.LibraryRepository;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * 
 * Note: 
 * 	only run these tests after connecting to real database server
 * 	only run these tests when using test database
 * 
 */
public class BookRepositoryITest {
	
	private IBookRepository bookRepo;
	
	public BookRepositoryITest() {
		PicoConfig pico = new PicoConfig();
		pico.addPicoComponent(Book.class);
		pico.addPicoComponent(BookRepository.class);
		this.bookRepo = 
				(BookRepository) pico.getPicoComponent(BookRepository.class);
	}
	
	private ILibraryRepository getLibRepo() {
		PicoConfig pico = new PicoConfig();
		pico.addPicoComponent(Library.class);
		pico.addPicoComponent(LibraryRepository.class);
		return (ILibraryRepository) pico.getPicoComponent(
				LibraryRepository.class);
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
	
	@Test
	public void testSaveBook() throws SQLException {
		Library library = new Library("library");
		ILibraryRepository libRepo = this.getLibRepo();
		int libraryId = libRepo.saveLibraryAndGetId(library);
		Book book = new Book("Hello", "World");
		book.setLibraryId(libraryId);
		int res = this.bookRepo.saveBook(book);
		assertEquals(res, 1);
		this.bookRepo.removeAllBooks();
		libRepo.removeAllLibraies();
	}
	
	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void testSaveBookWithError() throws SQLException {
		Book book = new Book("Hello", "World");
		this.bookRepo.saveBook(book);
	}
	
	@Test
	public void testFindBooksByLibraryId() throws SQLException {
		Library library = new Library("library");
		ILibraryRepository libRepo = this.getLibRepo();
		int libraryId = libRepo.saveLibraryAndGetId(library);
		Book book = new Book("Hello", "World");
		Book book1 = new Book("Hello1", "World1");
		book.setLibraryId(libraryId);
		book1.setLibraryId(libraryId);
		this.bookRepo.saveBook(book);
		this.bookRepo.saveBook(book1);
		List<Book> found = this.bookRepo.findBooksByLibraryId(libraryId);
		assertNotNull(found);
		assertEquals(found.size(), 2);
		this.bookRepo.removeAllBooks();
		libRepo.removeAllLibraies();
	}
	
	

}
