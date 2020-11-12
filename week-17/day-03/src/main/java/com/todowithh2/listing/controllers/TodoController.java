package com.todowithh2.listing.controllers;

import com.todowithh2.listing.models.ToDo;
import com.todowithh2.listing.repositories.ToDoRepository;
import java.util.ArrayList;
import java.util.List;
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

  @GetMapping({ "/", "/list" })
  public String list(Model model){
    List<String> todoList = new ArrayList<>();
    todoList.add("Start the day");
    todoList.add("Finish H2 workshop1");
    todoList.add("Finish JPA workshop2");
    todoList.add("Create a CRUD project");
    toDoRepository.save(new ToDo("Start the day"));
    toDoRepository.save(new ToDo("Finish H2 workshop1"));
    toDoRepository.save(new ToDo("Finish JPA workshop2"));
    toDoRepository.save(new ToDo("Create a CRUD project"));
    model.addAttribute("todos", toDoRepository.findAll());
    model.addAttribute("todoList",todoList);
    return "todo";
  }
}
