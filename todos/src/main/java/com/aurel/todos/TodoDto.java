package com.aurel.todos;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

@Data
@RestResource(rel = "todos", path = "todos")
public class TodoDto {

    private String name;

    public TodoDto(String name) {
        this.name = name;
    }
}
