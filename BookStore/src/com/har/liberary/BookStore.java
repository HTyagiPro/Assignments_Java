package com.har.liberary;

public class BookStore extends Book {
	Book[] books;
	String storeName;
	String location;
	int ptr = 0;
	public BookStore() {
		// TODO Auto-generated constructor stub
	}
	public BookStore(Book[] books, String storeName, String location) {
		this.books = books;
		this.storeName = storeName;
		this.location = location;
	}
	
	public void addBook(Book b) throws BookStoreFullException {
		boolean added = false;
		for(int i=0;i<books.length && added == false; i++) {
			
			if(books[i] == null ) {
				books[i] = b;
				added = true;
			}
		}
		if(!added)
			throw new BookStoreFullException("Book space not available");
	}
	
	public void showAllBooks() {
		for(Book i : books) {
			
				System.out.println("------------Books Available------------");
				System.out.println("Book ID : \t" + i.getBookId());
				System.out.println("Book Title : \t" + i.getBookTitle());
				System.out.println("Book Author : \t" + i.getAuthor());
				System.out.println("Book Category : \t" + i.getCategory());
				System.out.println("Book Price : \t" + i.getPrice());
				System.out.println("--------------------------------------");
			
		}
		
		
	}
	
	
	public void searchBooksByCategory(String cat) throws BookNotFoundException{
		boolean found = false;
		for(Book i : books) {
			if(i.getCategory().equals(cat)) {
			System.out.println("------------Books Available------------");
			System.out.println("Book ID : \t" + i.getBookId());
			System.out.println("Book Title : \t" + i.getBookTitle());
			System.out.println("Book Author : \t" + i.getAuthor());
			System.out.println("Book Category : \t" + i.getCategory());
			System.out.println("Book Price : \t" + i.getPrice());
			System.out.println("--------------------------------------");
			found = true;
			}
	}
		if(!found)
			throw new BookNotFoundException("Book not found!!!");
	}
	
	public void searchBooksByTitle(String title) throws BookNotFoundException{
		boolean found = false;
		for(Book i : books) {
			if(i.getBookTitle().equals(title)) {
			System.out.println("------------Books Available------------");
			System.out.println("Book ID : \t" + i.getBookId());
			System.out.println("Book Title : \t" + i.getBookTitle());
			System.out.println("Book Author : \t" + i.getAuthor());
			System.out.println("Book Category : \t" + i.getCategory());
			System.out.println("Book Price : \t" + i.getPrice());
			System.out.println("--------------------------------------");
			found = true;
			}
	}
		if(!found)
			throw new BookNotFoundException("Book not found!!!");
	}
	
	
	
	
	
	
	
	public Book[] getBooks() {
		return books;
	}
	public void setBooks(Book[] books) {
		this.books = books;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
