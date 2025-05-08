package com.acolyptos.encoderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.acolyptos.encoderapp.utilities.DotenvLoader;

@SpringBootApplication
public class App {
  public static void main(String[] args) {
    DotenvLoader.load();
    SpringApplication.run(App.class, args);  
  }
}
