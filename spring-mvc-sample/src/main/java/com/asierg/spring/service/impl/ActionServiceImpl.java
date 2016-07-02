package com.asierg.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asierg.spring.db.repository.ActionJpaRepository;
import com.asierg.spring.model.Action;
import com.asierg.spring.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {

	@Autowired
	private ActionJpaRepository actionJpaRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Action createAction(Action action) {
		return actionJpaRepository.save(action);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<Action> findAllOrderByDateAsc() {
		return actionJpaRepository.findAll();
	}

}
