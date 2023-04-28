package com.example.vendingmachine.states;

import com.example.vendingmachine.model.SodaMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldOutState implements SodaMachine {
    private final SodaMachineContext context;

    public SoldOutState(SodaMachineContext context) {
        this.context = context;
    }

    @Override
    public String insertQuarter() {
        return "Soda is sold out. Unable to insert quarter.";
    }

    @Override
    public String ejectQuarter() {
        return "No quarter inserted.";
    }

    @Override
    public String pushSodaButton() {
        return "Soda is sold out. Cannot dispense soda.";
    }

    @Override
    public String dispenseSoda() {
        return "No soda to dispense.";
    }
}
