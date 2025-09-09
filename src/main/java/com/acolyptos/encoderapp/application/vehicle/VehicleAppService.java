package com.acolyptos.encoderapp.application.vehicle;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleDataValidationException;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleFileHandlingException;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleMissingDataException;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.repository.VehicleClientInterface;
import com.acolyptos.encoderapp.domain.vehicle.service.VehicleService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class VehicleAppService {
  private final VehicleClientInterface vehicleClientInterface;
  private final VehicleService vehicleService;
  private final Validator validator;

  @Autowired
  public VehicleAppService(final VehicleClientInterface vehicleClientInterface,
      final Validator validator, final VehicleService vehicleService) {
    this.vehicleClientInterface = vehicleClientInterface;
    this.vehicleService = vehicleService;
    this.validator = validator;
  }

  public Vehicle filterVehicleInspectionFromJson() throws Exception {

    try {
      final VehicleInspection vehicleInspection = vehicleClientInterface.fetchVehicleData();

      final Set<ConstraintViolation<VehicleInspection>> violations =
          validator.validate(vehicleInspection);

      if (!violations.isEmpty()) {
        throw new ConstraintViolationException(violations);
      }

      return vehicleService.processVehicleInspectionToVehicle(vehicleInspection);

    } catch (final VehicleMissingDataException exception) {
      throw new VehicleDataValidationException(
          "Error in validating the data: " + exception.getMessage(), exception);
    } catch (final VehicleFileHandlingException exception) {
      throw new VehicleDataValidationException(
          "Error in handling vehicle file data: " + exception.getMessage());
    } catch (final Exception exception) {
      throw new VehicleDataValidationException(
          "Unexpected I/O error occured: " + exception.getMessage());
    }
  }

}
