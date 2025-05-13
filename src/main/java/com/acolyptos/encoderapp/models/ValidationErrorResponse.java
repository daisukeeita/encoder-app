package com.acolyptos.encoderapp.models;

import java.time.LocalDateTime;

public class ValidationErrorResponse extends ErrorReponse{
  public ValidationErrorResponse (String message, int status) {
    super(message, status, LocalDateTime.now());
  }
}
