package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.DTO.FAQResponse;
import com.smart_city_service_platform.city_directory_service.DTO.FaqRequestDTO;
import com.smart_city_service_platform.city_directory_service.mapper.FaqMapper;
import com.smart_city_service_platform.city_directory_service.model.FAQ;
import com.smart_city_service_platform.city_directory_service.model.FAQCategory;
import com.smart_city_service_platform.city_directory_service.repository.FAQRepository;
import com.smart_city_service_platform.city_directory_service.search.SearchOperation;
import com.smart_city_service_platform.city_directory_service.specification.FAQSpecificationBuilder;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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

  public List<FAQResponse> getFAQCriteria(String search, String sortBy, String sortDir,
      int page, int size) {
    FAQSpecificationBuilder builder = new FAQSpecificationBuilder();

    if (search != null && !search.isBlank()) {
      String[] operations = search.split(";");
      for (String operation : operations) {
        for (String symbol : SearchOperation.SIMPLE_OPERATION_SET) {
          int idx = operation.indexOf(symbol);
          if (idx != -1) {
            String key = operation.substring(0, idx);
            String value = operation.substring(idx + symbol.length());
            SearchOperation op = SearchOperation.getSimpleOperation(symbol.charAt(0));
            builder.with(key.trim(), op, value.trim());
            break;
          }
        }
      }
    }
    Specification<FAQ> spec = builder.build();
    Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortBy);
    Pageable pageable = PageRequest.of(page, size, sort);

    return faqRepository.findAll(spec, pageable)
        .map(faqMapper::toResponse)
        .toList();
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
