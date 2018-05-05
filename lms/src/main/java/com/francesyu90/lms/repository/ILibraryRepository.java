package com.francesyu90.lms.repository;

import java.sql.SQLException;
import java.util.List;

import com.francesyu90.lms.domain.Library;

public interface ILibraryRepository {
	
	public int saveLibrary(Library library) throws SQLException;
	
	public List<Library> getAllLibraries() throws SQLException;

}
