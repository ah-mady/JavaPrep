package com.backend.api;

import com.backend.api.frontend.services.MainServicesImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DoublingTests {

  @Test
  public void doublingShouldReturnTwiceTheInput(){
    //Arrange
    MainServicesImpl mainServices = new MainServicesImpl();

    //Act
    Integer returnObj = mainServices.doubleValue(4).getResult();

    //Assert
    Assertions.assertEquals(8,returnObj);
  }

}
