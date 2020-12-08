package com.reddit.demo.repositories;

import com.reddit.demo.models.Vote;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

  @Transactional
  @Modifying
  @Query("UPDATE Post c SET c.rating = c.rating +1 WHERE c.id = ?1")
  void upVote(Long id);

  @Transactional
  @Modifying
  @Query("UPDATE Post c SET c.rating = c.rating -1 WHERE c.id = ?1")
  void downVote(Long id);
}
