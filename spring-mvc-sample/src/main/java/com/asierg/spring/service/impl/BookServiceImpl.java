package com.asierg.spring.service.impl;

import com.asierg.spring.annotations.LogSampleMethod;
import com.asierg.spring.db.repository.BookJpaRepository;
import com.asierg.spring.form.SearchBookForm;
import com.asierg.spring.model.Book;
import com.asierg.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookJpaRepository bookJpaRepository;

    @Autowired
    public BookServiceImpl(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @LogSampleMethod(action = LogSampleMethod.Action.CREATE)
    public Book createBook(Book book) {
        return bookJpaRepository.save(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @LogSampleMethod(action = LogSampleMethod.Action.UPDATE)
    public Book updateBook(Book bookDto) {
        Book book = bookJpaRepository.findOne(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setDate(bookDto.getDate());
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        return bookJpaRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Book> getAllBooks() {
        return bookJpaRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    @LogSampleMethod(action = LogSampleMethod.Action.DELETE)
    public void delete(Long id) {
        bookJpaRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @LogSampleMethod(action = LogSampleMethod.Action.VIEW)
    public Book findById(Long id) {
        return bookJpaRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Book> getBooksBySearchForm(SearchBookForm searchBookForm) {
        List<Book> books = null;
        if (!StringUtils.isEmpty(searchBookForm.getTitle()) && StringUtils.isEmpty(searchBookForm.getDescription())) {
            books = bookJpaRepository.findByTitleLike("%" + searchBookForm.getTitle() + "%");
        } else if (StringUtils.isEmpty(searchBookForm.getTitle())
                && !StringUtils.isEmpty(searchBookForm.getDescription())) {
            books = bookJpaRepository.findByDescriptionLike("%" + searchBookForm.getDescription() + "%");
        } else if (!StringUtils.isEmpty(searchBookForm.getTitle())
                && !StringUtils.isEmpty(searchBookForm.getDescription())) {
            books = bookJpaRepository.findByTitleLikeAndDescriptionLike("%" + searchBookForm.getTitle() + "%",
                    "%" + searchBookForm.getDescription() + "%");
        } else {
            books = bookJpaRepository.findAll();
        }
        return books;
    }

}
