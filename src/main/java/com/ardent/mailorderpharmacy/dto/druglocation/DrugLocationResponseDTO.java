package com.ardent.mailorderpharmacy.dto.druglocation;

import com.ardent.mailorderpharmacy.dto.drug.DrugResponseDTO;
import com.ardent.mailorderpharmacy.dto.location.LocationResponseDTO;
import lombok.Data;

@Data
public class DrugLocationResponseDTO {
    private Long drugLocationId;
    private DrugResponseDTO drugDetails; // Nested DTO for drug details
    private LocationResponseDTO locationDetails; // Nested DTO for location details
    private int quantityInStock;

    public DrugLocationResponseDTO(Long drugLocationId, DrugResponseDTO drugDetails, LocationResponseDTO locationDetails, int quantityInStock) {
        this.drugLocationId = drugLocationId;
        this.drugDetails = drugDetails;
        this.locationDetails = locationDetails;
        this.quantityInStock = quantityInStock;
    }

}
