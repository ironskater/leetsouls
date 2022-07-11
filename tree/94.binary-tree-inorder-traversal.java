package tree;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (70.90%)
 * Likes:    8251
 * Dislikes: 379
 * Total Accepted:    1.6M
 * Total Submissions: 2.2M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 *
 * Example 2:
 *
 *
 * Input: root = []
 * Output: []
 *
 *
 * Example 3:
 *
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
class Solution
{
    public List<Integer>
        inorderTraversal(TreeNode root)
    {
        List<Integer> rtn = new ArrayList<>();

        if(root == null) {
            return rtn;
        }

        this.inorderTraversalHelper(root, rtn);

        return rtn;
    }

    private void
        inorderTraversalHelper(TreeNode node, List<Integer> refNodeValueList)
    {
        if(node.left != null) {
            this.inorderTraversalHelper(node.left, refNodeValueList);
        }

        refNodeValueList.add(node.val);

        if(node.right != null) {
            this.inorderTraversalHelper(node.right, refNodeValueList);
        }

        return;
    }
}
// @lc code=end

