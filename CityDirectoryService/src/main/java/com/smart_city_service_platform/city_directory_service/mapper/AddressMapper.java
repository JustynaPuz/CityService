package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.AddressDTO;
import com.smart_city_service_platform.city_directory_service.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  Address toEntity(AddressDTO dto);

  AddressDTO toDTO(Address entity);
}
