//package com.francesyu90.lms.service;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.sql.SQLException;
//
//import org.junit.Test;
//
//import com.francesyu90.lms.configuration.PicoConfig;
//import com.francesyu90.lms.repository.impl.BookRepository;
//import com.francesyu90.lms.repository.impl.LibraryRepository;
//import com.francesyu90.lms.service.impl.GeneralService;
//
///**
// * 
// * Note: 
// * 	only run these tests after connecting to real database server
// *	only run these tests when using test database
// * 
// */
//public class GeneralServiceTest {
//	
//	private IGeneralService generalService;
//	
//	public GeneralServiceTest() {
//		PicoConfig pico = new PicoConfig();
//		pico.addPicoComponent(LibraryRepository.class);
//		pico.addPicoComponent(BookRepository.class);
//		pico.addPicoComponent(GeneralService.class);
//		this.generalService = (IGeneralService) pico.getPicoComponent(GeneralService.class);
//	}
//	
//	@Test
//	public void testGeneralServiceVar() {
//		assertNotNull(this.generalService);
//	}
//	
//	@Test
//	public void testAddLibrary() throws SQLException {
//		boolean res = this.generalService.addLibrary();
//		assertTrue(res);
//	}
//
//}
