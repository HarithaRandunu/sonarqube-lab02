package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddOperation() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
    }

    @Test
    void testAddAgainOperation() {
        assertEquals(15, calculator.calculate(10, 5, "add-again"));
    }

    @Test
    void testSubOperation() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
    }

    @Test
    void testSubAgainOperation() {
        assertEquals(5, calculator.calculate(10, 5, "sub-again"));
    }

    @Test
    void testMulOperation() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
    }

    @Test
    void testDivOperation() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
    }

    @Test
    void testDivByZero() {
        assertEquals(0, calculator.calculate(10, 0, "div"));
    }

    @Test
    void testModOperation() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
    }

    @Test
    void testPowOperation() {
        assertEquals(8, calculator.calculate(2, 3, "pow"));
    }

    @Test
    void testPowWithZero() {
        assertEquals(1, calculator.calculate(5, 0, "pow"));
    }

    @Test
    void testInvalidOperation() {
        assertEquals(0, calculator.calculate(10, 5, "invalid"));
    }

    @Test
    void testAddAgainMethod() {
        assertEquals(15, calculator.addAgain(10, 5));
    }

    @Test
    void testSumValuesMethod() {
        assertEquals(15, calculator.sumValues(10, 5));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-15, calculator.calculate(-10, -5, "add"));
        assertEquals(-30, calculator.calculate(-10, 3, "mul"));
    }
}
