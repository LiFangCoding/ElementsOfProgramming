package _4_primitive_types;

import _4_primitive_types._5_ComputeXMultiYWithoutArith;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _5_ComputeXMultiYWithoutArithTest {

    @Test
    void multipy() {
        assertEquals(250, _5_ComputeXMultiYWithoutArith.multipy(25, 10));
        assertEquals(35, _5_ComputeXMultiYWithoutArith.multipy(5, 7));
        assertEquals(144, _5_ComputeXMultiYWithoutArith.multipy(12, 12));
        assertEquals(97047, _5_ComputeXMultiYWithoutArith.multipy(123, 789));
    }
}