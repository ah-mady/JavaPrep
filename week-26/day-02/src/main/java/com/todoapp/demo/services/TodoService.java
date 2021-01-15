package com.todoapp.demo.services;

import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.models.dto.ErrorDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {

  void save(TodoEntity todoEntity);

  List<TodoEntity> listTodos();

  ErrorDTO setError(String error);
}
