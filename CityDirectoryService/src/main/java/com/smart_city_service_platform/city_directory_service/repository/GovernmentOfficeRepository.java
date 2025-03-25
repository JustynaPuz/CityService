package com.smart_city_service_platform.city_directory_service.repository;


import com.smart_city_service_platform.city_directory_service.model.GovernmentOffice;
import com.smart_city_service_platform.city_directory_service.model.OfficeCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernmentOfficeRepository extends JpaRepository<GovernmentOffice, Long> {
  List<GovernmentOffice> findByCategory(OfficeCategory category);

  List<GovernmentOffice> findByLocation_Id(Long locationId);
}
