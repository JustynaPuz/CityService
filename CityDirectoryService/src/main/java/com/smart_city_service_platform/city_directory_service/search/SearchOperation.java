package com.smart_city_service_platform.city_directory_service.search;

public enum SearchOperation {
  EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS;

  public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", "<", "~" };

  public static SearchOperation getSimpleOperation(char input) {
    switch (input) {
      case ':':
        return EQUALITY;
      case '!':
        return NEGATION;
      case '>':
        return GREATER_THAN;
      case '<':
        return LESS_THAN;
      case '~':
        return LIKE;
      default:
        return null;
    }
  }
}
