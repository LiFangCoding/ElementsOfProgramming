package _10_BinaryTrees;

import common.TreeNode;

/**
 * A binary tree is symmetric if you can draw a vertical line through the root.
 * And then the left subtree is the mirror image of the right subtree. (This is recursion definition)
 * <p>
 * Write a program that checks whether a binary tree is symmetric.
 * T = O(n)
 * S = O(h)
 */
public class _2_binaryTreeSymmetric {
    public static boolean isSymmetric(TreeNode tree) {
        return tree == null || checkSymmetric(tree.left, tree.right);
    }

    private static boolean checkSymmetric(TreeNode sub0, TreeNode sub1) {
        if (sub0 == null && sub1 == null) {
            return true;
        } else if (sub0 != null && sub1 != null) {
            return sub0.val == sub1.val && checkSymmetric(sub0.left, sub1.right)
                    && checkSymmetric(sub0.right, sub1.left);
        }
        // One subtree is emtpy, and the other is not.
        return false;
    }
}
