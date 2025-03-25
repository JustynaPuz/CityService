package com.smart_city_service_platform.city_directory_service.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "amenity")
public class Amenity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private AmenityCategory category;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "location_id")
  private Location location;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "details_id", referencedColumnName = "id")
  private FacilityDetails details;


  public Amenity(Long id, String name, AmenityCategory category, Location location,
      FacilityDetails details) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.location = location;
    this.details = details;
  }

  public Amenity() {
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public AmenityCategory getCategory() {
    return this.category;
  }

  public Location getLocation() {
    return this.location;
  }

  public FacilityDetails getDetails() {
    return this.details;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCategory(AmenityCategory category) {
    this.category = category;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public void setDetails(FacilityDetails details) {
    this.details = details;
  }
}
