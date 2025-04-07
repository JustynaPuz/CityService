package com.smart_city_service_platform.city_directory_service.validation;

import com.smart_city_service_platform.city_directory_service.DTO.WorkingHoursDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;

public class TimeRangeValidator implements ConstraintValidator<ValidTimeRange, WorkingHoursDTO> {

  @Override
  public boolean isValid(WorkingHoursDTO dto, ConstraintValidatorContext context) {
    if (Objects.isNull(dto.getFromTime()) || Objects.isNull(dto.getToTime())) {
      return true; //NotNull annotations
    }
    return dto.getFromTime().isBefore(dto.getToTime());
  }
}
