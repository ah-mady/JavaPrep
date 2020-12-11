package com.orientation.practice.services;

import com.orientation.practice.models.Url;
import com.orientation.practice.repositories.UrlRepository;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService{
  private UrlRepository urlRepository;

  public UrlServiceImpl(UrlRepository urlRepository) {
    this.urlRepository = urlRepository;
  }


  @Override
  public void save(Url url) {
    urlRepository.save(url);
  }

  @Override
  public long generateSecretCode() {
    Random random = new Random();
    long  resRandom = random.nextInt((9999 - 100) + 1) + 10;
    return resRandom;
  }

  @Override
  public List<Url> findAll() {
    return urlRepository.findAll();
  }

  @Override
  public void setSecretCode(long generateSecretCode) {
    Optional<Url> urlObject = urlRepository.findById((long) 1);
  }
}
