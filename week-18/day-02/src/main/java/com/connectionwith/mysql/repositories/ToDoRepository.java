package com.connectionwith.mysql.repositories;


import com.connectionwith.mysql.models.ToDo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

  @Query("SELECT c FROM ToDo c WHERE c.title LIKE %?1%")
  List<ToDo> findTodoByString(String text);
}
