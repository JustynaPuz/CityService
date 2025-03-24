package com.smart_city_service_platform.city_directory_service.repository;

import com.smart_city_service_platform.city_directory_service.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
