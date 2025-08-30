package com.acolyptos.encoderapp.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.core.io.ClassPathResource;
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
  public ResponseEntity<String> getVehicleInfo () throws IOException {
    ClassPathResource resource = new ClassPathResource("mock/vehicle.json");
    String json = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

    return ResponseEntity.ok()
      .contentType(MediaType.APPLICATION_JSON)
      .body(json);
  }

  @GetMapping("/vehicle/{licensePlate}")
  public ResponseEntity<Object> getVehicleInfoBylicensePlate (@PathVariable String licensePlate) throws IOException {
    ClassPathResource resource = new ClassPathResource("mock/vehicle.json");
    
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(resource.getInputStream());

    JsonNode match = null;

    // Assuming that variable 'root' is an array object
    for (JsonNode vehicle : root) {
      if (licensePlate.equals(vehicle.get("Vehicle_Information").get("License_Plate").asText())) {
        match = vehicle;
        break;
      }
    }

    if (match == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok()
      .contentType(MediaType.APPLICATION_JSON)
      .body(match);
  }
}
