package com.orientation.practice.services;

import com.orientation.practice.models.Url;
import com.orientation.practice.repositories.UrlRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {
  private UrlRepository urlRepository;

  public UrlServiceImpl(UrlRepository urlRepository) {
    this.urlRepository = urlRepository;
  }


  @Override
  public void save(Url url) {
//    url.setSecretCode(generateSecretCode());
    urlRepository.save(url);
  }

  @Override
  public List<Url> findAll() {
    return urlRepository.findAll();
  }

  @Override
  public String generateSecretCode() {
    int code = (int) ((Math.random() * 9000) + 1000);
    String generatedCode = String.valueOf(code);
    return generatedCode;
  }

  @Override
  public boolean validateAlias(String alias) {
    Url validAlias = urlRepository.fetchAlias(alias);
    return validAlias == null;
  }

  @Override
  public Url findByAlias(String alias) {
    return urlRepository.fetchAlias(alias);
  }

  @Override
  public void deleteById(String id) {
    Long longId = Long.valueOf(id);
   urlRepository.deleteById(longId);
  }

  @Override
  public Url findById(long id) {
    urlRepository.findById(id);
    return urlRepository.findById(id).orElse(null);
  }

  @Override
  public boolean validateSecretCode(Url urlObject, String secretCode) {
    return urlObject.getSecretCode().equals(secretCode);
  }

}
