package com.ardent.mailorderpharmacy.repositories;

import com.ardent.mailorderpharmacy.models.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
    List<Drug> findByDrugNameContainingIgnoreCase(String name);

    Page<Drug> findByDrugNameContainingIgnoreCase(String name, Pageable pageable);

//    @Query("SELECT d FROM Drug d WHERE LOWER(d.drugName) LIKE LOWER(CONCAT('%', :name, '%'))")
//    List<Drug> findByDrugNameContaining(@Param("name") String name);

}
