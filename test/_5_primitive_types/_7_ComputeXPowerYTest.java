package _5_primitive_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class _7_ComputeXPowerYTest {
    private final double EPSILON = .1;
    private double expected;
    private double x;
    private int y;

    
    @Test
    void power() {
        expected = 4;
        x = 2;
        y = 2;

        test(expected, x, y);
    }

    @Test
    void power2() {
        expected = 8;
        x = 2;
        y = 3;

        test(expected, x, y);
    }

    private void test(double expected, double x, int y) {
        assertEquals(expected, _7_ComputeXPowerY.power(x, y), EPSILON);
    }
}