package com.smart_city_service_platform.city_directory_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

  private Long id;
  private String city;
  private String country;
  private String street;
  private String houseNumber;
}
