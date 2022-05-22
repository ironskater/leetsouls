/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */
class Solution {
    public int hammingDistance(int x, int y) {
		return myAns(x, y);
	}

	private int myAns(int x, int y)
	{
		int distance = 0;
		int bitmask = 1;
		int bitX;
		int bitY;

		for(int ix = 0; ix < 32; ix++)
		{
			bitX = x & (bitmask << ix);
			bitY = y & (bitmask << ix);

			if((bitX ^ bitY) != 0)
			{
				distance++;
			}
		}

		return distance;
	}
}

