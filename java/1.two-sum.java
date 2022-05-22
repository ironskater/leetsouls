import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
/**
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * 解題重點：
 * 1. hashmap的containsKey是O(1)
 */
class Solution
{
	public int[] twoSum(int[] nums, int target)
	{
		return myAns2(nums, target);
		// return ans1(nums, target);
		// return myAns(nums, target);
	}

	// time complexity: O(n)
	// We traverse the list containing nn elements only once. Each lookup in the table costs only O(1)O(1) time.

	// space complexity: O(n)
	// The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
	private int[]
		ans1(int[] nums, int target)
	{
		int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);

                return result;
            }

            map.put(nums[i], i);
        }

        return result;
	}

	// O(n^2)
	private int[]
		myAns(int[] nums, int target)
	{
		int[] rtn = new int[2];

		for(int ix = 0; ix < nums.length; ix++)
		{
			for(int iy = ix + 1; iy < nums.length; iy++)
			{
				if(target == nums[ix] + nums[iy])
				{
					rtn[0] = ix;
					rtn[1] = iy;
					break;
				}
			}
		}
		return rtn;
	}

	private int[]
		myAns2(int[] nums, int target)
	{
		int[] rtn = new int[2];

		Map<Integer, Integer> indexByComplement =
			new HashMap<>(nums.length, 1f);

		for(int idx = 0; idx < nums.length; idx++) {
			if(indexByComplement.containsKey(target - nums[idx])) {
				rtn[0] = idx;
				rtn[1] = indexByComplement.get(target - nums[idx]);

				return rtn;
			}

			indexByComplement.put(nums[idx], idx);
		}

		return rtn;
	}
}

