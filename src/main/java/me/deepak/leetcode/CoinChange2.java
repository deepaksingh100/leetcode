package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/coin-change-2/
*/
public class CoinChange2 {

	public int change(int amount, int[] coins) {
		int len = coins.length;
		int[][] table = new int[len + 1][amount + 1];
		for (int i = 0; i <= len; i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] > j) {
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
				}
			}
		}
		return table[len][amount];
	}

}
