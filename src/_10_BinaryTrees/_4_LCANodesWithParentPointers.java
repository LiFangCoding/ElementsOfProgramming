package _10_BinaryTrees;

import common.TreeNode;

/**
 * Given two nodes in a binary tree. Design an algorithm that computes their LCA.
 * Assume that each node has a parent pointer.
 */
public class _4_LCANodesWithParentPointers {
    // Hint: The problem is easy if both nodes are the same distance from
    // the root.

    /**
     * Brute force is to store nodes in hash table for first node.
     * Then go up from the second node. Stop when we hit a node in the hash table.
     * T = O(h), S = O(h)
     * <p>
     * We ascend from deeper node to get the same depth as the shallower node,
     * then perform the tandem upward movement.
     * If we know the depth, then we can move upwards.
     * T = O(h)
     * S = O(1)
     */
    public static TreeNode LCA(TreeNode node0, TreeNode node1) {
        int depth0 = getDepth(node0);
        int depth1 = getDepth(node1);

        // Makes node 0 as the deeper node in order to simplify the code.
        if (depth1 > depth0) {
            TreeNode temp = node0;
            node0 = node1;
            node1 = temp;
        }

        // Ascends from the deeper node.
        int depthDiff = Math.abs(depth0 - depth1);
        while (depthDiff-- > 0) {
            node0 = node0.parent;
        }

        // now acends both nodes until we reach the LCA.
        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }

        return node0;
    }

    private static int getDepth(TreeNode node) {
        int depth = 0;
        while (node.parent != null) {
            ++depth;
            node = node.parent;
        }
        return depth;
    }
}
