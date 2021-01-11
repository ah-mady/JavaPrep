package com.todoapp.demo.services;

import com.todoapp.demo.configurations.CustomUserDetail;
import com.todoapp.demo.models.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
  private UserServiceImpl userService;

  public CustomUserDetailService(UserServiceImpl userService) {
    this.userService = userService;
  }

  @Override
  public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity = userService.findByUsername(username);
    return CustomUserDetail.fromUserEntityToCustomUserDetails(userEntity);
  }
}
