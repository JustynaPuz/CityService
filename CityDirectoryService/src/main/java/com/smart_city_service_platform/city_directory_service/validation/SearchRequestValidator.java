package com.smart_city_service_platform.city_directory_service.validation;

import org.springframework.data.domain.Sort;

public class SearchRequestValidator {
  public static void validateSortDirection(String direction) {
    try {
      Sort.Direction.fromString(direction);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Sort direction must be 'asc' or 'desc'");
    }
  }

  public static void validatePageAndSize(int page, int size) {
    if (page < 0) {
      throw new IllegalArgumentException("Page index must not be negative");
    }
    if (size <= 0 || size > 100) {
      throw new IllegalArgumentException("Page size must be between 1 and 100");
    }
  }

}
