package _16_Recursion;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Write a program which returns all distinct binary trees with a specified number of nodes.
 * Just consider structure.
 */
public class _8_GenerateBinaryTrees {
    /**
     * Hint: Can two binary trees whose left subtrees differ in size be the same?
     */

    /**
     * direct search. left child has k nodes, use right children with n - 1 -l nodes to
     * get binary trees with n nodes that have left chid.
     * <p>
     * number of calls C(n) = sum(C(n - i) * C(i - 1)) for i = 1..n
     * The quantity C(n) is nth Catalan number.
     * C(n) = (2n)! / (n! * (n + 1)!)
     */
    public static List<TreeNode> generateAllBinaryTrees(int numNodes) {
        List<TreeNode> res = new ArrayList<>();
        // Empty tree, add as an null
        if (numNodes == 0) {
            res.add(null);
        }

        for (int numLeftTreeNodes = 0; numLeftTreeNodes < numNodes; numLeftTreeNodes++) {
            int numRightTreeNodes = numNodes - 1 - numLeftTreeNodes;
            List<TreeNode> leftSubtrees = generateAllBinaryTrees(numLeftTreeNodes);
            List<TreeNode> rightSubtrees = generateAllBinaryTrees(numRightTreeNodes);

            // Generate all combinations of leftsubtrees and rightsubtrees.
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    res.add(new TreeNode(0, left, right));
                }
            }
        }
        return res;
    }
}
