package com.example.vendingmachine.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VendingMachineControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testInsertQuarter() throws Exception {
        mockMvc.perform(get("/insert-quarter"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").isNotEmpty());
    }

    @Test
    public void testEjectQuarter() throws Exception {
        mockMvc.perform(get("/eject-quarter"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").isNotEmpty());
    }

    @Test
    public void testPushSodaButton() throws Exception {
        mockMvc.perform(get("/push-soda-button"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").isNotEmpty());
    }

    @Test
    public void testDispenseSoda() throws Exception {
        mockMvc.perform(get("/dispense-soda"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").isNotEmpty());
    }

    @Test
    public void testGetSodasRemaining() throws Exception {
        mockMvc.perform(get("/sodas-remaining"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
}