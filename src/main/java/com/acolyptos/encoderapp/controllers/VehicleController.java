package com.acolyptos.encoderapp.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acolyptos.encoderapp.models.Vehicle;
import com.acolyptos.encoderapp.services.VehicleService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/vehicles")
public class VehicleController {

  private final VehicleService vehicleService;

  @Autowired
  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GetMapping("/getVehicleByPlateNumber/{plateNumber}")
  public Optional<Vehicle> getVehicleByPlateNumber(@Valid @PathVariable String licensePlate) {
    return vehicleService.getVehicleByLicensePlate(licensePlate);
  }

  @GetMapping("/getVehicleByChassisNumber/{chassisNumber}")
  public Optional<Vehicle> getVehicleByChassisNumber(@Valid @PathVariable String chassis) {
    return vehicleService.getVehicleByChassis(chassis);
  }

  @GetMapping("/getVehicleByMvFileNumber/{mvFileNumber}")
  public Optional< Vehicle > getVehicleByMvFileNumber(@Valid @PathVariable String mvFileNumber) {
    return vehicleService.getVehicleByMvFileNumber(mvFileNumber);
  }
}
