package com.ardent.mailorderpharmacy.services.impl;

import com.ardent.mailorderpharmacy.exceptions.DrugNotFoundException;
import com.ardent.mailorderpharmacy.models.Drug;
import com.ardent.mailorderpharmacy.repositories.DrugRepository;
import com.ardent.mailorderpharmacy.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    @Override
    public Optional<Drug> getDrugById(Long id) {
        return drugRepository.findById(id);
    }

    @Override
    public List<Drug> getDrugsByDrugName(String name) {
        return drugRepository.findByDrugNameContainingIgnoreCase(name);
    }

    @Override
    public Page<Drug> getDrugsByDrugNameWithPagination(String name, Pageable pageable) {
        return drugRepository.findByDrugNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Drug addDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    @Override
    public Drug updateDrug(Long id, Drug updatedDrug) {
        Drug existingDrug = drugRepository
                        .findById(id)
                        .orElseThrow(() -> new DrugNotFoundException("Drug not found with ID: " + id));

        if (updatedDrug.getDrugName() != null) {
            existingDrug.setDrugName(updatedDrug.getDrugName());
        }
        if (updatedDrug.getManufacturer() != null) {
            existingDrug.setManufacturer(updatedDrug.getManufacturer());
        }
        if (updatedDrug.getManufactureDate() != null) {
            existingDrug.setManufactureDate(updatedDrug.getManufactureDate());
        }
        if (updatedDrug.getExpiryDate() != null) {
            existingDrug.setExpiryDate(updatedDrug.getExpiryDate());
        }
        if (updatedDrug.getDrugType() != null) {
            existingDrug.setDrugType(updatedDrug.getDrugType());
        }
        if (updatedDrug.getPrice() != null) {
            existingDrug.setPrice(updatedDrug.getPrice());
        }
        if (updatedDrug.getDosageForm() != null) {
            existingDrug.setDosageForm(updatedDrug.getDosageForm());
        }
        if (updatedDrug.getStrength() != null) {
            existingDrug.setStrength(updatedDrug.getStrength());
        }
        if (updatedDrug.getQuantity() != null) {
            existingDrug.setQuantity(updatedDrug.getQuantity());
        }
        if (updatedDrug.getSideEffects() != null) {
            existingDrug.setSideEffects(updatedDrug.getSideEffects());
        }
        if (updatedDrug.getInstructions() != null) {
            existingDrug.setInstructions(updatedDrug.getInstructions());
        }
        if (updatedDrug.getGenericAvailability() != null) {
            existingDrug.setGenericAvailability(updatedDrug.getGenericAvailability());
        }

        return drugRepository.save(existingDrug);
    }

    @Override
    public void deleteDrug(Drug drug) {
        drugRepository.delete(drug);
    }

    @Override
    public void deleteDrugById(Long id) {
        drugRepository.deleteById(id);
    }
}
