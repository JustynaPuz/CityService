package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.WorkingHoursDTO;
import com.smart_city_service_platform.city_directory_service.model.WorkingHours;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface WorkingHoursMapper {
  WorkingHours toEntity(WorkingHoursDTO dto);

  WorkingHoursDTO toDTO(WorkingHours entity);
}
