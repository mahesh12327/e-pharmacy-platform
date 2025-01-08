package com.ardent.mailorderpharmacy.services;

import com.ardent.mailorderpharmacy.models.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DrugService {
    List<Drug> getAllDrugs();

    Optional<Drug> getDrugById(Long id);

    List<Drug> getDrugsByDrugName(String name);

    Page<Drug> getDrugsByDrugNameWithPagination(String name, Pageable pageable);

    Drug addDrug(Drug drug);

    Drug updateDrug(Long id, Drug updatedDrug);

    void deleteDrug(Drug drug);

    void deleteDrugById(Long id);

}
