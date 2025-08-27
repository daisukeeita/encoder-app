package com.acolyptos.encoderapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acolyptos.encoderapp.models.Vehicle;
import com.acolyptos.encoderapp.services.VehicleService;

@RestController
@RequestMapping(value = "api/v1/vehicles")
public class VehicleController {

  private final VehicleService vehicleService;

  @Autowired
  public VehicleController (VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GetMapping("/getVehicleByPlateNumber/{plateNumber}")
  public Vehicle getVehicleByPlateNumber(@PathVariable String plateNumber) {
    return vehicleService.getVehicleByPlateNumber(plateNumber);
  }

  @GetMapping("/getVehicleByChassisNumber/{chassisNumber}")
  public Vehicle getVehicleByChassisNumber(@PathVariable String chassisNumber) {
    return vehicleService.getVehicleByChassisNumber(chassisNumber);
  }

  @GetMapping("/getVehicleByMvFileNumber/{mvFileNumber}")
  public Vehicle getVehicleByMvFileNumber(@PathVariable String mvFileNumber) {
    return vehicleService.getVehicleByMvFileNumber(mvFileNumber);
  }
}
