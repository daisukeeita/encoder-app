package com.acolyptos.encoderapp.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acolyptos.encoderapp.models.Vehicle;
import com.acolyptos.encoderapp.services.VehicleFileService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/mock/vehicleInformation", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleFileController {

  private final VehicleFileService vehicleFileService;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  public VehicleFileController (VehicleFileService vehicleFileService) {
    this.vehicleFileService = vehicleFileService;
  }

  @GetMapping("/v1")
  public ResponseEntity<Vehicle> getVehicleInformation() throws IOException {
    try {
      Vehicle vehicle = vehicleFileService.filterVehicleInformationFromJson();

      return ResponseEntity.ok(vehicle);

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
