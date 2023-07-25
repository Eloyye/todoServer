package com.eloy.todoserver.services;

import com.eloy.todoserver.models.TodoCard;
import com.eloy.todoserver.repositories.TodoCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoCardService {
    private final TodoCardRepository todoCardRepository;

    @Autowired
    public TodoCardService(TodoCardRepository todoCardRepository) {
        this.todoCardRepository = todoCardRepository;
    }

    //support CRUD operations

    public List<TodoCard> getAllTodoCards() {
        return this.todoCardRepository.findAll();
    }

    public Optional<TodoCard> getTodoCardById(String id) {
        return todoCardRepository.findById(id);
    }

    public TodoCard addTodoCard(TodoCard todoCard) {
        return todoCardRepository.save(todoCard);
    }

    public TodoCard updateTodoCard(TodoCard todoCard) {
        TodoCard existingTodoCard = todoCardRepository.findById(todoCard.getId())
                .orElseThrow(() -> new IllegalArgumentException("Todo Card Not Found"));
        existingTodoCard.setContents(todoCard.getContents());
        existingTodoCard.setHeader(todoCard.getHeader());
        existingTodoCard.setCompleted(todoCard.isCompleted());
        return todoCardRepository.save(existingTodoCard);
    }

    public void deleteTodoById(String id) {
        todoCardRepository.deleteById(id);
    }


}
