package com.github.fish895623.commandque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class App {
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(App.class);
    app.addListeners(new ApplicationPidFileWriter());
    app.run(args);
  }
}
