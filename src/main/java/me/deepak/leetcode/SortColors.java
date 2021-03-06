package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/sort-colors/
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
*/
public class SortColors {

	public void sortColors(int[] a) {
		int low = 0;
		int mid = 0;
		int high = a.length - 1;
		while (mid <= high) {
			switch (a[mid]) {
			case 0:
				swap(a, low++, mid++);
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(a, mid, high--);
				break;
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
