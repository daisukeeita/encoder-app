package com.acolyptos.encoderapp.vehicle.exception;

/**
 * Custom class exception for Validating Data (Service Layer).
 */
public class VehicleDataValidationException extends VehicleException {

  /**
   * Class constructor for validation exception.
   *
   * @param message description of error occured
   */
  public VehicleDataValidationException(final String message) {
    super(message);
  }


  /**
   * Class constructor for validation exception.
   *
   * @param message description of error occured
   * @param cause source of error occured
   */
  public VehicleDataValidationException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
