package com.francesyu90.lms.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.francesyu90.lms.domain.Book;

public class AppConfigTest {
	
	@Test
	public void testPicoAddAndGetCompoent() {
		
		AppConfig config = new AppConfig();
		config.addPicoComponent(String.class);
		config.addPicoComponent(Book.class);
		Object obj = config.getPicoComponent(Book.class);
		assertNotNull(obj);
		assertEquals(obj.getClass(), Book.class);
	}

}
