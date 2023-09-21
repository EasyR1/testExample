package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void sum() {
        assertEquals(calculator.sum(2, 2), 4);
        assertEquals(calculator.sum(2, -1), 1);
        assertEquals(calculator.sum(0, 0), 0);
    }
}