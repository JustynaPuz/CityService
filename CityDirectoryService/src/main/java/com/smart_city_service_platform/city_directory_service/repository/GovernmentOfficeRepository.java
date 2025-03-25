package com.smart_city_service_platform.city_directory_service.repository;


import com.smart_city_service_platform.city_directory_service.model.GovernmentOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernmentOfficeRepository extends JpaRepository<GovernmentOffice, Long> {
}
