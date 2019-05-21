package _15_Recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _3_permutationsTest {

    @Test
    void permutations() {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(5);
        A.add(7);

        System.out.println(_3_permutations.permutations(A));
    }
}