package com.smart_city_service_platform.city_directory_service.validation;

import org.springframework.data.domain.Sort;

public class SearchRequestValidator {

  private static final int MIN_PAGE_INDEX = 0;
  private static final int MIN_PAGE_SIZE = 1;
  private static final int MAX_PAGE_SIZE = 100;

  public static void validateSortDirection(String direction) {
    try {
      Sort.Direction.fromString(direction);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Sort direction must be 'asc' or 'desc'");
    }
  }

  public static void validatePageAndSize(int page, int size) {
    if (page < MIN_PAGE_INDEX) {
      throw new IllegalArgumentException("Page index must not be negative");
    }
    if (size < MIN_PAGE_SIZE || size > MAX_PAGE_SIZE) {
      throw new IllegalArgumentException("Page size must be between " + MIN_PAGE_SIZE + " and " + MAX_PAGE_SIZE);
    }
  }
}
