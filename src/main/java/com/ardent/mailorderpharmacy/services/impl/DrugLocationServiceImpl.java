package com.ardent.mailorderpharmacy.services.impl;

import com.ardent.mailorderpharmacy.dto.druglocation.DrugLocationRequestDTO;
import com.ardent.mailorderpharmacy.exceptions.DrugNotFoundException;
import com.ardent.mailorderpharmacy.exceptions.LocationNotFoundException;
import com.ardent.mailorderpharmacy.models.Drug;
import com.ardent.mailorderpharmacy.models.DrugLocation;
import com.ardent.mailorderpharmacy.models.Location;
import com.ardent.mailorderpharmacy.repositories.DrugLocationRepository;
import com.ardent.mailorderpharmacy.services.DrugLocationService;
import com.ardent.mailorderpharmacy.services.DrugService;
import com.ardent.mailorderpharmacy.services.LocationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugLocationServiceImpl implements DrugLocationService {
    private DrugLocationRepository drugLocationRepository;
    @Autowired
    private DrugService drugService;
    @Autowired
    private LocationService locationService;

    @Autowired
    public DrugLocationServiceImpl(DrugLocationRepository drugLocationRepository) {
        this.drugLocationRepository = drugLocationRepository;
    }
    @Override
    public List<DrugLocation> getAllDrugLocations() {
        return drugLocationRepository.findAll();
    }

    @Override
    public Optional<DrugLocation> getDrugLocationById(Long id) {
        return drugLocationRepository.findById(id);
    }

    @Override
    public DrugLocation addDrugLocation(DrugLocationRequestDTO drugLocationRequestDTO) {
        Drug drug = drugService.getDrugById(drugLocationRequestDTO.getDrugId())
                .orElseThrow(() -> new DrugNotFoundException("Drug not found with ID: " + drugLocationRequestDTO.getDrugId()));;
        Location location = locationService.getLocationById(drugLocationRequestDTO.getLocationId())
                .orElseThrow(() -> new LocationNotFoundException("Location not found with ID: " + drugLocationRequestDTO.getLocationId()));
        DrugLocation drugLocation = new DrugLocation();
        drugLocation.setDrug(drug);
        drugLocation.setLocation(location);
        drugLocation.setQuantityInStock(drugLocationRequestDTO.getQuantityInStock());
        return drugLocationRepository.save(drugLocation);
    }

    @Override
    public DrugLocation updateStockQuantity(DrugLocationRequestDTO drugLocationRequestDTO) {

        DrugLocation drugLocation = drugLocationRepository
                .findByDrug_DrugIdAndLocation_LocationId(drugLocationRequestDTO.getDrugId(), drugLocationRequestDTO.getLocationId())
                .orElseThrow(()-> new DrugNotFoundException("DrugLocation not found with drug ID: " + drugLocationRequestDTO.getDrugId() + " / location ID: " + drugLocationRequestDTO.getLocationId()));
        drugLocation.setQuantityInStock(drugLocationRequestDTO.getQuantityInStock());
        return drugLocationRepository.save(drugLocation);
    }

    @Override
    public Optional<DrugLocation> getDrugLocationByDrugIdAndLocationId(Long drugId, Long locationId) {
        Optional<DrugLocation> drugLocation = drugLocationRepository.findByDrug_DrugIdAndLocation_LocationId(drugId, locationId);
        return drugLocation;
    }
}
