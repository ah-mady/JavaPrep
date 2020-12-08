package com.backend.api.frontend.controllers;

import com.backend.api.frontend.models.AppendA;
import com.backend.api.frontend.models.ArrayHandler;
import com.backend.api.frontend.models.DoUntil;
import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.models.Greeter;
import com.backend.api.frontend.models.LogEntry;
import com.backend.api.frontend.models.LogEntryOutput;
import com.backend.api.frontend.models.Sith;
import com.backend.api.frontend.repositories.LogRepository;
import com.backend.api.frontend.services.MainServices;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  private MainServices mainServices;
  private LogRepository logRepository;

  public MainController(MainServices mainServices, LogRepository logRepository) {
    this.mainServices = mainServices;
    this.logRepository = logRepository;
  }

  @GetMapping("/doubling")
  public ResponseEntity<Double> doubling(@RequestParam(required = false) Integer input) {

    LogEntry logEntry = new LogEntry("/doubling", "input: " + input);
    logRepository.save(logEntry);

    Double doubleObject = mainServices.doubleValue(input);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(doubleObject);
  }

  @GetMapping("/greeter")
  public ResponseEntity<Greeter> greeterResponseEntity(@RequestParam(required = false) String name,
                                                       @RequestParam(required = false) String title) {
    LogEntry logEntry = new LogEntry("/greeter", "name: " + name + "\ntitle: " + title);
    logRepository.save(logEntry);

    Greeter greeterObject = mainServices.greeter(name, title);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    if (title == null || name == null) {
      return new ResponseEntity<>(greeterObject, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok().headers(headers).body(greeterObject);
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<AppendA> appendAResponseEntity(@PathVariable String appendable) {

    LogEntry logEntry = new LogEntry("/appenda/" + appendable, "input: " + appendable);
    logRepository.save(logEntry);

    AppendA appendObject = mainServices.appendLetterA(appendable);
    if (appendable == null) {
      return new ResponseEntity<>(appendObject, HttpStatus.NOT_FOUND);
    }

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    return ResponseEntity.ok().headers(headers).body(appendObject);
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity<DoUntil> doUntilResponseEntity(@PathVariable String action,
                                                       @RequestBody(required = false) DoUntil until) {
    LogEntry logEntry = new LogEntry("/dountil/" + action, "input: " + until.getUntil());
    logRepository.save(logEntry);

    DoUntil doUntilObject = mainServices.doUntil(action, until);

    if (until == null) {
      return new ResponseEntity<>(doUntilObject, HttpStatus.BAD_REQUEST);
    }

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    return ResponseEntity.ok().headers(headers).body(doUntilObject);
  }


  @PostMapping("/array")
  public ResponseEntity<ArrayHandler> arrayHandlerRE(@RequestBody ArrayHandler arrayHandler) {

    LogEntry logEntry = new LogEntry("/array", "what: " + arrayHandler.getWhat()
        + " numbers: " + Arrays.toString(arrayHandler.getNumbers()));
    logRepository.save(logEntry);

    ArrayHandler arrayHandlerObject = mainServices.arrayHandler(arrayHandler.getWhat(), arrayHandler.getNumbers());

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    return ResponseEntity.ok().headers(headers).body(arrayHandlerObject);
  }

  @GetMapping("/log")
  public ResponseEntity<?> getLogs() {
    List<LogEntry> logEntries = logRepository.findAll();

    LogEntryOutput output = new LogEntryOutput();

    output.setEntries(logEntries);
    output.setEntryCount(logEntries.size());

    if (logEntries == null || logEntries.isEmpty()) {
      return ResponseEntity.status(400).body(output);
    }
    return ResponseEntity.ok().body(output);
  }

//  @PostMapping("/sith")
//  public ResponseEntity<Sith> sithResponseEntity(@RequestBody Sith sith){
//  Sith sithObject = mainServices.sith(sith.getSith());
//    return ResponseEntity.ok().body(sithObject);
//  }

}
