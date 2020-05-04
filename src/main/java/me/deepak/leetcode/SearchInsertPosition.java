package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/search-insert-position/
*/
public class SearchInsertPosition {
	
	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high + 1;
	}
}
