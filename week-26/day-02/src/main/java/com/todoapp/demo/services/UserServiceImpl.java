package com.todoapp.demo.services;

import com.todoapp.demo.models.UserEntity;
import com.todoapp.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void save(UserEntity userEntity) {
    userRepository.save(userEntity);
  }

  @Override
  public boolean findByUsernameAndPassword(String username, String password) {
    return userRepository.findByUsernameAndPassword(username, password);
  }
}
