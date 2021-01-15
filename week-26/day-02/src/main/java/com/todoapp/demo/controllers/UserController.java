package com.todoapp.demo.controllers;

import com.todoapp.demo.configurations.jwt.JwtProvider;
import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.models.UserEntity;
import com.todoapp.demo.models.dto.AuthResponse;
import com.todoapp.demo.models.dto.UserEntityDto;
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

  public UserController(UserService userService, JwtProvider jwtProvider) {
    this.userService = userService;
    this.jwtProvider = jwtProvider;
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
  public ResponseEntity<AuthResponse> loginUser(@RequestBody UserEntityDto userEntityDto) {
    UserEntity userEntity = new UserEntity();

    if (userService.findByUsernameAndPassword(userEntityDto.getUsername(), userEntityDto.getPassword()) != null) {
      userEntity.setUsername(userEntityDto.getUsername());
      userEntity.setPassword(userEntityDto.getPassword());
      String token = jwtProvider.generateToken(userEntity.getUsername());
      return ResponseEntity.ok().body(new AuthResponse(token));
    } else {
      return ResponseEntity.badRequest().body(new AuthResponse());
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
