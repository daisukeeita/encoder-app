package com.acolyptos.encoderapp.domain.exception;

public class UnexpectedError extends RuntimeException {

  public UnexpectedError (final String message, final Throwable cause) {
    super(message, cause);
  }

  public UnexpectedError (final String message) {
    super(message);
  }
}
