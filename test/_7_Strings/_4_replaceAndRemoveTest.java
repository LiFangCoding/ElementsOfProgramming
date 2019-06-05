package _7_Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _4_replaceAndRemoveTest {

    @Test
    void replaceAndRemove() {
        char[] exp = {'d', 'd', 'c', 'd', 'c', 'd', 'd'};
        char[] arg = {'a', 'c', 'd', 'b', 'b', 'c', 'a'};
        _4_replaceAndRemove.replaceAndRemove(7, arg);
        assertArrayEquals(exp, arg);
    }
}