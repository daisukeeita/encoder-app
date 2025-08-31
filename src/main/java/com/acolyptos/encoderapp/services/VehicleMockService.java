package com.acolyptos.encoderapp.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.acolyptos.encoderapp.repositories.VehicleFileClient;

@Service
public class VehicleMockService {

  private final VehicleFileClient vehicleFileClient;

  public VehicleMockService (VehicleFileClient vehicleFileClient) {
    this.vehicleFileClient = vehicleFileClient;
  }

  public ResponseEntity<String> filterVehicleInfo(String licensePlate) {
    return vehicleFileClient.getVehicleInfoFromFile(licensePlate);
  }


}
