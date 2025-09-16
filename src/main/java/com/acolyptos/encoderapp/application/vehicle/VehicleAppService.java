package com.acolyptos.encoderapp.application.vehicle;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acolyptos.encoderapp.domain.exception.UnexpectedError;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;
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
  public VehicleAppService(final Validator validator, final VehicleService vehicleService,
      final VehicleClientInterface vehicleClientInterface) {
    this.validator = validator;
    this.vehicleService = vehicleService;
    this.vehicleClientInterface = vehicleClientInterface;
  }

  public Vehicle filterVehicleInspectionFromJson(final VehicleRequest vehicleRequest)
      throws Exception {

    try {
      final VehicleInspection vehicleInspection =
          vehicleClientInterface.fetchVehicleData(vehicleRequest);

      final Set<ConstraintViolation<VehicleInspection>> violations =
          validator.validate(vehicleInspection);

      if (!violations.isEmpty()) {
        throw new ConstraintViolationException(violations);
      }

      return vehicleService.processVehicleInspectionToVehicle(vehicleInspection);

    } catch (final Exception exception) {
      throw new UnexpectedError("Unexpected I/O error occured: " + exception.getMessage());
    }
  }

}
