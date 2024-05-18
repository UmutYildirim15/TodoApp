package com.todo.controllers.Impl;

import com.todo.models.TodoItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITodoRestController {
    public ResponseEntity<List<TodoItem>> getAllTasks();
    public ResponseEntity<TodoItem> addTask(@RequestBody TodoItem requestItem);
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody TodoItem updatedItem);
    public ResponseEntity<List<TodoItem>> showLowPriorityTasks();
    public ResponseEntity<List<TodoItem>> showMediumPriorityTasks();
    public ResponseEntity<List<TodoItem>> showHighPriorityTasks();
    public ResponseEntity<List<TodoItem>> getDoneTasks();
    public ResponseEntity<List<TodoItem>> getTodoTasks();
    public ResponseEntity<String> removeTask(@PathVariable Long id);
}
