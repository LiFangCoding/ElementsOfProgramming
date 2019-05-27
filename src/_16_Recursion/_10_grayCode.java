package _16_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * A n-bit Gray code is a permutation of {0,1,2,..., 2^n - 1}
 */
public class _10_grayCode {
    public static List<Integer> grayCode(int numBits) {
        List<Integer> res = new ArrayList<>();
        directedGrayCode(numBits, new HashSet<Integer>(Arrays.asList(0)), res);
        return res;
    }

    private static boolean directedGrayCode(int numBits, HashSet<Integer> history, List<Integer> res) {
        if (res.size() == (1 << numBits)) {
            return differsByOneBit(res.get(0), res.get(res.size() - 1));
        }

        for (int i = 0; i < numBits; i++) {
            int previousCode = res.get(res.size() - 1);
            int candidateNextCode = previousCode ^ (1 << i);
            if (!history.contains(candidateNextCode)) {
                history.add(candidateNextCode);
                res.add(candidateNextCode);
                if (directedGrayCode(numBits, history, res)) {
                    return true;
                }
                history.remove(candidateNextCode);
                history.remove(res.size() - 1);
            }
        }
        return false;
    }

    private static boolean differsByOneBit(int x, int y) {
        int bitDifference = x ^ y;
        return bitDifference != 0 && (bitDifference & (bitDifference - 1)) == 0;
    }

    public static class Solution2 {
        /**
         * Assume we operate on integers taht fit within the size of the
         * integer word, the time complexity T(n) satisfies T(n) = T(n - 1) + O(2^(n - 1))
         * T(n) = O(2^n)
         */
        public static List<Integer> grayCode(int numBits) {
            if (numBits == 0) {
                return new ArrayList<>(Arrays.asList(0));
            }

            //These implicitly begin with 0 at bit-index (numBits - 1).
            List<Integer> grayCodeNumBitsMinus1 = grayCode(numBits - 1);
            // Now, add a 1 at bit-index(numBits - 1) to all entries in grayCodeNumBitsMinus1
            int leadingBitOne = 1 << (numBits - 1);
            // process in reverse order to achieve reflection of grayCodeNumBitsMinus1
            for (int i = grayCodeNumBitsMinus1.size() - 1; i >= 0; --i) {
                grayCodeNumBitsMinus1.add(leadingBitOne | grayCodeNumBitsMinus1.get(i));
            }
            return grayCodeNumBitsMinus1;
        }
    }
}
