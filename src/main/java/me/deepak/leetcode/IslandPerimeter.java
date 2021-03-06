package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/island-perimeter/
 * https://www.geeksforgeeks.org/find-perimeter-shapes-formed-1s-binary-matrix/
*/
public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int perimeter = 0;

		// traversing the matrix and finding ones to calculate their contribution.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					perimeter += (4 - getNeighbourCount(grid, i, j));
				}
			}
		}
		return perimeter;
	}

	private int getNeighbourCount(int[][] grid, int i, int j) {
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;

		// up
		if (i > 0 && grid[i - 1][j] == 1) {
			count++;
		}

		// left
		if (j > 0 && grid[i][j - 1] == 1) {
			count++;
		}

		// down
		if (i < row - 1 && grid[i + 1][j] == 1) {
			count++;
		}

		// right
		if (j < col - 1 && grid[i][j + 1] == 1) {
			count++;
		}
		return count;
	}

}
