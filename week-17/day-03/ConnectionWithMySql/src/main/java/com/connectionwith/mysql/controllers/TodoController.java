package com.connectionwith.mysql.controllers;

import com.connectionwith.mysql.models.ToDo;
import com.connectionwith.mysql.repositories.ToDoRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private ToDoRepository toDoRepository;

  @Autowired
  public TodoController(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  @GetMapping({"/", "/list"})
  public String list(Model model,
                     @RequestParam(value = "isActive", required = false) Boolean isActive) {
    if (isActive == null) {
      model.addAttribute("todos", toDoRepository.findAll());
    } else if (isActive) {
      model.addAttribute("todos",
          toDoRepository.findAll().stream().filter(task -> !task.isDone()).collect(
              Collectors.toList()));
    } else if (!isActive) {
      model.addAttribute("todos",
          toDoRepository.findAll().stream().filter(ToDo::isDone).collect(Collectors.toList()));
    }
    return "todo";
  }

  @GetMapping("/add")
  public String addTodo(Model model){
    model.addAttribute("task", new ToDo());
    return "addTodo";
  }

  @PostMapping("/add")
  public String addTodo(@ModelAttribute ToDo task){
    toDoRepository.save(task);

    return "redirect:/";
  }

}
