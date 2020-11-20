package com.connectionwith.mysql.controllers;

import com.connectionwith.mysql.services.AssigneeService;
import org.springframework.stereotype.Controller;

@Controller
public class AssigneeController {
  private AssigneeService assigneeService;

  public AssigneeController(AssigneeService assigneeService) {
    this.assigneeService = assigneeService;
  }

  

}
