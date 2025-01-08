package com.ardent.mailorderpharmacy.dto.druglocation;

import com.ardent.mailorderpharmacy.dto.drug.DrugResponseDTO;
import com.ardent.mailorderpharmacy.dto.location.LocationResponseDTO;
import lombok.Data;

@Data
public class DrugLocationRequestDTO {
    private Long drugId;
    private Long locationId;
    private int quantityInStock;

    public DrugLocationRequestDTO(Long drugId, Long locationId, int quantityInStock) {
        this.drugId = drugId;
        this.locationId = locationId;
        this.quantityInStock = quantityInStock;
    }
}
