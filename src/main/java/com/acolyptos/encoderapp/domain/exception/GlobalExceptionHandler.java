package com.acolyptos.encoderapp.domain.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InterruptedIOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleDataValidationException;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleFileHandlingException;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleMissingDataException;

/**
 * Centralized exception handling for layers.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handle exceptions in vehicle file handling (repository layer).
   *
   * @param exception exception object that will be passed
   * @return an error reponse object as Reponse Entity
   */
  @ExceptionHandler(VehicleFileHandlingException.class)
  public ResponseEntity<ErrorResponse> handleVehicleFileExceptions(
      final VehicleFileHandlingException exception) {

    final Throwable cause = exception.getCause();
    final HttpStatus status = mapExceptionsToHttpStatus(cause);
    final ErrorResponse errorResponse = new ErrorResponse(status.value(), exception.getMessage());

    return ResponseEntity.status(status).body(errorResponse);
  }

  /**
   * Handle exceptions in validating the vehicle data (service layer).
   *
   * @param exception exception object that will be passed
   * @return an error reponse object as Reponse Entity
   */
  @ExceptionHandler(VehicleDataValidationException.class)
  public ResponseEntity<ErrorResponse> handleVehicleValidationExceptions(
      final VehicleDataValidationException exception) {

    final Throwable cause = exception.getCause();
    final HttpStatus status = mapExceptionsToHttpStatus(cause);
    final ErrorResponse errorResponse = new ErrorResponse(status.value(), exception.getMessage());

    return ResponseEntity.status(status).body(errorResponse);
  }

  @ExceptionHandler(VehicleMissingDataException.class)
  public ResponseEntity<ErrorResponse> handleMissingDataValidationException(
      final VehicleMissingDataException exception) {
    final ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

  private HttpStatus mapExceptionsToHttpStatus(final Throwable cause) {
    if (cause instanceof FileNotFoundException || cause instanceof VehicleMissingDataException) {
      return HttpStatus.NOT_FOUND;
    } else if (cause instanceof EOFException) {
      return HttpStatus.BAD_REQUEST;
    } else if (cause instanceof InterruptedIOException) {
      return HttpStatus.REQUEST_TIMEOUT;
    }

    return HttpStatus.INTERNAL_SERVER_ERROR;
  }

}
