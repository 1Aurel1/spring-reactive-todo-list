package com.aurel.todos;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends ReactiveMongoRepository<Todo, String> {

}
