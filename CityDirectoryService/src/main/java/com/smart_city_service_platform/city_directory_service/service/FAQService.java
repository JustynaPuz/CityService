package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.DTO.FaqRequestDTO;
import com.smart_city_service_platform.city_directory_service.mapper.FaqMapper;
import com.smart_city_service_platform.city_directory_service.model.FAQ;
import com.smart_city_service_platform.city_directory_service.model.FAQCategory;
import com.smart_city_service_platform.city_directory_service.repository.FAQRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FAQService {

  private final FAQRepository faqRepository;
  private final FaqMapper faqMapper;

  public FAQService(FAQRepository faqRepository, FaqMapper faqMapper) {
    this.faqRepository = faqRepository;
    this.faqMapper = faqMapper;
  }

  public List<FAQ> getAllFAQ() {
    return faqRepository.findAll();
  }

  public FAQ getFAQById(Long id) {
    return faqRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("FAQ not found with id: " + id));
  }

  public List<FAQ> getFAQByCategory(FAQCategory category) {
    return faqRepository.findByCategory(category);
  }

  public FAQ createFAQ(FaqRequestDTO dto) {
    FAQ faq = faqMapper.toEntity(dto);
    return faqRepository.save(faq);
  }

  public FAQ updateFAQ(Long id, FaqRequestDTO dto) {
    FAQ existingFAQ = getFAQById(id);
    FAQ updatedAmenity = faqMapper.toEntity(dto);
    updatedAmenity.setId(existingFAQ.getId());
    return faqRepository.save(updatedAmenity);
  }

  public void deleteFAQ(Long id) {
    faqRepository.deleteById(id);
  }


}
