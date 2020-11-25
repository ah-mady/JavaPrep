package com.reddit.demo.repositories;

import com.reddit.demo.models.Reddit;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RedditRepository extends JpaRepository<Reddit, Long> {

  @Transactional
  @Modifying
  @Query("UPDATE Reddit c SET c.vote = c.vote +1 WHERE c.id = ?1")
  void upVote(Long id);

  @Transactional
  @Modifying
  @Query("UPDATE Reddit c SET c.vote = c.vote -1 WHERE c.id = ?1")
  void downVote(Long id);
}
