import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (47.80%)
 * Likes:    2409
 * Dislikes: 343
 * Total Accepted:    628K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		return mySolution(l1, l2);
	}

	private ListNode mySolution(ListNode l1, ListNode l2)
	{
		if((l1 == null) || (l2 == null))
		{
			return null;
		}

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		ListNode node1 = l1;
		ListNode node2 = l2;

		while(true)
		{
			list1.add(node1.val);

			if(node1.next == null)
			{
				break;
			}

			node1 = node1.next;
		}
		while(true)
		{
			list2.add(node2.val);

			if(node2.next == null)
			{
				break;
			}

			node1 = node1.next;
		}

		list1.addAll(list2);
		Collections.sort(list1);

		ListNode last = null;
		ListNode rtn = null;
		for(Integer value : list1)
		{
			rtn = new ListNode(value);

			if(last == null)
			{
				last = rtn;
				continue;
			}

			last.next = rtn;

			last = rtn;
		}

		return rtn;
	}
}

