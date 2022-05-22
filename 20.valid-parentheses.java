/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.76%)
 * Likes:    3121
 * Dislikes: 149
 * Total Accepted:    638.3K
 * Total Submissions: 1.7M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 *
 * Input: "()"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: "()[]{}"
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: "(]"
 * Output: false
 *
 *
 * Example 4:
 *
 *
 * Input: "([)]"
 * Output: false
 *
 *
 * Example 5:
 *
 *
 * Input: "{[]}"
 * Output: true
 *
 *
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isValid(String s) {
		return mySolution(s);
	}

	private boolean mySolution(String s)
	{
		List<Character> stack = new ArrayList<>();

		if(s.length() % 2 != 0)
		{
			return false;
		}

		for(int ix = 0; ix < s.length(); ix++)
		{
			if(stack.isEmpty())
			{
				stack.add(s.charAt(ix));
				continue;
			}

			if(')' == s.charAt(ix) && '(' == stack.get(stack.size() - 1))
			{
				stack.remove(stack.size() - 1);
			}
			else if(']' == s.charAt(ix) && '[' == stack.get(stack.size() - 1))
			{
				stack.remove(stack.size() - 1);
			}
			else if('}' == s.charAt(ix) && '{' == stack.get(stack.size() - 1))
			{
				stack.remove(stack.size() - 1);
			}
			else
			{
				stack.add(s.charAt(ix));
			}
		}

		if(stack.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

