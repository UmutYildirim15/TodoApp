package com.todo.controllers.Impl;

import com.todo.models.Priority;
import com.todo.models.TodoItem;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface ITodoAppController {
    public String index(Model model);
    public String showAllTasks(Model model);
    public String showDoneTasks(Model model);
    public String showTodoTasks(Model model);
    public String add(@ModelAttribute TodoItem requestItem);
    public String update(@PathVariable Long id, @RequestParam String newName, @RequestParam(required = false) Optional<Priority> priority);
    public String remove(@ModelAttribute TodoItem item);
    public String toggleComplete(@PathVariable Long id);
    public String deleteAllTasks();
    public String deleteDoneTasks();
    public String showLowPriority(Model model);
    public String showMediumPriority(Model model);
    public String showHighPriority(Model model);
    public String updateName(@PathVariable Long id, @RequestParam String newName);

}
