package com.greenfox.finder.service;

import com.greenfox.finder.model.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by aze on 25/10/17.
 */

@Service
public class UserService {

  private List<User> users;

  public UserService() {
    this.users = new ArrayList<>();
  }

  public List<User> getAll() {
    return users;
  }

  public void save(User user) {
    users.add(user);
  }

  public UserService service() {
    return new UserService();
  }
}
