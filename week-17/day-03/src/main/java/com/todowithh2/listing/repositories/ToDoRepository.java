package com.todowithh2.listing.repositories;

import com.todowithh2.listing.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
