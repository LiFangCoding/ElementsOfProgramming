package _12_Searching;

import java.util.List;

/**
 * Write a method that takes a sorted array and a key and returns the index of the first occurence of that key in the array.
 */
public class _1_SearchSortedArray {
    // Hint: What happens when every entry equals k? Do not stop when you first see k.

    // T = O(log n)
    public static int searchFirstOfK(List<Integer> A, int k) {
        int left = 0;
        int right = A.size() - 1;

        // A.subList(left, right + 1) is the candidate set
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (A.get(left) == k) {
            return left;
        }

        if (A.get(right) == k) {
            return right;
        }

        return -1;
    }
}
