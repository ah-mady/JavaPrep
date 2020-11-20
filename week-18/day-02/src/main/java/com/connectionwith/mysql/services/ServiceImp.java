package com.connectionwith.mysql.services;

import com.connectionwith.mysql.models.ToDo;
import com.connectionwith.mysql.repositories.ToDoRepository;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImp implements Service {

  ToDoRepository toDoRepository;

  public ServiceImp(ToDoRepository toDoRepository) {
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
}
