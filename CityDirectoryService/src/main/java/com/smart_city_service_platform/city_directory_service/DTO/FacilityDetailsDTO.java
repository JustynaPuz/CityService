package com.smart_city_service_platform.city_directory_service.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDetailsDTO {

  @NotNull
  private WorkingHoursDTO workingHours;
  @NotNull
  private AddressDTO address;
}
