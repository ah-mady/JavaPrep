package com.todowithh2.listing;

import com.todowithh2.listing.models.ToDo;
import com.todowithh2.listing.repositories.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingApplication implements CommandLineRunner {
  private ToDoRepository toDoRepository;

  public static void main(String[] args) {
    SpringApplication.run(ListingApplication.class, args);
  }

  public ListingApplication(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    toDoRepository.deleteAll();
    toDoRepository.save(new ToDo("I have to learn Object Relational Mapping"));
  }
}
