package _19_Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Design an algorithm which takes as input a graph G = (V , E), directed or undirected, a nonnegative cost function on E, and vertices s and t;
 * your algorithm should output a path with the fewest edges amongst all shortest paths from s to t.
 */
public class _9_ComputeShortestPathFewestEdges {
    /**
     * T = O(E + V) * log*(V)
     */
    public static void dijkstraShortestPath(GraphVertex s, GraphVertex t) {
        // Initialization of the distance of starting point.
        s.distanceWithFewestEdges = new DistanceWithFewestEdges(0, 0);
        SortedSet<GraphVertex> nodeSet = new TreeSet<>();
        nodeSet.add(s);

        while (!nodeSet.isEmpty()) {
            // Extracts the minimum distance vertex from heap.
            GraphVertex u = nodeSet.first();
            if (u.equals(t)) {
                break;
            }
            nodeSet.remove(nodeSet.first());

            // Relax neighboring vertices of u.
            for (VertexWithDistance v : u.edges) {
                int vDistance = u.distanceWithFewestEdges.distance + v.distance;
                int vNumEdges = u.distanceWithFewestEdges.minNumEdges + 1;
                if (v.vertex.distanceWithFewestEdges.distance > vDistance || (v.vertex.distanceWithFewestEdges.distance == vDistance)
                        && v.vertex.distanceWithFewestEdges.minNumEdges > vNumEdges) {
                    nodeSet.remove(v.vertex);
                    v.vertex.pred = u;
                    v.vertex.distanceWithFewestEdges = new DistanceWithFewestEdges(vDistance, vNumEdges);
                    nodeSet.add(v.vertex);
                }
            }

            // Outputs the shortest path with fewest edges.
            outputShortestPath(t);
        }
    }

    private static void outputShortestPath(GraphVertex v) {
        if (v != null) {
            outputShortestPath(v.pred);
            System.out.println(v.id + " ");
        }
    }

    // Hint: Change the edge cost and cast it as an instance of the standard shortest path problem.
    private static class VertexWithDistance {
        public GraphVertex vertex;
        public Integer distance;

        public VertexWithDistance(GraphVertex vertex, Integer distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private static class DistanceWithFewestEdges {
        public int distance;
        public int minNumEdges;

        public DistanceWithFewestEdges(int distance, int minNumEdges) {
            this.distance = distance;
            this.minNumEdges = minNumEdges;
        }
    }

    public static class GraphVertex implements Comparable<GraphVertex> {
        public DistanceWithFewestEdges distanceWithFewestEdges = new DistanceWithFewestEdges(Integer.MAX_VALUE, 0);
        public List<VertexWithDistance> edges = new ArrayList<>();
        // The id of this vertex.
        public int id;
        // The predecessor in the shortest path.
        public GraphVertex pred = null;

        @Override
        public int compareTo(GraphVertex o) {
            if (distanceWithFewestEdges.distance != o.distanceWithFewestEdges.distance) {
                return Integer.compare(distanceWithFewestEdges.distance, o.distanceWithFewestEdges.distance);
            }

            if (distanceWithFewestEdges.minNumEdges != o.distanceWithFewestEdges.minNumEdges) {
                return Integer.compare(distanceWithFewestEdges.minNumEdges, o.distanceWithFewestEdges.minNumEdges);
            }
            return Integer.compare(id, o.id);
        }
    }
}
