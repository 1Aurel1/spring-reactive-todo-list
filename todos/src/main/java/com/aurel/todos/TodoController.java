package com.aurel.todos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public Mono<ResponseEntity<?>> testController() {

        return todoService.findAllUserTodos();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Mono<ResponseEntity<?>> postTodos(
           @Valid @RequestBody Todo todo
    ){

        return todoService.createTodo(Mono.just(todo));
    }

    @PutMapping
    public Mono<ResponseEntity<?>> putTodo(
            @Valid @RequestBody Todo todo
    ){

        return todoService.updateTodo(Mono.just(todo));
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(
            @PathVariable("id") String id
    ){

        todoService.deleteTodo(Mono.just(id));
    }
}
