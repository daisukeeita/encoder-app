package com.acolyptos.encoderapp.infrastructure.vehicle.file;

import com.acolyptos.encoderapp.domain.vehicle.client.VehicleClientInterface;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleFileHandlingException;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/** A class responsible for fetching a raw data from a file. */
@Component
@Profile("mock")
public class VehicleFileDataFetcher implements VehicleClientInterface {

  private final ObjectMapper objectMapper;
  private final ClassPathResource resource = new ClassPathResource("mock/vehicle.json");

  /**
   * Constructs a VehicleFileDataFetcher with necessary dependency.
   *
   * @param objectMapper A service that converts the raw JSON vehicle data into {@link
   *     VehicleInspection} object.
   */
  public VehicleFileDataFetcher(final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  /**
   * Fetches raw vehicle data from a file.
   *
   * <p>This method fetches raw vehicle data from a file. It doesn't use the request body because
   * this is for integration test. It checks if the file exists and process the raw vehicle data
   * into {@link VehicleInspection}. If an error occurs during data fetching or if the files does
   * not exists, it'll throw {@link VehicleFileHandlingException}.
   *
   * @param vehicleRequest The request object containing vehicle information for fetching data.
   *     VehicleRequest won't be used for this method.
   * @return A {@link VehicleInspection} processed from a JSON data.
   * @throws VehicleFileHandlingException if an error occurs during data fetching.
   */
  @Override
  public VehicleInspection fetchVehicleData(VehicleRequest vehicleRequest) {

    if (!resource.exists()) {
      throw new VehicleFileHandlingException("Vehicle file not found from: " + resource.getPath());
    }

    try (InputStream file = resource.getInputStream()) {
      return objectMapper.readValue(file, VehicleInspection.class);
    } catch (final FileNotFoundException exception) {
      throw new VehicleFileHandlingException("Vehicle file not found from: " + resource, exception);
    } catch (final EOFException exception) {
      throw new VehicleFileHandlingException("End of file unexpectedly reached.", exception);
    } catch (final InterruptedIOException exception) {
      throw new VehicleFileHandlingException("I/O operation has been interrupted.", exception);
    } catch (final IOException exception) {
      throw new VehicleFileHandlingException(
          "Unexpected I/O error occured: " + exception.getMessage(), exception);
    }
  }
}
