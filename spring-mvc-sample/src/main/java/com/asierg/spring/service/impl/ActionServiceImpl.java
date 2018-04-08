package com.asierg.spring.service.impl;

import com.asierg.spring.db.repository.ActionJpaRepository;
import com.asierg.spring.model.Action;
import com.asierg.spring.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {

    private ActionJpaRepository actionJpaRepository;

    @Autowired
    public ActionServiceImpl(ActionJpaRepository actionJpaRepository) {
        this.actionJpaRepository = actionJpaRepository;
    }

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
