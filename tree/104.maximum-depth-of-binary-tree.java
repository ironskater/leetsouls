import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (71.95%)
 * Likes:    7601
 * Dislikes: 131
 * Total Accepted:    1.8M
 * Total Submissions: 2.5M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 *
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     * draw io
     * https://drive.google.com/file/d/1g_i4zOPGWbNpnt-RCSG9ow_atlEIfsA4/view?usp=sharing
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }

    private int
        myAns(TreeNode root, int depth)
    {
        if(root == null) {
            return 0;
        }

        return this.maxDepthHelper(root, depth);
    }

    private int
        maxDepthHelper(TreeNode node, int depth)
    {
        int leftNextDepth = depth;
        int rightNextDepth = depth;

        if(node.left != null) {
            leftNextDepth =
                this.maxDepthHelper(node.left, depth + 1);
        }

        if(node.right != null) {
            rightNextDepth =
                this.maxDepthHelper(node.right, depth + 1);
        }

        return leftNextDepth > rightNextDepth ? leftNextDepth : rightNextDepth;
    }
}
// @lc code=end

