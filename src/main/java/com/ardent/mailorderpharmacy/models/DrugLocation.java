package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(nullable = false)
    private String address; // Address of the drug storage location

    @Column(nullable = false)
    private String zipcode; // Zip code of the location

    @Column(nullable = false)
    private Integer quantityInStock; // Quantity of the drug available at this location
}
