package com.acolyptos.encoderapp.domain.insurance;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsurancePolicy {

  @NotNull private String policyNumber;

  @NotNull private String plateNumber;

  @NotNull private String ownerName;

  @Override
  public String toString() {
    return "InsurancePolicy {\n\tpolicyNumber: "
        + policyNumber
        + ",\n\tplateNumber: "
        + plateNumber
        + ",\n\townerName: "
        + ownerName
        + "\n}";
  }
}
