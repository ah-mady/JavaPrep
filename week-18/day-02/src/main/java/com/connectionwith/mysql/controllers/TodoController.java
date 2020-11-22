package com.connectionwith.mysql.controllers;

import com.connectionwith.mysql.models.ToDo;
import com.connectionwith.mysql.services.AssigneeService;
import com.connectionwith.mysql.services.TodoService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
  private TodoService todoService;
  private AssigneeService assigneeService;

  public TodoController(TodoService todoService, AssigneeService assigneeService) {
    this.todoService = todoService;
    this.assigneeService = assigneeService;
  }

  @GetMapping( {"/", "/list"})
  public String list(Model model,
                     @RequestParam(value = "isActive", required = false) Boolean isActive) {
    if (isActive == null) {
      model.addAttribute("todos", todoService.findAll());
    } else if (isActive) {
      model.addAttribute("todos",
          todoService.findAll().stream().filter(task -> !task.getIsDone()).collect(
              Collectors.toList()));
    } else if (!isActive) {
      model.addAttribute("todos",
          todoService.findAll().stream().filter(task -> task.getIsDone()).collect(Collectors.toList()));
    }
    model.addAttribute("assignees", assigneeService.findAll());
    return "todo";
  }

  @GetMapping("/add")
  public String addTodo(Model model) {
    model.addAttribute("task", new ToDo());
    return "addTodo";
  }

  @PostMapping("/add")
  public String addTodo(@RequestParam String dueDate2, @ModelAttribute ToDo task) {
    task.setDueDate(LocalDate.parse(dueDate2));
    todoService.save(task);
    return "redirect:/";
  }

  @GetMapping("/{id}/delete")
  public String deleteTask(@PathVariable("id") Long id, Model model) {
    model.addAttribute("id", id);
    todoService.deleteById(id);
    return "redirect:/";
  }

  @GetMapping("/{id}/edit")
  public String editTask(Model model, @PathVariable("id") Long id) {
    model.addAttribute("task", todoService.getOne(id));
    model.addAttribute("assignees", assigneeService.findAll());
    return "edit";
  }

  @PostMapping("/{id}/edit")
  public String editTask(@ModelAttribute ToDo task, @PathVariable("id") Long id,
                         @RequestParam(required = false) Long assignee,
                         @RequestParam(required = false) String dueDate2) {
    if (assignee == 0) {
      task.setAssignee(null);
    } else {
      task.setAssignee(assigneeService.getOne(assignee));
    }

    task.setDueDate(LocalDate.parse(dueDate2));

    ToDo toDo = todoService.getOne(id);

    task.setId(toDo.getId());
    task.setCreatedAt(toDo.getCreatedAt());
    todoService.save(task);
    return "redirect:/";
  }

  @PostMapping("/search")
  public String searchResult(Model model, @RequestParam String search) {
    model.addAttribute("todos", todoService.findTodoByString(search));
    return "todo";
  }

  @GetMapping("/searchByDate")
  public String searchByDate(Model model){
    model.addAttribute("task", todoService.findAll());
    return "dateSearch";
  }

  @PostMapping("/searchByDate")
  public String searchByDate(Model model, @RequestParam String dueDate2){
    LocalDate dateTime = LocalDate.parse(dueDate2);
    List<ToDo> result = todoService.findTodoByDate(dateTime);
    model.addAttribute("todos", result);
    return "todo";
  }

}
