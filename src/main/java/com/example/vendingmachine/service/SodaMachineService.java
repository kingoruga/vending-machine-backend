package com.example.vendingmachine.service;

import com.example.vendingmachine.exception.RecordNotFoundException;
import com.example.vendingmachine.model.PurchaseRecord;
import com.example.vendingmachine.persistence.PurchaseRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SodaMachineService {

    private final PurchaseRecordRepository purchaseRecordRepository;

    public SodaMachineService(PurchaseRecordRepository purchaseRecordRepository) {
        this.purchaseRecordRepository = purchaseRecordRepository;
    }

    public Long addPurchaseRecord() {
        LocalDateTime timestamp = LocalDateTime.now();
        PurchaseRecord record = purchaseRecordRepository.save(new PurchaseRecord(timestamp));
        return record.getId();
    }

    public PurchaseRecord getPurchaseRecords(Long id) throws RecordNotFoundException {
        PurchaseRecord record = purchaseRecordRepository.findFirstById(id);
        if(record == null) {
            throw new RecordNotFoundException("No record found for ID " + id);
        }
        return record;
    }
}
