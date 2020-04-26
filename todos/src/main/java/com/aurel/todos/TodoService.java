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

    public Mono<ResponseEntity<?>> createTodo(TodoDto dto){

        Mono<Todo> todo = Mono.just(dto).map(dto1 -> {
            Todo todo1 = new Todo();
            todo1.setName(dto1.getName());
            return todo1;
        });
        todo = todoRepository.insert(todo).next();


        return Mono.just(
                new ResponseEntity<>(
                        todo.map(t -> new TodoDto(t.getName())),
                        HttpStatus.OK)
        );
    }
}
