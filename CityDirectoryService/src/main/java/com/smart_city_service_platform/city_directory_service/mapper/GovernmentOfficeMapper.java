package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.GovernmentOfficeDTO;
import com.smart_city_service_platform.city_directory_service.model.GovernmentOffice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {WorkingHoursMapper.class, LocationMapper.class})
public interface GovernmentOfficeMapper {
  GovernmentOffice toEntity(GovernmentOfficeDTO dto);

  GovernmentOfficeDTO toDTO(GovernmentOffice entity);
}
