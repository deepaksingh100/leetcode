package me.deepak.leetcode;

import me.deepak.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
*/
public class DeleteNodeLinkedList {

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
