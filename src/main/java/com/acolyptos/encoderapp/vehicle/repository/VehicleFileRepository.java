package com.acolyptos.encoderapp.vehicle.repository;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import com.acolyptos.encoderapp.vehicle.model.VehicleInspection;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class VehicleFileRepository {

  private final ObjectMapper objectMapper = new ObjectMapper();

  public VehicleInspection getVehicleFromJson() throws IOException {
    try {
      ClassPathResource resource = new ClassPathResource("mock/vehicle.json");
      VehicleInspection vehicleInspection = objectMapper.readValue(
        resource.getInputStream().readAllBytes(), 
        VehicleInspection.class
      );

      return vehicleInspection;
    } catch (IOException e) {
      throw new IOException(e.getMessage());
    }
  }
}
