package com.smart_city_service_platform.city_directory_service.DTO;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHoursDTO {

  private LocalTime fromTime;
  private LocalTime toTime;

}
