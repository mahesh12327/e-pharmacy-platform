package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "insurance_policy")
@Data
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyNumber;

    @Column(nullable = false)
    private Long groupId;
    
    @Column(nullable = false)
    private String insuranceProviderName;

}
