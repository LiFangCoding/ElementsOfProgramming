package _16_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * A nonattacking placement of queens is one in which no two queens
 *  are in the same row, column, or diagonal.
 *  Write a program which returns all distinct nonattacking placements of n queens
 *  on an n * n chessboard, where n is an input to the problem.
 */
public class _2_NQueens {
    /**
     * Hint: IF the first queen is placed at (i, j), where can the remaining
     * queens definitely not be placed?
     */

    /**
     * Brute force is C(n^2, n).
     * Since we would never place two queens on the same row.
     * A much faster solution is to enumerate placements that use distince rows.
     * It can be represented by an array of length n,
     * where its entity is the location of queen on Row i.
     */

    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<>(), res);
        return res;
    }

    private static void solveNQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> res) {
        if (row == n) {
            // All queens are legally placed.
            res.add(new ArrayList<>(colPlacement));
        } else {
            for (int col = 0; col < n; col++) {
                colPlacement.add(col);
                if (isValid(colPlacement)) {
                    solveNQueens(n, row + 1, colPlacement, res);
                }
                colPlacement.remove(colPlacement.size() - 1);
            }
        }
    }

    /**
     * Test if a newly placed queen will conflict any earlier queens placed before.
     */
    private static boolean isValid(List<Integer> colPlacement) {
        int rowId = colPlacement.size() - 1;
        for (int i = 0; i < rowId; i++) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }
}
