package com.todoapp.demo.services;

import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.repositories.TodoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService{
  private TodoRepository todoRepository;

  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }


  @Override
  public void save(TodoEntity todoEntity) {
    todoRepository.save(todoEntity);
  }

  @Override
  public List<TodoEntity> listTodos() {
    return todoRepository.findAll();
  }
}
