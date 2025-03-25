package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.model.GovernmentOffice;
import com.smart_city_service_platform.city_directory_service.repository.GovernmentOfficeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class GovernmentOfficeService {

  private final GovernmentOfficeRepository repository;

  public GovernmentOfficeService(GovernmentOfficeRepository repository) {
    this.repository = repository;
  }

  public GovernmentOffice save(GovernmentOffice office) {
    return repository.save(office);
  }

  public List<GovernmentOffice> findAll() {
    return repository.findAll();
  }
}