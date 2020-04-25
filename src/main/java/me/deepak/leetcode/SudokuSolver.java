package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/sudoku-solver/
 * https://youtu.be/G_UYXzGuqvM
 * https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
*/
public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		solve(board);
	}

	private boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {

					// trial. Try 1 through 9
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {

							// Put c for this cell
							board[i][j] = c;
							if (solve(board)) {

								// If it's the solution return true
								return true;
							}

							// Otherwise go back
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}

		// return true if all cells are checked
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {

			// check in column
			if (board[i][col] == c) {
				return false;
			}

			// check in row
			if (board[row][i] == c) {
				return false;
			}

			// check in 3x3 block
			if (board[3 * row / 3 + i / 3][3 * col / 3 + i % 3] == c) {
				return false;
			}
		}
		return true;
	}
}
