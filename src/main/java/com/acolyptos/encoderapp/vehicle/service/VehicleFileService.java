package com.acolyptos.encoderapp.vehicle.service;

import java.io.IOException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acolyptos.encoderapp.vehicle.exception.VehicleDataValidationException;
import com.acolyptos.encoderapp.vehicle.exception.VehicleFileHandlingException;
import com.acolyptos.encoderapp.vehicle.exception.VehicleMissingDataException;
import com.acolyptos.encoderapp.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.vehicle.repository.VehicleFileRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class VehicleFileService {

  private final VehicleFileRepository vehicleFileRepository;
  private final Validator validator;

  @Autowired
  public VehicleFileService(final VehicleFileRepository vehicleFileRepository,
      final Validator validator) {
    this.vehicleFileRepository = vehicleFileRepository;
    this.validator = validator;
  }

  public Vehicle setFilterVehicleInformationFromJson() throws IOException {
    try {
      final VehicleInspection vehicleInspection = vehicleFileRepository.fetchVehicleData();

      final Set<ConstraintViolation<VehicleInspection>> violations =
          validator.validate(vehicleInspection);
      if (!violations.isEmpty()) {
        throw new ConstraintViolationException(violations);
      }

      return processVehicleInspectionToVehicle(vehicleInspection);
    } catch (final VehicleMissingDataException exception) {
      throw new VehicleDataValidationException(
          "Error in validating the data: " + exception.getMessage(), exception);
    } catch (final VehicleFileHandlingException exception) {
      throw new VehicleDataValidationException(
          "Error in handling vehicle file data: " + exception.getMessage());
    } catch (final IOException exception) {
      throw new VehicleDataValidationException(
          "Unexpected I/O error occured: " + exception.getMessage());
    }
  }

  private Vehicle processVehicleInspectionToVehicle(final VehicleInspection vehicleInspection) {
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
