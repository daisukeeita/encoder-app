package com.acolyptos.encoderapp.domain.vehicle.exception;

/** The class responsible for the entry point of Exception Handlers of Vehicle Feature. */
public class VehicleException extends RuntimeException {
  /**
   * Constructs the class with description of the error.
   *
   * @param message The customized description of the error occured.
   */
  public VehicleException(final String message) {
    super(message);
  }

  /**
   * Constructs the class with the description of the error and where it is coming from.
   *
   * @param message The customized description of the error occured.
   * @param cause The source of the error occured.
   */
  public VehicleException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
