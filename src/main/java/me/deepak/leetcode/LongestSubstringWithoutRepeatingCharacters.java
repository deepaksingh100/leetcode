package me.deepak.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode.com/articles/longest-substring-without-repeating-characters/
*/
public class LongestSubstringWithoutRepeatingCharacters {

	// solution using sliding window technique
	public int lengthOfLongestSubstring(String s) {

		// base case
		if (s == null || s.length() == 0) {
			return 0;
		}

		// map of char and it's index. if we find duplicate then overwrite with new
		// index.
		Map<Character, Integer> indexMap = new HashMap<>();

		int max = Integer.MIN_VALUE;
		int len = s.length();

		// left of current window
		int left = 0;

		// right of current window
		int right = 0;

		while (right < len) {

			// pick current char
			char c = s.charAt(right);

			Integer index = indexMap.get(c);

			// if not found in map, put (c, right)
			if (index == null) {
				indexMap.put(c, right);
			} else {

				// if duplicate found, calculate max of current window.
				max = Math.max(max, right - left);

				for (int i = left; i <= index; i++) {
					indexMap.remove(s.charAt(i));
				}

				// set left to index + 1. we have new window now.
				left = index + 1;

				// put (c, right)
				indexMap.put(c, right);
			}

			// go to next element
			right++;
		}

		// this line take care of last window, which was not terminated
		return Math.max(max, right - left);
	}

}
