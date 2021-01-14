package com.todoapp.demo.repositories;

import com.todoapp.demo.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

  RoleEntity findByRole(String role);
  RoleEntity findById(long id);
}
