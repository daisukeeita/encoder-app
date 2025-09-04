package com.acolyptos.encoderapp.shared.exception;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.acolyptos.encoderapp.vehicle.exception.VehicleDataNotFoundException;
import com.acolyptos.encoderapp.vehicle.exception.VehicleDataParseException;
import com.acolyptos.encoderapp.vehicle.exception.VehicleNotFoundException;

/**
 * Centralized exception handling for layers.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {



  @ExceptionHandler(VehicleNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleVehicleNotFound(
      final VehicleNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(Map.of("error", exception.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, String>> handleGeneral(final Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(Map.of("error", "Unexpected error occured - ", "Details:", exception.getMessage()));
  }
}
