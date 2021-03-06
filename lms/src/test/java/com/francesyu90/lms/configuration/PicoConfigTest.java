package com.francesyu90.lms.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;

public class PicoConfigTest {
	
	@Test
	public void testPicoAddAndGetCompoent() {
		
		PicoConfig config = new PicoConfig();
		config.addPicoComponent(String.class);
		config.addPicoComponent(Book.class);
		Object obj = config.getPicoComponent(Book.class);
		assertNotNull(obj);
		assertEquals(obj.getClass(), Book.class);
	}
	
	@Test
	public void testPicoAddAndGetCompoentI() {
		
		PicoConfig config = new PicoConfig();
		config.addPicoComponent(String.class);
		config.addPicoComponent(Book.class);
		config.addPicoComponent(Library.class);
		Object obj = config.getPicoComponent(Library.class);
		assertNotNull(obj);
		assertEquals(obj.getClass(), Library.class);
	}

}
