package com.ardent.mailorderpharmacy.controllers;

import com.ardent.mailorderpharmacy.exceptions.DrugNotFoundException;
import com.ardent.mailorderpharmacy.models.Drug;
import com.ardent.mailorderpharmacy.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/drugs")
@Validated
public class DrugController {
    private DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public ResponseEntity<List<Drug>> getAllDrugs() {
        List<Drug> drugs = drugService.getAllDrugs();
        return ResponseEntity.ok(drugs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drug> getDrugById(@PathVariable Long id) {
        Optional<Drug> drug = drugService.getDrugById(id);
        return drugService.getDrugById(id)
                .map(ResponseEntity::ok) // Return 200 with the drug if present
                .orElseThrow(() -> new DrugNotFoundException("Drug not found with ID: " + id)); // Throw 404 exception if not found
    }

    @PostMapping
    public ResponseEntity<Drug> addDrug(@RequestBody Drug drug) {
        Drug savedDrug =  drugService.addDrug(drug);
        return ResponseEntity.ok(savedDrug);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drug> updateDrug(@PathVariable Long id, @RequestBody Drug updatedDrug) {
        Drug modifiedDrug =  drugService.updateDrug(id, updatedDrug);
        return ResponseEntity.ok(modifiedDrug);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDrug(@RequestBody Drug drug) {
        drugService.deleteDrug(drug);
        return ResponseEntity.ok("Drug - " + drug.getDrugName() + " Deleted Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrugById(@PathVariable Long id) {
        drugService.deleteDrugById(id);
        return ResponseEntity.ok("Drug - " + id + " Deleted Successfully");
    }
}
