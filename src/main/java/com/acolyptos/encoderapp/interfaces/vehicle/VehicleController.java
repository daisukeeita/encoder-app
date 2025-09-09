package com.acolyptos.encoderapp.interfaces.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acolyptos.encoderapp.application.vehicle.VehicleAppService;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;

@RestController
@RequestMapping(path = "/api/v1/vehicleInformation", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {

  private final VehicleAppService vehicleAppService;

  @Autowired
  public VehicleController(final VehicleAppService vehicleAppService) {
    this.vehicleAppService = vehicleAppService;
  }

  @GetMapping("/mock")
  public Vehicle retrieveVehicleFromFile() throws Exception {
    return vehicleAppService.filterVehicleInspectionFromJson();
  }
}
