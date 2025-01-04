package com.ardent.mailorderpharmacy.repositories;

import com.ardent.mailorderpharmacy.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
}
