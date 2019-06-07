package _18_GreedyAlgAndInvariants;

import java.util.Collections;
import java.util.List;

/**
 * Design an algorithm that takes as input an array and a number and determines if there are three entries in the array.
 * (Not necessarily distinct) which add up to the specified number.
 * For example, if the array is <11,2,5,7,3>, (3, 7 ,11) and (5,5, 11) add up to 21.
 */
public class _4_3Sum {
    // Hint: How would check if a given array entry can be added to two more entries to get teh specified number>?

    /**
     * The invariant is that if two elements which sum to the desired value exist, they must lie within the subarray currently under considertaion.
     * <p>
     * For <2,3,5,7,11>, for A[0] = 2, if A[0] + A[j] + A[k] = 21, we search for two entries that add up to 21 - 2 = 19.
     */
    public static boolean hasThreeSum(List<Integer> A, int t) {
        Collections.sort(A);
        for (int a : A) {
            // Finds if the sum of two numbers in A equals to t - a.
            if (hasTwoSum(A, t - a)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasTwoSum(List<Integer> A, int t) {
        int i = 0;
        int j = A.size() - 1;

        while (i < j) {
            int sum = A.get(i) + A.get(j);
            if (sum == t) {
                return true;
            } else if (sum > t) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
