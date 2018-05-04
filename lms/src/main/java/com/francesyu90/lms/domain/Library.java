package com.francesyu90.lms.domain;

import java.util.List;

public class Library {
	
	private int id;
	
	private String name;
	
	private List<Book> books;
	
	public Library(String name) {
		super();
		this.name = name;
	}

	public Library(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}

	public Library(int id, String name, List<Book> books) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
}
