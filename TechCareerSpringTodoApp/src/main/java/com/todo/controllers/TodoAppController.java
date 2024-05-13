package com.todo.controllers;

import com.todo.models.Priority;
import com.todo.models.TodoItem;
import com.todo.repositories.TodoItemRepository;
import com.todo.models.TodoListViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

// That controller manages the operations in the TodoApp via routing them to index view and thymeleaf codes in index.html.
@Controller
public class TodoAppController {

	@Autowired
	private TodoItemRepository repository;

	// Endpoint to display all tasks on the index page.
	@GetMapping("/")
	public String index(Model model) {
		Iterable<TodoItem> todoList = repository.findAll();
		model.addAttribute("items", new TodoListViewModel(todoList));
		model.addAttribute("newitem", new TodoItem());
		return "index";
	}

	// Endpoint to display all tasks on the index page.
	@GetMapping("/showAllTasks")
	public String showAllTasks(Model model) {
		Iterable<TodoItem> todoList = repository.findAll();
		model.addAttribute("items", new TodoListViewModel(todoList));
		model.addAttribute("newitem", new TodoItem());
		return "index";
	}

	// Endpoint to display only completed tasks on the index page.
	@GetMapping("/showDoneTasks")
	public String showDoneTasks(Model model) {
		Iterable<TodoItem> todoList = repository.findByCompleteTrue();
		model.addAttribute("items", new TodoListViewModel(todoList));
		model.addAttribute("newitem", new TodoItem());
		return "index";
	}

	// Endpoint to display only incomplete tasks on the index page.
	@GetMapping("/showTodoTasks")
	public String showTodoTasks(Model model) {
		Iterable<TodoItem> todoList = repository.findByCompleteFalse();
		model.addAttribute("items", new TodoListViewModel(todoList));
		model.addAttribute("newitem", new TodoItem());
		return "index";
	}

	// Endpoint to add a new task.
	@PostMapping("/add")
	public String add(@ModelAttribute TodoItem requestItem) {
		TodoItem item = new TodoItem(requestItem.getName());
		item.setPriority(Priority.MEDIUM); // Set priority to MEDIUM default.
		repository.save(item);
		return "redirect:/";
	}

	// Endpoint to update tasks including priority.
	@PostMapping("/update/{id}")
	public String update(@PathVariable Long id, @RequestParam String newName, @RequestParam(required = false) Optional<Priority> priority) {
		Optional<TodoItem> optionalItem = repository.findById(id);
		if (optionalItem.isPresent()) {
			TodoItem item = optionalItem.get();
			item.setName(newName);
			priority.ifPresent(item::setPriority); // Set priority if present
			repository.save(item);
		}
		return "redirect:/";
	}

	// Endpoint to remove a task.
	@PostMapping("/remove")
	public String remove(@ModelAttribute TodoItem item) {
		repository.deleteById(item.getId());
		return "redirect:/";
	}

	// Endpoint to toggle the completion status of a task.
	@PostMapping("/toggleComplete/{id}")
	public String toggleComplete(@PathVariable Long id) {
		Optional<TodoItem> optionalItem = repository.findById(id);
		if (optionalItem.isPresent()) {
			TodoItem item = optionalItem.get();
			item.setComplete(!item.isComplete()); // toggle `complete` value
			repository.save(item);
		}
		return "redirect:/";
	}

	// Endpoint to delete all tasks.
	@PostMapping("/deleteAllTasks")
	public String deleteAllTasks() {
		repository.deleteAll();
		return "redirect:/";
	}

	// Endpoint to delete all completed tasks.
	@Transactional
	@PostMapping("/deleteDoneTasks")
	public String deleteDoneTasks() {
		repository.deleteByCompleteTrue();
		System.out.println("Deleted done tasks");
		return "redirect:/";
	}
	// Endpoint to display only low priority tasks on the index page.
	@GetMapping("/showLowPriority")
	public String showLowPriority(Model model) {
		Iterable<TodoItem> todoList = repository.findByPriority(Priority.LOW);
		model.addAttribute("items", new TodoListViewModel(todoList));
		model.addAttribute("newitem", new TodoItem());
		return "index";
	}

	// Endpoint to display only medium priority tasks on the index page.
	@GetMapping("/showMediumPriority")
	public String showMediumPriority(Model model) {
		Iterable<TodoItem> todoList = repository.findByPriority(Priority.MEDIUM);
		model.addAttribute("items", new TodoListViewModel(todoList));
		model.addAttribute("newitem", new TodoItem());
		return "index";
	}

	// Endpoint to display only high priority tasks on the index page.
	@GetMapping("/showHighPriority")
	public String showHighPriority(Model model) {
		Iterable<TodoItem> todoList = repository.findByPriority(Priority.HIGH);
		model.addAttribute("items", new TodoListViewModel(todoList));
		model.addAttribute("newitem", new TodoItem());
		return "index";
	}

	// Endpoint to update the name of a task.
	@PostMapping("/updateName/{id}")
	public String updateName(@PathVariable Long id, @RequestParam String newName) {
		Optional<TodoItem> optionalItem = repository.findById(id);
		if (optionalItem.isPresent()) {
			TodoItem item = optionalItem.get();
			item.setName(newName);
			repository.save(item);
		}
		return "redirect:/";
	}
}
