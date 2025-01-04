package com.ardent.mailorderpharmacy.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "drug_details")
@Data
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId; // Primary key

    @Column(nullable = false, unique = true)
    private String drugName; // Name of the drug, must be unique

    @Column(nullable = false)
    private String manufacturer; // Manufacturer of the drug

    @Column(nullable = false)
    private LocalDate manufactureDate; // Date the drug was manufactured

    @Column(nullable = false)
    private LocalDate expiryDate; // Expiry date of the drug

    @Column(nullable = false)
    private String drugType; // Type of drug (e.g., OTC or Prescription)

    @Column(nullable = false)
    private Double price; // Price of the drug

    @Column(nullable = false)
    private String dosageForm; // Form of the drug (e.g., Tablet, Capsule, Liquid)

    @Column(nullable = false)
    private String strength; // Strength of the drug (e.g., 500mg)

    @Column(nullable = false)
    private Integer quantity; // Quantity available in stock

    @Column(length = 1000)
    private String sideEffects; // Possible side effects of the drug

    @Column(length = 1000)
    private String instructions; // Instructions for using the drug

    @Column(nullable = false)
    private Boolean genericAvailability; // Whether the drug is available as a generic version

//    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<DrugLocation> locations; // One drug can have multiple locations
}