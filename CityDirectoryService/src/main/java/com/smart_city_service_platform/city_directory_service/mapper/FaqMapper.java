package com.smart_city_service_platform.city_directory_service.mapper;

import com.smart_city_service_platform.city_directory_service.DTO.FAQResponse;
import com.smart_city_service_platform.city_directory_service.DTO.FaqRequestDTO;
import com.smart_city_service_platform.city_directory_service.model.FAQ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FaqMapper {

  FAQ toEntity(FaqRequestDTO dto);

  FaqRequestDTO toDTO(FAQ entity);

  FAQResponse toResponse(FAQ entity);

}
