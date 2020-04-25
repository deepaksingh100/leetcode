package me.deepak.leetcode;

import java.util.ArrayList;
import java.util.List;

import me.deepak.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-paths/
*/
public class BinaryTreePaths {

	private static final String ARROW = "->";
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		binaryTreePaths(root, new StringBuilder(), paths);
		return paths;
	}

	public void binaryTreePaths(TreeNode root, StringBuilder path, List<String> paths) {

		if (root == null) {
			return;
		}

		path.append(root.val);

		if (root.left == null && root.right == null) {
			paths.add(path.toString());
			return;
		}

		binaryTreePaths(root.left, new StringBuilder(path).append(ARROW), paths);
		binaryTreePaths(root.right, new StringBuilder(path).append(ARROW), paths);

	}

}
