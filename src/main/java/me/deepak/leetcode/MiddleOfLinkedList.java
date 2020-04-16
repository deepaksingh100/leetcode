package me.deepak.leetcode;

import me.deepak.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/middle-of-the-linked-list/
*/
public class MiddleOfLinkedList {

	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
