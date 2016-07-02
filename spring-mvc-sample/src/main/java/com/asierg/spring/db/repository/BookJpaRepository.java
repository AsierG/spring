package com.asierg.spring.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asierg.spring.model.Book;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitleLike(String title);

	List<Book> findByDescriptionLike(String description);

	List<Book> findByTitleLikeAndDescriptionLike(String title, String description);

}
