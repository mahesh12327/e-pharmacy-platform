package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "refill_order")
@Data
public class RefillOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refillOrderId; // Primary key for the refill order

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Many refills can belong to one user

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug; // Many refills can be linked to one drug

    @Column(nullable = false)
    private Integer refillFrequency; // Frequency in days (e.g., every 30 days)

    @Column(nullable = false)
    private Double price; // Price of the refill order

    @Column(nullable = false)
    private LocalDate refillDueDate; // Next due date for the refill

    @Column(nullable = false)
    private Boolean autoRefill; // Whether auto-refill is enabled (true/false)

    @Column(length = 1000)
    private String notificationDetails; // Notification preferences/details (e.g., email, SMS)

    @Column(nullable = false)
    private Boolean active; // Whether this refill order is currently active
}
