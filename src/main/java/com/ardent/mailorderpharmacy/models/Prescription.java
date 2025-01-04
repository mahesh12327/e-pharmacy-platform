package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prescription")
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId; // Primary key

    @Column(nullable = false)
    private Long doctorId; // ID of the prescribing doctor

    @Column(nullable = false)
    private String doctorName; // Name of the prescribing doctor

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Many prescriptions belong to one user (patient)

    @Column(nullable = true)
    private Long patientId; // Optional: ID of the patient if different from the user

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug; // Many prescriptions can be for the same drug

    @Column(nullable = false)
    private String drugName; // Name of the prescribed drug

    @Column(nullable = false)
    private String dosage; // Dosage instructions (e.g., 500mg)

    @Column(nullable = false)
    private String frequency; // Frequency (e.g., 1x per day)

    @Column(nullable = false)
    private Integer duration; // Duration of the prescription in days

    @Column(nullable = false)
    private Integer quantityPrescribed; // Quantity prescribed

    @Column(nullable = false)
    private LocalDate prescriptionDate; // Date when the prescription was issued

    @Column(nullable = false)
    private LocalDate expirationDate; // Expiry date of the prescription

    @Column(length = 1000)
    private String doctorsInstruction; // Additional instructions from the doctor

    @Column(length = 1000)
    private String allergyWarnings; // Any allergy warnings

    @Column(nullable = false)
    private Boolean verification;
}
