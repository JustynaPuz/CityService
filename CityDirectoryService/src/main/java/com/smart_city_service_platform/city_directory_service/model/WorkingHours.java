package com.smart_city_service_platform.city_directory_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Time;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "working_hours")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime fromTime;
    private LocalTime toTime;

}
