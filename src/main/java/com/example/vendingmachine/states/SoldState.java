package com.example.vendingmachine.states;

import com.example.vendingmachine.model.SodaMachine;
import com.example.vendingmachine.service.SodaMachineService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldState implements SodaMachine {
    private final SodaMachineContext context;
    private final SodaMachineService sodaMachineService;

    public SoldState(SodaMachineContext context, SodaMachineService sodaMachineService) {
        this.context = context;
        this.sodaMachineService = sodaMachineService;
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
        Long purchaseRecordId = sodaMachineService.addPurchaseRecord();
        if (context.getSodasRemaining() > 0) {
            context.setState(context.getNoQuarterState());
            return "Soda dispensed. Purchase ID: " + purchaseRecordId;
        } else {
            context.setState(context.getSoldOutState());
            return "Soda is sold out.";
        }
    }
}
