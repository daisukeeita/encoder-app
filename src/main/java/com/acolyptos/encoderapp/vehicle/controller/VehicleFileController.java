package com.acolyptos.encoderapp.vehicle.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acolyptos.encoderapp.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.vehicle.service.VehicleFileService;

@RestController
@RequestMapping(path = "/mock/vehicleInformation", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleFileController {

  private final VehicleFileService vehicleFileService;

  @Autowired
  public VehicleFileController(final VehicleFileService vehicleFileService) {
    this.vehicleFileService = vehicleFileService;
  }

  @GetMapping("/v1")
  public Vehicle getVehicleInformation() throws IOException {
    return vehicleFileService.setFilterVehicleInformationFromJson();
  }
}
