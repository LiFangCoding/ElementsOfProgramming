package _5_primitive_types;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _4_findAClosestIntTest {

    @Test
    void cloestIntSameBitCount() {
        String x1String = "10001";
        long x1 = Long.parseLong(x1String, 2);
        assertEquals(Long.parseLong("10010", 2), _4_findAClosestInt.cloestIntSameBitCount(x1));

        String x2String = "111";
        long x2 = Long.parseLong(x2String, 2);
        assertEquals(Long.parseLong("1011", 2), _4_findAClosestInt.cloestIntSameBitCount(x2));

        String x3String = "1001";
        long x3 = Long.parseLong(x3String, 2);
        assertEquals(Long.parseLong("1010", 2), _4_findAClosestInt.cloestIntSameBitCount(x3));
    }
}