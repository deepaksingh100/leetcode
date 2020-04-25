package me.deepak.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 * https://leetcode.com/problems/top-k-frequent-elements/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap
*/
public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(entry.getValue());
			if (minHeap.size() > k) {
				minHeap.remove();
			}
		}

		while (!minHeap.isEmpty()) {
			result.add(minHeap.remove());
		}

		return result;

	}

}
