package com.acolyptos.encoderapp.infrastructure.vehicle.api;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;
import com.acolyptos.encoderapp.domain.vehicle.repository.VehicleClientInterface;
import com.acolyptos.encoderapp.shared.UnsafeRestTemplateFactory;
import io.github.cdimascio.dotenv.Dotenv;

@Component
@Profile("dev")
public class VehicleApiDataFetcher implements VehicleClientInterface {

  private final Dotenv dotenv = Dotenv.load();
  private final String uri = dotenv.get("API_URI");
  private final HttpHeaders header = new HttpHeaders();
  // FIX: Update rest template because this is not safe at all
  private final RestTemplate restTemplate = UnsafeRestTemplateFactory.create();

  @Override
  public VehicleInspection fetchVehicleData(VehicleRequest vehicleRequest) {

    header.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<VehicleRequest> entity = new HttpEntity<>(vehicleRequest, header);

    ResponseEntity<VehicleInspection> response = restTemplate.postForEntity(uri, entity, VehicleInspection.class);

    return response.getBody();

  }
}
