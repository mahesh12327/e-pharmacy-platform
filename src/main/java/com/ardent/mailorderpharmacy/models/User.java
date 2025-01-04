package com.ardent.mailorderpharmacy.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_details")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String uName;

    private String uPassword;

    private String email;

    private String role;

    private String authToken;
}
