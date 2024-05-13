package com.todo.repositories;

import com.todo.models.Priority;
import com.todo.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This code defines a Spring Data JPA repository interface TodoItemRepository for managing TodoItem entities,
// providing methods to retrieve TodoItems based on their completion status and delete completed TodoItems.

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByCompleteFalse();
    List<TodoItem> findByCompleteTrue();
    void deleteByCompleteFalse();  // It is not necessary now however it could be.
    void deleteByCompleteTrue();

    List<TodoItem> findByPriority(Priority priority);
}
