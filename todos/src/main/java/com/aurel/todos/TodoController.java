package com.aurel.todos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public Flux<String> testController() {

        return Flux.just("Test", "test 2");
    }

    @PostMapping(consumes = "application/json")
    public Mono<ResponseEntity<?>> postTodos(
            @RequestBody TodoDto dto
    ){

        return todoService.createTodo(dto);
    }

}
