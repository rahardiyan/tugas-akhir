package com.apap.be.service;

import java.util.List;
import java.util.Optional;

import com.apap.be.model.BookModel;
import com.apap.be.model.BookTypeModel;

public interface BookService {

	List<BookModel> getAllBook();
	
	Optional<BookModel> getBookByID(long id);
	
	void addBook(BookModel book);
	
	void updateBook(BookModel book);
	
	void deleteBook(BookModel book);
	
	List<BookTypeModel> getAllBookType();
}
