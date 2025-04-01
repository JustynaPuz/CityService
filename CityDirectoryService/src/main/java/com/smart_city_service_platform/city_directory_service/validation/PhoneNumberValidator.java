package com.smart_city_service_platform.city_directory_service.validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

  private static final String PHONE_PATTERN = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value == null || value.matches(PHONE_PATTERN);
  }
}
