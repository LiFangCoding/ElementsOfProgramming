package _15_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * compute all subsets of a given size for a specified set.
 * Write a program which computes all size k subsets of {1,2,...,n}, where
 * k and n are program inputs.
 */
public class _5_all_subsetsOfSizeK {
    /**
     * Hint: think of the right function signature.
     */

    /**
     * T = O(n * C(n, k)).
     * case analysis. There are two possibilities for a subset [1,2,3,4,5] - it does not contain
     * 1 or it does contain 1. In the first case, return all subsets of size k of {2,3,...n}
     * In the second case, compute all k - 1 sized subsets of {2,3...,n} and add 1 to each of them.
     */
    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        directedCombinations(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    private static void directedCombinations(int n, int k, int offset, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Generate remaining combinations over {offset, ..., n - 1} of size
        // numRemaining.
        final int numRemaining = k - path.size();
        for (int i = offset; i <= n && numRemaining <= n - i + 1; i++) {
            path.add(i);
            directedCombinations(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    static class Solution2 {
        public static List<List<Integer>> combinations(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(n, k, 1, new ArrayList<Integer>(), res);
            return res;
        }

        private static void dfs(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            // remaining from {start, ..., n}
            int numRemaining = k - path.size();
            if (numRemaining > (n - start + 1)) {
                return;
            }

            path.add(start);
            dfs(n, k, start + 1, path, res);
            path.remove(path.size() - 1);

            dfs(n, k, start + 1, path, res);
        }
    }
}
