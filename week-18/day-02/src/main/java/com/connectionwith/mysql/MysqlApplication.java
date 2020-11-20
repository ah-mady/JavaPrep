package com.connectionwith.mysql;

import com.connectionwith.mysql.models.ToDo;
import com.connectionwith.mysql.repositories.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlApplication implements CommandLineRunner {
    private ToDoRepository toDoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }

    public MysqlApplication(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*toDoRepository.save(new ToDo("Start the day"));
        toDoRepository.save(new ToDo("Finish H2 workshop1" , true, true));
        toDoRepository.save(new ToDo("Finish JPA workshop2", true, false));
        toDoRepository.save(new ToDo("Create a CRUD project", false, true));
        toDoRepository.save(new ToDo("Make the beds", true, true));
        toDoRepository.save(new ToDo("Do the washing up", false, true));
        toDoRepository.save(new ToDo("Vacuum the carpet"));*/
    }
}
