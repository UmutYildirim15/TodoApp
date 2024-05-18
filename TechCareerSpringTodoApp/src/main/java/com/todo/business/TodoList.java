package com.todo.business;
import com.todo.models.TodoItem;
import lombok.Getter;
import java.util.ArrayList;
import javax.validation.Valid;

// That class only used to show todoList items easily.
// For instance, via using Thymeleaf, todoList can be showed easily in the index.html file.
@Getter
public class TodoList {

	@Valid
	private ArrayList<TodoItem> todoList = new ArrayList<>();
	public TodoList(Iterable<TodoItem> items) {
		items.forEach(todoList:: add);
	}

}