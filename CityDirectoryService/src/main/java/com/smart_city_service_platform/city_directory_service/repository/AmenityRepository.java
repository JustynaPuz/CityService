package com.smart_city_service_platform.city_directory_service.repository;

import com.smart_city_service_platform.city_directory_service.model.Amenity;
import com.smart_city_service_platform.city_directory_service.model.AmenityCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {

  List<Amenity> findByCategory(AmenityCategory category);

  List<Amenity> findByLocation_Id(Long locationId);
}
