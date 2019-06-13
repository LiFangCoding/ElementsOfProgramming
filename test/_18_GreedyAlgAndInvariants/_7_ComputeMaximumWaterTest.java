package _18_GreedyAlgAndInvariants;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _7_ComputeMaximumWaterTest {

    @Test
    void getMaxTrappedWater() {
        assertEquals(48, _7_ComputeMaximumWater.getMaxTrappedWater(Arrays.asList(1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1)));
    }
}