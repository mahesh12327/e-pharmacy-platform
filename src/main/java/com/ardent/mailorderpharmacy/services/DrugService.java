package com.ardent.mailorderpharmacy.services;

import com.ardent.mailorderpharmacy.models.Drug;

import java.util.List;
import java.util.Optional;

public interface DrugService {
    List<Drug> getAllDrugs();

    Optional<Drug> getDrugById(Long id);

    Drug addDrug(Drug drug);

    Drug updateDrug(Long id, Drug updatedDrug);

    void deleteDrug(Drug drug);

    void deleteDrugById(Long id);

}
