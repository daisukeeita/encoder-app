package com.acolyptos.encoderapp.domain.vehicle.exception;

/**
 * Custom class for missing data exception.
 */
public class VehicleMissingDataException extends VehicleException {

  /**
   * Class constructor for missing data exception.
   *
   * @param message description of error occured
   */
  public VehicleMissingDataException(String message) {
    super(message);
  }
}
