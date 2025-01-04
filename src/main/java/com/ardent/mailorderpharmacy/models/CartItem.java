package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart_item")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId; // Primary key for the cart item

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Many cart items can belong to one user

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug; // Many cart items can reference the same drug

    @Column(nullable = false)
    private Integer quantity; // Quantity of the drug added to the cart

    @Column(nullable = false)
    private Double price; // Price of the drug (can include calculated price based on quantity)
}
