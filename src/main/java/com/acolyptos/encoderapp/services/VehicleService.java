package com.acolyptos.encoderapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acolyptos.encoderapp.models.Vehicle;
import com.acolyptos.encoderapp.repositories.VehicleRepository;

@Service
public class VehicleService {

  private final VehicleRepository vehicleRepository;

  @Autowired
  public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  // Check the vehicle on local database or else fetch the vehicle from LTMS
  // API.
  public Vehicle getVehicleByPlateNumber(String plateNumber) {
    return vehicleRepository.findVehicleByPlateNumber(plateNumber)  
      .orElseGet(() -> {
        Vehicle vehicleFromLTMS = ltmsClient.fetchVehicle(plateNumber);
        return vehicleRepository.save(vehicleFromLTMS);
    });
  }

  public Vehicle getVehicleByChassisNumber(String chassisNumber) {
    return vehicleRepository.findVehicleByChassisNumber(chassisNumber)
      .orElseGet(() -> {
        Vehicle vehicleFromLTMS = ltmsClient.fetchVehicle(chassisNumber);
        return vehicleRepository.save(vehicleFromLTMS);
    });
  }

  public Vehicle getVehicleByMvFileNumber(String mvFileNumber) {
    return vehicleRepository.findVehicleByMvFileNumber(mvFileNumber)
      .orElseGet(() -> {
      Vehicle vehicleFromLTMS = ltmsClient.fetchVehicle(mvFileNumber);
      return vehicleRepository.save(vehicleFromLTMS);
    })
  }
}
