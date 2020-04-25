package me.deepak.leetcode;

import me.deepak.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/8804/Simple-Java-solution-in-one-pass
*/
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		for (int i = 1; i <= n + 1; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;
		return dummy.next;
	}

}
