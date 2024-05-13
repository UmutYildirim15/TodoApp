package com.todo.models;


import lombok.Getter;

import java.util.ArrayList;

import javax.validation.Valid;

// That model only used to show todoList items easily.
// For instance, via using Thymeleaf, todoList can be showed easily in the index.html file.
@Getter
public class TodoListViewModel {

	@Valid
	private ArrayList<TodoItem> todoList = new ArrayList<>();
	public TodoListViewModel(Iterable<TodoItem> items) {
		items.forEach(todoList:: add);
	}

}