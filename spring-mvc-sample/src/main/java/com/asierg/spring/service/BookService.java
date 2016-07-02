package com.asierg.spring.service;

import java.util.List;

import com.asierg.spring.form.SearchBookForm;
import com.asierg.spring.model.Book;

public interface BookService {

	public Book createBook(Book book);

	public Book updateBook(Book bookDto);

	public List<Book> getAllBooks();

	public List<Book> getBooksBySearchForm(SearchBookForm searchBookForm);

	public void delete(Long id);

	public Book findById(Long id);

}
