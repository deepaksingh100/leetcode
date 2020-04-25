package me.deepak.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/3sum/
 * https://leetcode.com/problems/3sum/discuss/7399/Easiest-Java-Solution
*/
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] a) {
		Arrays.sort(a);
		int length = a.length;
		Set<List<Integer>> triplets = new HashSet<>();
		for (int k = 0; k < length - 2; k++) {
			List<Integer> triplet = new ArrayList<>();
			int target = -a[k];
			int i = k + 1;
			int j = length - 1;
			while (i < j) {
				if (k != j) {
					if (a[i] + a[j] < target) {
						i++;
					} else if (a[i] + a[j] > target) {
						j--;
					} else {
						triplet.add(a[i]);
						triplet.add(a[j]);
						triplet.add(a[k]);
						Collections.sort(triplet);
						triplets.add(triplet);
						triplet = new ArrayList<>();
						i++;
						j--;
					}
				} else {
					j--;
				}
			}
		}
		return new ArrayList<>(triplets);
	}
}
