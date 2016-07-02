package com.asierg.spring.service;

import java.util.List;

import com.asierg.spring.model.Action;

public interface ActionService {

	public Action createAction(Action action);

	public List<Action> findAllOrderByDateAsc();

}
