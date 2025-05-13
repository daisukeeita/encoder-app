package com.acolyptos.encoderapp.exceptions;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.acolyptos.encoderapp.models.ErrorReponse;
import com.acolyptos.encoderapp.models.ValidationErrorResponse;

public class GlobalExceptionHandler {

  private final static Logger LOGGER = 
    LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorReponse> handleEntityNotFoundException(
    EntityNotFoundException exception
  ) {
    LOGGER.error("Entity Not Found Exception occured: {}", exception.getMessage());
    return buildErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ValidationErrorResponse> handleValidationException(
    ValidationException exception
  ) {
    LOGGER.error("Validation Exception occured: {}", exception.getMessage());
    return buildValidationErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST); 
  }

  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ResponseEntity<ErrorReponse> handleBusinessException (
    BusinessException exception
  ) {
    LOGGER.error("Business Exception occurred: {}", exception.getMessage());
    return buildErrorResponse(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(DataAccessException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorReponse> handleDataAccessException (
    DataAccessException exception
  ) {
    LOGGER.error("Data Access Exception occurred: {}", exception.getMessage());
    return buildErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorReponse> handleUnexpectedException (
    Exception exception
  ) {
    LOGGER.error("Unhandled Exception occurred: {}", exception.getMessage());
    return buildErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<ValidationErrorResponse> buildValidationErrorResponse (
    String message,
    HttpStatus status
  ) {
    ValidationErrorResponse response = new ValidationErrorResponse(
      message, 
      status.value()
    );

    return new ResponseEntity<>(response, status);
  }

  private ResponseEntity<ErrorReponse> buildErrorResponse (
    String message,
    HttpStatus status
  ) {
    ErrorReponse errorReponse = new ErrorReponse(
      message, 
      status.value(), 
      LocalDateTime.now()
    );

    return new ResponseEntity<>(errorReponse, status);
  }
}
