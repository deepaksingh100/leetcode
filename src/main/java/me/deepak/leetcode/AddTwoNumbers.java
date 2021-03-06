package me.deepak.leetcode;

import me.deepak.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/add-two-numbers/
*/
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode current = null;
		int sum = 0;
		int carry = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			sum += carry;
			carry = sum / 10;
			sum %= 10;
			ListNode newNode = new ListNode(sum);
			sum = 0;
			if (head != null) {
				current.next = newNode;
				current = current.next;
			} else {
				head = newNode;
				current = head;
			}
		}
		if (carry > 0) {
			current.next = new ListNode(carry);
		}
		return head;
	}

}
