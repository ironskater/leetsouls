import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (66.50%)
 * Likes:    13442
 * Dislikes: 397
 * Total Accepted:    1.8M
 * Total Submissions: 2.6M
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 *
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 *
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> rtn = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {

            String charCountKey = getCharCountKey(str);

            List<String> anagramStrs = map.computeIfAbsent(charCountKey, key -> new ArrayList<>());

            anagramStrs.add(str);
        }

        map.values().forEach(rtn::add);

        return rtn;
    }

    private String getCharCountKey(String str) {

        char[] charAry = new char[26];

        for(char c : str.toCharArray()) {
            charAry[c - 'a']++;
        }

        return new String(charAry);
    }
}
// @lc code=end
