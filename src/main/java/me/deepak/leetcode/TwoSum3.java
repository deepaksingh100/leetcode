package me.deepak.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetfree.com/problems/two-sum-iii-data-structure-design.html
 * https://www.programcreek.com/2014/03/two-sum-iii-data-structure-design-java/
*/
public class TwoSum3 {
	
	private final Map<Integer, Integer> frequencyMap = new HashMap<>();

	public void add(int number) {
		frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
	}

	public boolean find(int value) {
		for (Integer i : frequencyMap.keySet()) {
			int target = value - i;
			if (frequencyMap.containsKey(target)) {
				if (i == target && frequencyMap.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
}
