package com.ardent.mailorderpharmacy.dto.location;

import lombok.Data;

@Data
public class LocationResponseDTO {
    private Long locationId;
    private String address;
    private String zipcode;

    public LocationResponseDTO(Long locationId, String address, String zipcode) {
        this.locationId = locationId;
        this.address = address;
        this.zipcode = zipcode;
    }
}
