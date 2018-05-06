package com.francesyu90.lms.service;

import java.sql.SQLException;

public interface IGeneralService {
	
	public boolean addLibrary() throws SQLException;

	public boolean listLibraries() throws SQLException;
	
	public boolean removeLibraryById() throws SQLException;

}
