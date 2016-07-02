package com.asierg.spring.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asierg.spring.model.Action;

@Repository
public interface ActionJpaRepository extends JpaRepository<Action, Long> {

}
