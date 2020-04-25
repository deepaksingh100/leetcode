package me.deepak.leetcode;

/*
 * https://leetcode.com/problems/valid-sudoku/
*/
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}

		// check each row
		for (int i = 0; i < 9; i++) {
			boolean[] exist = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (exist[board[i][j] - '1']) {
						return false;
					}
					exist[board[i][j] - '1'] = true;
				}
			}
		}

		// check each column
		for (int j = 0; j < 9; j++) {
			boolean[] exist = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (exist[board[i][j] - '1']) {
						return false;
					}
					exist[board[i][j] - '1'] = true;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boolean[] exist = new boolean[9];
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						int x = i * 3 + k;
						int y = j * 3 + l;
						if (board[x][y] != '.') {
							if (exist[board[x][y] - '1']) {
								return false;
							}
							exist[board[x][y] - '1'] = true;
						}
					}
				}
			}
		}

		return true;
	}

}
