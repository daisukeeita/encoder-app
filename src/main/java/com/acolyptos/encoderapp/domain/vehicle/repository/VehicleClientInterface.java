package com.acolyptos.encoderapp.domain.vehicle.repository;

import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;

/** A client interface for fetching raw vehicle data from an external source. */
public interface VehicleClientInterface {

  /**
   * Fetches raw vehicle data from either a file or an API.
   *
   * @param vehicleRequest The request containing the criteria used to find vehicle details.
   * @return A {@link VehicleInspection} for the requested vehicle.
   * @throws Exception if the vehicle data cannot be found or an error occurs during the fetch.
   */
  VehicleInspection fetchVehicleData(VehicleRequest vehicleRequest);
}
