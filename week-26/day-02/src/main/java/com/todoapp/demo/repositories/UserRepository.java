package com.todoapp.demo.repositories;

import com.todoapp.demo.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  void findByUsername(String username);
  void findByPassword(String password);
  boolean findByUsernameAndPassword(String username, String password);
}
