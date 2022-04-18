package org.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for App.
 */
public class AppTest {
    @Test
    public void test_squareRoot() {
        double a = 25.0;
        double expectedResult = 5.0;
        double result = App.squareRoot(a);
        assertEquals(expectedResult, result, 0.0f);
    }

    @Test
    public void test_factorial() {
        int a = 5;
        int expectedResult = 120;
        int result = App.factorial(a);
        assertEquals(expectedResult, result);
    }

    @Test
    public void test_naturalLog() {
        double a = 2.718;
        double expectedResult = 1.0;
        double result = App.naturalLog(a);
        assertEquals(expectedResult, result, 0.2f);
    }

    @Test
    public void test_power() {
        double a = 2.0;
        double b = 5.0;
        double expectedResult = 32.0;
        double result = App.power(a,b);
        assertEquals(expectedResult, result, 0.0f);
    }
}
