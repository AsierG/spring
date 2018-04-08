package com.asierg.spring.db.repository;

import com.asierg.spring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleLike(String title);

    List<Book> findByDescriptionLike(String description);

    List<Book> findByTitleLikeAndDescriptionLike(String title, String description);

}
