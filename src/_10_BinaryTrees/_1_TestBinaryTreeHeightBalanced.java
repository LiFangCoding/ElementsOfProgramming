package _10_BinaryTrees;

import common.TreeNode;

/**
 * A binary tree is height-blanced if for each node in the tree,
 * the difference in the height of its left and right subtrees is at most one.
 * Write a program that takes as input the root of a binary tree and checks whether the tree is
 * height balanced.
 */
public class _1_TestBinaryTreeHeightBalanced {
    public static boolean isBalanced(TreeNode tree) {
        return checkBalanced(tree).balanced;
    }

    /**
     * postorder traversal with some calls possibly being eliminated
     * because of early termination.
     * If any left subtree is not height-balanced, we do not need to visit
     * the corresponding right subtree.
     * Space = O(h)
     * T = O(n). number of nodes.
     */
    private static BalancedStatusWithHeight checkBalanced(TreeNode tree) {
        if (tree == null) {
            return new BalancedStatusWithHeight(true, -1);
        }

        BalancedStatusWithHeight left = checkBalanced(tree.left);
        if (!left.balanced) {
            // left subtree is not balanced.
            return left;
        }

        BalancedStatusWithHeight right = checkBalanced(tree.right);
        if (!right.balanced) {
            // right subtree is not balanced.
            return right;
        }

        boolean isBalanced = Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        return new BalancedStatusWithHeight(isBalanced, height);
    }


    /**
     * Hint: Think of a classic binary tree algorithm.
     */

    private static class BalancedStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalancedStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }
}
