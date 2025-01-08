package com.ardent.mailorderpharmacy.services;

import com.ardent.mailorderpharmacy.dto.druglocation.DrugLocationRequestDTO;
import com.ardent.mailorderpharmacy.models.DrugLocation;

import java.util.List;
import java.util.Optional;

public interface DrugLocationService {
    List<DrugLocation> getAllDrugLocations();

    Optional<DrugLocation> getDrugLocationById(Long id);

    DrugLocation addDrugLocation(DrugLocationRequestDTO drugLocationRequestDTO);

    DrugLocation updateStockQuantity(DrugLocationRequestDTO drugLocationRequestDTO);

    Optional<DrugLocation> getDrugLocationByDrugIdAndLocationId(Long drugId, Long locationId);
}
