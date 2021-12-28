package com.github.fish895623.commandque;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Que {
  // 123
  @RequestMapping(method = RequestMethod.POST, path = "/a")
  public InfoVO aa(@RequestBody InfoVO body) {
    body.setT(body.getName() + "123");
    return body;
  }
}
