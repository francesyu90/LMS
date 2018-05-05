package com.francesyu90.lms.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.francesyu90.lms.configuration.PicoConfig;
import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.repository.impl.BookRepository;

/**
 * 
 * Note: only run these tests after connecting to real database server
 * 
 */
public class BookRepositoryTest {
	
	private BookRepository bookRepo;
	
	public BookRepositoryTest() {
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

}
