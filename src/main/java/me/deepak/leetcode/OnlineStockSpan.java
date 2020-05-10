package me.deepak.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/online-stock-span/
 * https://leetcode.com/problems/online-stock-span/discuss/168311/C%2B%2BJavaPython-O(1)
*/
public class OnlineStockSpan {

	private Deque<int[]> stack = new ArrayDeque<>();

	public int next(int price) {
		int res = 1;
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			res += stack.pop()[1];
		}
		stack.push(new int[] { price, res });
		return res;
	}

}
