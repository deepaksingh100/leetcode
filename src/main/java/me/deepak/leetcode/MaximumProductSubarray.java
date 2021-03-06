package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/maximum-product-subarray/
 * https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
*/
public class MaximumProductSubarray {

	public int maxProduct(int[] a) {

		int minValue = a[0];
		int maxValue = a[0];
		int maxProduct = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < 0) {
				int temp = maxValue;
				maxValue = minValue;
				minValue = temp;
			}
			maxValue = Math.max(a[i], maxValue * a[i]);
			minValue = Math.min(a[i], minValue * a[i]);
			maxProduct = Math.max(maxProduct, maxValue);
		}
		return maxProduct;
	}

}
