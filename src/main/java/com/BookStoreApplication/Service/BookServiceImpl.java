package com.BookStoreApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStoreApplication.DAO.BooksDao;
import com.BookStoreApplication.DTO.BooksDto;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BooksDao booksdao;

	@Override
	public BooksDto addBook(BooksDto Book) {
		// TODO Auto-generated method stub
		return booksdao.save(Book);
	}

	@Override
	public BooksDto updateBook(BooksDto Book, int BookId) {
		// TODO Auto-generated method stub
		Optional<BooksDto> bookobj=booksdao.findById(BookId);	
		if((bookobj.isPresent())){
			BooksDto newEntity = bookobj.get();	
			newEntity.setBookName(Book.getBookName());
			newEntity.setBookAuthor(Book.getBookAuthor());
	        newEntity.setBookPrice(Book.getBookPrice());
	        newEntity = booksdao.save(newEntity);
	        return newEntity;
	    }
		else {
			return null;
		}
	}

	@Override
	public boolean deleteBook(int BookId) {
		// TODO Auto-generated method stub
		Optional<BooksDto> bookobj=booksdao.findById(BookId);
		if(bookobj.isPresent()) {
			booksdao.deleteById(BookId);
			return true;
		}
		else {
			return false;	
		}
	}

	@Override
	public List<BooksDto> getBooks() {
		// TODO Auto-generated method stub
		return booksdao.findAll();
	}

	@Override
	public List<BooksDto> showAllBooks() {
		// TODO Auto-generated method stub
		return booksdao.findAll();
	}

	@Override
	public Optional<BooksDto> getBookById(int BookId) {
		// TODO Auto-generated method stub
		return booksdao.findById(BookId);
	}
	

}
