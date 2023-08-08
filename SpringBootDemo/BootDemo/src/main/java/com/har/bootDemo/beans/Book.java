package com.har.bootDemo.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	private String bookid;
	@Column(name = "book_title")
	private String booktitle;
	@Column(name = "boot_author")
	private String bootauthor;
	@Column(name = "book_category")
	private String bookcategoy;
	@Column(name = "book_price")
	private double bookprice;
	private int copies;
	
	

	public Book() {
	}

	

	public Book(String bookid, String booktitle, String bookauthor, String bookcategoy, double bookprice,
			int copies) {
		this.bookid = bookid;
		this.booktitle = booktitle;
		this.bootauthor = bookauthor;
		this.bookcategoy = bookcategoy;
		this.bookprice = bookprice;
		this.copies = copies;
	}


	


	public String getBookid() {
		return bookid;
	}



	public void setBookid(String bookid) {
		this.bookid = bookid;
	}



	public String getBooktitle() {
		return booktitle;
	}



	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}



	public String getBootauthor() {
		return bootauthor;
	}



	public void setBootauthor(String bootauthor) {
		this.bootauthor = bootauthor;
	}



	public String getBookcategoy() {
		return bookcategoy;
	}



	public void setBookcategoy(String bookcategoy) {
		this.bookcategoy = bookcategoy;
	}



	public double getBookprice() {
		return bookprice;
	}



	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}



	public int getCopies() {
		return copies;
	}



	public void setCopies(int copies) {
		this.copies = copies;
	}



	@Override
	public String toString() {
		return "Book-: \n--------------------\nBook ID: " + bookid + "\nBook Title:" + booktitle + "\nBook Author: " + bootauthor + "\nBook Categoy: "
				+ bookcategoy + "\nBook Price: " + bookprice + "\nCopies: " + copies + " \n--------------------\n";
	}
	
	
	
}
