package com.asierg.spring.service;

import com.asierg.spring.model.Action;

import java.util.List;

public interface ActionService {

    Action createAction(Action action);

    List<Action> findAllOrderByDateAsc();

}
