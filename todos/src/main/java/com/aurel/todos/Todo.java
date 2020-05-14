package com.aurel.todos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@RestResource(rel = "todos", path = "todos")
@Document
public class Todo {

    @Id
    private String id;

    @Size
    private String name;

    private Date createdAt;

    public Todo() {

        this.createdAt = new Date();
    }
}
