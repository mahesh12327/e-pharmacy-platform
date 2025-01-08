package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "location",
        uniqueConstraints = @UniqueConstraint(columnNames = {"address", "zipcode"})
)
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId; // Primary key for location

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String zipcode;
}
