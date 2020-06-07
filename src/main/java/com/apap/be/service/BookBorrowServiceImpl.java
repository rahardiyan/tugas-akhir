package com.apap.be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.be.model.BookBorrowModel;
import com.apap.be.repository.BookBorrow;

@Service
@Transactional
public class BookBorrowServiceImpl implements BookBorrowService {

	@Autowired
	private BookBorrow books;

	@Override
	public List<BookBorrowModel> getAllBook() {
		return books.findAll();
	}

	@Override
	public Optional<BookBorrowModel> getBookByID(long id) {
		return books.findById(id);
	}

	@Override
	public void addBook(BookBorrowModel book) {
		books.save(book);
	}

	@Override
	public void updateBook(BookBorrowModel book) {
		books.save(book);
		
	}

	@Override
	public void deleteBook(BookBorrowModel book) {
		books.delete(book);
	}

}
