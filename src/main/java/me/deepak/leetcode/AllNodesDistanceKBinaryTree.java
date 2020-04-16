package me.deepak.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import me.deepak.leetcode.beans.TreeNode;

/*
 * https://youtu.be/nPtARJ2cYrg
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/allNodesDistanceKFromStart.java
*/
public class AllNodesDistanceKBinaryTree {

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

		// create the node to parent map and populate it
		Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
		populateNodeToParentMap(nodeToParentMap, root, null);

		// create the queue that we will be used for the breadth first search.
		// add the start node to the queue
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(target);

		/*
		 * The is an undirected graph now that we can go to and from nodes. Before we
		 * could only go down the tree. Therefore, we need a map to keep track of nodes
		 * we have visited so that we do not go back and revisit what has already been
		 * processed and cause an infinite cycle
		 */
		Set<TreeNode> visited = new HashSet<>();
		visited.add(target);

		// when our search starts, we are standing at layer 0
		int layer = 0;
		while (!queue.isEmpty()) {

			// is this the layer we want? If so, extract and return it
			if (layer == k) {
				return extractLayers(queue);
			}

			/*
			 * How large is this layer? Let's process all node in the layer. This is Breadth
			 * First Search.
			 */
			int size = queue.size();
			while (size-- > 0) {

				/*
				 * Pull a node from the search queue, we are going to basically use our current
				 * layer to populate the next layer of nodes that we need to search in the next
				 * while loop iteration
				 */
				TreeNode currentNode = queue.remove();

				/*
				 * Has left been touched before? No? 1.) Add it to the search queue 2.) Add it
				 * to the visited set
				 */
				if (currentNode.left != null && !visited.contains(currentNode.left)) {
					queue.add(currentNode.left);
					visited.add(currentNode.left);
				}

				/*
				 * Has right been touched before? No? 1.) Add it to the search queue 2.) Add it
				 * to the visited set
				 */
				if (currentNode.right != null && !visited.contains(currentNode.right)) {
					queue.add(currentNode.right);
					visited.add(currentNode.right);
				}
				/*
				 * Has this node's parent been touched before? No? 1.) Add it to the search
				 * queue 2.) Add it to the visited set
				 */
				TreeNode parentOfCurrentNode = nodeToParentMap.get(currentNode);
				if (parentOfCurrentNode != null && !visited.contains(parentOfCurrentNode)) {
					queue.add(parentOfCurrentNode);
					visited.add(parentOfCurrentNode);
				}
			}

			// advance the layer for the next iteration
			layer++;
		}
		return new ArrayList<>();
	}

	private void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap, TreeNode root, TreeNode parent) {

		// base case
		if (root == null) {
			return;
		}

		// map the node to its parent
		nodeToParentMap.put(root, parent);

		/*
		 * Go left and after that go right. The call that we make next will have what we
		 * call 'root' now as the 'parent' value so we can do the mapping in THAT call
		 * stack frame...and so on and so on...
		 */
		populateNodeToParentMap(nodeToParentMap, root.left, root);
		populateNodeToParentMap(nodeToParentMap, root.right, root);
	}

	private List<Integer> extractLayers(Queue<TreeNode> queue) {
		List<Integer> extractedList = new ArrayList<>();
		for (TreeNode node : queue) {
			extractedList.add(node.val);
		}
		return extractedList;
	}

}