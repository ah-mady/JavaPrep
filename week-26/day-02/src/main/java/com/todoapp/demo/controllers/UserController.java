package com.todoapp.demo.controllers;

import com.todoapp.demo.configurations.jwt.JwtProvider;
import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.models.UserEntity;
import com.todoapp.demo.models.dto.AuthResponse;
import com.todoapp.demo.models.dto.ErrorDTO;
import com.todoapp.demo.models.dto.UserEntityDto;
import com.todoapp.demo.services.TodoService;
import com.todoapp.demo.services.UserService;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private UserService userService;
  private JwtProvider jwtProvider;
  private TodoService todoService;

  public UserController(UserService userService, JwtProvider jwtProvider, TodoService todoService) {
    this.userService = userService;
    this.jwtProvider = jwtProvider;
    this.todoService = todoService;
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
  public ResponseEntity<?> loginUser(@RequestBody UserEntityDto userEntityDto) {
    UserEntity userEntity = new UserEntity();

    if (userService.findByUsernameAndPassword(userEntityDto.getUsername(), userEntityDto.getPassword()) != null) {
      userEntity.setUsername(userEntityDto.getUsername());
      userEntity.setPassword(userEntityDto.getPassword());
      String token = jwtProvider.generateToken(userEntity.getUsername());
      return ResponseEntity.ok().body(new AuthResponse(token));
    } else {
      ErrorDTO error = todoService.setError("user already registered with this username.");
      return ResponseEntity.badRequest().body(error);
    }
  }

  @GetMapping("/user/get")
  public String userPage(){
    return "This is user page";
  }


  @GetMapping("/admin/get")
  public String adminPage(){
    return "This is admin page";
  }


}
