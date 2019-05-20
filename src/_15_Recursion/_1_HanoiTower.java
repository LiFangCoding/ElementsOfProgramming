package _15_Recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Prints a sequence of operations that transfer n rings from one peg to another.
 * You have a third peg, which is initially empty.
 * The only operation you can perform is taking a single ring from the top of on peg,
 * and placing it on the top of another peg.
 * You must never place a larget ring above a smaller ring.
 */
public class _1_HanoiTower {
    /**
     * Hint: If you know how to transfer the top n -1 rings,
     * how does that helpmove the nth ring?
     */

    private static final int NUM_PEGS = 3;

    /**
     * The number of moves, T(n) = T(n - 1) + 1 + T(n - 1).
     * THe first T(n - 1) means transfer of the top n - 1 rings from P1 to P3.
     * The second means transfer from P3 to P2.
     * T(n) = 2 ^ n - 1
     * @param numRings
     */
    public static void computeTowerHanoi(int numRings) {
        List<Deque<Integer>> pegs = new ArrayList<>();
        for (int i = 0; i < NUM_PEGS; i++) {
            pegs.add(new LinkedList<>());
        }

        // Initialize pegs.
        for (int i = numRings; i >= 1; i--) {
            pegs.get(0).addFirst(i);
        }

        computeTowerHanoiSteps(numRings, pegs, 0 , 1, 2);
    }

    private static void computeTowerHanoiSteps(int numRingsToMove, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg) {
        if (numRingsToMove > 0) {
            computeTowerHanoiSteps(numRingsToMove - 1, pegs, fromPeg, usePeg, toPeg);
            // Move fromPeg the only one ring to the toPeg.
            pegs.get(toPeg).add(pegs.get(fromPeg).removeFirst());
            System.out.println("Move from peg " + fromPeg + " to peg " + toPeg);
            computeTowerHanoiSteps(numRingsToMove - 1, pegs, usePeg, toPeg, fromPeg);
        }
    }
}
