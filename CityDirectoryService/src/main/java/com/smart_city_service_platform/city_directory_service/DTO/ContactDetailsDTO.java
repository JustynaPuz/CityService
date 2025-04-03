package com.smart_city_service_platform.city_directory_service.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetailsDTO {

  @NotBlank
  private String phoneNumber;
  @NotBlank
  private String email;
}
