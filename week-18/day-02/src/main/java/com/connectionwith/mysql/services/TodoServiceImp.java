package com.connectionwith.mysql.services;

import com.connectionwith.mysql.models.ToDo;
import com.connectionwith.mysql.repositories.ToDoRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class TodoServiceImp implements TodoService {

  ToDoRepository toDoRepository;

  public TodoServiceImp(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  @Override
  public List<ToDo> findAll() {
    return toDoRepository.findAll();
  }

  @Override
  public void save(ToDo task) {
    toDoRepository.save(task);
  }

  @Override
  public void deleteById(Long id) {
    toDoRepository.deleteById(id);
  }

  @Override
  public ToDo getOne(Long id) {
    return toDoRepository.getOne(id);
  }

  @Override
  public List<ToDo> findTodoByString(String search) {
    return toDoRepository.findTodoByString(search);
  }

  @Override
  public List<ToDo> findTodoByDate(LocalDate date) {
    return toDoRepository.findTodoByDate(date);
  }

}
