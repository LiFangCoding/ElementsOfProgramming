package _5_primitive_types;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _6_ComputeXDivYTest {

    @Test
    void divide() {
        assertEquals(10, _6_ComputeXDivY.divide(100, 10));
        assertEquals(41, _6_ComputeXDivY.divide(205, 5));
        assertEquals(Long.MAX_VALUE, _6_ComputeXDivY.divide(Long.MAX_VALUE, 1));
        assertEquals(5133, _6_ComputeXDivY.divide(15399, 3));
        assertEquals(1, _6_ComputeXDivY.divide(Long.MAX_VALUE, Long.MAX_VALUE));
        assertEquals(2, _6_ComputeXDivY.divide(Long.MAX_VALUE, Long.MAX_VALUE / 2));
    }
}