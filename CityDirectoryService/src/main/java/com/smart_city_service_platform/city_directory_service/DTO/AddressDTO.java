package com.smart_city_service_platform.city_directory_service.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

  @NotBlank
  private String city;
  @NotBlank
  private String country;
  @NotBlank
  private String street;
  @NotBlank
  private String houseNumber;
}