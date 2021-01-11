package com.todoapp.demo.services;

import com.todoapp.demo.models.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  void save(UserEntity userEntity);
  UserEntity findByUsername(String username);
  UserEntity findByUsernameAndPassword(String username, String password);
}
