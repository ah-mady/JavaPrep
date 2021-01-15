package com.todoapp.demo;

import static org.junit.Assert.*;

import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.services.TodoService;
import org.junit.Test;
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



}
