package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.FaqDTO;
import com.smart_city_service_platform.city_directory_service.model.FAQ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FaqMapper {

  FAQ toEntity(FaqDTO dto);

  FaqDTO toDTO(FAQ entity);

}
