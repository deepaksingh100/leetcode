package me.deepak.leetcode;

import me.deepak.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
*/
public class SearchInBinarySearchTree {

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null || root.val == val) {
			return root;
		}
		if (val < root.val) {
			return searchBST(root.left, val);
		}
		return searchBST(root.right, val);
	}

}
