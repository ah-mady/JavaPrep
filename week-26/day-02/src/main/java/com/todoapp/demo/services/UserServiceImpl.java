package com.todoapp.demo.services;

import com.todoapp.demo.models.RoleEntity;
import com.todoapp.demo.models.UserEntity;
import com.todoapp.demo.repositories.RoleRepository;
import com.todoapp.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void save(UserEntity userEntity) {
    RoleEntity userRole = roleRepository.findByRole("ROLE_USER");
    userEntity.setRoleEntity(userRole);
    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    userRepository.save(userEntity);
  }

  @Override
  public boolean findByUsernameAndPassword(String username, String password) {
    return userRepository.findByUsernameAndPassword(username, password);
  }
}
