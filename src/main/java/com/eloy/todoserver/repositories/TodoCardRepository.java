package com.eloy.todoserver.repositories;

import com.eloy.todoserver.models.TodoCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoCardRepository extends MongoRepository<TodoCard, String> {
}
