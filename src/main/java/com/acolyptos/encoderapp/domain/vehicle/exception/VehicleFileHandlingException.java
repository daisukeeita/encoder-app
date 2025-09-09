package com.acolyptos.encoderapp.vehicle.exception;

/**
 * Custom class exception for repository layer.
 */
public class VehicleFileHandlingException extends VehicleException {

  /**
   * Class constructor of File Handling Exceptions.
   *
   * @param message description of error occured.
   */
  public VehicleFileHandlingException(final String message) {
    super(message);
  }

  /**
   * Class constructor of File Handling Exceptions.
   *
   * @param message description of error occured.
   * @param cause source of error occured.
   */
  public VehicleFileHandlingException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
