package com.acolyptos.encoderapp.interfaces.vehicle;

import com.acolyptos.encoderapp.application.vehicle.VehicleAppService;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Controller responsible for handling incoming client request to process the vehicle data once
 * fetched from the external source and returns an appropriate response based on the result.
 */
@RestController
@RequestMapping("api/v1/encoder/")
public class VehicleController {

  private final VehicleAppService vehicleAppService;
  private static final Logger clientLog = LoggerFactory.getLogger("client.requests");
  private static final Logger serverLog = LoggerFactory.getLogger(VehicleController.class);

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
  public Vehicle retrieveVehicleDetails(@RequestBody VehicleRequest vehicleRequest)
      throws Exception {
    serverLog.info("Received a request from the client: {}", vehicleRequest.getPlate_no());
    return vehicleAppService.filterVehicleInspectionFromJson(vehicleRequest);
  }

  @PostMapping(value = "/clientLog")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void receiveClientLog(@RequestBody Map<String, Object> logPayload) {
    String level = (String) logPayload.getOrDefault("level", "INFO");
    String message = (String) logPayload.getOrDefault("message", "Client Log Received.");

    logPayload.forEach((key, value) -> MDC.put(key, String.valueOf(value)));

    try {
      switch (level.toUpperCase()) {
        case "ERROR":
          clientLog.error("Client Error: {}", message);
          break;
        case "WARN":
          clientLog.warn("Client Warning: {}", message);
          break;
        case "INFO":
        default:
          clientLog.info("Client Info: {}", message);
          break;
      }
    } finally {
      MDC.clear();
    }
  }
}
