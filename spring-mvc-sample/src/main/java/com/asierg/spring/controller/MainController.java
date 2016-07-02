package com.asierg.spring.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asierg.spring.form.SearchBookForm;
import com.asierg.spring.model.Action;
import com.asierg.spring.model.Book;
import com.asierg.spring.service.ActionService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private ActionService actionService;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String orderHome(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/createBook", method = RequestMethod.GET)
	public String processBooks(ModelMap model) {
		model.addAttribute("book", new Book());
		return "book/edit-book";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String viewBooks(Model model) {
		SearchBookForm searchBookForm = new SearchBookForm();
		model.addAttribute("searchBookForm", searchBookForm);
		return "book/search-books";
	}

	@RequestMapping(value = "/viewActions", method = RequestMethod.GET)
	public String viewActions(Model model) {
		List<Action> actions = actionService.findAllOrderByDateAsc();
		model.addAttribute("results", actions);
		return "action/actions";
	}

}