package com.ardent.mailorderpharmacy.repositories;

import com.ardent.mailorderpharmacy.models.DrugLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrugLocationRepository extends JpaRepository<DrugLocation, Long> {
    Optional<DrugLocation> findByDrug_DrugIdAndLocation_LocationId(Long drugId, Long locationId);
}
