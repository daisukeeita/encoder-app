package com.acolyptos.encoderapp.repositories;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.acolyptos.encoderapp.models.VehicleDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class VehicleFileClient {

  private final ObjectMapper mapper = new ObjectMapper();

  public VehicleDTO getVehicleInfoFromFileByLicencePlate (String licensePlate) throws Exception {
    try {
      ClassPathResource resource = new ClassPathResource("/mock/vehicle.json");
      ObjectMapper mapper = new ObjectMapper();
      JsonNode root = mapper.readTree(resource.getInputStream());

      if (!root.isArray()) {
        throw new Exception("{\"error\":\"Invalid JSON format\"}");
      }

      for (JsonNode vehicle : root) {
        if (licensePlate
            .equals(vehicle.path("Vehicle_Information").path("License_Plate").asText())) {
          VehicleDTO vehicleDTO = mapper.readValue(vehicle.asText(), VehicleDTO.class);  
          return vehicleDTO;
        }
      }
    } catch (Exception e) {
      throw new Exception("Vehicle Not Found.");
    }
  }

}
