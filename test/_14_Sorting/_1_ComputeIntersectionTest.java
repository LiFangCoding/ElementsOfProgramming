package _14_Sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class _1_ComputeIntersectionTest {
    @Test
    public void isTrue() {

        List<Integer> A = Arrays.asList(2, 3, 3, 5, 7, 11);
        List<Integer> B = Arrays.asList(3, 3, 7, 15, 31);
        List<Integer> exp = Arrays.asList(3, 7);

        assertIterableEquals(exp, _1_ComputeIntersection.Advance2ArraysSol.intersectTwoSortedArrays(A, B));
    }
}