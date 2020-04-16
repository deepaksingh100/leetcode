package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/
*/
public class CopyListWithRandomPointer {

	public Node copyRandomList(Node head) {

		if (head == null) {
			return head;
		}

		// copy every node and insert to list
		Node current = head;
		while (current != null) {
			Node copy = new Node(current.val);
			copy.next = current.next;
			current.next = copy;
			current = copy.next;
		}

		// copy random pointer for each new node
		current = head;
		while (current != null) {
			if (current.random != null) {
				current.next.random = current.random.next;
			}
			current = current.next.next;
		}

		// break list to two
		current = head;
		Node newHead = head.next;
		while (current != null) {
			Node copy = current.next;
			current.next = copy.next;
			if (copy.next != null) {
				copy.next = copy.next.next;
			}
			current = current.next;
		}

		return newHead;
	}
}

class Node {
	int val;
	Node next;
	Node random;

	Node(int val) {
		this.val = val;
	}
}
