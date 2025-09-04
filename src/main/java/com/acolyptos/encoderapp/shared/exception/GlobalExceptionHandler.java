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
