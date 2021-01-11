package com.todoapp.demo.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role_entity")
@Getter
@Setter
public class RoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @OneToMany(mappedBy = "roleEntity")
  private List<UserEntity> userEntity;

  public RoleEntity() {
  }

  public RoleEntity(String role) {
    this.name = role;
  }
}
