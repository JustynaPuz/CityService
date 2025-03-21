package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.model.FAQ;
import com.smart_city_service_platform.city_directory_service.model.FAQCategory;
import com.smart_city_service_platform.city_directory_service.repository.FAQRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FAQService {

  @Autowired
  private final FAQRepository repository;

  public FAQService(FAQRepository repository) {
    this.repository = repository;
  }

  public FAQ save(FAQ faq) {
    return repository.save(faq);
  }

  public List<FAQ> findAll() {
    return repository.findAll();
  }

  public List<FAQ> findByCategory(FAQCategory faqCategory) {
    return repository.findByCategory(faqCategory);
  }

  public Optional<FAQ> findById(Long id) {
    return repository.findById(id);
  }
}
