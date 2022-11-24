import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (62.78%)
 * Likes:    7558
 * Dislikes: 250
 * Total Accepted:    1.8M
 * Total Submissions: 2.9M
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 *
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 *
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you
 * adapt your solution to such a case?
 *
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {

        if(Objects.isNull(s) || Objects.isNull(t)) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];

        for(int ix = 0; ix < s.length(); ix++) {
            alphabets[s.charAt(ix) - 'a']++;
            alphabets[t.charAt(ix) - 'a']--;
        }

        for(int alphabet : alphabets) {
            if(alphabet != 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

