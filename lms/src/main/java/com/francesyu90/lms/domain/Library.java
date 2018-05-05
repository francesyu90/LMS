package com.francesyu90.lms.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Library {
	
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	
	private int id;
	
	private String name;
	
	private List<Book> books;
	
	public Library(String name) {
		this.id = ID_GENERATOR.getAndIncrement();
		this.name = name;
		this.books = new ArrayList<Book>();
	}

	public Library(String name, List<Book> books) {
		this.id = ID_GENERATOR.getAndIncrement();
		this.name = name;
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
}
