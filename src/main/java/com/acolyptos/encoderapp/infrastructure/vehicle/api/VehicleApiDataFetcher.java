package com.acolyptos.encoderapp.infrastructure.vehicle.api;

import com.acolyptos.encoderapp.domain.exception.UnexpectedError;
import com.acolyptos.encoderapp.domain.vehicle.client.VehicleClientInterface;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleResourceNotFoundException;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleServiceNotAvailableException;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;
import com.acolyptos.encoderapp.shared.UnsafeRestTemplateFactory;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/** A class responsible for fetching a raw vehicle data from the API provided. */
@Component
@Profile("dev")
public class VehicleApiDataFetcher implements VehicleClientInterface {

  private final Dotenv dotenv = Dotenv.load();
  private final String uri = dotenv.get("API_URI");
  // FIX: Update rest template because this is not safe at all
  private final RestTemplate restTemplate = UnsafeRestTemplateFactory.create();

  /**
   * Fetches raw vehicle data from the API.
   *
   * <p>This method fetches raw vehicle data from the API provided. It will call the API with its
   * header the provided {@link VehicleRequest}. If the vehicle cannot be found, it'll throw {@link
   * VehicleResourceNotFoundException}. If the API is not available, it'll throw {@link
   * VehicleServiceNotAvailableException}.
   *
   * @param vehicleRequest The request object containing vehicle information for fetching data.
   * @return A {@link VehicleInspection} processed from a JSON data.
   * @throws VehicleResourceNotFoundException if the vehicle data cannot be found.
   * @throws VehicleServiceNotAvailableException if the API is not available.
   * @throws UnexpectedError if an unexpected error occurred while fetching the data.
   */
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
