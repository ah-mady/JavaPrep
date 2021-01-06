package com.todoapp.demo.controllers;

import com.todoapp.demo.models.UserEntity;
import com.todoapp.demo.models.dto.UserEntityDto;
import com.todoapp.demo.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/adduser")
  public ResponseEntity<UserEntity> addUser(@RequestBody UserEntityDto userEntityDto) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(userEntityDto.getUsername());
    userEntity.setPassword(userEntityDto.getPassword());
    userService.save(userEntity);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(userEntity);
  }

  @PostMapping("/login")
  public ResponseEntity<UserEntity> loginUser(@RequestBody UserEntityDto userEntityDto){
    UserEntity userEntity = new UserEntity();

    if (userService.findByUsernameAndPassword(userEntityDto.getUsername(), userEntityDto.getPassword())){
      userEntity.setUsername(userEntityDto.getUsername());
      userEntity.setPassword(userEntityDto.getPassword());
      return ResponseEntity.ok().body(userEntity);
    } else {
      return ResponseEntity.badRequest().body(userEntity);
    }
  }

}
