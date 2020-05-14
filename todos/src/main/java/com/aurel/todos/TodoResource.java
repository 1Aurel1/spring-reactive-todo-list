package com.aurel.todos;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class TodoResource {

    private String id;
    private String name;
    private Date createdAt;

    public TodoResource(Todo todo) {
        this.id = todo.getId();
        this.name = todo.getName();
        this.createdAt = todo.getCreatedAt();
    }
}
