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
}
