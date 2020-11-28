package com.reddit.demo.repositories;

import com.reddit.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT c FROM User c WHERE c.userName = ?1 AND c.password = ?2")
  User fetchUsernameAndPassword(String userName, String password);
}
