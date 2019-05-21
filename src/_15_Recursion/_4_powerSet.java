package _15_Recursion;

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
}
