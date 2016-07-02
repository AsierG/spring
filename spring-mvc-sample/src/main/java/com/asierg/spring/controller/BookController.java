package com.asierg.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asierg.spring.form.SearchBookForm;
import com.asierg.spring.model.Book;
import com.asierg.spring.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController extends GlobalControllerHandler {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String handleAdmin(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult);
			model.addAttribute("errors", true);
		} else {
			if (book.getId() == null) {
				bookService.createBook(book);
				model.addAttribute("info", "saved");
			} else {
				bookService.updateBook(book);
				model.addAttribute("info", "updated");
			}
		}
		return "book/edit-book";
	}

	@RequestMapping(value = "/searchBooks", method = RequestMethod.GET)
	public String searchBooks(@Valid @ModelAttribute("searchBookForm") SearchBookForm searchBookForm,
			BindingResult bindingResult, Model model) {
		List<Book> books = bookService.getBooksBySearchForm(searchBookForm);
		model.addAttribute("results", books);
		return "book/search-books";
	}

	@RequestMapping(value = "/searchBooksModelAndView", method = RequestMethod.GET)
	public ModelAndView searchBooksModelAndView(@Valid @ModelAttribute("searchBookForm") SearchBookForm searchBookForm,
			BindingResult bindingResult, Model model) {
		List<Book> books = bookService.getBooksBySearchForm(searchBookForm);
		model.addAttribute("results", books);
		return new ModelAndView("book/book-results-table", model.asMap());
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showUpdate(Model model, @PathVariable("id") long id) {
		Book book = bookService.findById(id);
		if (book == null) {
			book = new Book();
		}
		model.addAttribute("book", book);
		return "book/edit-book";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody String deletePrueba(@RequestParam(value = "bookId", required = true) Long bookId) {
		String response = null;
		try {
			bookService.delete(bookId);
			response = "deleted";
		} catch (Exception e) {
			response = "error";
		}
		return response;
	}

}