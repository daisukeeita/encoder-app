package com.acolyptos.encoderapp.services;

import java.io.IOException;
import org.springframework.stereotype.Service;
import com.acolyptos.encoderapp.models.Vehicle;
import com.acolyptos.encoderapp.models.VehicleInspection;
import com.acolyptos.encoderapp.repositories.VehicleFileRepository;

@Service
public class VehicleFileService {

  private final VehicleFileRepository vehicleFileRepository;

  public VehicleFileService(VehicleFileRepository vehicleFileRepository) {
    this.vehicleFileRepository = vehicleFileRepository;
  }

  public Vehicle filterVehicleInformationFromJson() throws IOException {
    try {
      VehicleInspection vehicleInspection = vehicleFileRepository.getVehicleFromJson();

      Vehicle vehicle = new Vehicle();
      vehicle.setInspectionId(vehicleInspection.getInspectionId());
      vehicle.setLicensePlate(vehicleInspection.getVehicleInformation().getLicensePlate());
      vehicle.setChassis(vehicleInspection.getVehicleInformation().getChassis());
      vehicle.setEngine(vehicleInspection.getVehicleInformation().getEngine());
      vehicle.setMvFileNumber(vehicleInspection.getVehicleInformation().getMvFileNumber());
      vehicle.setColor(vehicleInspection.getVehicleInformation().getColor());
      vehicle.setCategoryType(vehicleInspection.getVehicleInformation().getCategory());
      vehicle.setModel(vehicleInspection.getVehicleInformation().getManufacturer() + " - " + vehicleInspection.getVehicleInformation().getBrand());
      vehicle.setModelYear(vehicleInspection.getVehicleInformation().getModelYear());
      vehicle.setFuelType(vehicleInspection.getVehicleInformation().getFuelType());

      return vehicle;

    } catch (IOException e) {
      throw new IOException(e.getMessage());
    }
  }
}
