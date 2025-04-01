package com.smart_city_service_platform.city_directory_service.search;

import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SearchCriteria {

  private String key;
  private SearchOperation operation;
  private String value;

}