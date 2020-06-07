package com.apap.be.service;

import java.util.List;
import java.util.Optional;

import com.apap.be.model.BookPurchaseModel;
public interface BookPurchaseService {

	List<BookPurchaseModel> getAllBook();
	
	Optional<BookPurchaseModel> getBookByID(long id);
	
	void addBook(BookPurchaseModel book);
	
	void updateBook(BookPurchaseModel book);
	
	void deleteBook(BookPurchaseModel book);

}
