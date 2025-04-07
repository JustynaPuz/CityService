package com.smart_city_service_platform.city_directory_service.DTO;

import com.smart_city_service_platform.city_directory_service.validation.ValidTimeRange;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidTimeRange
public class WorkingHoursDTO {

  @NotNull(message = "Start time must not be null")
  private LocalTime fromTime;

  @NotNull(message = "End time must not be null")
  private LocalTime toTime;

}
