package com.asierg.spring.service;

import com.asierg.spring.form.SearchBookForm;
import com.asierg.spring.model.Book;

import java.util.List;

interface BookService {

    Book createBook(Book book);

    Book updateBook(Book bookDto);

    List<Book> getAllBooks();

    List<Book> getBooksBySearchForm(SearchBookForm searchBookForm);

    void delete(Long id);

    Book findById(Long id);

}
