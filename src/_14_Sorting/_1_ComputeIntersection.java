package _14_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A natural implementation for a search engine is to retrieve documents that match the set of words in a query by maintaining an inverted index.
 * Each page is assigned an integer identifier, its document-ID. An inverted index is a mapping that takes a word w
 * and returns a sorted array of page-ids which contain w—the sort order could be, for example, the page rank in descending order.
 * When a query contains multiple words, the search engine finds the sorted array for each word and then computes the intersection of these arrays—these are the pages containing all the words in the query.
 * The most computationally intensive step of doing this is finding the intersection of the sorted arrays.
 * <p>
 * Write a program which takes as input two sorted arrays, and returns a new array containing elements that are present in both of the input arrays.
 * The input arrays may have duplicate entries, but the returned array should be free of duplicates.
 * For example, the input is (2,3,3,5,5,6,7,7,8,12} and (5,5,6,8,8,9,10,10), your output should be (5,6,8).
 */
public class _1_ComputeIntersection {
    // Hint: solve the problem if the input array lengths differ by orders of magnitude. What if they are approximately equal?

    /**
     * The brute force algorithm is a "loop in". traverse all elements of one array and comparing them to the elements of the other array.
     * m, n be the lengths of the two input arrays. T = O(m * n)
     * Since both arrays are sorted, we can make some optimizations.
     */

    // First, we can iterate through the first array and use binary search in array to test if the element is present in the second array.
    static class BinarySearchSol {
        /**
         * A: [2, 3, 8] B: [2,3, 3, 5, 6]
         * res : [2, 3]
         * T = (m log n)
         * We can improve T by choosing shorter array for outerloop since if n << m, n * log(m) << m * log(n).
         * This is best if one set is much smaller than the other.
         */
        public static List<Integer> IntersectTwoSortedArrays(List<Integer> A, List<Integer> B) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < A.size(); i++) {
                boolean indexisValid = (i == 0 || A.get(i) != A.get(i - 1));
                if (indexisValid && Collections.binarySearch(B, A.get(i)) >= 0) {
                    res.add(A.get(i));
                }
            }
            return res;
        }
    }

    //TODO: another solution

}
