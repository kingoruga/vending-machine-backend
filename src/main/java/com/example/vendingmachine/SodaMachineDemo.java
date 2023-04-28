package com.example.vendingmachine;

import com.example.vendingmachine.states.SodaMachineContext;

public class SodaMachineDemo {
    public static void main(String[] args) {
        // Create a new SodaMachineContext with 5 sodas
        SodaMachineContext sodaMachine = new SodaMachineContext(5);

        // Test the soda machine by simulating various actions
        sodaMachine.insertQuarter();
        sodaMachine.pushSodaButton();

        sodaMachine.insertQuarter();
        sodaMachine.ejectQuarter();

        sodaMachine.insertQuarter();
        sodaMachine.pushSodaButton();

        sodaMachine.insertQuarter();
        sodaMachine.pushSodaButton();

        sodaMachine.insertQuarter();
        sodaMachine.pushSodaButton();

        sodaMachine.insertQuarter();
        sodaMachine.pushSodaButton();

        // Test the sold-out state
        sodaMachine.insertQuarter();
        sodaMachine.pushSodaButton();
    }
}
