package com.todoapp.demo;

import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.services.TodoService;
import org.junit.Assert;
import org.junit.Test;



public class UnitTest {


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
    Assert.assertEquals("test todo", todoEntity.getTitle());
    Assert.assertTrue(todoEntity.isDone());
  }



}
