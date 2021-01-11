package com.todoapp.demo.controllers;

import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.models.dto.TodoEntityDto;
import com.todoapp.demo.services.TodoService;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @PostMapping("/save")
  public ResponseEntity<TodoEntity> saveTodo(@RequestBody TodoEntityDto todoEntityDto){
    TodoEntity todoEntity1 = new TodoEntity();
    todoEntity1.setTitle(todoEntityDto.getTitle());
    todoEntity1.setDone(todoEntityDto.isDone());
    todoEntity1.setUrgent(todoEntityDto.isUrgent());
    todoService.save(todoEntity1);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(todoEntity1);
  }

  @PostMapping("/list")
  public ResponseEntity<List<TodoEntity>> listTodos(){
    List<TodoEntity> todoEntityList = todoService.listTodos();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(todoEntityList);
  }

}
