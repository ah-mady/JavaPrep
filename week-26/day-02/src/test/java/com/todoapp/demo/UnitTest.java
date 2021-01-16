package com.todoapp.demo;

import static org.junit.Assert.*;

import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.services.TodoService;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;


public class UnitTest {

  TodoService todoService = Mockito.mock(TodoService.class);

  @Test
  public void createNewTodoShouldReturnNewTodo(){
    //Arrange
    String testTitle = "test todo";
    boolean testUrgent = false;
    boolean testDone = true;
    //Act
    TodoEntity todoEntity = new TodoEntity();
    todoEntity.setUrgent(testUrgent);
    todoEntity.setDone(testDone);
    todoEntity.setTitle(testTitle);
    //Assert
    assertEquals("test todo", todoEntity.getTitle());
    assertTrue(todoEntity.isDone());
  }

  @Test(expected = NullPointerException.class)
  public void saveShouldThrowNullPointer(){
    //Arrange
    String testTitle = null;
    boolean testUrgent = false;
    boolean testDone = true;
    //Act
    TodoEntity todoEntity = new TodoEntity();
    todoEntity.setUrgent(testUrgent);
    todoEntity.setDone(testDone);
    todoEntity.setTitle(testTitle);
    todoService.save(todoEntity);
  }

  @Test
  public void listShouldListAllTodos(){
    //Arrange
    TodoEntity todoEntity1 = new TodoEntity("testing 1");
    TodoEntity todoEntity2 = new TodoEntity("testing 2");
    todoEntity2.setUrgent(true);
    todoService.save(todoEntity1);
    todoService.save(todoEntity2);

    //Act
    List<TodoEntity> todoEntityList = Arrays.asList(todoEntity1,todoEntity2);
    List<TodoEntity> result = todoService.listTodos();

    //Assert
    assertEquals(todoEntityList,result);
  }

  @Test
  public void returnTrue(){
    boolean result = true;
    Assertions.assertTrue(result);
  }

}
