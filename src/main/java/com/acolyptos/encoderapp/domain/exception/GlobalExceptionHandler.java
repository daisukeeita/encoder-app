package com.acolyptos.encoderapp.domain.exception;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InterruptedIOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleFileHandlingException;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleResourceNotFoundException;
import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleServiceNotAvailableException;

/**
 * Centralized exception handling for layers.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handle exceptions in vehicle file handling (client layer).
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
  @ExceptionHandler(VehicleResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleVehicleResourceNotFoundException(
      final VehicleResourceNotFoundException exception) {
    final ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(VehicleServiceNotAvailableException.class)
  public ResponseEntity<ErrorResponse> handleVehicleServiceNotAvailableException(
      final VehicleServiceNotAvailableException exception) {
    final ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), exception.getMessage());
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
  }

  @ExceptionHandler(UnexpectedError.class)
  public ResponseEntity<ErrorResponse> handleUnexpectederror(final UnexpectedError exception) {
    final ErrorResponse errorResponse =
        new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleAllExceptions(final Exception exception) {
    final ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }

  private HttpStatus mapExceptionsToHttpStatus(final Throwable cause) {
    if (cause instanceof FileNotFoundException) {
      return HttpStatus.NOT_FOUND;
    } else if (cause instanceof EOFException) {
      return HttpStatus.BAD_REQUEST;
    } else if (cause instanceof InterruptedIOException) {
      return HttpStatus.REQUEST_TIMEOUT;
    }

    return HttpStatus.INTERNAL_SERVER_ERROR;
  }

}
