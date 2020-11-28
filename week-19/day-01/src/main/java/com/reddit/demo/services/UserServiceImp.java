package com.reddit.demo.services;

import com.reddit.demo.models.User;
import com.reddit.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

  private User loggedUser;
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
    User validUser = userRepository.fetchUsernameAndPassword(userName, password);
    if (validUser != null) {
      loggedUser = validUser;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public User fetchUser(String userName, String password) {
    return userRepository.fetchUsernameAndPassword(userName, password);
  }

  @Override
  public User loggedUser() {
    return loggedUser;
  }

  @Override
  public void logout() {
    loggedUser = null;
  }

  @Override
  public User getLoggedUser() {
    return loggedUser;
  }

  @Override
  public void setLoggedUser(User loggedUser) {
    this.loggedUser = loggedUser;
  }
}
