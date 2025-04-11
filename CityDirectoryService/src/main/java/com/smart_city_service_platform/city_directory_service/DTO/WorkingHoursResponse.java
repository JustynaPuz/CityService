package com.smart_city_service_platform.city_directory_service.DTO;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHoursResponse {

  private Long id;
  private LocalTime fromTime;
  private LocalTime toTime;

}
