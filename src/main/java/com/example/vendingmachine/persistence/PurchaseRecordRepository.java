package com.example.vendingmachine.persistence;

import com.example.vendingmachine.model.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {
    PurchaseRecord findFirstById(Long id);
}
