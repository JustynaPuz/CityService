package com.smart_city_service_platform.city_directory_service.search;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SearchCriteria {

  @NotBlank(message = "Key must not be blank")
  private String key;
  @NotNull(message = "Operation must be specified")
  private SearchOperation operation;
  @NotBlank(message = "Value must not be blank")
  private String value;

}