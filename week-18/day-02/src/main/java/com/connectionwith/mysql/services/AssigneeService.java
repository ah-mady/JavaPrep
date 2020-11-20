package com.connectionwith.mysql.services;

import com.connectionwith.mysql.models.Assignee;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AssigneeService {

  List<Assignee> findAll();
  void add(Assignee assignee);
  void deleteById(Long id);
}
