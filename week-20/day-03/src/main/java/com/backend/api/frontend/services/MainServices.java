package com.backend.api.frontend.services;

import com.backend.api.frontend.models.AppendA;
import com.backend.api.frontend.models.ArrayHandler;
import com.backend.api.frontend.models.DoUntil;
import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.models.Greeter;
import com.backend.api.frontend.models.Sith;
import org.springframework.stereotype.Service;

@Service
public interface MainServices {
  Double doubleValue(Integer valueToBeDoubled);

  Greeter greeter(String name, String title);

  AppendA appendLetterA(String appendTo);

  DoUntil doUntil(String action, DoUntil until);

  ArrayHandler arrayHandler(String what, int[] numbers);

//  Sith sith(String sith);
}
