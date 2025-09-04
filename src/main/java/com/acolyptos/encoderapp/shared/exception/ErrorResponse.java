package com.acolyptos.encoderapp.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Custom Error Response Class.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

  private int statusCode;
  private String message;

  /**
   * Custom constructor for Error Response Object.
   *
   * @param message explaining the error occured
   */
  public ErrorResponse(final String message) {
    super();
    this.message = message;
  }
}
