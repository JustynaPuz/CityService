package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.DTO.AmenityRequestDTO;
import com.smart_city_service_platform.city_directory_service.mapper.AmenityMapper;
import com.smart_city_service_platform.city_directory_service.model.Amenity;
import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import com.smart_city_service_platform.city_directory_service.repository.AmenityRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AmenityService {

  private final AmenityRepository amenityRepository;
  private final AmenityMapper amenityMapper;

  public AmenityService(AmenityRepository amenityRepository, AmenityMapper amenityMapper) {
    this.amenityRepository = amenityRepository;
    this.amenityMapper = amenityMapper;
  }

  public List<Amenity> getAllAmenities() {
    return amenityRepository.findAll();
  }

  public Amenity getAmenityById(Long id) {
    return amenityRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Amenity not found with id: " + id));
  }

  public List<Amenity> getAmenitiesByCategory(AmenityCategory category) {
    return amenityRepository.findByCategory(category);
  }

  public List<Amenity> getAmenitiesByLocation(Long locationId) {
    return amenityRepository.findByLocation_Id(locationId);
  }

  public Amenity createAmenity(AmenityRequestDTO dto) {
    Amenity amenity = amenityMapper.toEntity(dto);
    return amenityRepository.save(amenity);
  }

  public Amenity updateAmenity(Long id, AmenityRequestDTO dto) {
    Amenity existingAmenity = getAmenityById(id);
    Amenity updatedAmenity = amenityMapper.toEntity(dto);
    updatedAmenity.setId(existingAmenity.getId());
    return amenityRepository.save(updatedAmenity);
  }

  public void deleteAmenity(Long id) {
    amenityRepository.deleteById(id);
  }
}
