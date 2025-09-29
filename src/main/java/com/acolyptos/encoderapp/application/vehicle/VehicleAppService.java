package com.acolyptos.encoderapp.application.vehicle;

import com.acolyptos.encoderapp.domain.exception.UnexpectedError;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;
import com.acolyptos.encoderapp.domain.vehicle.repository.VehicleClientInterface;
import com.acolyptos.encoderapp.domain.vehicle.service.VehicleService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A Service responsible for handling vehicle-related business logic, including data fetching,
 * validation, and processing.
 */
@Service
public class VehicleAppService {
  private final Validator validator;
  private final VehicleService vehicleService;
  private final VehicleClientInterface vehicleClientInterface;

  /**
   * Constructs a new VehicleAppService with necessary dependencies.
   *
   * @param validator The validator used to check constraints on vehicle inspection data.
   * @param vehicleService The service that processes {@link VehicleInspection} data into a {@link
   *     Vehicle} Object.
   * @param vehicleClientInterface The client for fetching raw vehicle data.
   */
  @Autowired
  public VehicleAppService(
      final Validator validator,
      final VehicleService vehicleService,
      final VehicleClientInterface vehicleClientInterface) {
    this.validator = validator;
    this.vehicleService = vehicleService;
    this.vehicleClientInterface = vehicleClientInterface;
  }

  /**
   * Filters and validates a Vehicle Inspection from a JSON Request.
   *
   * <p>This method fetches raw vehicle data using the provided request, validates the retrieved
   * inspection object, and then process it into a {@link Vehicle} object. If validation fails, it
   * throws {@link ConstraintViolationException}. If an I/O error occurs during data fetching, it
   * throws an {@link UnexpectedError}.
   *
   * @param vehicleRequest The request object containing vehicle information for fetching data.
   * @return A {@link Vehicle} object processed from validated vehicle inspection.
   * @throws UnexpectedError If an I/O or other unexpected issue occurs during data fetching.
   * @throws ConstraintViolationException If the fetched data violates any validation constraints.
   */
  public Vehicle filterVehicleInspectionFromJson(final VehicleRequest vehicleRequest) {
    final VehicleInspection vehicleInspection =
        vehicleClientInterface.fetchVehicleData(vehicleRequest);

    final Set<ConstraintViolation<VehicleInspection>> violations =
        validator.validate(vehicleInspection);

    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    return vehicleService.processVehicleInspectionToVehicle(vehicleInspection);
  }
}
