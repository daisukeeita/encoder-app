package com.acolyptos.encoderapp.vehicle.repository;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import com.acolyptos.encoderapp.vehicle.exception.VehicleFileHandlingException;
import com.acolyptos.encoderapp.vehicle.model.VehicleInspection;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleFileRepository {

  @Autowired
  private ObjectMapper objectMapper = new ObjectMapper();
  private final ClassPathResource resource = new ClassPathResource("mock/vehicle.json");

  public VehicleFileRepository(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  /**
   * Fetches and return a vehicle information or throws an error if there's no data.
   *
   * @return VehicleInspection object once the data is fetched.
   *
   * @throws IOException if it the file is empty or the data is missing.
   */
  public VehicleInspection fetchVehicleData() throws IOException {
    if (!resource.exists()) {
      throw new VehicleFileHandlingException("Vehicle file not found: " + resource.getPath());
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
