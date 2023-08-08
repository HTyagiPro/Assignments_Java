package com.har.bootDemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.bootDemo.beans.Book;

public interface BookRepository extends JpaRepository<Book, String> {
	//Optional<Book> findBookByBook_title(String book_title); 
	//List<Book> findBookByCategoy(String book_categoy); 
}
