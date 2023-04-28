package com.example.vendingmachine.states;

import com.example.vendingmachine.model.SodaMachine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldState implements SodaMachine {
    private final SodaMachineContext context;

    public SoldState(SodaMachineContext context) {
        this.context = context;
    }

    @Override
    public String insertQuarter() {
        return "Please wait, dispensing soda.";
    }

    @Override
    public String ejectQuarter() {
        return "Unable to eject quarter, soda is being dispensed.";
    }

    @Override
    public String pushSodaButton() {
        return "Soda already being dispensed.";
    }

    @Override
    public String dispenseSoda() {
        context.releaseSoda();
        context.addPurchaseRecord();
        if (context.getSodasRemaining() > 0) {
            context.setState(context.getNoQuarterState());
            return "Soda dispensed.";
        } else {
            context.setState(context.getSoldOutState());
            return "Soda is sold out.";
        }
    }
}
