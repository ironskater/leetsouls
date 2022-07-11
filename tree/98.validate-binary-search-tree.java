package java;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (30.60%)
 * Likes:    10565
 * Dislikes: 922
 * Total Accepted:    1.5M
 * Total Submissions: 4.8M
 * Testcase Example:  '[2,1,3]'
 *
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 *
 * A valid BST is defined as follows:
 *
 *
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is
 * 4.
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
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
class Solution
{
    private Integer prev = null;

    public boolean
        isValidBST(TreeNode root)
    {
        // solution 1: by in-order check
        return this.isValidBSTHelperByInorder(root);

        // solution 2: by recursive directly
        // return this.isValidBSTHelper(root, null, null);
    }

    private boolean
        isValidBSTHelperByInorder(TreeNode node)
    {
        //   5
        // 1   6
        //    4 7 <--- 4必須在5的左側, 故此case非BST
        if(node == null) {
            return true;
        }

        if(!this.isValidBSTHelperByInorder(node.left)) {
            return false;
        }

        if(prev != null && node.val <= prev) {
            return false;
        }

        prev = node.val;

        if(!this.isValidBSTHelperByInorder(node.right)) {
            return false;
        }

        return true;
    }

    // private boolean
    //     isValidBSTHelper(TreeNode node, Integer upperLimit, Integer lowerLimit)
    // {
    //     // empty tree is valid BST
    //     if(node == null) {
    //         return true;
    //     }

    //     /**
    //      * 1. 相等的node.val視作false
    //      * 2. 須考慮Not only the right child should be larger than the node but all the elements in the right subtree.
    //      *      5
    //      *    1   6
    //      *       4 7 <--- 4必須在5的左側, 故此case非BST
    //      */
    //     if((lowerLimit != null && node.val <= lowerLimit.intValue())
    //             || (upperLimit != null && node.val >= upperLimit.intValue())) {
    //         return false;
    //     }

    //     return isValidBSTHelper(node.left, node.val, lowerLimit)
    //                 && isValidBSTHelper(node.right, upperLimit, node.val);
    // }
}
// @lc code=end

