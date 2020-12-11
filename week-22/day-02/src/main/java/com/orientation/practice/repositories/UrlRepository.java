package com.orientation.practice.repositories;

import com.orientation.practice.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

  @Query("SELECT c FROM Url c WHERE c.alias = ?1")
  Url fetchAlias(String alias);

}
