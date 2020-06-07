package com.apap.be.service;

import java.util.List;
import java.util.Optional;

import com.apap.be.model.BookBorrowModel;

public interface BookBorrowService {

	List<BookBorrowModel> getAllBook();
	
	Optional<BookBorrowModel> getBookByID(long id);
	
	void addBook(BookBorrowModel book);
	
	void updateBook(BookBorrowModel book);
	
	void deleteBook(BookBorrowModel book);
}
