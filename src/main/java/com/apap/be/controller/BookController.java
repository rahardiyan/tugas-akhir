package com.apap.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.be.model.BookModel;
import com.apap.be.model.BookTypeModel;
import com.apap.be.model.ResultModel;
import com.apap.be.service.BookService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/book")

public class BookController {

	@Autowired 
	private BookService bookService;
	
	
	@GetMapping(value="/view-all")
	public ResponseEntity<Object> GetBook() {
		List<BookModel> lBook = bookService.getAllBook();
		return ResultModel.generateResponse(HttpStatus.OK, "success", lBook);
	}
	
	@GetMapping(value="/view-all-jenis-buku")
	public ResponseEntity<Object> GetBookType() {
		List<BookTypeModel> lBook = bookService.getAllBookType(); 
		return ResultModel.generateResponse(HttpStatus.OK, "success", lBook);
	}
	
	@GetMapping(value="/view/{id}")
	public ResponseEntity<Object> GetBookByID(@PathVariable("id") Long id) {
		BookModel Book = bookService.getBookByID(id).get();
		return ResultModel.generateResponse(HttpStatus.OK, "success", Book);
	}

	@PostMapping(value="/add")
	public ResponseEntity<Object> AddBook(@RequestBody BookModel book) {
		bookService.addBook(book);;
		return ResultModel.generateResponse(HttpStatus.OK, "success", book);
	}

	@PutMapping(value="/update/{id}")
	public ResponseEntity<Object> UpdateBook(@PathVariable("id") long id, @RequestParam("jumlah") int jumlah) {
		BookModel book = bookService.getBookByID(id).get();
		if(book.equals(null)) {
			return ResultModel.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "failed", book);
		}
		book.setJumlahBuku(jumlah);
		bookService.updateBook(book);
		return ResultModel.generateResponse(HttpStatus.OK, "success", book);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<Object> DeleteBook(@RequestParam("id") long id) {
		BookModel book = bookService.getBookByID(id).get();
		if(book.equals(null)) {
			return ResultModel.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "failed", book);
		}
		bookService.deleteBook(book);
		return ResultModel.generateResponse(HttpStatus.OK, "success", null);
	}
	
}
