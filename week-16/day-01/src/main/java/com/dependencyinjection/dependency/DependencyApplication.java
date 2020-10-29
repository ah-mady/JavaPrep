package com.dependencyinjection.dependency;

import com.dependencyinjection.dependency.color.service.MyColor;
import com.dependencyinjection.dependency.hellodi.service.Printer;
import com.dependencyinjection.dependency.usefulutility.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyApplication implements CommandLineRunner {

  private Printer printer;
  private MyColor myColor;
  private UtilityService utilityService;

  public DependencyApplication(Printer printer, MyColor myColor, UtilityService utilityService) {
    this.myColor = myColor;
    this.printer = printer;
    this.utilityService = utilityService;
  }

  public static void main(String[] args) {
    SpringApplication.run(DependencyApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //printer.log("Hello, Dependency Injection");
    //myColor.printColor();
    utilityService.randomColor();
  }
}
