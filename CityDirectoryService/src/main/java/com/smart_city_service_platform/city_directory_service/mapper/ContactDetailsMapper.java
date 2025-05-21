package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.ContactDetailsDTO;
import com.smart_city_service_platform.city_directory_service.model.ContactDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactDetailsMapper {

  ContactDetails toEntity(ContactDetailsDTO dto);

  ContactDetailsDTO toDTO(ContactDetails entity);

}
