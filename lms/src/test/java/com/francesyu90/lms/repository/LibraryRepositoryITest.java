package com.francesyu90.lms.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;

import com.francesyu90.lms.configuration.DBConfig;
import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.impl.LibraryRepository;

/**
 * 
 * Note: only run these tests after connecting to real database server
 * 
 */
public class LibraryRepositoryITest {
	
	private ILibraryRepository libRepo;
	
	public LibraryRepositoryITest() throws SQLException {
		DataSource dataSource = DBConfig.setUpPool();
		this.libRepo = new LibraryRepository(dataSource);
	}
	
	@Test
	public void testGetAllLibraries() throws SQLException {
		List<Library> libraries = this.libRepo.getAllLibraries();
		assertNotNull(libraries);
		assertTrue(libraries.isEmpty());
	}
	
	@Test
	public void testSaveLibrary() throws SQLException {
		Library library = new Library("library");
		int res = this.libRepo.saveLibrary(library);
		assertEquals(res, 1);
		List<Library> libraries = this.libRepo.getAllLibraries();
		assertNotNull(libraries);
		assertEquals(libraries.size(), 1);
		this.libRepo.removeAllLibraies();
	}
	
	@Test
	public void testFindLibraryByName() throws SQLException {
		String name = "library1";
		Library library = new Library(name);
		this.libRepo.saveLibrary(library);
		Library found = this.libRepo.findByName(name);
		assertNotNull(found);
		this.libRepo.removeAllLibraies();
	}
	
	@Test
	public void testRemoveLibrary() throws SQLException {
		String name = "library1";
		Library library = new Library(name);
		this.libRepo.saveLibrary(library);
		int res = this.libRepo.removeLibraryByName(library);
		assertEquals(res, 1);
	}
	
	

}
