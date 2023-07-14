package com.har.liberary;

public class Book {
	private int bookId;
	int price;
	String bookTitle;
	String author;
	String category;
	
	
	public Book() {
	}

	public Book(int bookId, int price, String bookTitle, String author, String category) {
		this.bookId = bookId;
		this.price = price;
		this.bookTitle = bookTitle;
		this.author = author;
		this.category = category;
	}
	
	
	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	

}
