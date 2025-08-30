package com.acolyptos.encoderapp.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/mockLtms")
public class VehicleMockController {

  @GetMapping("/vehicle")
  public ResponseEntity<String> getVehicleInfo() throws IOException {
    ClassPathResource resource = new ClassPathResource("mock/vehicle.json");
    String json = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
  }

  @GetMapping(path = "/vehicle/{licensePlate}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getVehicleInfoByLicensePlate(@PathVariable String licensePlate)
      throws IOException {

    try {
      ClassPathResource resource = new ClassPathResource("mock/vehicle.json");
      ObjectMapper mapper = new ObjectMapper();
      JsonNode root = mapper.readTree(resource.getInputStream());

      if (!root.isArray()) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("{\"error\":\"Invalid JSON format\"}");
      }
      for (JsonNode vehicle : root) {
        if (licensePlate.equals(vehicle.path("Vehicle_Information").path("License_Plate").asText())) {
          return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(mapper.writeValueAsString(vehicle));
        }
      }

      return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("{\"error\":\"Vehicle not found\"}");

    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("{\"error\":\"Could not read vehicle.json\"}");
    }
  }
}
