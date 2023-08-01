package com.har.jdbc.bean;

public class Book {
	private String bookID;
	private String bookTitle;
	private String bookAuthor;
	private String bookCategoy;
	private double bookPrice;
	private int copies;
	
	public Book(String bookID, String bookTitle, String bookAuthor, String bookCategoy, double bookPrice, int copies) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookCategoy = bookCategoy;
		this.bookPrice = bookPrice;
		this.copies = copies;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookCategoy() {
		return bookCategoy;
	}

	public void setBookCategoy(String bookCategoy) {
		this.bookCategoy = bookCategoy;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	@Override
	public String toString() {
		return "Book-: \n--------------------\n Book ID: " + bookID + "\nBook Title:" + bookTitle + "\nBook Author: " + bookAuthor + "\nBook Categoy: "
				+ bookCategoy + "\nBook Price: " + bookPrice + "\nCopies: " + copies + " \n--------------------\n";
	}
	
	
	
}
