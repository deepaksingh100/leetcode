package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/maximum-subarray/
 * https://youtu.be/2MmGzdiKR9Y
 * https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
*/
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int prevSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (prevSum < 0) {
				prevSum = nums[i];
			} else {
				prevSum += nums[i];
			}
			maxSum = Math.max(maxSum, prevSum);
		}
		return maxSum;
	}

}
