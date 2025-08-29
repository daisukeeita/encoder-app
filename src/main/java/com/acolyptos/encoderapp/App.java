package com.acolyptos.encoderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.acolyptos.encoderapp.models.Vehicle;

@SpringBootApplication
public class App {
  public static void main( String[] args ) {
    SpringApplication.run(App.class, args);

    Vehicle vehicle = new Vehicle(
      "AAR4855",
      "3D7666A51764D251E06373916",
      "MALA251AAEM257815",
      "63HADM23257815",
      "062000000178260",
      "ELECTRIC RED",
      "Light Vehicle",
      "EON",
      "2014",
      "Gas"
    );

    System.out.println(vehicle.toString());
  }
}
