package com.acolyptos.encoderapp.services;

import java.util.Optional;
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
  // API and save to local DB.
  public Optional<Vehicle> getVehicleByLicensePlate(String licensePlate) {
    return vehicleRepository.findVehicleByLicensePlate(licensePlate);
  }

  // Check the vehicle on local database or else fetch the vehicle from LTMS
  // API and save to local DB.
  public Optional<Vehicle> getVehicleByMvFileNumber(String mvFileNumber) {
    return vehicleRepository.findVehicleByMvFileNumber(mvFileNumber);
  }

  // Check the vehicle on local database or else fetch the vehicle from LTMS
  // API and save to local DB.
  public Optional<Vehicle> getVehicleByEngine(String engine) {
    return vehicleRepository.findVehicleByEngine(engine);
  }

  public Optional<Vehicle> getVehicleByChassis(String chassis) {
    return vehicleRepository.findVehicleByChassis(chassis);
  }

  // This is for updating the cached record of the vehicle (draft)
  // if forceRefresh == false -> search the local database else throw error
  // message
  // if forceRefresh == true -> retrieve the records from LTMS API and update
  // the local database
  // public Vehicle getVehicle (String plateNumber, boolean forceRefresh) {
  // if (!forceRefresh) {
  // return vehicleRepository.findVehicleByPlateNumber(plateNumber)
  // .orElseThrow(() -> new NotFoundException("Vehicle Not Found"));
  // }
  // Vehicle fresh = ltmsClient.fetchVehicle(plateNumber);
  // return vehicleRepository.save(fresh);
  // }


}
