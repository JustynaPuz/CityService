package com.smart_city_service_platform.city_directory_service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetailsDTO {

  private static final int EMAIL_MAX_LENGTH = 100;

  @NotBlank(message = "Phone number must not be blank")
  private String phoneNumber;

  @NotBlank(message = "Email must not be blank")
  @Email(message = "Email must be a valid email address")
  @Size(max = EMAIL_MAX_LENGTH, message = "Email must not exceed {max} characters")
  private String email;
}
