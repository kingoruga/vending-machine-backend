package com.example.vendingmachine.states;

import com.example.vendingmachine.model.SodaMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoQuarterState implements SodaMachine {
    private final SodaMachineContext context;

    public NoQuarterState(SodaMachineContext context) {
        this.context = context;
    }

    @Override
    public String insertQuarter() {
        context.setState(context.getHasQuarterState());
        return "Quarter inserted.";
    }

    @Override
    public String ejectQuarter() {
        return "No quarter to eject.";
    }

    @Override
    public String pushSodaButton() {
        return "Insert a quarter first.";
    }

    @Override
    public String dispenseSoda() {
        return "No soda dispensed. Insert quarter to dispense Soda.";
    }
}
