package com.BookStoreApplication.Service;

import java.util.List;
import java.util.Optional;

import com.BookStoreApplication.DTO.BooksDto;

public interface BookService {
	
	BooksDto addBook(BooksDto Book);
	BooksDto updateBook(BooksDto Book,int BookId);
	boolean deleteBook(int BookId);
	List<BooksDto> getBooks();
	List<BooksDto> showAllBooks();
	Optional<BooksDto> getBookById(int BookId);

}
