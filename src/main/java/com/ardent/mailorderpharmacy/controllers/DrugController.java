package com.ardent.mailorderpharmacy.controllers;

import com.ardent.mailorderpharmacy.exceptions.DrugNotFoundException;
import com.ardent.mailorderpharmacy.models.Drug;
import com.ardent.mailorderpharmacy.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
        return drug
                .map(ResponseEntity::ok) // Return 200 with the drug if present
                .orElseThrow(() -> new DrugNotFoundException("Drug not found with ID: " + id)); // Throw 404 exception if not found
    }

    @GetMapping("/search")
    public ResponseEntity<?> getDrugsByDrugName(
            @RequestParam String name,
            @RequestParam(defaultValue = "true") boolean paginate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "drugName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
            ) throws IllegalAccessException {
        // Validate page and size parameters
        if(page<0 || size<= 0) {
            throw new IllegalAccessException("Page no must be >= 0 and size must be > 0");
        }
        if(paginate) {
            Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
            Pageable pageable = PageRequest.of(page, size, sort);
            Page<Drug> drugs = drugService.getDrugsByDrugNameWithPagination(name, pageable);
            if(drugs.isEmpty()) {
                throw new DrugNotFoundException("Drugs not found with name: " + name);
            }
            return ResponseEntity.ok(drugs);
        }else {
            List<Drug> drugs = drugService.getDrugsByDrugName(name);
            if(drugs.isEmpty()) {
                throw new DrugNotFoundException("Drugs not found with name: " + name);
            }
            return ResponseEntity.ok(drugs);
        }
    }

    @PostMapping
    public ResponseEntity<Drug> addDrug(@RequestBody Drug drug) {
        Drug savedDrug =  drugService.addDrug(drug);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDrug);
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
