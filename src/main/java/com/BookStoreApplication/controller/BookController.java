package com.BookStoreApplication.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RestController;

import com.BookStoreApplication.DTO.BooksDto;
import com.BookStoreApplication.Service.BookService;

@CrossOrigin(origins="localhost:4200")
@RestController
@RequestMapping(value="/BookController")
public class BookController {
	@Autowired
	private BookService bookservice;
	
	@PostMapping("/addBook")
	public BooksDto addBook(@RequestBody BooksDto bookdto) {
		return bookservice.addBook(bookdto);
		
	}
	@PutMapping("/updateBook/{BookId}")
	public ResponseEntity<BooksDto> updateBook(@PathVariable("BookId") int BookId,  @RequestBody BooksDto bookdto) {
		BooksDto updatedBook=bookservice.updateBook(bookdto,BookId);
		if(updatedBook!=null)
			return new ResponseEntity<>(updatedBook, new HttpHeaders(), HttpStatus.OK);
		else {
			return null;
		} 
		
	}
	
	@DeleteMapping("/deleteBook/{BookId}")
	public boolean deleteBook(@PathVariable("BookId") int BookId) {
		return bookservice.deleteBook(BookId);
	}
	@GetMapping("/viewBooks")
	public ResponseEntity<List<BooksDto>> getBooks(){
		List<BooksDto> result=bookservice.getBooks();
		if(result.isEmpty()) {
			return null;
		}
		return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	

}
