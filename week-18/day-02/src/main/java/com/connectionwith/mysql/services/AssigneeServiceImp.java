package com.connectionwith.mysql.services;

import com.connectionwith.mysql.models.Assignee;
import com.connectionwith.mysql.repositories.AssigneeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AssigneeServiceImp implements AssigneeService{
  private AssigneeRepository assigneeRepository;

  public AssigneeServiceImp(AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }

  @Override
  public List<Assignee> findAll() {
    return assigneeRepository.findAll();
  }

  @Override
  public void add(Assignee assignee) {
    assigneeRepository.save(assignee);
  }

  @Override
  public void deleteById(Long id) {
    assigneeRepository.deleteById(id);
  }
}
