package me.deepak.leetcode;

import me.deepak.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/reverse-linked-list/
 * https://leetcode.com/articles/reverse-linked-list/
 * https://www.youtube.com/watch?v=MRe3UsRadKw
*/
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
