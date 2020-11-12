package com.connectionwith.mysql.controllers;

import com.connectionwith.mysql.models.ToDo;
import com.connectionwith.mysql.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
  private ToDoRepository toDoRepository;

  @Autowired
  public TodoController(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  @GetMapping({"/", "/list"})
  public String list(Model model) {
    toDoRepository.save(new ToDo("Start the day"));
    toDoRepository.save(new ToDo("Finish H2 workshop1"));
    toDoRepository.save(new ToDo("Finish JPA workshop2"));
    toDoRepository.save(new ToDo("Create a CRUD project"));
    model.addAttribute("todos", toDoRepository.findAll());
    return "todo";
  }
}
