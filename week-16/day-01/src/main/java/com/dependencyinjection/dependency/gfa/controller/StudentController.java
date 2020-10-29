package com.dependencyinjection.dependency.gfa.controller;

import com.dependencyinjection.dependency.gfa.service.StudentService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
  private StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/gfa")
  public String homePage(Model model) {
    model.addAttribute("counter", studentService.count());
    return "gfa";
  }

  @GetMapping("/gfa/list")
  public String links(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "gfaList";
  }

  @PostMapping("/gfa/save")
  public String addStudent(Model model, @RequestParam String studentName) {
    studentService.save(studentName);
    model.addAttribute("confirmation", "Student <strong>'" + studentName +
        "'</strong> was added to GreenFox Academy.");
    model.addAttribute("listStudents", "List all students at GFA.");
    return "gfaAdd";
  }

  @GetMapping("/gfa/add")
  public String addStudent() {
    return "gfaAdd";
  }

  @PostMapping("/gfa/check")
  public String validateStudent(Model model, @RequestParam String name) {
    if (studentService.findAll().stream()
        .map(String::toLowerCase)
        .collect(Collectors.toList())
        .contains(name.toLowerCase())) {
      model.addAttribute("validation", "Student '" + name + "'<strong> IS</strong> already enrolled.");
    } else {
      model.addAttribute("validation", "Student '" + name + "'<strong> IS NOT</strong> already enrolled.");
    }
    model.addAttribute("listStudents", "List all students at GFA.");
    return "gfaCheck";
  }

  @GetMapping("/gfa/check")
  public String validateStudent() {
    return "gfaCheck";
  }
}
