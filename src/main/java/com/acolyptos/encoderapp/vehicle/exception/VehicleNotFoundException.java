package com.acolyptos.encoderapp.vehicle.exception;

/**
 * Class Exception for Service Layer.
 */
public class VehicleNotFoundException extends VehicleException {

  /**
   * Constructor of the class.
   */
  public VehicleNotFoundException(String vehicleProperty) {

    super("Vehicle with property: " + vehicleProperty + " not found.");
  }

}
