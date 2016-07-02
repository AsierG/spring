package com.asierg.spring.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.asierg.spring.editor.PricePropertyEditor;

public class GlobalControllerHandler extends ConfigurableWebBindingInitializer {

	public static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	@InitBinder
	public void registerCustomEditors(WebDataBinder binder, WebRequest webRequest) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(SIMPLE_DATE_FORMAT, true));
		binder.registerCustomEditor(Double.class, "price", new PricePropertyEditor());
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) throws StaleObjectStateException {
		return "error";
	}

}
