package com.smart_city_service_platform.city_directory_service.repository;

import com.smart_city_service_platform.city_directory_service.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
