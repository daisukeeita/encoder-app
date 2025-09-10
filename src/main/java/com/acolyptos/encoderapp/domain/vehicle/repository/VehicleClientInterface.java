package com.acolyptos.encoderapp.domain.vehicle.repository;

import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;

/**
 * Interface for fetching vehicle data.
 */
public interface VehicleClientInterface {

  /**
   * Rule for this interface.
   */
  VehicleInspection fetchVehicleData(VehicleRequest vehicleRequest) throws Exception;
}
