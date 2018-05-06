package com.francesyu90.lms.service;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;

import com.francesyu90.lms.configuration.DBConfig;
import com.francesyu90.lms.configuration.PicoConfig;
import com.francesyu90.lms.repository.impl.BookRepository;
import com.francesyu90.lms.repository.impl.LibraryRepository;
import com.francesyu90.lms.service.impl.GeneralService;

/**
 * 
 * Note: 
 * 	only run these tests after connecting to real database server
 * 	only run when using test database
 * 
 */
public class GeneralServiceTest {
	
	private IGeneralService generalService;
	
	public GeneralServiceTest() throws SQLException {
		DataSource dataSource = DBConfig.setUpPool();
		PicoConfig pico = new PicoConfig();
		pico.addPicoComponent(new LibraryRepository(dataSource));
		pico.addPicoComponent(new BookRepository(dataSource));
		pico.addPicoComponent(GeneralService.class);
		this.generalService = (IGeneralService) pico.getPicoComponent(GeneralService.class);
	}
	
	@Test
	public void testGeneralServiceVar() {
		assertNotNull(this.generalService);
	}
	
	@Test
	@Ignore
	public void testListLibraries() throws SQLException {
		this.generalService.addLibrary();
		this.generalService.listLibraries();
		this.generalService.removeLibraryById();
		this.generalService.listLibraries();
	}


}
