package me.deepak.leetcode;

import me.deepak.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/diameter-of-binary-tree/
*/
public class DiameterOfBinaryTree {

	private static class Height {
		int h = 0;
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return diameter(root, new Height());
	}

	private int diameter(TreeNode root, Height height) {
		if (root == null) {
			return 0;
		}
		Height lHeight = new Height();
		Height rHeight = new Height();
		int lDiameter = diameter(root.left, lHeight);
		int rDiameter = diameter(root.right, rHeight);
		height.h = Math.max(lHeight.h, rHeight.h) + 1;
		return Math.max(lHeight.h + rHeight.h + 1, Math.max(lDiameter, rDiameter));
	}

}
