package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/gas-station/
 * https://youtu.be/nTKdYm_5-ZY
*/
public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int surplus = 0;
		int deficit = 0;

		for (int i = 0; i < gas.length; i++) {
			surplus += gas[i] - cost[i];
			if (surplus < 0) {
				deficit += surplus;
				surplus = 0;
				start = i + 1;
			}
		}
		return surplus + deficit < 0 ? -1 : start;
	}

}
