package me.deepak.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import me.deepak.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
*/
public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<>();
		if (root == null) {
			return traversal;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();

		while (root != null || !stack.isEmpty()) {

			// reach the left most Node from root
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			traversal.add(root.val);

			// we have visited the node and its left subtree. Now, it's right subtree's turn
			root = root.right;
		}
		return traversal;
	}

}
