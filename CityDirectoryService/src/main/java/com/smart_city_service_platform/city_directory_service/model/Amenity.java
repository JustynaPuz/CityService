package com.smart_city_service_platform.city_directory_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "amenity")
@Getter
@Setter
@NoArgsConstructor
public class Amenity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private AmenityCategory category;

  @ManyToOne
  @JoinColumn(name = "location_id")
  private Location location;

  @OneToOne
  @JoinColumn(name = "details_id")
  private FacilityDetails details;


}
