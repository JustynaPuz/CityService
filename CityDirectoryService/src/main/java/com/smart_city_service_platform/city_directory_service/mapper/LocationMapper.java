package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.LocationDTO;
import com.smart_city_service_platform.city_directory_service.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LocationMapper {

  LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

  Location toEntity(LocationDTO dto);

  LocationDTO toDTO(Location entity);
}
