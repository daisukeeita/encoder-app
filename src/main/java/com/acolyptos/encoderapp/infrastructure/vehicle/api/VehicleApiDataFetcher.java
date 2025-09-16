package com.acolyptos.encoderapp.infrastructure.vehicle.api;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.acolyptos.encoderapp.domain.exception.UnexpectedError;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleResourceNotFoundException;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleServiceNotAvailableException;
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
  // FIX: Update rest template because this is not safe at all
  private final RestTemplate restTemplate = UnsafeRestTemplateFactory.create();

  @Override
  public VehicleInspection fetchVehicleData(VehicleRequest vehicleRequest) {
    try {
      final HttpHeaders header = new HttpHeaders();
      header.setContentType(MediaType.APPLICATION_JSON);
      final HttpEntity<VehicleRequest> payload =
          new HttpEntity<VehicleRequest>(vehicleRequest, header);

      ResponseEntity<VehicleInspection> response =
          restTemplate.postForEntity(uri, payload, VehicleInspection.class);

      return response.getBody();

    } catch (HttpClientErrorException exception) {
      if (exception.getStatusCode() == HttpStatus.BAD_REQUEST) {
        throw new VehicleResourceNotFoundException(
            "Vehicle was not found in the LTMS database and Legacy data.");
      } else if (exception.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
        throw new VehicleServiceNotAvailableException("Cannot connect to the LTMS.");
      } else {
        throw new UnexpectedError("An unexpected internal server error occured.");
      }
    }
  }
}
