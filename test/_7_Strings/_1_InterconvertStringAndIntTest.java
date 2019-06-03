package _7_Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _1_InterconvertStringAndIntTest {

    @Test
    void intToString() {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int zero = 0;

        assertEquals(Integer.toString(max), _1_InterconvertStringAndInt.intToString(max));
        assertEquals(Integer.toString(min), _1_InterconvertStringAndInt.intToString(min));
        assertEquals(Integer.toString(0), _1_InterconvertStringAndInt.intToString(0));
    }

    @Test
    void stringToInt() {
        assertEquals(Integer.MAX_VALUE, _1_InterconvertStringAndInt.stringToInt(Integer.toString(Integer.MAX_VALUE)));
        assertEquals(Integer.MIN_VALUE, _1_InterconvertStringAndInt.stringToInt(Integer.toString(Integer.MIN_VALUE)));
        assertEquals(0, _1_InterconvertStringAndInt.stringToInt("0"));
    }
}