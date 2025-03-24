package com.smart_city_service_platform.city_directory_service.repository;

import com.smart_city_service_platform.city_directory_service.model.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {

}
