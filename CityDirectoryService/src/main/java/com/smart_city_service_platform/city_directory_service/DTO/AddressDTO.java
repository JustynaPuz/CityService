package com.smart_city_service_platform.city_directory_service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

  private static final int NAME_MIN_LENGTH = 2;
  private static final int NAME_MAX_LENGTH = 50;
  private static final int STREET_MAX_LENGTH = 100;
  private static final int HOUSE_NUMBER_MAX_LENGTH = 10;

  @NotBlank(message = "City must not be blank")
  @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH, message = "City length must be between {min} and {max} characters")
  private String city;

  @NotBlank(message = "Country must not be blank")
  @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH, message = "Country length must be between {min} and {max} characters")
  private String country;

  @NotBlank(message = "Street must not be blank")
  @Size(max = STREET_MAX_LENGTH, message = "Street must not exceed {max} characters")
  private String street;

  @NotBlank(message = "House number must not be blank")
  @Size(max = HOUSE_NUMBER_MAX_LENGTH, message = "House number must not exceed {max} characters")
  private String houseNumber;
}