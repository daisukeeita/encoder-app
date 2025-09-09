package com.acolyptos.encoderapp.infrastructure.vehicle.file;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleFileHandlingException;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.repository.VehicleClientInterface;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class VehicleFileDataFetcher implements VehicleClientInterface {

  private final ObjectMapper objectMapper;
  private final ClassPathResource resource = new ClassPathResource("mock/vehicle.json");

  public VehicleFileDataFetcher(final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public VehicleInspection fetchVehicleData() {

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
