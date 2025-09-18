package com.acolyptos.encoderapp.domain.vehicle.exception;

/** The class responsible for handling the API's thrown vehicle data that not found error. */
public class VehicleResourceNotFoundException extends VehicleException {
  /**
   * Constructs the class with description of the error.
   *
   * @param message The customized description of the error occured.
   */
  public VehicleResourceNotFoundException(final String message) {
    super(message);
  }
}
