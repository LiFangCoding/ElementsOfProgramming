package _15_Recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Write a program which takes input as an array of distinct integers
 * and generates all permutations os that array. No permutation of the array
 * may appear more than once.
 */
public class _3_permutations {

    /**
     * Hint: How many possible values are there for the first element?
     */
    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> res = new ArrayList<>();
        directedPermutations(A, 0, res);
        return res;
    }

    /**
     * Count of recursive calls are:
     * C(n) = 1 + nC(n - 1) for n >= 1. C(0) = 1
     * C(n) = n!
     * do O(n) computation per call outside of recursive calls.
     * T(n) = (n * n!).
     */
    private static void directedPermutations(List<Integer> A, int i, List<List<Integer>> res) {
        if (i == A.size()) {
            res.add(new ArrayList<Integer>(A));
            return;
        }

        // Try every possibility for A[i].
        for (int j = i; j < A.size(); j++) {
            Collections.swap(A, i , j);
            //Generate all permutations for A.subList(i + 1, A.size())
            directedPermutations(A, i + 1, res);
            Collections.swap(A, i, j);
        }
    }

    /**
     * Use nextPermutation method.
     *
     */
    static class Solution2 {
        /**
         * T = (n * n!)
         * There are n! permutations and we spend O(n) time to store each one.
         */
        public static List<List<Integer>> permutations(List<Integer> A) {
            List<List<Integer>> res = new ArrayList<>();

            //Generate the first permutation in dictionary order.
            Collections.sort(A);
            do {
                res.add(new ArrayList<>(A));
                //A = NextPermutation.nextPermutation(A);
            } while (!A.isEmpty());

            return res;
        }
    }
}
