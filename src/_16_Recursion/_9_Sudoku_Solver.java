package _16_Recursion;

import java.util.List;

/**
 * Implement a Sudoku solver.
 */
public class _9_Sudoku_Solver {
    /**
     * Hint: Apply the constraints to speed up a brute-force algorithm.
     */

    /**
     * We can reduce runtime considerably by making use of
     * the fact that we are adding a value to an array that already
     * satisfies the constraints. This means we need to check just the row,
     * column, and subgrid of the added entry.
     */
    private static final int EMPTY_ENTRY = 0;

    public static boolean solveSudoku(List<List<Integer>> partialAssignment) {
        return solvePartialSudoku(0, 0, partialAssignment);
    }

    /**
     * Because the program is specialized to 9 * 9 grids,
     * it does not make sense to speak of complexity.
     */
    private static boolean solvePartialSudoku(int i, int j, List<List<Integer>> partialAssignment) {
        if (i == partialAssignment.size()) {
            // Starts a new row.
            i = 0;
            if (++j == partialAssignment.get(i).size()) {
                // Entire matrix has been filled without conflict.
                return true;
            }
        }

        // Skips nonempty entries.
        if (partialAssignment.get(i).get(j) != EMPTY_ENTRY) {
            return solvePartialSudoku(i + 1, j, partialAssignment);
        }

        for (int val = 1; val <= partialAssignment.size(); ++val) {
            // It is substantially quicker to check if entry val conflicts with any
            // of the constraints if we add it at (i, j) before adding it, rather than adding
            // it and then checking all constraints.
            // The reason is that we are staring with a valid configuration.
            // and the only entry which can cause a problem is entryval at (i, j).
            if (validToaddVal(partialAssignment, i, j, val)) {
                partialAssignment.get(i).set(j, val);
                if (solvePartialSudoku(i + 1, j, partialAssignment)) {
                    return true;
                }
            }

            // Undo assignment
            partialAssignment.get(i).set(j, EMPTY_ENTRY);
        }
        return false;
    }

    private static boolean validToaddVal(List<List<Integer>> partialAssignment, int i, int j, int val) {
        // Check row constraints.
        for (List<Integer> element : partialAssignment) {
            if (val == element.get(j)) {
                return false;
            }
        }

        // Check column constraints.
        for (int k = 0; k < partialAssignment.size(); k++) {
            if (val == partialAssignment.get(i).get(k)) {
                return false;
            }
        }

        // Check region constraints.
        int regionSize = (int) Math.sqrt(partialAssignment.size());
        int I = i / regionSize, J = j / regionSize;

        for (int a = 0; a < regionSize; a++) {
            for (int b = 0; b < regionSize; b++) {
                if (val == partialAssignment.get(regionSize * I + a).get(regionSize * J + b)) {
                    return false;
                }
            }
        }
        return true;
    }
}
