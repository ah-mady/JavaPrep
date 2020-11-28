package com.reddit.demo.services;

import com.reddit.demo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


  void save(User user);

  boolean validateCredential(String userName, String password);

}
