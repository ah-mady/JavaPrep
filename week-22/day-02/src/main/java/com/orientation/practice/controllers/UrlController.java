package com.orientation.practice.controllers;

import com.orientation.practice.models.Url;
import com.orientation.practice.models.dtos.SecretCodeDto;
import com.orientation.practice.services.UrlService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UrlController {
  private UrlService urlService;

  public UrlController(UrlService urlService) {
    this.urlService = urlService;
  }

  @GetMapping("/")
  public String homepage(Model model) {
    Url newUrlObj = new Url();
    model.addAttribute("url", newUrlObj);
    return "homepage";
  }

  @PostMapping("/save-link")
  public String submitUrl(@ModelAttribute Url url, Model model) {
    if (urlService.validateAlias(url.getAlias())) {
      model.addAttribute("url", url);
      url.setSecretCode(urlService.generateSecretCode());
      urlService.save(url);
      return "savedAlias";
    } else {
      model.addAttribute("existingAlias", true);
      return "homepage";
    }
  }

  @GetMapping("/a/{alias}")
  @ResponseBody
  public ResponseEntity<Url> increaseCount(@PathVariable String alias) throws URISyntaxException {
    Url foundAlias = urlService.findByAlias(alias);
    if (foundAlias == null) {
      return ResponseEntity.notFound().build();
    }

    foundAlias.setHitCount(foundAlias.getHitCount() + 1);
    urlService.save(foundAlias);

    //it takes the application to the provided url
    URI uri = new URI(foundAlias.getURL());
    HttpHeaders myHeader = new HttpHeaders();
    myHeader.setLocation(uri);

    return new ResponseEntity<>(myHeader, HttpStatus.SEE_OTHER);
  }

  @GetMapping("/api/links")
  @ResponseBody
  public ResponseEntity<List<Url>> showJson() {
    List<Url> urlEntries = urlService.findAll();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(urlEntries);
  }

  @DeleteMapping("/api/links/{id}")
  @ResponseBody
  public ResponseEntity<Url> deleteById(@PathVariable String id,
                                        @RequestBody SecretCodeDto url) {

    Long longId = Long.valueOf(id);
    Url urlObject = urlService.findById(longId);


    if (urlObject == null) {
      return ResponseEntity.notFound().build();
    }

    if (urlService.validateSecretCode(urlObject, url.getSecretCode())) {
      urlService.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

  }

}
