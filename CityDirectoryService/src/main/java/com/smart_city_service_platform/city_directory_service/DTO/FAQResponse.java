package com.smart_city_service_platform.city_directory_service.DTO;

import com.smart_city_service_platform.city_directory_service.model.FAQCategory;
import lombok.Data;

@Data
public class FAQResponse {
  private Long id;
  private String question;
  private String answer;
  private FAQCategory category;

}
