package com.acolyptos.encoderapp.domain.vehicle.exception;

/** The class responsible for handling the API's thrown service unavailable error. */
public class VehicleServiceNotAvailableException extends VehicleException {
  /**
   * Constructs the class with description of the error.
   *
   * @param message The customized description of the error occured.
   */
  public VehicleServiceNotAvailableException(final String message) {
    super(message);
  }
}
