package _15_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * write a program that takes as input a number and returns all the strings
 * with that number of matched pairs of parens.
 */
public class _6_StringOfMatchedParens {
    /**
     * Hint: Think about what the prefix of a string of matched parens must look like.
     */

    /**
     * Suppose we have a string whose length is less than 2k.
     * Two possibilities: add a left parens or a right parens.
     * If we add a left parens and want to complete string to with k pairs matched,
     * the number of left parens we need is greater than 0.
     * If we add a right parens and want k pair matched, the number of left parens we need is
     * less than the number of right parens (have unmatched left parens in the string).
     */

    public static List<String> generateBalancedParentheses(int numPairs) {
        List<String> res = new ArrayList<>();
        directParentheses(numPairs, numPairs, "", res);
        return res;
    }

    /**
     * C(k)
     */
    private static void directParentheses(int numLeftParensNeeded, int numRightParensNeeded, String validPrefix, List<String> res) {
        if (numLeftParensNeeded == 0 && numLeftParensNeeded == 0) {
            res.add(validPrefix);
            return;
        }

        if (numLeftParensNeeded > 0) {
            //Able to insert '('.
            directParentheses(numLeftParensNeeded - 1, numRightParensNeeded,
                    validPrefix + "(", res);
        }

        if (numLeftParensNeeded < numRightParensNeeded) {
            //Able to insert ')'.
            directParentheses(numLeftParensNeeded, numRightParensNeeded - 1, validPrefix + ")", res);
        }
    }
}
