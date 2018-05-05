package com.francesyu90.lms.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
	
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	
	private int id;
	
	private String title;
	
	private String author;

	public Book(String title, String author) {
		this.id = ID_GENERATOR.getAndIncrement();
		this.title = title;
		this.author = author;
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

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
}
