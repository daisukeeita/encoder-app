package com.acolyptos.encoderapp.vehicle.exception;

/**
 * The generic business exception.
 */
public class VehicleException extends RuntimeException {
  /**
   * Contructor of the Vehicle Exception Class with an error message.
   *
   * @param message error message.
   */
  public VehicleException(final String message) {
    super(message);
  }

  /**
   * Contructor of the Vehicle Exception Class with an error message.
   *
   * @param message message of the error occured.
   * @param cause cause of the error occured.
   */
  public VehicleException(final String message, final Throwable cause) {
    super(message, cause);
  }
}


