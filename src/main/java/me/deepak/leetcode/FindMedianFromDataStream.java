package me.deepak.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-median-from-data-stream/
 * https://leetcode.com/articles/find-median-from-data-stream/
 * https://youtu.be/VmogG01IjYc
*/
public class FindMedianFromDataStream {

	PriorityQueue<Integer> upperHalf = null;
	PriorityQueue<Integer> lowerHalf = null;

	public FindMedianFromDataStream() {
		upperHalf = new PriorityQueue<>(); // Min Heap
		lowerHalf = new PriorityQueue<>(Comparator.reverseOrder()); // Max Heap
	}

	public void addNum(int num) {
		upperHalf.add(num);
		lowerHalf.add(upperHalf.remove());
		if (upperHalf.size() < lowerHalf.size()) {
			upperHalf.add(lowerHalf.remove());
		}
	}

	public double findMedian() {
		if (upperHalf.size() > lowerHalf.size()) {
			return upperHalf.peek();
		}
		return (upperHalf.peek() + lowerHalf.peek()) / 2.0;
	}

}
