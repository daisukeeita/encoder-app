package com.acolyptos.encoderapp.vehicle.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import com.acolyptos.encoderapp.vehicle.exception.VehicleDataParseException;
import com.acolyptos.encoderapp.vehicle.exception.VehicleNotFoundException;
import com.acolyptos.encoderapp.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.vehicle.model.VehicleInformation;
import com.acolyptos.encoderapp.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.vehicle.repository.VehicleFileRepository;

@Service
public class VehicleFileService {

  private final VehicleFileRepository vehicleFileRepository;

  public VehicleFileService(VehicleFileRepository vehicleFileRepository) {
    this.vehicleFileRepository = vehicleFileRepository;
  }

  public Vehicle setFilterVehicleInformationFromJson() throws IOException {
    try {
      VehicleInspection vehicleInspection = vehicleFileRepository.fetchVehicleData();
      VehicleInformation vehicleInformation = vehicleInspection.getVehicleInformation();

      if (vehicleInformation == null) {
        throw new VehicleNotFoundException("Vehicle Information is missing from response.");
      }
      if (vehicleInspection.getInspectionId() == null
          || vehicleInspection.getInspectionId().isBlank()) {
        throw new VehicleNotFoundException("Inspection ID is missing from response.");
      }
      if (vehicleInformation.getLicensePlate() == null
          || vehicleInformation.getLicensePlate().isBlank()) {
        throw new VehicleNotFoundException("License Plate is missing from response.");
      }
      if (vehicleInformation.getChassis() == null || vehicleInformation.getChassis().isBlank()) {
        throw new VehicleNotFoundException("Chassis is missing from response.");
      }
      if (vehicleInformation.getEngine() == null || vehicleInformation.getEngine().isBlank()) {
        throw new VehicleNotFoundException("Engine is missing from response.");
      }
      if (vehicleInformation.getMvFileNumber() == null
          || vehicleInformation.getMvFileNumber().isBlank()) {
        throw new VehicleNotFoundException("MV File Number is missing from response.");
      }
      if (vehicleInformation.getColor() == null || vehicleInformation.getColor().isBlank()) {
        throw new VehicleNotFoundException("Color is missing from response.");
      }
      if (vehicleInformation.getCategory() == null || vehicleInformation.getCategory().isBlank()) {
        throw new VehicleNotFoundException("Category is missing from response.");
      }
      if (vehicleInformation.getBrand() == null || vehicleInformation.getBrand().isBlank()) {
        throw new VehicleNotFoundException("Brand is missing from response.");
      }
      if (vehicleInformation.getManufacturer() == null
          || vehicleInformation.getManufacturer().isBlank()) {
        throw new VehicleNotFoundException("Manufacturer is missing from response.");
      }
      if (vehicleInformation.getModelYear() == null
          || vehicleInformation.getModelYear().isBlank()) {
        throw new VehicleNotFoundException("Model Year is missing from response.");
      }
      if (vehicleInformation.getFuelType() == null || vehicleInformation.getFuelType().isBlank()) {
        throw new VehicleNotFoundException("Fuel Type is missing from response.");
      }

      Vehicle vehicle = new Vehicle();
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

    } catch (VehicleDataParseException exception) {
      throw new VehicleNotFoundException("Error fetching data.");
    } catch (IOException e) {
      throw new VehicleNotFoundException("Vehicle not registered to LTMS.");
    }
  }
}
