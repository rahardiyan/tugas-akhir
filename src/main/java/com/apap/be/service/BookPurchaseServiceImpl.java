package com.apap.be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.be.model.BookPurchaseModel;
import com.apap.be.repository.BookPurchase;

@Service
@Transactional
public class BookPurchaseServiceImpl implements BookPurchaseService {

	@Autowired
	private BookPurchase books;

	@Override
	public List<BookPurchaseModel> getAllBook() {
		return books.findAll();
	}

	@Override
	public Optional<BookPurchaseModel> getBookByID(long id) {
		return books.findById(id);
	}

	@Override
	public void addBook(BookPurchaseModel book) {
		books.save(book);
	}

	@Override
	public void updateBook(BookPurchaseModel book) {
		books.save(book);
		
	}

	@Override
	public void deleteBook(BookPurchaseModel book) {
		books.delete(book);
	}

}
