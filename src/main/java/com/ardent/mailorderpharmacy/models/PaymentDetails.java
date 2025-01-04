package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PaymentDetails {
    private String paymentMethod; // Payment method (e.g., Credit Card, Insurance)

    private String transactionId; // Transaction ID for payment reference
}
