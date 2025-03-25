package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.DTO.GovernmentOfficeDTO;
import com.smart_city_service_platform.city_directory_service.mapper.GovernmentOfficeMapper;
import com.smart_city_service_platform.city_directory_service.model.GovernmentOffice;
import com.smart_city_service_platform.city_directory_service.model.OfficeCategory;
import com.smart_city_service_platform.city_directory_service.repository.GovernmentOfficeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class GovernmentOfficeService {

  private final GovernmentOfficeRepository governmentOfficeRepository;
  private final GovernmentOfficeMapper governmentOfficeMapper;

  public GovernmentOfficeService(GovernmentOfficeRepository repository,
      GovernmentOfficeMapper governmentOfficeMapper) {
    this.governmentOfficeRepository = repository;
    this.governmentOfficeMapper = governmentOfficeMapper;
  }

  public List<GovernmentOffice> getAllOffices() {
    return governmentOfficeRepository.findAll();
  }

  public GovernmentOffice getOfficeById(Long id) {
    return governmentOfficeRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Office not found with id: " + id));
  }

  public List<GovernmentOffice> getOfficesByCategory(OfficeCategory category) {
    return governmentOfficeRepository.findByCategory(category);
  }

  public List<GovernmentOffice> getOfficesByLocation(Long locationId) {
    return governmentOfficeRepository.findByLocation_Id(locationId);
  }

  public GovernmentOffice createOffice(GovernmentOfficeDTO dto) {
    GovernmentOffice office = governmentOfficeMapper.toEntity(dto);
    return governmentOfficeRepository.save(office);
  }

  public GovernmentOffice updateOffice(Long id, GovernmentOfficeDTO dto) {
    GovernmentOffice existingOffice = getOfficeById(id);
    GovernmentOffice updatedOffice = governmentOfficeMapper.toEntity(dto);
    updatedOffice.setId(existingOffice.getId());
    return governmentOfficeRepository.save(updatedOffice);
  }

  public void deleteOffice(Long id) {
    governmentOfficeRepository.deleteById(id);
  }
}