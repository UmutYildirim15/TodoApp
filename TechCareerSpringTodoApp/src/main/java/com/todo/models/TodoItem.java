package com.todo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// That class represents the TodoItem instance in the MySQL.
// With that class, database table is created.
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// TodoItem has 4 different columns, id as a primary key, name, complete status and priority.
public class TodoItem {

    @Id  // It means id is a primary key.
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private boolean complete;
    private Priority priority;


    public TodoItem(String name) {
        this.name = name;
        this.complete = false;
    }
}
