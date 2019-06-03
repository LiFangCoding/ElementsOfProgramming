package _16_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Packets in Ethernet local area networks (LANs) are routed according to the unique path
 * in a tree whose leaves correspond to clients,
 * internal nodes to switches,and edges to physical connection.
 * In this problem, we want to design an algorithm for finding the "worst-case" route, i.e.,
 * the two clients that are furthest apart.
 * The diameter of a tree is defined to be the length of a longest path in the tree.
 * Design an efficient algorithm to compute the diameter of a tree.
 */
public class _11_ComputeDiameterOfATree {
    /**
     * Hint: The longest path may or may not pass through the root.
     */

    public static double computeDiameter(TreeNode T) {
        return T != null ? computeHeightAndDiameter(T).diameter : 0.0;
    }

    /**
     * Since the time spent at each node is proportional to the number of its children,
     * the time complexity is O(n).
     */
    private static HeightAndDiameter computeHeightAndDiameter(TreeNode r) {
        double diameter = Double.MIN_VALUE;
        //Stores the max two heights
        double[] heights = {0.0, 0.0};
        for (Edge e : r.edges) {
            HeightAndDiameter heightDiameter = computeHeightAndDiameter(e.root);
            double heightSubtree = heightDiameter.height + e.length;
            if (heightSubtree > heights[0]) {
                heights[1] = heights[0];
                heights[0] = heightSubtree;
            } else if (heightSubtree > heights[1]) {
                heights[1] = heightSubtree;
            }
            diameter = Math.max(diameter, heightDiameter.diameter);
        }
        return new HeightAndDiameter(heights[0], Math.max(diameter, heights[0] + heights[1]));
    }

    /**
     * Consider a longest path in the tree. Either it passes through root or it does not pass through the root.
     * If the longest path does not pass through root, it must be entirely within one of the subtree.
     * Therefore, the longest path length in the tree is the maximum of the diameters of the subtree.
     * If the longest path does not path through the root, it must be between a pair of nodes in distinct subtrees that are furthest from the root.
     * The distance from the root to the node in the ith subtree Ti that is fi = hi + li
     * hi is the height of of Ti. li is the length of the edge from the root to the root of Ti.
     * Since one of two cases must hold, the longest path is the larger of the maximum of the subtree diameters and the sum of the two largest fis.
     */

    public static class TreeNode {
        List<Edge> edges = new ArrayList();
    }

    private static class Edge {
        public TreeNode root;
        public Double length;

        public Edge(TreeNode root, Double length) {
            this.root = root;
            this.length = length;
        }
    }

    private static class HeightAndDiameter {
        public Double height;
        public Double diameter;

        public HeightAndDiameter(Double height, Double diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
