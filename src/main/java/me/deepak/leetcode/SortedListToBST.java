package me.deepak.leetcode;

import me.deepak.leetcode.beans.ListNode;
import me.deepak.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * https://leetcode.com/articles/convert-sorted-list-to-binary-search-tree/
*/
public class SortedListToBST {

	private ListNode head;

	public TreeNode sortedListToBST(ListNode head) {
		this.head = head;
		return sortedListToBST(0, size(head) - 1);
	}

	private TreeNode sortedListToBST(int low, int high) {
		if (low > high) {
			return null;
		}
		
		int mid = (low + high) >>> 1;
		TreeNode left = sortedListToBST(low, mid - 1);
		TreeNode root = new TreeNode(head.val);
		root.left = left;
		head = head.next;
		root.right = sortedListToBST(mid + 1, high);
		return root;
	}

	private int size(ListNode head) {
		int size = 0;
		ListNode current = head;
		while (current != null) {
			current = current.next;
			size++;
		}
		return size;
	}

}
