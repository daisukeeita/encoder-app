package com.acolyptos.encoderapp.interfaces.vehicle;

import com.acolyptos.encoderapp.application.vehicle.VehicleAppService;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Controller responsible for handling incoming client request to process the vehicle data once
 * fetched from the external source and returns an appropriate response based on the result.
 */
@RestController
@RequestMapping("api/v1/encoder/")
public class VehicleController {

  private final VehicleAppService vehicleAppService;

  /**
   * Constructs a new VehicleController with necessary dependency.
   *
   * @param vehicleAppService The service that process raw data from the external source. object.
   */
  @Autowired
  public VehicleController(final VehicleAppService vehicleAppService) {
    this.vehicleAppService = vehicleAppService;
  }

  @PostMapping(value = "/requestVehicle", produces = MediaType.APPLICATION_JSON_VALUE)
  public Vehicle retrieveVehicleFromFile(@RequestBody VehicleRequest vehicleRequest)
      throws Exception {
    return vehicleAppService.filterVehicleInspectionFromJson(vehicleRequest);
  }
}
