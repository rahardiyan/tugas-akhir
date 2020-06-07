package com.apap.be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.be.model.BookModel;
import com.apap.be.model.BookTypeModel;
import com.apap.be.repository.Book;
import com.apap.be.repository.BookType;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private Book books;
	
	@Autowired
	private BookType booksType;

	@Override
	public List<BookModel> getAllBook() {
		return books.GetAllBook();
	}

	@Override
	public Optional<BookModel> getBookByID(long id) {
		return books.findById(id);
	}

	@Override
	public void addBook(BookModel book) {
		books.save(book);
	}

	@Override
	public void updateBook(BookModel book) {
		books.save(book);
		
	}

	@Override
	public void deleteBook(BookModel book) {
		books.delete(book);
	}

	@Override
	public List<BookTypeModel> getAllBookType() {
		return booksType.findAll();
	}

}
