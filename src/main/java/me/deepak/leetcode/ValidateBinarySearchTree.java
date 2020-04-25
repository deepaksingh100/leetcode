package me.deepak.leetcode;

import me.deepak.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/validate-binary-search-tree/
 * https://leetcode.com/articles/validate-binary-search-tree/
*/
public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

}
