package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class DeliveryDetails {
    private String deliveryAddress; // Address where the order will be delivered

    private String recipientName; // Name of the recipient

    private String contactNumber; // Contact number of the recipient

}
