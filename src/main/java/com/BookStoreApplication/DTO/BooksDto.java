package com.BookStoreApplication.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class BooksDto {
	@Id
	@GeneratedValue
	private int BookId;
	
	@NotNull
	@Size(min = 2, message = "BookName should have at least 2 character")
	private String BookName;
	
	@NotNull
	@Size(min = 3, message = "BookAuthor should have at least 3 character")
	private String BookAuthor;
	
	private int BookPrice;
	
	
	
	
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public int getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(int bookPrice) {
		BookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "BooksDto [BookId=" + BookId + ", BookName=" + BookName + ", BookAuthor=" + BookAuthor + ", BookPrice="
				+ BookPrice + "]";
	}

	
}
