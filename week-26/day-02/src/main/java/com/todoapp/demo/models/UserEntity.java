package com.todoapp.demo.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String username;
  private String password;

  @OneToMany(mappedBy = "user")
  private List<TodoEntity> listOfTodos;

  @ManyToOne()
  @JoinColumn(name = "roleId")
  private RoleEntity roleEntity;

  public UserEntity() {
  }

  public UserEntity(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
