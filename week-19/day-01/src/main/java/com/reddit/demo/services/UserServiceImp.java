package com.reddit.demo.services;

import com.reddit.demo.models.User;
import com.reddit.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

  private UserRepository userRepository;

  public UserServiceImp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public boolean validateCredential(String userName, String password) {
    User validUser = userRepository.fetchUsernameAndPassword(userName,password);
    return validUser != null;
  }
}
