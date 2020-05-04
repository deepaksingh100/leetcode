package me.deepak.leetcode;

import java.util.Random;

/*
 * https://leetcode.com/problems/random-pick-with-weight/
 * https://stackoverflow.com/questions/1761626/weighted-random-numbers
 * http://blog.gainlo.co/index.php/2016/11/11/uber-interview-question-weighted-random-numbers/
*/
public class RandomPickWithWeight {

	private int[] wSums;
	private Random random;

	public RandomPickWithWeight(int[] w) {
		random = new Random();
		for (int i = 1; i < w.length; i++) {
			w[i] += w[i - 1];
		}
		wSums = w;
	}

	public int pickIndex() {
		int len = wSums.length;

		int index = random.nextInt(wSums[len - 1]) + 1;

		/*
		 * if we are generating random in range [1, wSums[len - 1] + 1), then we need to
		 * find next larger or equal element to index. if we are generating random in
		 * range [0, wSums[len - 1]), then we need to find next larger element to index.
		 */

		// find next larger or equal element than index in wSums
		return nextLargerOrEqualElement(index);
	}

	private int nextLargerOrEqualElement(int target) {
		int low = 0;
		int high = wSums.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (wSums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high + 1;
	}

}
