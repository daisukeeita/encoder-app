package com.acolyptos.encoderapp.domain.vehicle.exception;

/**
 * The class responsible for handling the errors that will occur while fetching the raw data from a
 * file.
 */
public class VehicleFileHandlingException extends VehicleException {

  /**
   * Constructs the class with description of the error.
   *
   * @param message The customized description of the error occured.
   */
  public VehicleFileHandlingException(final String message) {
    super(message);
  }

  /**
   * Constructs the class with the description of the error and where it is coming from.
   *
   * @param message The customized description of the error occured.
   * @param cause The source of the error occured.
   */
  public VehicleFileHandlingException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
