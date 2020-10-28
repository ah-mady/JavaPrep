package com.dependencyinjection.dependency;

import com.dependencyinjection.dependency.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyApplication implements CommandLineRunner {

  private Printer printer;

  public DependencyApplication(Printer printer) {
    this.printer = printer;
  }

  public static void main(String[] args) {
    SpringApplication.run(DependencyApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("Hello, Dependency Injection");
  }
}
