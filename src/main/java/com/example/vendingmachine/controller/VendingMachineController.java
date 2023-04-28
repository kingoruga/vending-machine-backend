package com.example.vendingmachine.controller;

import com.example.vendingmachine.model.BaseResponse;
import com.example.vendingmachine.states.SodaMachineContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendingMachineController {
    private final SodaMachineContext sodaMachine;

    public VendingMachineController() {
        // Initialize the soda machine with a default number of sodas
        this.sodaMachine = new SodaMachineContext(10);
    }

    @GetMapping("/insert-quarter")
    public BaseResponse insertQuarter() {
        return new BaseResponse(sodaMachine.insertQuarter());
    }

    @GetMapping("/eject-quarter")
    public BaseResponse ejectQuarter() {
        return new BaseResponse(sodaMachine.ejectQuarter());
    }

    @GetMapping("/push-soda-button")
    public BaseResponse pushSodaButton() {
        return new BaseResponse(sodaMachine.pushSodaButton());
    }

    @GetMapping("/dispense-soda")
    public BaseResponse dispenseSoda() {
        return new BaseResponse(sodaMachine.dispenseSoda());
    }

    @GetMapping("/sodas-remaining")
    public String getSodasRemaining() {
        return String.valueOf(sodaMachine.getSodasRemaining());
    }
}
