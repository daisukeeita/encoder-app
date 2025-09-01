package com.acolyptos.encoderapp;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import com.acolyptos.encoderapp.models.VehicleInspection;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class App {
  public static void main(String[] args) throws IOException {
    SpringApplication.run(App.class, args);

    ObjectMapper mapper = new ObjectMapper();
    ClassPathResource resource = new ClassPathResource("mock/vehicle.json");

    VehicleInspection vehicle = mapper.readValue(
        resource.getInputStream().readAllBytes(), 
        VehicleInspection.class
      );

    System.out.println(vehicle.toString());
  }
}
