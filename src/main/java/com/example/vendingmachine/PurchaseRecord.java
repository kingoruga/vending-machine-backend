package com.example.vendingmachine;

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
