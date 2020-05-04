package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/fibonacci-number/
 * https://leetcode.com/articles/fibonacci-number/
*/
public class FibonacciNumber {

	public int fib(int n) {
		if (n <= 0) {
			return 0;
		}
		int first = 0;
		int second = 1;
		for (int i = 2; i <= n; i++) {
			int temp = first + second;
			first = second;
			second = temp;
		}
		return second;
	}
}
