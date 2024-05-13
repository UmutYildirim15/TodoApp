package com.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.todo.models.TodoItem;
import org.junit.jupiter.api.Test;

// Test class for TodoItem class
public class TodoItemTests {

    // Test method to check TodoItem creation
    @Test
    public void testTodoItemCreation() {
        TodoItem item = new TodoItem("Example Task");
        assertEquals("Example Task", item.getName());
        assertFalse(item.isComplete());
    }
}
