package com.smart_city_service_platform.city_directory_service.DTO;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

  private static final double LAT_MIN = -90.0;
  private static final double LAT_MAX = 90.0;
  private static final double LNG_MIN = -180.0;
  private static final double LNG_MAX = 180.0;

  private static final String LAT_MIN_STR = "-90.0";
  private static final String LAT_MAX_STR = "90.0";
  private static final String LNG_MIN_STR = "-180.0";
  private static final String LNG_MAX_STR = "180.0";

  @NotNull(message = "Latitude must not be null")
  @DecimalMin(value = LAT_MIN_STR, message = "Latitude must be ≥ " + LAT_MIN_STR)
  @DecimalMax(value = LAT_MAX_STR, message = "Latitude must be ≤ " + LAT_MAX_STR)
  private Double latitude;

  @NotNull(message = "Longitude must not be null")
  @DecimalMin(value = LNG_MIN_STR, message = "Longitude must be ≥ " + LNG_MIN_STR)
  @DecimalMax(value = LNG_MAX_STR, message = "Longitude must be ≤ " + LNG_MAX_STR)
  private Double longitude;

}
