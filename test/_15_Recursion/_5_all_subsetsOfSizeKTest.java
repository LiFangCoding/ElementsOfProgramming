package _15_Recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _5_all_subsetsOfSizeKTest {

    @Test
    void combinations() {
        List<List<Integer>> res = _5_all_subsetsOfSizeK.combinations(3, 2);

        System.out.println(res);
    }

    @Test
    void combinations2() {
        List<List<Integer>> res = _5_all_subsetsOfSizeK.Solution2.combinations(3, 2);

        System.out.println(res);
    }
}