package com.charterassessment.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    void calculateRewards() {
        TransactionService service = new TransactionService();
        int rewards = service.calculateRewards(BigDecimal.valueOf(120));
        assertEquals(90,rewards);
    }
}