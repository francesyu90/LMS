package com.francesyu90.lms.repository;

import java.sql.SQLException;
import java.util.List;

import com.francesyu90.lms.domain.Library;

public interface ILibraryRepository {
	
	public int saveLibrary(Library library) throws SQLException;
	
	public List<Library> getAllLibraries() throws SQLException;
	
	public Library findByName(String name) throws SQLException;
	
	public int removeLibraryByName(Library library) throws SQLException;

	public int removeAllLibraies() throws SQLException;
	
}
