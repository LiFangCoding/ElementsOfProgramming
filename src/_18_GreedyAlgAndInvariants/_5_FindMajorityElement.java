package _18_GreedyAlgAndInvariants;

import java.util.Iterator;

/**
 *
 */
public class _5_FindMajorityElement {
    // Take advantage of the existence of a majority element to perform elimination.

    /**
     * Delete the elements different from the array.
     * The array, it is liking  erasing things out. Only left one is the majority.
     * [b,a,c,a,a]
     * first, [b,a] remove since it is same count.
     * then choose c, util a, remove it. Then last one a will be the answer.
     * T = O(n)
     * S = O(1)
     */
    public static String majoritySearch(Iterator<String> sequence) {
        String candidate = "";
        String iter;
        int count = 0;

        while (sequence.hasNext()) {
            iter = sequence.next();
            if (count == 0) {
                candidate = iter;
                count = 1;
            } else if (candidate.equals(iter)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
