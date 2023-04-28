package com.example.vendingmachine.states;

import com.example.vendingmachine.PurchaseRecord;
import com.example.vendingmachine.model.SodaMachine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SodaMachineContext {
    private SodaMachine currentMachineState;
    private int sodasRemaining;
    private final List<PurchaseRecord> purchaseRecords;

    private final SodaMachine soldOutState;
    private final SodaMachine noQuarterState;
    private final SodaMachine hasQuarterState;
    private final SodaMachine soldState;

    public SodaMachineContext(int initialSodas) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        sodasRemaining = initialSodas;
        purchaseRecords = new ArrayList<>();

        if (initialSodas > 0) {
            currentMachineState = noQuarterState;
        } else {
            currentMachineState = soldOutState;
        }
    }

    public String insertQuarter() {
        return currentMachineState.insertQuarter();
    }

    public String ejectQuarter() {
        return currentMachineState.ejectQuarter();
    }

    public String pushSodaButton() {
        return currentMachineState.pushSodaButton();
    }

    public String dispenseSoda() {
        return currentMachineState.dispenseSoda();
    }

    public void setState(SodaMachine newState) {
        currentMachineState = newState;
    }

    public SodaMachine getCurrentState() {
        return currentMachineState;
    }

    public void releaseSoda() {
        if (sodasRemaining > 0) {
            sodasRemaining--;
        }
    }

    public void addPurchaseRecord() {
        LocalDateTime timestamp = LocalDateTime.now();
        purchaseRecords.add(new PurchaseRecord(timestamp));
    }

    public List<PurchaseRecord> getPurchaseRecords() {
        return purchaseRecords;
    }

    public SodaMachine getSoldOutState() {
        return soldOutState;
    }

    public SodaMachine getNoQuarterState() {
        return noQuarterState;
    }

    public SodaMachine getHasQuarterState() {
        return hasQuarterState;
    }

    public SodaMachine getSoldState() {
        return soldState;
    }

    public int getSodasRemaining() {
        return sodasRemaining;
    }
}


