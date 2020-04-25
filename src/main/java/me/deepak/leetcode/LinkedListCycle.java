package me.deepak.leetcode;

import me.deepak.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/linked-list-cycle/
 * https://leetcode.com/articles/linked-list-cycle/
*/
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
