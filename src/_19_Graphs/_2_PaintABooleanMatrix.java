package _19_Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implement a routine that takes an n * m Boolean array A together with an entry (x, y) and flips
 * the color of the region associatred with (x, y).
 */
public class _2_PaintABooleanMatrix {
    // Hint: Solve this conceptually, then think about implementation optimizations.

    /**
     * [1, 0, 0]
     * [0, 1, 1]
     * [1, 1, 0]
     * -> x = 1, y = 1
     * [1, 0, 0]
     * [0, 0, 0]
     * [0, 0, 0]
     * <p>
     * T is same as that of BFS. ie: O(m * n)
     * he space complexity is a little better than the worst-case for BFS,
     * since there are at most 0{m + n) vertices that are at the same distance from a given entry.
     */
    public static void flipColorBFS(List<List<Boolean>> A, int x, int y) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean color = A.get(x).get(y);

        Queue<Coordinate> q = new LinkedList<>();
        // Flips color
        A.get(x).set(y, !A.get(x).get(y));
        q.add(new Coordinate(x, y));

        while (!q.isEmpty()) {
            Coordinate curr = q.remove();
            for (int[] dir : dirs) {
                Coordinate next = new Coordinate(curr.x + dir[0], curr.y + dir[1]);
                boolean xyAndColorValid = next.x >= 0 && next.x < A.size() && next.y >= 0 && next.y < A.get(next.x).size()
                        && A.get(next.x).get(next.y) == color;
                if (xyAndColorValid) {
                    // Flips the color
                    A.get(next.x).set(next.y, !color);
                    q.add(next);
                }
            }
        }
    }

    // inside the x, y and color is same. It is dangerous
    private static boolean isValid(Coordinate coor, List<List<Boolean>> A, boolean color) {
        /**
         * !!! dangerous. Do not have the valid seperate.
         */
//        boolean xValid = coor.x >= 0 && coor.x < A.size();
//        // This can have bug since A.get(coor.x) can be indexOfBoundsException.
//        boolean yValid = coor.y >= 0 && coor.y < A.get(coor.x).size();
//        // This can have bug since the x and y may not be valid.
//        // It will throw ArrayIndexOutOfBoundsException: -1 error
//        //boolean colorValid = A.get(coor.x).get(coor.y) == color;
//        return xValid && yValid;
        return false;
    }

    /**
     * DFS. It does not need a queue but implicitly uses a stack, namely the function calls stack.
     * <p>
     * Both BFS and DFS differ slightly from traditional BFS and DFS.
     * The reaso nis that we have a color field already available and hence do not need auxiliary color
     * filed traditionally associated with vertices BFS and DFS.
     * Further more, since we are determining reachability, we only need two colors, whereas BFS and DFS
     * traditionally use three colors to track state, (The use of an additonal color makes it possible, for example,
     * to answer questions about cycles in direted graph, but that is not relevant here).
     */
    public static void flipColorDFS(List<List<Boolean>> A, int x, int y) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean color = A.get(x).get(y);
        // Flips
        A.get(x).set(y, !color);
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX >= 0 && nextX < A.size() && nextY >= 0 && nextY < A.get(nextX).size() && A.get(nextX).get(nextY) == color) {
                flipColorDFS(A, nextX, nextY);
            }
        }
    }

    /**
     * for the current problem, we are searching for all vertices whose color is the same as that of (x,y)
     * that of (x,y) that are reachable from (x, y). BFS is natural when starting with a set of vertices.
     * <p>
     * Specifically, we can use a queue to store such vertices. The queue is initilized to (x, y). The queue is
     * popped iteratively. Call the popped point p. First, we record p's initial color and then flip its color.
     * <p>
     * Next, we examine p neighbors. ANy neighbor which is the same color as p's initial color is added to the
     * queue. The computation ends when the queue is empty. So any point that is added to the queue is reachable
     * from (x, y) via a path consisting of points of the same color, and all points reachable via points of the same
     * color will eventually be added to the queue.
     */

    private static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
