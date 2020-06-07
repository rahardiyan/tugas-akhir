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

import com.apap.be.model.BookPurchaseModel;
import com.apap.be.model.ResultModel;
import com.apap.be.service.BookPurchaseService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/book-purchase")

public class BookPurchaseController {

	@Autowired 
	private BookPurchaseService bookService;
	
	
	@GetMapping(value="/view-all")
	public ResponseEntity<Object> GetBook() {
		List<BookPurchaseModel> lBook = bookService.getAllBook();
		return ResultModel.generateResponse(HttpStatus.OK, "success", lBook);
	}
	
	@GetMapping(value="/view/{id}")
	public ResponseEntity<Object> GetBookByID(@PathVariable("id") Long id) {
		BookPurchaseModel Book = bookService.getBookByID(id).get();
		return ResultModel.generateResponse(HttpStatus.OK, "success", Book);
	}

	@PostMapping(value="/add")
	public ResponseEntity<Object> AddBook(@RequestBody BookPurchaseModel book) {
		bookService.addBook(book);;
		return ResultModel.generateResponse(HttpStatus.OK, "success", book);
	}

	@PutMapping(value="/update/{id}")
	public ResponseEntity<Object> UpdateBook(@PathVariable("id") long id, @RequestParam("status") int status) {
		BookPurchaseModel book = bookService.getBookByID(id).get();
		if(book.equals(null)) {
			return ResultModel.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "failed", book);
		}
		book.setStatusPengadaan(status);
		bookService.updateBook(book);
		return ResultModel.generateResponse(HttpStatus.OK, "success", book);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<Object> DeleteBook(@RequestParam("id") long id) {
		BookPurchaseModel book = bookService.getBookByID(id).get();
		if(book.equals(null)) {
			return ResultModel.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "failed", book);
		}
		bookService.deleteBook(book);
		return ResultModel.generateResponse(HttpStatus.OK, "success", null);
	}
	
}
