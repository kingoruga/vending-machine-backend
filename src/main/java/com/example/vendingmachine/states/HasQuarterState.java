package com.example.vendingmachine.states;

import com.example.vendingmachine.model.SodaMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HasQuarterState implements SodaMachine {
    private final SodaMachineContext context;

    public HasQuarterState(SodaMachineContext context) {
        this.context = context;
    }

    @Override
    public String insertQuarter() {
        return "You already inserted a quarter.";
    }

    @Override
    public String ejectQuarter() {
        context.setState(context.getNoQuarterState());
        return "Quarter ejected.";
    }

    @Override
    public String pushSodaButton() {
        context.setState(context.getSoldState());
        return "Soda button pushed.";
    }

    @Override
    public String dispenseSoda() {
        return "No soda dispensed. Make a soda selection to dispense soda.";
    }
}
