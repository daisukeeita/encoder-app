package com.acolyptos.encoderapp;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableAutoConfiguration(
//     exclude = {
//       DataSourceAutoConfiguration.class,
//       DataSourceTransactionManagerAutoConfiguration.class,
//       HibernateJpaAutoConfiguration.class
//     })
public class App {
  private static final Logger serverLog = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) throws IOException {
    Dotenv dotenv = Dotenv.load();
    dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

    SpringApplication.run(App.class, args);
    serverLog.info("Encoder Application started.");
  }
}
