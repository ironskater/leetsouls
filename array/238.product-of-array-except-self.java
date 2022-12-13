/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (64.76%)
 * Likes:    15608
 * Dislikes: 870
 * Total Accepted:    1.5M
 * Total Submissions: 2.3M
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 *
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 *
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 *
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 *
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {

        return solution1(nums);
    }

    private int[] solution1(int[] nums) {
        int[] fromLeft = new int[nums.length];
        fromLeft[0] = 1;

        int[] fromRight = new int[nums.length];
        fromRight[nums.length - 1] = 1;

        for(int ix = 1; ix < nums.length; ix++) {
            fromLeft[ix] = nums[ix - 1] * fromLeft[ix - 1];
        }

        for(int iy = nums.length - 2; iy >= 0; iy--) {
            fromRight[iy] = nums[iy + 1] * fromRight[iy + 1];
        }

        int[] rtn = new int[nums.length];

        for(int iz = 0; iz < nums.length; iz++) {
            rtn[iz] = fromLeft[iz] * fromRight[iz];
        }

        return rtn;
    }
}
// @lc code=end

