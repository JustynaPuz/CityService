package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.LocationDTO;
import com.smart_city_service_platform.city_directory_service.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

  Location toEntity(LocationDTO dto);

  LocationDTO toDTO(Location entity);
}
