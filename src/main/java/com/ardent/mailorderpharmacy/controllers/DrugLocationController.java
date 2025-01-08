package com.ardent.mailorderpharmacy.controllers;

import com.ardent.mailorderpharmacy.dto.drug.DrugResponseDTO;
import com.ardent.mailorderpharmacy.dto.druglocation.DrugLocationRequestDTO;
import com.ardent.mailorderpharmacy.dto.druglocation.DrugLocationResponseDTO;
import com.ardent.mailorderpharmacy.dto.location.LocationResponseDTO;
import com.ardent.mailorderpharmacy.exceptions.LocationNotFoundException;
import com.ardent.mailorderpharmacy.models.DrugLocation;
import com.ardent.mailorderpharmacy.services.DrugLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/drug-locations")
public class DrugLocationController {
    private DrugLocationService drugLocationService;

    public DrugLocationController(DrugLocationService drugLocationService) {
        this.drugLocationService = drugLocationService;
    }

    @GetMapping
    public ResponseEntity<List<DrugLocationResponseDTO>> getAllDrugLocations() {
        List<DrugLocation> drugLocation = drugLocationService.getAllDrugLocations();
        List<DrugLocationResponseDTO> drugLocationResponseDTOs = drugLocation.stream().map(dl -> new DrugLocationResponseDTO(
                dl.getDrugLocationId(),
                new DrugResponseDTO(
                        dl.getDrug().getDrugId(),
                        dl.getDrug().getDrugName(),
                        dl.getDrug().getManufacturer(),
                        dl.getDrug().getDosageForm(),
                        dl.getDrug().getStrength(),
                        dl.getDrug().getPrice()
                ),
                new LocationResponseDTO(
                        dl.getLocation().getLocationId(),
                        dl.getLocation().getAddress(),
                        dl.getLocation().getZipcode()
                ),
                dl.getQuantityInStock()
        )).collect(Collectors.toList());
        return ResponseEntity.ok(drugLocationResponseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrugLocationResponseDTO> getDrugLocationById(@PathVariable Long id) {
        Optional<DrugLocation> drugLocation = drugLocationService.getDrugLocationById(id);
        DrugLocationResponseDTO drugLocationResponseDTO = drugLocation.map(dl -> new DrugLocationResponseDTO(
                dl.getDrugLocationId(),
                new DrugResponseDTO(
                        dl.getDrug().getDrugId(),
                        dl.getDrug().getDrugName(),
                        dl.getDrug().getManufacturer(),
                        dl.getDrug().getDosageForm(),
                        dl.getDrug().getStrength(),
                        dl.getDrug().getPrice()
                ),
                new LocationResponseDTO(
                        dl.getLocation().getLocationId(),
                        dl.getLocation().getAddress(),
                        dl.getLocation().getZipcode()
                ),
                dl.getQuantityInStock()
        )).orElseThrow(()->new LocationNotFoundException("Location not found with ID: " + id));

        return ResponseEntity.ok(drugLocationResponseDTO);
    }

    @GetMapping("/{drugId}/{locationId}")
    public ResponseEntity<DrugLocationResponseDTO> getDrugLocationByDrugIdAndLocationId(@PathVariable Long drugId, @PathVariable Long locationId) {
        Optional<DrugLocation> drugLocation = drugLocationService.getDrugLocationByDrugIdAndLocationId(drugId, locationId);
        DrugLocationResponseDTO drugLocationResponseDTO = drugLocation.map(dl -> new DrugLocationResponseDTO(
                dl.getDrugLocationId(),
                new DrugResponseDTO(
                        dl.getDrug().getDrugId(),
                        dl.getDrug().getDrugName(),
                        dl.getDrug().getManufacturer(),
                        dl.getDrug().getDosageForm(),
                        dl.getDrug().getStrength(),
                        dl.getDrug().getPrice()
                ),
                new LocationResponseDTO(
                        dl.getLocation().getLocationId(),
                        dl.getLocation().getAddress(),
                        dl.getLocation().getZipcode()
                ),
                dl.getQuantityInStock()
        )).orElseThrow(()->new LocationNotFoundException("Location not found with drug ID: " + drugId + " / location ID: " + locationId));

        return ResponseEntity.ok(drugLocationResponseDTO);
    }

    @PostMapping
    public ResponseEntity<DrugLocationResponseDTO> addDrugLocation(@RequestBody DrugLocationRequestDTO drugLocationRequestDTO) {
        DrugLocation savedDrugLocation = drugLocationService.addDrugLocation(drugLocationRequestDTO);
        DrugLocationResponseDTO drugLocationResponseDTO = new DrugLocationResponseDTO(
                savedDrugLocation.getDrugLocationId(),
                new DrugResponseDTO(
                        savedDrugLocation.getDrug().getDrugId(),
                        savedDrugLocation.getDrug().getDrugName(),
                        savedDrugLocation.getDrug().getManufacturer(),
                        savedDrugLocation.getDrug().getDosageForm(),
                        savedDrugLocation.getDrug().getStrength(),
                        savedDrugLocation.getDrug().getPrice()
                ),
                new LocationResponseDTO(
                        savedDrugLocation.getLocation().getLocationId(),
                        savedDrugLocation.getLocation().getAddress(),
                        savedDrugLocation.getLocation().getZipcode()
                ),
                savedDrugLocation.getQuantityInStock()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(drugLocationResponseDTO);
    }

    @PutMapping("/update-stock")
    public ResponseEntity<DrugLocationResponseDTO> updateStockQuantity(@RequestBody DrugLocationRequestDTO drugLocationRequestDTO) {
        DrugLocation updatedStockQuantity = drugLocationService.updateStockQuantity(drugLocationRequestDTO);
        DrugLocationResponseDTO drugLocationResponseDTO = new DrugLocationResponseDTO(
                updatedStockQuantity.getDrugLocationId(),
                new DrugResponseDTO(
                        updatedStockQuantity.getDrug().getDrugId(),
                        updatedStockQuantity.getDrug().getDrugName(),
                        updatedStockQuantity.getDrug().getManufacturer(),
                        updatedStockQuantity.getDrug().getDosageForm(),
                        updatedStockQuantity.getDrug().getStrength(),
                        updatedStockQuantity.getDrug().getPrice()
                ),
                new LocationResponseDTO(
                        updatedStockQuantity.getLocation().getLocationId(),
                        updatedStockQuantity.getLocation().getAddress(),
                        updatedStockQuantity.getLocation().getZipcode()
                ),
                updatedStockQuantity.getQuantityInStock()
        );
        return ResponseEntity.ok(drugLocationResponseDTO);
    }

}
