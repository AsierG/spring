package com.asierg.spring.db.repository;

import com.asierg.spring.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionJpaRepository extends JpaRepository<Action, Long> {

}
