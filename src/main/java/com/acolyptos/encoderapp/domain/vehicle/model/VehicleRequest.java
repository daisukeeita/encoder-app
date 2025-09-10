package com.acolyptos.encoderapp.domain.vehicle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

  private String chassis_no;
  private String engine_no;
  private String vin_no;
  private String plate_no;
  private String mv_file_no;
}
