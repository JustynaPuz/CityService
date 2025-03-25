package com.smart_city_service_platform.city_directory_service.DTO;

import com.smart_city_service_platform.city_directory_service.model.OfficeCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GovernmentOfficeDTO {
  private String name;
  private OfficeCategory category;
  private LocationDTO location;
  private FacilityDetailsDTO details;

}