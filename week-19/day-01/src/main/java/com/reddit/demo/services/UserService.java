package com.reddit.demo.services;

import com.reddit.demo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


  void save(User user);

  boolean validateCredential(String userName, String password);

  User fetchUser(String userName, String password);

  User loggedUser();

  void logout();

  User getLoggedUser();

  void setLoggedUser(User loggedUser);
}
