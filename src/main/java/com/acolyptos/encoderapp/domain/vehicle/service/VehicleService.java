package com.acolyptos.encoderapp.domain.vehicle.service;

import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;

public class VehicleService {

  public Vehicle processVehicleInspectionToVehicle(final VehicleInspection vehicleInspection) {
    final Vehicle vehicle = new Vehicle();
    vehicle.setInspectionId(vehicleInspection.getInspectionId());
    vehicle.setLicensePlate(vehicleInspection.getVehicleInformation().getLicensePlate());
    vehicle.setChassis(vehicleInspection.getVehicleInformation().getChassis());
    vehicle.setEngine(vehicleInspection.getVehicleInformation().getEngine());
    vehicle.setMvFileNumber(vehicleInspection.getVehicleInformation().getMvFileNumber());
    vehicle.setColor(vehicleInspection.getVehicleInformation().getColor());
    vehicle.setCategoryType(vehicleInspection.getVehicleInformation().getCategory());
    vehicle.setModel(vehicleInspection.getVehicleInformation().getManufacturer() + " - "
        + vehicleInspection.getVehicleInformation().getBrand());
    vehicle.setModelYear(vehicleInspection.getVehicleInformation().getModelYear());
    vehicle.setFuelType(vehicleInspection.getVehicleInformation().getFuelType());

    return vehicle;
  }
}
