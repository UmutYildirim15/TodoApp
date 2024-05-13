package com.todo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// Integration tests for the TodoController class
@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    // Test method for checking the functionality of showing all tasks
    @Test
    public void testShowAllTasks() throws Exception {
        mockMvc.perform(get("/showAllTasks"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    // Test method for checking the functionality of showing done tasks
    @Test
    public void testShowDoneTasks() throws Exception {
        mockMvc.perform(get("/showDoneTasks"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    // Test method for checking the functionality of showing todo tasks
    @Test
    public void testShowTodoTasks() throws Exception {
        mockMvc.perform(get("/showTodoTasks"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    // Test method for checking the functionality of adding a task
    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(post("/add").param("name", "New Task"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    // Test method for checking the functionality of updating a task
    @Test
    public void testUpdate() throws Exception {
        mockMvc.perform(post("/update/1")
                        .param("newName", "Updated Task")
                        .param("complete", "true"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    // Test method for checking the functionality of removing a task
    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(post("/remove").param("id", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    // Test method for checking the functionality of toggling the completion status of a task
    @Test
    public void testToggleComplete() throws Exception {
        mockMvc.perform(post("/toggleComplete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    // Test method for checking the functionality of deleting all tasks
    @Test
    public void testDeleteAllTasks() throws Exception {
        mockMvc.perform(post("/deleteAllTasks"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    // Test method for checking the functionality of deleting all completed tasks
    @Test
    public void testDeleteDoneTasks() throws Exception {
        mockMvc.perform(post("/deleteDoneTasks"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    // Test method for checking the functionality of updating the name of a task
    @Test
    public void testUpdateName() throws Exception {
        mockMvc.perform(post("/updateName/1").param("newName", "New Name"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}
