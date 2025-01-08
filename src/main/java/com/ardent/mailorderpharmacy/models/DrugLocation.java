package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;

@Entity
@Table(name = "drug_location")
@Data
public class DrugLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugLocationId; // Primary key for drug location

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug; // Many DrugLocation entries are linked to one Drug

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location; // Many DrugLocation entries are linked to one Location

    @Column(nullable = false)
    private Integer quantityInStock; // Quantity of the drug available at this location

}
