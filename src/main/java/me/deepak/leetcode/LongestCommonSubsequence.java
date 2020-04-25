package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/longest-common-subsequence/
*/
public class LongestCommonSubsequence {

	private LongestCommonSubsequence() {

	}

	public int longestCommonSubsequence(String text1, String text2) {
		int len1 = text1.length();
		int len2 = text2.length();
		int[][] lcsCount = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 || j == 0) {
					lcsCount[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					lcsCount[i][j] = 1 + lcsCount[i - 1][j - 1];
				} else {
					lcsCount[i][j] = Math.max(lcsCount[i][j - 1], lcsCount[i - 1][j]);
				}
			}
		}
		return lcsCount[len1][len2];
	}

}
