package com.acolyptos.encoderapp.domain.vehicle.service;

import org.springframework.stereotype.Service;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;

@Service
public class VehicleService {

  public Vehicle processVehicleInspectionToVehicle(final VehicleInspection vehicleInspection) {
    final Vehicle vehicle = new Vehicle();
    vehicle.setInspectionId(vehicleInspection.getInspectionId());
    vehicle.setLicensePlate(vehicleInspection.getVehicleInformation().getLicensePlate());
    vehicle.setChassis(vehicleInspection.getVehicleInformation().getChassis());
    vehicle.setEngine(vehicleInspection.getVehicleInformation().getEngine());
    vehicle.setMvFileNumber(vehicleInspection.getVehicleInformation().getMvFileNumber());
    vehicle.setModel(vehicleInspection.getVehicleInformation().getManufacturer() + " - "
          + vehicleInspection.getVehicleInformation().getBrand());
    vehicle.setFuelType(vehicleInspection.getVehicleInformation().getFuelType());

    if (vehicleInspection.getVehicleInformation().getColor() == null) {
      vehicle.setColor("Color was not provided. Please see the nearest LTO to update the Vehicle Color.");
    } else {
      vehicle.setColor(vehicleInspection.getVehicleInformation().getColor());
    }

    if (vehicleInspection.getVehicleInformation().getCategoryType() == null) {
      vehicle.setCategoryType("Category Type was not provided. Please see the nearest LTO to update the Vehicle Category Type.");
    } else {
      vehicle.setCategoryType(vehicleInspection.getVehicleInformation().getCategoryType());
    }

    if (vehicleInspection.getVehicleInformation().getModelYear() == null) {
      vehicle.setModelYear("Year Model was not provided. Please see the nearest LTO to update the Vehicle Year Model.");
    } else {
      vehicle.setModelYear(vehicleInspection.getVehicleInformation().getModelYear());
    }
    return vehicle;
  }
}
