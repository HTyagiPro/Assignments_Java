package com.har.jdbc.service;
import com.har.jdbc.bean.Book;
import java.util.Scanner;

import com.har.jdbc.dao.BookDAO;

public class BookService {
	private static Scanner scan = new Scanner(System.in);
	private BookDAO bdao = new BookDAO();
	public String addBook() {
		System.out.println("Enter Book ID: ");
		String book_id = scan.nextLine();
		System.out.println("Enter Book Title: ");
		String book_title = scan.nextLine();
		System.out.println("Enter Book Author Name: ");
		String book_author = scan.nextLine();
		System.out.println("Enter Book Category: ");
		String book_category = scan.nextLine();
		System.out.println("Enter Book Price: ");
		double book_price = scan.nextDouble();
		System.out.println("Enter Book Copies Available: ");
		int book_copies = scan.nextInt();
		scan.close();
		
		//scan.next();
		if(bdao.insertBook(new Book(book_id, book_title, book_author, book_category, book_price, book_copies)))
			return "Book Details Added";
		return "Operation to add Book Failed!!!";
			
		
	}
	
	public void showAllBook() {
		BookDAO bdao = new BookDAO();
		for (Book b :bdao.getAllBook())
			System.out.println(b);
	}
	
	public void showBookByTitle() {
		System.out.println("Enter Book Title: ");
		String title = scan.nextLine();
		BookDAO bdao = new BookDAO();
		System.out.println(bdao.getBookByTitle(title));
		scan.close();
	}
	
	public void showBookByCategory() {
		BookDAO bdao = new BookDAO();
		System.out.println("Enter Book Category: ");
		String category = scan.nextLine();
		
		for (Book b :bdao.getBookByCategory(category))
			System.out.println(b);
		scan.close();
	}

	public void deleteBookByTitle() {
		// TODO Auto-generated method stub
		BookDAO bdao = new BookDAO();
		System.out.println("Enter Book Title: ");
		String title = scan.nextLine();
		if(bdao.deleteBookByTitle(title))
			System.out.println(title + " Deleted Successfully!!!");
		else
			System.out.println("Book "+title+" doesn't exist!!!");
		
		scan.close();
		
	}
	
	
}
