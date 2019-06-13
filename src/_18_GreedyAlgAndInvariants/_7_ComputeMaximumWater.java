package _18_GreedyAlgAndInvariants;

import java.util.List;

/**
 * An array of integers naturally defines a set of lines parallel to the Y-axis, starting from x = 0 as illustrated in Figure 18.4(a).
 * The goal of this problem is to find the pair of lines that together with the X-axis "trap" the most water.
 * <p>
 * Write a program which takes as input an integer array adn returns the pair of entries that trap the maximum amount of water.
 */
public class _7_ComputeMaximumWater {
    // Hint: start with 0 and n - 1 and work your way in.

    /**
     * A good strategy is to consider the widest pair. We can eliminate both 0 and n - 1 from further consideration.
     * We iteratively to continuously reduce the subarray that must be explored, which recording the most water
     * trapped so far. In essence, we are exploring the best way in which to trade-off width for height.
     * <p>
     * T = O(n)
     */

    public static int getMaxTrappedWater(List<Integer> heights) {
        int i = 0, j = heights.size() - 1, maxWater = 0;
        while (i < j) {
            int width = j - i;
            maxWater = Math.max(maxWater, width * Math.min(heights.get(i), heights.get(j)));
            if (heights.get(i) > heights.get(j)) {
                --j;
            } else if (heights.get(i) < heights.get(j)) {
                ++i;
            } else {
                ++i;
                --j;
            }
        }
        return maxWater;
    }
}
