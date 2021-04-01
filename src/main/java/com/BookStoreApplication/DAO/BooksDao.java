package com.BookStoreApplication.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStoreApplication.DTO.BooksDto;

@Repository
public interface BooksDao extends JpaRepository<BooksDto, Integer>{

}
