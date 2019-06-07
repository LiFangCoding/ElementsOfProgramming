package _15_BinarySearchTree;

import common.TreeNode;

/**
 * Write a program that takes as input a binary tree and checks if the tree satisfies the BST property.
 */
public class _1_TestBST {
    // Hint: Is it correct to check for each node that its key is greater than or equal to
    // the key at its left child and less than or equal to the key at its right child?
    public static class constraintsSol {
        public static boolean isBinaryTreeBST(TreeNode tree) {
            return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        /**
         * node is range [lower, upper]. when go left, left root node is in [lower, root.val], right node is in [root.val, upper]
         * T = O(n)
         * S = O(h)
         */
        private static boolean areKeysInRange(TreeNode tree, Integer lower, Integer upper) {
            if (tree == null) {
                return true;
            } else if (Integer.compare(tree.val, lower) < 0 || Integer.compare(tree.val, upper) > 0) {
                return false;
            }

            return areKeysInRange(tree.left, lower, tree.val) && areKeysInRange(tree.right, tree.val, upper);
        }
    }
}
