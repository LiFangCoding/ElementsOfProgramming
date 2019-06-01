package _10_BinaryTrees;

import common.TreeNode;

/**
 * Write a program which takes as input an integer and a binary tree with
 * integer node weights, and checks if there exists a leaf whose path weight
 * equals the given integer.
 */
public class _6_FindARootToLeafPathWithSum {
    // Hint: What do you need to know about the rest of the tree when checking a
    // specific subtree?

    /**
     * Brute force: we have overlapping paths, and we do not share the summation computation across those overlaps.
     * <p>
     * A better approach is to traverse the tree, keeping track of the root-to-node path sum.
     * The first time we encounter a leaf whose weight equals the target weight, we have succeeded at locating a desired leaf.
     * Short circuit evaluation of the check ensures that we do not process additional leaves.
     */

    public static boolean hasPathSum(TreeNode tree, int targetSum) {
        return hasPathSumHelper(tree, 0, targetSum);
    }

    /**
     * T = O(n)
     * S = O(h)
     */
    private static boolean hasPathSumHelper(TreeNode node, int partialPathSum, int targetSum) {
        if (node == null) {
            return false;
        }

        partialPathSum += node.val;
        if (node.left == null && node.right == null) {
            return partialPathSum == targetSum;
        }

        // Non-leaf
        return hasPathSumHelper(node.left, partialPathSum, targetSum)
                || hasPathSumHelper(node.right, partialPathSum, targetSum);
    }
}
