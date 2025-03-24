package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.AmenityRequestDTO;
import com.smart_city_service_platform.city_directory_service.model.Amenity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LocationMapper.class, FacilityDetailsMapper.class})
public interface AmenityMapper {

  Amenity toEntity(AmenityRequestDTO dto);

  AmenityRequestDTO toDTO(Amenity entity);

}
