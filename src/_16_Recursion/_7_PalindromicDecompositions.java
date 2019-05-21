package _16_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * A string is said to be palindromic if it reads the same backwards and forwards.
 * Compute all palindromic decompositions of a given string.
 * For example, if the string is "0204451881", then the decomposition "020", "44", "5", "1881" is palindromic, as is "020", "44", "5", "1", "88", "1".
 * However, "02044, "5", "1881" is not a palindromic decomposition.
 */
public class _7_PalindromicDecompositions {
    /**
     * Hint: Focus on the first palindromic string in a palindromic decomposition.
     */

    /**
     * We should enumerate decompositions that begin with a palindrome.
     * This reduce the try that is not successful.
     */
    public static List<List<String>> palindromePartitioning(String input) {
        List<List<String>> res = new ArrayList<>();
        dfs(input, 0, new ArrayList<String>(), res);
        return res;
    }

    /**
     * The worst time complexity is still O(n * 2 ^n). eg, the input string consists of n repetitions of a single character.
     * start is used to cut the range of string input.
     */
    private static void dfs(String input, int start, List<String> path, List<List<String>> res) {
        if (start == input.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // input string, select from [start ~ input.length()].
        for (int i = start + 1; i <= input.length(); i++) {
            String prefix = input.substring(start, i);
            if (isPalindrome(prefix)) {
                path.add(prefix);
                dfs(input, i, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String prefix) {
        for (int i = 0, j = prefix.length() - 1; i < j; i++, j--) {
            if (prefix.charAt(i) != prefix.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
