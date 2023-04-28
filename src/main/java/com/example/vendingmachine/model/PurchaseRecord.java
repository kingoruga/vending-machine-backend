package com.example.vendingmachine.model;

import java.time.LocalDateTime;

public class PurchaseRecord {
    private final LocalDateTime timestamp;

    public PurchaseRecord(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
