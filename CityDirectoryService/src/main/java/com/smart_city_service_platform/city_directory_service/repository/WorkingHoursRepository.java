package com.smart_city_service_platform.city_directory_service.repository;

import com.smart_city_service_platform.city_directory_service.model.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {

}
