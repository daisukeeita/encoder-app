package com.acolyptos.encoderapp.domain.vehicle.repository;

import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;

/**
 * Interface for fetching vehicle data.
 */
public interface VehicleClientInterface {

  /**
   * Rule for this interface.
   */
  VehicleInspection fetchVehicleData() throws Exception;
}
