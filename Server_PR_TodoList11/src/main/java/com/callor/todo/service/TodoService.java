package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.TodoVO;


public interface TodoService {

	public List<TodoVO> selectAll();
	
	public TodoVO findById(Long seq);
	
	public Integer insert(TodoVO tdVO);
	public Integer update(TodoVO tdVO);
	public Integer delete(Long seq);
	
}
