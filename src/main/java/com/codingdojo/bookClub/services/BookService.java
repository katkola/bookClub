package com.codingdojo.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookClub.models.Book;
import com.codingdojo.bookClub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public Book create(Book b) {
		return bookRepo.save(b);
	}
	
	public Book getById(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		
		if(book.isEmpty()) {
			return null;
		}
		return book.get();
	}

	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
}
