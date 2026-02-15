package com.ncatania.resilienceobservability.web;

import com.ncatania.resilienceobservability.dto.Todo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange(url = "https://jsonplaceholder.typicode.com", accept = "application`/json")
public interface TodoClient {

    @GetExchange("/todos")
    @CircuitBreaker(name = "jsonPlaceholderCB", fallbackMethod = "getAllTodosFallback")
    List<Todo> getAllTodos();

    @GetExchange("/todos/{id}")
    Todo getTodoById(Long id);

    @GetExchange("/todos?userId={userId}")
    List<Todo> getTodosByUserId(@PathVariable Long userId);

    @PostExchange("/todos")
    Todo createTodo(@RequestBody Todo todo);

    @PutExchange("/todos/{id}")
    Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo);

    @DeleteExchange("/todos/{id}")
    void deleteTodo(@PathVariable Long id);

    // fallback
    default List<Todo> getPostsFallback(Exception e) {
        return List.of(new Todo(0L, 0L, "Please try again later", false));
    }
}
