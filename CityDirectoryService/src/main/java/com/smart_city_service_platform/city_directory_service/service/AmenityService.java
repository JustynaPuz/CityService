package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.DTO.AmenityRequestDTO;
import com.smart_city_service_platform.city_directory_service.model.Address;
import com.smart_city_service_platform.city_directory_service.model.Amenity;
import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import com.smart_city_service_platform.city_directory_service.model.FacilityDetails;
import com.smart_city_service_platform.city_directory_service.model.Location;
import com.smart_city_service_platform.city_directory_service.model.WorkingHours;
import com.smart_city_service_platform.city_directory_service.repository.AmenityRepository;
import com.smart_city_service_platform.city_directory_service.repository.FacilityDetailsRepository;
import com.smart_city_service_platform.city_directory_service.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AmenityService {

  private final AmenityRepository amenityRepository;
  private final LocationRepository locationRepository;
  private final FacilityDetailsRepository facilityDetailsRepository;

  public AmenityService(AmenityRepository amenityRepository, LocationRepository locationRepository,
      FacilityDetailsRepository facilityDetailsRepository) {
    this.amenityRepository = amenityRepository;
    this.locationRepository = locationRepository;
    this.facilityDetailsRepository = facilityDetailsRepository;
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
    Location location = new Location();
    location.setLatitude(dto.getLocation().getLatitude());
    location.setLongitude(dto.getLocation().getLongitude());

    WorkingHours workingHours = new WorkingHours();
    workingHours.setFromTime(dto.getDetails().getWorkingHours().getFromTime());
    workingHours.setToTime(dto.getDetails().getWorkingHours().getToTime());

    Address address = new Address();
    address.setCity(dto.getDetails().getAddress().getCity());
    address.setCountry(dto.getDetails().getAddress().getCountry());
    address.setStreet(dto.getDetails().getAddress().getStreet());
    address.setHouseNumber(dto.getDetails().getAddress().getHouseNumber());

    FacilityDetails facilityDetails = new FacilityDetails();
    facilityDetails.setWorkingHours(workingHours);
    facilityDetails.setAddress(address);

    Amenity amenity = new Amenity();
    amenity.setName(dto.getName());
    amenity.setCategory(dto.getCategory());
    amenity.setDetails(facilityDetails);
    amenity.setLocation(location);
    
    return amenityRepository.save(amenity);
  }

  public Amenity updateAmenity(Long id, Amenity updatedAmenity) {
    Amenity existingAmenity = getAmenityById(id);
    existingAmenity.setName(updatedAmenity.getName());
    existingAmenity.setCategory(updatedAmenity.getCategory());
    existingAmenity.setLocation(updatedAmenity.getLocation());
    existingAmenity.setDetails(updatedAmenity.getDetails());
    return amenityRepository.save(existingAmenity);
  }

  public void deleteAmenity(Long id) {
    amenityRepository.deleteById(id);
  }
}
