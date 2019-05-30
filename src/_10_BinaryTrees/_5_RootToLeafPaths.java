package _10_BinaryTrees;

import common.TreeNode;

/**
 * Consider a binary tree in which each node contains
 * a binary digit. root is the MSB.
 * Design an algorithm to compute the sum of the binary numbers
 * represented by the root-to-leaf-paths.
 */
public class _5_RootToLeafPaths {
    /**
     * The insight to improving complexity is to recognize that paths share nodes and that it is not necessary to repeat computations across the shared nodes.
     * To compute the integer for the path from the root to any node, we take the integer for the node's parent,
     * double it, and add the bit at that node. For example, the integer for the path from A to L is 2 X (1100)2 + 1 = (11001)2
     * <p>
     * Each time we visit a node, we compute the integer it encodes using the number for its parent.
     * If the node is a leaf we return its integer. If it is not a leaf, we return the sum of the results from its left and right children.
     * <p>
     * T = O(n)
     * S = O(h)
     */
    public static int sumRootToLeaf(TreeNode tree) {
        return sumRootToLeafHelper(tree, 0);
    }

    private static int sumRootToLeafHelper(TreeNode tree, int partialPathSum) {
        if (tree == null) {
            return 0;
        }

        partialPathSum = partialPathSum * 2 + tree.val;
        if (tree.left == null && tree.right == null) {
            return partialPathSum;
        }

        // Non-leaf
        return sumRootToLeafHelper(tree.left, partialPathSum) + sumRootToLeafHelper(tree.right, partialPathSum);
    }
}
