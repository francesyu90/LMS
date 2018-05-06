package com.francesyu90.lms.service.impl;

import java.sql.SQLException;
import java.util.Scanner;

import com.francesyu90.lms.domain.Book;
import com.francesyu90.lms.domain.Library;
import com.francesyu90.lms.repository.IBookRepository;
import com.francesyu90.lms.repository.ILibraryRepository;
import com.francesyu90.lms.service.IGeneralService;

public class GeneralService implements IGeneralService {
	
	private ILibraryRepository libRepo;
	private IBookRepository bookRepo;
	private Scanner scanner;
	
	public GeneralService(
			ILibraryRepository libRepo, IBookRepository bookRepo) {
		this.libRepo = libRepo;
		this.bookRepo = bookRepo;
		this.scanner = new Scanner(System.in);
	}

	public boolean addLibrary() throws SQLException {
		
		this.logln("Please enter a name for the new library: ");
		String name = this.scanner.nextLine();
		Library library = new Library(name);
		int libraryId = this.libRepo.saveLibraryAndGetId(library);
		
		boolean next = false;
		while(!next) {
			this.logln("Please enter the title of the new book: ");
			String title = this.scanner.nextLine();
			this.logln("Please enter the author of the new book: ");
			String author = this.scanner.nextLine();
			Book book = new Book(title, author);
			book.setLibraryId(libraryId);
			this.bookRepo.saveBook(book);
			this.logln("Would you like to add more books? ['y' for YES only]");
			String res = this.scanner.nextLine();
			next = (res.equals("y"))? false : true;
		}
		
		return true;
	}
	
	public void logln(String message) {
		System.out.println(message);
	}
	
	

}
