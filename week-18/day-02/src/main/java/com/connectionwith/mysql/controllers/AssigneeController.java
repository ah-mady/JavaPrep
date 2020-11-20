package com.connectionwith.mysql.controllers;

import com.connectionwith.mysql.models.Assignee;
import com.connectionwith.mysql.services.AssigneeService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AssigneeController {
  private AssigneeService assigneeService;

  public AssigneeController(AssigneeService assigneeService) {
    this.assigneeService = assigneeService;
  }

  @GetMapping("/listAssignee")
  public String listAssignee(Model model) {
    List<Assignee> assignees = assigneeService.findAll();
    if (assigneeService.findAll() == null || assignees.isEmpty()) {
      model.addAttribute("emptyList", true);
    } else {
      model.addAttribute("assignees", assignees);
    }
    return "assignee";
  }

  @GetMapping("/addAssignee")
  public String addAssignee(Model model) {
    model.addAttribute("newAssignee", new Assignee());
    return "addAssignee";
  }

  @PostMapping("/addAssignee")
  public String addAssignee(@ModelAttribute Assignee assignee) {
    assigneeService.add(assignee);
    return "redirect:/listAssignee";
  }

  @GetMapping("{id}/deleteAssignee")
  public String deleteAssignee(@PathVariable Long id) {
    assigneeService.deleteById(id);
    return "redirect:/listAssignee";
  }

  @GetMapping("{id}/editAssignee")
  public String editAssignee(Model model, @PathVariable Long id) {
    model.addAttribute("assignee", assigneeService.getOne(id));
    return "editAssignee";
  }

  @PostMapping("{id}/editAssignee")
  public String editAssigneeSubmit(@ModelAttribute Assignee assignee, @PathVariable Long id) {
    assignee.setId(id);
    assigneeService.save(assignee);
    return "redirect:/listAssignee";
  }

}
