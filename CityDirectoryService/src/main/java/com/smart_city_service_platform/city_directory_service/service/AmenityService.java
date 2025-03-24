package com.smart_city_service_platform.city_directory_service.service;

import com.smart_city_service_platform.city_directory_service.DTO.AmenityRequestDTO;
import com.smart_city_service_platform.city_directory_service.model.Address;
import com.smart_city_service_platform.city_directory_service.model.Amenity;
import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import com.smart_city_service_platform.city_directory_service.model.FacilityDetails;
import com.smart_city_service_platform.city_directory_service.model.Location;
import com.smart_city_service_platform.city_directory_service.model.WorkingHours;
import com.smart_city_service_platform.city_directory_service.repository.AmenityRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AmenityService {

  private final AmenityRepository amenityRepository;

  public AmenityService(AmenityRepository amenityRepository) {
    this.amenityRepository = amenityRepository;
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
    Amenity amenity = buildAmenity(new Amenity(), dto);

    return amenityRepository.save(amenity);
  }

  public Amenity updateAmenity(Long id, AmenityRequestDTO dto) {
    Amenity existingAmenity = getAmenityById(id);
    Amenity amenity = buildAmenity(existingAmenity, dto);
    return amenityRepository.save(amenity);
  }

  public void deleteAmenity(Long id) {
    amenityRepository.deleteById(id);
  }

  private Amenity buildAmenity(Amenity amenity, AmenityRequestDTO dto) {
    Location location = getLocationFromDTO(dto);
    WorkingHours workingHours = getWorkingHoursFromDTO(dto);
    FacilityDetails facilityDetails = getFacilityDetailsFromDTO(dto, workingHours);

    amenity.setName(dto.getName());
    amenity.setCategory(dto.getCategory());
    amenity.setDetails(facilityDetails);
    amenity.setLocation(location);

    return amenity;
  }

  private static Location getLocationFromDTO(AmenityRequestDTO dto) {
    Location location = new Location();
    location.setLatitude(dto.getLocation().getLatitude());
    location.setLongitude(dto.getLocation().getLongitude());
    return location;
  }

  private static WorkingHours getWorkingHoursFromDTO(AmenityRequestDTO updatedAmenity) {
    WorkingHours workingHours = new WorkingHours();
    workingHours.setFromTime(updatedAmenity.getDetails().getWorkingHours().getFromTime());
    workingHours.setToTime(updatedAmenity.getDetails().getWorkingHours().getToTime());
    return workingHours;
  }

  private static FacilityDetails getFacilityDetailsFromDTO(AmenityRequestDTO updatedAmenity,
      WorkingHours workingHours) {
    Address address = new Address();
    address.setCity(updatedAmenity.getDetails().getAddress().getCity());
    address.setCountry(updatedAmenity.getDetails().getAddress().getCountry());
    address.setStreet(updatedAmenity.getDetails().getAddress().getStreet());
    address.setHouseNumber(updatedAmenity.getDetails().getAddress().getHouseNumber());

    FacilityDetails facilityDetails = new FacilityDetails();
    facilityDetails.setWorkingHours(workingHours);
    facilityDetails.setAddress(address);
    return facilityDetails;
  }

}
