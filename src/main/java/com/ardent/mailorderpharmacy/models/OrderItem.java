package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId; // Primary key for the order item

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug; // Many order items can reference the same drug

    @Column(nullable = false)
    private Integer quantity; // Quantity of the drug in the order

    @Column(nullable = false)
    private Double price; // Price of the item (based on quantity)
}
