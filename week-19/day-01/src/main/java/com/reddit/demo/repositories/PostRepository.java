package com.reddit.demo.repositories;

import com.reddit.demo.models.Post;
import com.reddit.demo.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  @Query("SELECT c FROM Post c WHERE c.user = ?1")
  List<Post> getMyPosts(User loggedUser);
}
