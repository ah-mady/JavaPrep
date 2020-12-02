package com.backend.api.frontend.controllers;

import com.backend.api.frontend.models.AppendA;
import com.backend.api.frontend.models.ArrayHandler;
import com.backend.api.frontend.models.DoUntil;
import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.models.Greeter;
import com.backend.api.frontend.services.MainServices;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private MainServices mainServices;

  public MainController(MainServices mainServices) {
    this.mainServices = mainServices;
  }

  @GetMapping()
  public String frontEnd() {
    return "index";
  }

  @GetMapping("/doubling")
  public ResponseEntity<Double> doubling(@RequestParam(required = false) Integer input) {
    Double doubleObject = mainServices.doubleValue(input);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(doubleObject);
  }

  @GetMapping("/greeter")
  public ResponseEntity<Greeter> greeterResponseEntity(@RequestParam(required = false) String name,
                                                       @RequestParam(required = false) String title) {
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
    DoUntil doUntilObject = mainServices.doUntil(action, until);

    if (until == null) {
      return new ResponseEntity<>(doUntilObject, HttpStatus.BAD_REQUEST);
    }

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    return ResponseEntity.ok().headers(headers).body(doUntilObject);
  }

//  @PostMapping("/array")
//  @ResponseBody
//  public ResponseEntity<?> arrayHandlerRE(@RequestBody ArrayHandler arrayHandler) throws JsonProcessingException {
//
//    Integer[] array = new Integer[arrayHandler.getNumbers().size()];
//    arrayHandler.getNumbers().toArray(array);
//
//
//    ArrayHandler arrayHandler2 = mainServices.arrayHandler(arrayHandler.getWhat(), array);,
//
//    HttpHeaders headers = new HttpHeaders();
//    headers.add("Content-Type", "application/json");
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    String json = objectMapper.writeValueAsString(arrayHandler2);
//
//    return ResponseEntity.ok().body(json);
//  }

  @PostMapping("/array")
  public ResponseEntity<?> addMember(@RequestBody ArrayHandler arrayHandler){

    ArrayHandler arrayHandlerObject = mainServices.arrayHandler(arrayHandler.getWhat(), arrayHandler.getNumbers());

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");

    return ResponseEntity.ok().headers(headers).body(arrayHandlerObject);
  }

}
