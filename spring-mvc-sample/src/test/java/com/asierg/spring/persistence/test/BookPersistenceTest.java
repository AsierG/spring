package com.asierg.spring.persistence.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.asierg.spring.configuration.AppConfig;
import com.asierg.spring.db.repository.BookJpaRepository;
import com.asierg.spring.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@ActiveProfiles("test")
@WebAppConfiguration
public class BookPersistenceTest {

	@Autowired
	private BookJpaRepository bookJpaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void test_create_and_get_ok() throws Exception {

		Book book = new Book();
		book.setTitle("Ruby Cookbook, 2nd Edition");
		book.setDescription(
				"Why spend time on coding problems that others have already solved when you could be making real progress on your Ruby project? This updated cookbook provides ...");
		book.setWriter("Lucas Carlson");
		book.setPrice(9.9);
		book.setDate(new Date());
		Book savedBook = bookJpaRepository.save(book);

		Book findedBook = bookJpaRepository.findOne(savedBook.getId());
		assertEquals(book.getTitle(), findedBook.getTitle());

	}

	@Test
	public void test_find_by_title_like() throws Exception {

		Book book = new Book();
		book.setTitle("Angular.js and Node.js Programming");
		book.setDescription(
				"AngularJS (commonly referred to as Angular) is an open-source web application framework maintained by Google and by a community of individual developers and corporations to address many...");
		book.setWriter("Asier Darwin");
		book.setPrice(6.0);
		book.setDate(new Date());
		bookJpaRepository.save(book);

		book = new Book();
		book.setTitle("Think Java");
		book.setDescription(
				"Currently used at many colleges, universities, and high schools, this hands-on introduction to computer science is ideal for people with little or no programming experience. The goal of this concise book is not just to teach you Java, but to help you think like a computer scie...");
		book.setWriter("Chris Mayfield");
		book.setPrice(9.2);
		book.setDate(new Date());
		bookJpaRepository.save(book);

		List<Book> books = bookJpaRepository.findByTitleLike("%" + "gular.js and Node." + "%");
		assertEquals("Angular.js and Node.js Programming", books.get(0).getTitle());

	}

	@Test
	public void test_find_by_description_like() throws Exception {

		Book book = new Book();
		book.setTitle("Programming Google App Engine with Java");
		book.setDescription(
				"This practical guide shows intermediate and advanced web and mobile app developers how to build highly scalable Java applications in the cloud with Google App Engine. The flagship of Google's Cloud Platform, App Engine hosts your app on infrastructure that grows automatically with your traffic, minimizing up-front costs and...");
		book.setWriter("Dan Sanderson");
		book.setPrice(8.0);
		book.setDate(new Date());
		bookJpaRepository.save(book);

		book = new Book();
		book.setTitle("Spring MVC for Java Developers");
		book.setDescription(
				"In this Spring MVC for Java Developers training course, expert author Kevin Bowersox will teach you how to develop web applications using the Spring MVC framework. This course is designed for users that are already familiar with Java.");
		book.setWriter("Kevin Bowersox");
		book.setPrice(7.9);
		book.setDate(new Date());
		bookJpaRepository.save(book);

		List<Book> books = bookJpaRepository
				.findByDescriptionLike("%" + "ourse, expert author Kevin Bowersox will teach you how t" + "%");
		assertEquals(book.getTitle(), books.get(0).getTitle());

	}

}
