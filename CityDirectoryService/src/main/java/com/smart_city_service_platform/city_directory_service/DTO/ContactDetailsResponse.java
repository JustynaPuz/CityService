package com.smart_city_service_platform.city_directory_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetailsResponse {

  private Long id;
  private String phoneNumber;
  private String email;

}
