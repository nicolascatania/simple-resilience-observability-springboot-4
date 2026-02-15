package com.ncatania.resilienceobservability.web;


import com.ncatania.resilienceobservability.dto.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoClient todoClient;


    public TodoController(TodoClient todoClient) {
        this.todoClient = todoClient;
    }


    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> all = todoClient.getAllTodos();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoClient.getTodoById(id);
        return ResponseEntity.ok(todo);
    }
}
