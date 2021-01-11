package com.todoapp.demo.controllers;

import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.models.UserEntity;
import com.todoapp.demo.models.dto.UserEntityDto;
import com.todoapp.demo.services.UserService;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<UserEntity> addUser(@RequestBody UserEntityDto userEntityDto) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(userEntityDto.getUsername());
    userEntity.setPassword(userEntityDto.getPassword());
    List<TodoEntity> todoEntityList = userEntityDto.getTodoListDto();
    userEntity.setListOfTodos(todoEntityList);
    userService.save(userEntity);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(userEntity);
  }

  @PostMapping("/login")
  public ResponseEntity<UserEntity> loginUser(@RequestBody UserEntityDto userEntityDto) {
    UserEntity userEntity = new UserEntity();

    if (userService.findByUsernameAndPassword(userEntityDto.getUsername(), userEntityDto.getPassword()) != null) {
      userEntity.setUsername(userEntityDto.getUsername());
      userEntity.setPassword(userEntityDto.getPassword());
      return ResponseEntity.ok().body(userEntity);
    } else {
      return ResponseEntity.badRequest().body(userEntity);
    }
  }

  @GetMapping("/admin")
  public String admin (){
    return "This is admin endpoint!";
  }

  @GetMapping("/user")
  public String user(){
    return "This is User endpoint!";
  }

}
