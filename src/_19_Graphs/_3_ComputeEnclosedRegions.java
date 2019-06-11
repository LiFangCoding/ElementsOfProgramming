package _19_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This problem is concerned with computing regions within a 2D grid that are enclosed.
 * <p>
 * Let A be a 2D array whose entries are either W or B. Write a program that takes A and replace all Ws
 * that cannot reach the boundary with a B.
 */
public class _3_ComputeEnclosedRegions {
    // Hint: It is easier to compute complement of the desired result.
    /**
     * It is easier to focus on the inverse problem, namely idetifying Ws that can reach the boundary.
     * The reason that inverse is simpler is that if a W is adjacent to a W that is can reach the boundary,
     * then first W can reach it too. The Ws on the boundary are the initial set.
     * <p>
     * Subsequenctly, we find Ws neighboring the boundary Ws and iteratively grow the set. Whenever we find a new
     * W that can reach the boundary, we need to record it, and at some stage search for new Ws from it.
     * <p>
     * BFS.
     * T = O(m * n)
     */
    public static void fillSurroundedRegions(List<List<Character>> board) {
        if (board.isEmpty()) {
            return;
        }

        int size = board.size();
        List<List<Boolean>> visited = new ArrayList<>(board.size());

        for (int i = 0; i < size; i++) {
            List<Boolean> temp = new ArrayList<>();
            for (int j = 0; j < board.get(i).size(); j++) {
                temp.add(false);
            }
            visited.add(temp);
        }

        // Identifies the regions that are reachable via white path starting from the first or last columns.
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(0) == 'W' && !visited.get(i).get(0)) {
                markBoundaryRegion(i, 0, board, visited);
            }

            if (board.get(i).get(size - 1) == 'w' && !visited.get(i).get(size - 1)) {
                markBoundaryRegion(i, size - 1, board, visited);
            }
        }


        // Identifies the regions that are reachable via white path starting from the first or last rows.
        for (int j = 0; j < board.get(0).size(); j++) {
            if (board.get(0).get(j) == 'W' && !visited.get(0).get(j)) {
                markBoundaryRegion(0, j, board, visited);
            }

            if (board.get(size - 1).get(j) == 'W' && !visited.get(size - 1).get(j)) {
                markBoundaryRegion(size - 1, j, board, visited);
            }
        }

        // Mark the surrounded white regions as black.
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                if (board.get(i).get(j) == 'W' && !visited.get(i).get(j)) {
                    board.get(i).set(j, 'B');
                }
            }
        }
    }

    private static void markBoundaryRegion(int i, int j, List<List<Character>> board, List<List<Boolean>> visited) {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(i, j));
        visited.get(i).set(j, true);
        // Uses BFS to traverse this region
        while (!q.isEmpty()) {
            Coordinate curr = q.poll();
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : dirs) {
                Coordinate next = new Coordinate(curr.x + dir[0], curr.y + dir[1]);
                // check the xy valid, color valid and not visited
                boolean xyAndNotVisitedValid = next.x >= 0 && next.x < board.size() && next.y >= 0 && next.y < board.get(next.x).size()
                        && board.get(next.x).get(next.y) == 'W' && !visited.get(next.x).get(next.y);

                if (xyAndNotVisitedValid) {
                    visited.get(next.x).set(next.y, true);
                    q.add(next);
                }
            }
        }
    }

    private static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
