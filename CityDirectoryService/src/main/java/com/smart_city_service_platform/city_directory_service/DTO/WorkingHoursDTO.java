package com.smart_city_service_platform.city_directory_service.DTO;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHoursDTO {

  @NotBlank
  private LocalTime fromTime;
  @NotBlank
  private LocalTime toTime;

}
