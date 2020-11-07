package com.programmer.foxclub.services;

import com.programmer.foxclub.models.Fox;
import com.programmer.foxclub.models.Trick;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FoxService {
  private List<Fox> foxList;

  public FoxService() {
    this.foxList = new ArrayList<>(Arrays.asList(new Fox("Karak"), new Fox("Green")));
  }

  public Fox getFoxName(String name) {
    Optional<Fox> foxName = foxList.stream()
        .filter(e -> e.getName().equals(name))
        .findFirst();
    return foxName.orElse(null);
  }

  public void addTrick(Trick trick, Fox fox){
    fox.getTrickList().add(trick);
  }

  public void addFox(String name) {
    Fox myFox = new Fox(name);
    foxList.add(myFox);
  }

}
