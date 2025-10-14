package com.acolyptos.encoderapp.domain.user.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRegistrationRequest {

  @NotNull @NotEmpty private String username;

  @NotNull @NotEmpty private String plainPassword;

  @NotNull @NotEmpty private String firstName;

  @NotNull @NotEmpty private String middleInitial;

  @NotNull @NotEmpty private String lastName;

  @NotNull
  @Digits(integer = 1, fraction = 0)
  @Positive
  private Long roleId;
}
