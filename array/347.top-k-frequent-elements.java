import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (64.77%)
 * Likes:    12046
 * Dislikes: 440
 * Total Accepted:    1.2M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 *
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 *
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        return solution1(nums, k);
    }

    private int[] solution1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> sizeByNum = new HashMap<>();
        int[] rtn = new int[k];

        for (int ix = 0; ix < nums.length; ix++) {
            int size = sizeByNum.computeIfAbsent(nums[ix], key -> Integer.valueOf(0));
            sizeByNum.put(nums[ix], ++size);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
            (current, incoming) -> incoming.getValue() - current.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : sizeByNum.entrySet()) {
            priorityQueue.add(entry);
        }

        for (int iy = 0; iy < k; iy++) {
            rtn[iy] = priorityQueue.poll().getKey();
        }

        return rtn;
    }
}
// @lc code=end
