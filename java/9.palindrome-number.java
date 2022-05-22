/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int x) {
		// return mySouls(x);
		return recommended(x);
	}

	private boolean mySouls(int x)
	{
		if(x < 0)
		{
			return false;
		}
		else if(x == 0)
		{
			return true;
		}

		int[] digits = new int[10];
		int idxOfDigit = 0;
		int base = 1;
		int palindrome = 0;
		int input = x;

		for(; x != 0; idxOfDigit++)
		{
			digits[idxOfDigit] = x % 10;
			x = x / 10;

			if(idxOfDigit > 0)
			{
				base = base * 10;
			}
		}

		for(int iy = 0; iy < idxOfDigit; iy++)
		{
			palindrome = palindrome + digits[iy] * base;
			base = base / 10;
		}

		return input == palindrome;
	}

	private boolean recommended(int x)
	{
		int res = 0;

		if(x<0 || (x!=0 && x%10==0))
		{
			return false;
		}

		while(x > res)
		{
			res = res*10 + x%10;
			x = x/10;
		}

		return (x==res || x==res/10);
	}
}

