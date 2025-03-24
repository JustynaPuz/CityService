package com.smart_city_service_platform.city_directory_service.DTO;

import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AmenityRequestDTO {

  private String name;
  private AmenityCategory category;
  private LocationDTO location;
  private FacilityDetailsDTO details;

}
