package com.smart_city_service_platform.city_directory_service.DTO;

import com.smart_city_service_platform.city_directory_service.model.FAQCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FaqRequestDTO {

  @NotBlank
  private String question;
  @NotBlank
  private String answer;
  @NotNull
  private FAQCategory category;

}
