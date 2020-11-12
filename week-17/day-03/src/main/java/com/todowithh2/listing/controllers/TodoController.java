package com.todowithh2.listing.controllers;

import com.todowithh2.listing.repositories.ToDoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
  private ToDoRepository toDoRepository;

  public TodoController(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  @ResponseBody
  @RequestMapping(value={"/","/list"}, method= RequestMethod.GET)
  public String list(){
    return "This is my first ToDo";
  }
}
