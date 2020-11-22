package com.connectionwith.mysql.repositories;


import com.connectionwith.mysql.models.ToDo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

  @Query("SELECT c FROM ToDo c WHERE c.title LIKE %?1%")
  List<ToDo> findTodoByString(String text);

  @Query("SELECT c FROM ToDo c WHERE c.createdAt = ?1 OR c.dueDate =?1")
  List<ToDo> findTodoByDate(LocalDate date);
}
