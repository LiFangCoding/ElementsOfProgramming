package _7_Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _2_BaseConversionTest {

    @Test
    void convertBase() {
        assertEquals("1A7", _2_BaseConversion.convertBase("615", 7, 13));
        assertEquals("5A", _2_BaseConversion.convertBase("65", 10, 11));
        assertEquals("56", _2_BaseConversion.convertBase("71", 10, 13));
    }
}