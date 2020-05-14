package com.aurel.todos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Mono<ResponseEntity<?>> createTodo(Mono<Todo> todo){

        todo = todoRepository.insert(todo).next();

        return Mono.just(
                new ResponseEntity<>(
                        todo,
                        HttpStatus.OK)
        );
    }

    public Mono<ResponseEntity<?>> findAllUserTodos(){

        return todoRepository.findAll()
            .map(todo -> {

                return new TodoResource(todo);
            })
            .collectList()
            .map(todoResources -> new ResponseEntity<>(todoResources, HttpStatus.OK))
        ;
    }

    public Mono<ResponseEntity<?>> updateTodo(Mono<Todo> todo) {

        return todoRepository.saveAll(todo).collectList()
                    .map(todos -> new ResponseEntity<>(todos, HttpStatus.OK))
        ;
    }

    public void deleteTodo(Mono<String> id) {

        id.map(s -> todoRepository.deleteById(s));
    }
}
