package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/container-with-most-water/
 * https://leetcode.com/articles/container-with-most-water/
*/
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = Integer.MIN_VALUE;
		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

}
