package _19_Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D array of black and white entries representing a maze with designated entrance and exit points, find a path
 * from the entrance to the exit, if one exists.
 */
public class _1_SearchAMaze {
    // Hint: Model the maze as a graph.

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();
        maze.get(s.x).set(s.y, Color.BLACK);
        path.add(s);

        if (!searchMazeHelper(maze, s, e, path)) {
            // this has no relationship with the helper. Just to make sure the path is empty when no path exists.
            path.remove(path.size() - 1);
        }

        // Empty path means no path between s and e.
        return path;
    }

    // performs DFS to find a feasible path.
    private static boolean searchMazeHelper(List<List<Color>> maze, Coordinate cur, Coordinate e, List<Coordinate> path) {
        if (cur.x == e.x && cur.y == e.y) {
            return true;
        }

        final int[][] SHIFT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] s : SHIFT) {
            Coordinate next = new Coordinate(cur.x + s[0], cur.y + s[1]);
            if (isValid(next, maze)) {
                maze.get(next.x).set(next.y, Color.BLACK);
                path.add(next);
                if (searchMazeHelper(maze, next, e, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }

        return false;
    }

    // Checks cur is within maze and is a white pixel.
    private static boolean isValid(Coordinate cur, List<List<Color>> maze) {
        boolean xValid = cur.x >= 0 && cur.x < maze.size();
        boolean yValid = cur.y >= 0 && cur.y < maze.get(cur.x).size();
        boolean colorValid = maze.get(cur.x).get(cur.y) == Color.WHITE;

        return xValid && yValid && colorValid;
    }

    public enum Color {WHITE, BLACK}

    /**
     * A brute-force approach would be to enumerate every possible path from entry to exit.
     * However, the number of paths is astronomical. Of course, pruning helps, since we can stop as soon as a path
     * hits a black pixel, but the work-case behavior of enumerative approaches is still very bad.
     * <p>
     * Anothe approach is to perform a random walk from a white pixcel to a random white pixel, Given enough time this will
     * find a path if exists. However, it repeats visits, which retards the progress. The random walk does sugguest the right way.
     * We should keep track of pixcels that we have already visited. This is exactly what DFS and BFS do to ensure progress.
     * <p>
     * model maze as a graph. Each vertex corresponds to a white pixel. index the vertices based on the coordinates of the
     * corresponding pixel, ie, vertex v_i,j corresponds to the white entry at (i, j) in the 2D array.
     * <p>
     * Edges model adjacent white pixels.
     * <p>
     * T = O (|V| + |E|). Same as that for DFS.
     */

    public static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
