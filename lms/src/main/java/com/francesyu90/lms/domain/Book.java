package com.francesyu90.lms.domain;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {
	
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	
	private int id;
	
	private String title;
	
	private String author;
	
	private Optional<Integer> libraryId;

	public Book(String title, String author) {
		this.id = ID_GENERATOR.getAndIncrement();
		this.title = title;
		this.author = author;
		this.libraryId = Optional.empty();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public Optional<Integer> getOptionalLibraryId() {
		return this.libraryId;
	}
	
	public int getLibraryId() {
		return this.libraryId.orElse(0);
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = Optional.of(libraryId);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
}
