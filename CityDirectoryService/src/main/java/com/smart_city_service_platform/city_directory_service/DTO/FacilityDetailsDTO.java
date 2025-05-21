package com.smart_city_service_platform.city_directory_service.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDetailsDTO {

  @NotNull(message = "Working hours must not be null")
  @Valid
  private WorkingHoursDTO workingHours;

  @NotNull(message = "Address must not be null")
  @Valid
  private AddressDTO address;

}
