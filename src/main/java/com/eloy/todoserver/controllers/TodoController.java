package com.eloy.todoserver.controllers;

import com.eloy.todoserver.models.TodoCard;
import com.eloy.todoserver.services.TodoCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoCardService todoCardService;

    public TodoController(TodoCardService todoCardService) {
        this.todoCardService = todoCardService;
    }

    @GetMapping
    public List<TodoCard> listTodoCards() {
        return todoCardService.getAllTodoCards();
    }

    @GetMapping("/{id}")
    public TodoCard viewTodo(@PathVariable String id) {
        return todoCardService.getTodoCardById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid Todo ID: " + id)
        );
    }

    @PostMapping
    public TodoCard addTodo(@RequestBody TodoCard todoCard) {
        return todoCardService.addTodoCard(todoCard);
    }

    @PutMapping("/{id}")
    public TodoCard updateTodo(@PathVariable String id, @RequestBody TodoCard updatedTodo) {
        updatedTodo.setId(id);
        return todoCardService.updateTodoCard(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
        todoCardService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

}
