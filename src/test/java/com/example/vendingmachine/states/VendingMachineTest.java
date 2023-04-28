package com.example.vendingmachine.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * With more complex applications that need mocking I would run with Mockito instead of
 * SpringBootTest.
 * */
@SpringBootTest
public class VendingMachineTest {
    private SodaMachineContext sodaMachine;

    @BeforeEach
    public void setUp() {
        sodaMachine = new SodaMachineContext(5);
    }

    @Test
    public void testInsertQuarter() {
        sodaMachine.insertQuarter();
        assertEquals(sodaMachine.getHasQuarterState(), sodaMachine.getCurrentState(), "After inserting a quarter, the soda machine should be in the 'Has Quarter' state.");
    }

    @Test
    public void testEjectQuarter() {
        sodaMachine.insertQuarter();
        sodaMachine.ejectQuarter();
        assertEquals(sodaMachine.getNoQuarterState(), sodaMachine.getCurrentState(), "After ejecting a quarter, the soda machine should be in the 'No Quarter' state.");
    }

    @Test
    public void testPushSodaButton() {
        sodaMachine.insertQuarter();
        sodaMachine.pushSodaButton();
        assertEquals(sodaMachine.getSoldState(), sodaMachine.getCurrentState(), "After purchasing a soda, the soda machine should be in the Sold state.");
    }

    @Test
    public void testDispenseSoda() {
        //Arrange - when state is SOLD
        sodaMachine.setState(sodaMachine.getSoldState());

        //Act - and soda is dispensed
        sodaMachine.dispenseSoda();

        //Assert
        //then sodas remaining should decrease by amount sold
        assertEquals(4, sodaMachine.getSodasRemaining(), "After purchasing a soda, the soda machine should have one less soda remaining.");

        //and state should revert to 'NoQuarter'
        assertEquals(sodaMachine.getNoQuarterState(), sodaMachine.getCurrentState(), "After purchasing a soda, the state should revert to no qauarter.");

    }

    @Test
    public void testSoldOut() {
        sodaMachine = new SodaMachineContext(0);
        assertEquals(sodaMachine.getSoldOutState(), sodaMachine.getCurrentState(), "If no sodas are remaining, the soda machine should be in the 'Sold Out' state.");
    }
}
