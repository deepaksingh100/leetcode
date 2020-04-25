package me.deepak.leetcode;

import me.deepak.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/invert-binary-tree/
 * https://leetcode.com/articles/invert-binary-tree/
*/
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.left = right;
		root.right = left;

		return root;

	}
}
