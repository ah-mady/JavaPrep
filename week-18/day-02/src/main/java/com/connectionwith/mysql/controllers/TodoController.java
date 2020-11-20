package com.connectionwith.mysql.controllers;

import com.connectionwith.mysql.models.ToDo;
import com.connectionwith.mysql.repositories.ToDoRepository;
import com.connectionwith.mysql.services.Service;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
  private Service service;


  public TodoController(Service service) {
    this.service = service;
  }

  @GetMapping({"/", "/list"})
  public String list(Model model,
                     @RequestParam(value = "isActive", required = false) Boolean isActive) {
    if (isActive == null) {
      model.addAttribute("todos", service.findAll());
    } else if (isActive) {
      model.addAttribute("todos",
          service.findAll().stream().filter(task -> !task.getIsDone()).collect(
              Collectors.toList()));
    } else if (!isActive) {
      model.addAttribute("todos",
          service.findAll().stream().filter(task -> task.getIsDone()).collect(Collectors.toList()));
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
    service.save(task);
    return "redirect:/";
  }

  @GetMapping("/{id}/delete")
  public String deleteTask(@PathVariable("id") Long id, Model model){
    model.addAttribute("id", id);
    service.deleteById(id);
    return "redirect:/";
  }

  @GetMapping("/{id}/edit")
  public String editTask (Model model, @PathVariable("id") Long id){
    model.addAttribute("task", service.getOne(id));
    return "edit";
  }

  @PostMapping("/{id}/edit")
  public String editTask(@ModelAttribute ToDo task, @PathVariable("id") Long id){
    task.setId(id);
    service.save(task);
    return "redirect:/";
  }

  @PostMapping("/search")
  public String searchResult(Model model, @RequestParam String search) {
    model.addAttribute("todos", service.findTodoByString(search));
    return "todo";
  }

}
