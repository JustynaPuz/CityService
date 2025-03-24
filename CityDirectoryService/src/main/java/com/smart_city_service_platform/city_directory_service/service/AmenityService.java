package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.model.Amenity;
import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import com.smart_city_service_platform.city_directory_service.repository.AmenityRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AmenityService {

  private final AmenityRepository repository;

  public AmenityService(AmenityRepository repository) {
    this.repository = repository;
  }

  public List<Amenity> getAllAmenities() {
    return repository.findAll();
  }

  public Amenity getAmenityById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Amenity not found with id: " + id));
  }

  public List<Amenity> getAmenitiesByCategory(AmenityCategory category) {
    return repository.findByCategory(category);
  }

  public List<Amenity> getAmenitiesByLocation(Long locationId) {
    return repository.findByLocation_Id(locationId);
  }

  public Amenity createAmenity(Amenity amenity) {
    return repository.save(amenity);
  }

  public Amenity updateAmenity(Long id, Amenity updatedAmenity) {
    Amenity existingAmenity = getAmenityById(id);
    existingAmenity.setName(updatedAmenity.getName());
    existingAmenity.setCategory(updatedAmenity.getCategory());
    existingAmenity.setLocation(updatedAmenity.getLocation());
    existingAmenity.setDetails(updatedAmenity.getDetails());
    return repository.save(existingAmenity);
  }

  public void deleteAmenity(Long id) {
    repository.deleteById(id);
  }
}
