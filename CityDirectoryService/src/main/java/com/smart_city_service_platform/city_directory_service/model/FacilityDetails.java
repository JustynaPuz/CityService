package com.smart_city_service_platform.city_directory_service.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "facility_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "working_hours_id")
  private WorkingHours workingHours;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  private Address address;

}
