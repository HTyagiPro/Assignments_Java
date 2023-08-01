package com.har.jdbc;

import java.util.Scanner;

import com.har.jdbc.service.BookService;

public class MainBook {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		do {
			System.out.println("Add Book ---------------------> [ 1 ]");
			System.out.println("Show All Books ---------------> [ 2 ]");
			System.out.println("Show Books by Categories -----> [ 3 ]");
			System.out.println("Show Boks by Title -----------> [ 4 ]");
			System.out.println("Delete Book by Title ---------> [ 5 ]");
			System.out.println("EXIT -------------------------> [ 6 ]");
			opt = scan.nextInt();
			
			switch(opt) {
			case 1:
				bookService.addBook();
				break;
			case 2:
				bookService.showAllBook();
				break;
			case 3:
				bookService.showBookByCategory();
				break;
			case 4:
				bookService.showBookByTitle();
				break;
			case 5:
				bookService.deleteBookByTitle();
				break;
			case 6:
				System.out.println("You are quitting Menu!!!");
				break;
				default:
					System.out.println("Not a Correct Option");
					break;
			}
			
		}while(opt!=6);
		scan.close();
	}
}
