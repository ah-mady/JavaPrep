package com.connectionwith.mysql.services;

import com.connectionwith.mysql.models.ToDo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public interface TodoService {

  List<ToDo> findAll();

  void save(ToDo task);

  void deleteById(Long id);

  ToDo getOne(Long id);

  List<ToDo> findTodoByString(String search);

  List<ToDo> findTodoByDate(LocalDate date);
}
