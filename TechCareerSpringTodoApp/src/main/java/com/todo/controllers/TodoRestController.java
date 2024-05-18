package com.todo.controllers;

import com.todo.controllers.Impl.ITodoRestController;
import com.todo.models.Priority;
import com.todo.repositories.*;
import com.todo.models.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// This controller class defines REST endpoints for managing TodoItem entities.

@RestController
@RequestMapping(path = "/api/todo")
public class TodoRestController implements ITodoRestController {

    @Autowired
    private TodoItemRepository repository;

    // Endpoint to get all tasks.
    @GetMapping("/all")
    public ResponseEntity<List<TodoItem>> getAllTasks() {
        List<TodoItem> todoList = repository.findAll();
        return ResponseEntity.ok(todoList);
    }

    // Endpoint to add a new task.
    @PostMapping("/add")
    public ResponseEntity<TodoItem> addTask(@RequestBody TodoItem requestItem) {
        TodoItem item = new TodoItem(requestItem.getName());
        repository.save(item);
        return ResponseEntity.ok(item);
    }

    // Endpoint to update an existing task including priority.
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TodoItem updatedItem) {
        Optional<TodoItem> optionalItem = repository.findById(id);
        if (optionalItem.isPresent()) {
            TodoItem item = optionalItem.get();
            item.setName(updatedItem.getName());
            item.setComplete(updatedItem.isComplete());
            item.setPriority(updatedItem.getPriority());
            repository.save(item);
            return ResponseEntity.ok("Task updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to display only low priority tasks.
    @GetMapping("/lowPriority")
    public ResponseEntity<List<TodoItem>> showLowPriorityTasks() {
        List<TodoItem> todoList = repository.findByPriority(Priority.LOW);
        return ResponseEntity.ok(todoList);
    }

    // Endpoint to display only medium priority tasks.
    @GetMapping("/mediumPriority")
    public ResponseEntity<List<TodoItem>> showMediumPriorityTasks() {
        List<TodoItem> todoList = repository.findByPriority(Priority.MEDIUM);
        return ResponseEntity.ok(todoList);
    }

    // Endpoint to display only high priority tasks.
    @GetMapping("/highPriority")
    public ResponseEntity<List<TodoItem>> showHighPriorityTasks() {
        List<TodoItem> todoList = repository.findByPriority(Priority.HIGH);
        return ResponseEntity.ok(todoList);
    }



    // Endpoint to get all completed tasks.
    @GetMapping("/done")
    public ResponseEntity<List<TodoItem>> getDoneTasks() {
        List<TodoItem> todoList = repository.findByCompleteTrue();
        return ResponseEntity.ok(todoList);
    }

    // Endpoint to get all incomplete tasks.
    @GetMapping("/todo")
    public ResponseEntity<List<TodoItem>> getTodoTasks() {
        List<TodoItem> todoList = repository.findByCompleteFalse();
        return ResponseEntity.ok(todoList);
    }

    // Endpoint to remove a task.
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeTask(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Task removed successfully");
    }
}
