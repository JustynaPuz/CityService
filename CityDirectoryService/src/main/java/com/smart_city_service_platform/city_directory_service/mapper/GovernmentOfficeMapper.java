package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.GovernmentOfficeRequestDTO;
import com.smart_city_service_platform.city_directory_service.DTO.GovernmentOfficeResponse;
import com.smart_city_service_platform.city_directory_service.model.GovernmentOffice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FacilityDetailsMapper.class, LocationMapper.class, ContactDetailsMapper.class})
public interface GovernmentOfficeMapper {
  GovernmentOffice toEntity(GovernmentOfficeRequestDTO dto);

  GovernmentOfficeRequestDTO toDTO(GovernmentOffice entity);

  GovernmentOfficeResponse toResponse(GovernmentOffice entity);
}
