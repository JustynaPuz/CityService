package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.FacilityDetailsDTO;
import com.smart_city_service_platform.city_directory_service.model.FacilityDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, WorkingHoursMapper.class})
public interface FacilityDetailsMapper {

  FacilityDetails toEntity(FacilityDetailsDTO dto);

  FacilityDetailsDTO toDTO(FacilityDetails entity);

}
