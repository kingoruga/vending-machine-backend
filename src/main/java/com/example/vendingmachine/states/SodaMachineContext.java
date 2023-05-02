package com.example.vendingmachine.states;

import com.example.vendingmachine.model.SodaMachine;
import com.example.vendingmachine.service.SodaMachineService;

public class SodaMachineContext {
    private SodaMachine currentMachineState;
    private int sodasRemaining;

    private final SodaMachine soldOutState;
    private final SodaMachine noQuarterState;
    private final SodaMachine hasQuarterState;
    private final SodaMachine soldState;

    public SodaMachineContext(int initialSodas, SodaMachineService sodaMachineService) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this, sodaMachineService);

        sodasRemaining = initialSodas;

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


