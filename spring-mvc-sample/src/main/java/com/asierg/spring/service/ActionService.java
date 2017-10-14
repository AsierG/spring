package com.asierg.spring.service;

import java.util.List;

import com.asierg.spring.model.Action;

 interface ActionService {

	 Action createAction(Action action);

	 List<Action> findAllOrderByDateAsc();

}
