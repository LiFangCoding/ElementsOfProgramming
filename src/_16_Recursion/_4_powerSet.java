package _16_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Power set of a set S is set of all subsets of S, including both the empty set and S itself.
 * Write a function that takes as input a set and returns its power set.
 */
public class _4_powerSet {
    /**
     * Hint: There are 2^n subsets for a given set S of size n.
     * There are 2^k k-bit words.
     */

    /**
     * Compute all subsets.
     * One is all subsets U that do not include that element.
     * One is all subsets V that include that element.
     * res is U & V.
     */
    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> powerSet = new ArrayList<>();
        directedPowerSet(inputSet, 0, new ArrayList<Integer>(), powerSet);
        return powerSet;
    }

    /**
     * The number of calls are C(n) = 2C(n - 1), which is O(2^n)
     * Spend O(n) time within a call.
     * T = (n * 2 ^ n)
     * Generate all subsets whose intersection with inputSet[0], ..
     * InputSet[toBeSelected - 1] is exactly selectedSoFar.
     */
    private static void directedPowerSet(List<Integer> inputSet,
                                         int toBeSelected, List<Integer> selectedSoFar,
                                         List<List<Integer>> powerSet) {
        if (toBeSelected == inputSet.size()) {
            powerSet.add(new ArrayList<>(selectedSoFar));
            return;
        }

        //Generate all subsets that contain inputSet[ToBeSelected].
        selectedSoFar.add(inputSet.get(toBeSelected));
        directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet);

        // Generate all subsets that do not contain inputSet[toBeSelected]
        selectedSoFar.remove(selectedSoFar.size() - 1);
        directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet);
    }

    static class Solution2 {
        /**
         * enumerate the integers in [0, 2^n - 1] and examine the indices of bits set.
         * ex: {a,b,c,d}, <1,0,1,1>
         * These indices are determined bny isolating the lowest set bit.
         * y = x & ~(x - 1). Then get the index by computing lgy.
         * Each set takes O(n) time. The time complexity is O(n * 2^n).
         */
        private static final double LOG_2 = Math.log(2);

        public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
            List<List<Integer>> powerSet = new ArrayList<>();
            for (int intForSubset = 0; intForSubset < (1 << inputSet.size()); intForSubset++) {
                int bitArray = intForSubset;
                List<Integer> subset = new ArrayList<>();
                while (bitArray != 0) {
                    subset.add((int) (Math.log(bitArray & ~(bitArray - 1)) / LOG_2));
                    bitArray &= bitArray - 1;
                }
                powerSet.add(subset);
            }
            return powerSet;
        }
    }
}
