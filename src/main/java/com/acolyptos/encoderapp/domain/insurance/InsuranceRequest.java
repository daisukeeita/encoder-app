package com.acolyptos.encoderapp.domain.insurance;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceRequest {
  @NotNull @NotEmpty private String ownerName;

  @NotNull @NotEmpty private String ownerAddress;

  @NotEmpty private String idType;

  @NotEmpty private String idNumber;

  @NotNull @NotEmpty private String plateNumber;

  @NotEmpty private String mvFileNumber;

  @NotEmpty private String chassisNumber;

  @NotEmpty private String engineNumber;

  @NotEmpty private String vehicleType;

  @NotEmpty private String vehicleManufacturer;

  @NotEmpty private String vehicleModel;

  @NotEmpty private String modelYear;
}
