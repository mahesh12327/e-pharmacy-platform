package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId; // Primary key for the order

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Many orders can belong to one user

    @Column(nullable = false)
    private LocalDate orderDate; // Date when the order was placed

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items; // Items in the order

    @Column(nullable = false)
    private Double totalPrice; // Total price of the order

    @Embedded
    private PaymentDetails paymentDetails; // Payment information

    @Embedded
    private DeliveryDetails deliveryDetails; // Delivery information

    @Column(nullable = false)
    private String orderStatus; // Status of the order (e.g., Pending, Shipped, Delivered)

    @Column
    private String trackingDetails; // Optional tracking details for the order
}
