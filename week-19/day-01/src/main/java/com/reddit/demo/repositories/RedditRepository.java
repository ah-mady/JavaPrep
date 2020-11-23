package com.reddit.demo.repositories;

import com.reddit.demo.models.Reddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedditRepository extends JpaRepository<Reddit, Long> {
}
