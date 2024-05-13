package com.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import com.todo.models.TodoItem;
import com.todo.repositories.TodoItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// This class contains test methods for the TodoItemRepository class.
@DataJpaTest
public class TodoItemRepositoryTests {

    // Auto-wired TodoItemRepository instance for accessing database operations
    @Autowired
    private TodoItemRepository repository;

    // Test method to check the findAll() method of the repository
    @Test
    public void testFindAll() {
        List<TodoItem> items = repository.findAll();
        assertEquals(0, items.size());
    }

    // Test method to check the findByCompleteFalse() method of the repository
    @Test
    public void testFindByCompleteFalse() {
        // Creating and saving two TodoItems with different completion statuses
        TodoItem item1 = new TodoItem("Task 1");
        item1.setComplete(false);
        repository.save(item1);

        TodoItem item2 = new TodoItem("Task 2");
        item2.setComplete(true);
        repository.save(item2);

        // Retrieving incomplete items and asserting the result
        List<TodoItem> incompleteItems = repository.findByCompleteFalse();
        assertEquals(1, incompleteItems.size());
        assertEquals("Task 1", incompleteItems.get(0).getName());
    }

    // Test method to check the findByCompleteTrue() method of the repository
    @Test
    public void testFindByCompleteTrue() {
        // Creating and saving two TodoItems with different completion statuses
        TodoItem item1 = new TodoItem("Task 1");
        item1.setComplete(false);
        repository.save(item1);

        TodoItem item2 = new TodoItem("Task 2");
        item2.setComplete(true);
        repository.save(item2);

        // Retrieving completed items and asserting the result
        List<TodoItem> completeItems = repository.findByCompleteTrue();
        assertEquals(1, completeItems.size());
        assertEquals("Task 2", completeItems.get(0).getName());
    }

    // Test method to check the deleteByCompleteFalse() method of the repository
    @Test
    public void testDeleteByCompleteFalse() {
        // Creating and saving two TodoItems with different completion statuses
        TodoItem item1 = new TodoItem("Task 1");
        item1.setComplete(false);
        repository.save(item1);

        TodoItem item2 = new TodoItem("Task 2");
        item2.setComplete(true);
        repository.save(item2);

        // Deleting incomplete items and asserting the result
        repository.deleteByCompleteFalse();
        List<TodoItem> remainingItems = repository.findAll();
        assertEquals(1, remainingItems.size());
        assertEquals("Task 2", remainingItems.get(0).getName());
    }

    // Test method to check the deleteByCompleteTrue() method of the repository
    @Test
    public void testDeleteByCompleteTrue() {
        // Creating and saving two TodoItems with different completion statuses
        TodoItem item1 = new TodoItem("Task 1");
        item1.setComplete(false);
        repository.save(item1);

        TodoItem item2 = new TodoItem("Task 2");
        item2.setComplete(true);
        repository.save(item2);

        // Deleting completed items and asserting the result
        repository.deleteByCompleteTrue();
        List<TodoItem> remainingItems = repository.findAll();
        assertEquals(1, remainingItems.size());
        assertEquals("Task 1", remainingItems.get(0).getName());
    }
}
