package com.orientation.practice.services;

import com.orientation.practice.models.Url;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {

  void save(Url url);

  List<Url> findAll();

  String generateSecretCode();

  boolean validateAlias(String alias);

  Url findByAlias(String alias);
}
