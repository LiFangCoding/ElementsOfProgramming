package _17_DynamicProgramming;

import java.util.Arrays;

/**
 * In 1965, Vladimir Levenshtein defined the distance between two words as the minimum number of "edits" it would take to transform the misspelled word into a correct word,
 * where a single edit is the insertion, deletion, or substitution of a single character.
 * For example, the Levenshtein distance between "Saturday" and "Sundays" is 4—delete the first 'a' and 't', substitute V by 'n' and insert the trailing 's'.
 * Write a program that takes two strings and computes the minimum number of edits needed to transform the first string into the second string.
 */
public class _2_ComputeTheLevenshteinDistance {
    // Hint: Consider the same problem for prefixes of the two strings.
    public static int levenshteinDistance(String A, String B) {
        int[][] distanceBetweenPrefixes = new int[A.length()][B.length()];
        for (int[] row : distanceBetweenPrefixes) {
            Arrays.fill(row, -1);
        }

        return computeDistanceBetweenPrefixes(A, A.length() - 1, B, B.length() - 1, distanceBetweenPrefixes);
    }

    /**
     * The value E(A[0: a - 1], B[0 : b - 1]) takes time O(1) to compute once E(A[0:k], B[0:l]) is known for all k < a and l < b.
     * T = O(a * b). Implementation uses O(a * b) space.
     */
    private static int computeDistanceBetweenPrefixes(String A, int A_idx, String B, int B_idx, int[][] distanceBetweenPrefixed) {
        if (A_idx < 0) {
            // A is empty so add all of B's characters
            return B_idx + 1;
        } else if (B_idx < 0) {
            // B is empty so delete all of A's characters
            return A_idx + 1;
        }
        if (distanceBetweenPrefixed[A_idx][B_idx] == -1) {
            if (A.charAt(A_idx) == B.charAt(B_idx)) {
                distanceBetweenPrefixed[A_idx][B_idx] = computeDistanceBetweenPrefixes(A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixed);
            } else {
                int substitueLast = computeDistanceBetweenPrefixes(A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixed);
                int addLast = computeDistanceBetweenPrefixes(A, A_idx, B, B_idx - 1, distanceBetweenPrefixed);
                int deleteLast = computeDistanceBetweenPrefixes(A, A_idx - 1, B, B_idx, distanceBetweenPrefixed);

                distanceBetweenPrefixed[A_idx][B_idx] = 1 + Math.min(substitueLast, Math.min(addLast, deleteLast));
            }
        }
        return distanceBetweenPrefixed[A_idx][B_idx];
    }
}
