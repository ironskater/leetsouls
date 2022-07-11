/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */
class Solution
{
	public int reverse(int x)
	{
		// return method1(x);
		return method3(x);
	}

	private int method1(int x)
	{
		long rtn = 0;
		int[] digit = new int[10];
		int ix = 0;
		long base = 1;

		for(ix = 0; x != 0; ix++)
		{
			digit[ix] = x % 10;
			x = x / 10;
		}

		for(int iy = ix - 1; iy >= 0; iy--)
		{
			rtn = rtn + digit[iy] * base;
			base = base * 10;
		}

		if(rtn > Integer.MAX_VALUE || rtn < Integer.MIN_VALUE)
		{
			return 0;
		}

		return (int)rtn;
	}

	private int method2(int x)
	{
		long rtn = 0;

		while(x != 0)
		{
			rtn = rtn * 10 + x % 10;
			x = x / 10;
		}

		if(rtn > Integer.MAX_VALUE || rtn < Integer.MIN_VALUE)
		{
			return 0;
		}

		return (int)rtn;
	}

	private int method3(int x)
	{
		int result = 0;

		while (x != 0)
		{
			int tail = x % 10;
			int newResult = result * 10 + tail;

			if ((newResult - tail) / 10 != result)
			{
				return 0;
			}

			result = newResult;

			x = x / 10;
		}

		return result;
	}
}

