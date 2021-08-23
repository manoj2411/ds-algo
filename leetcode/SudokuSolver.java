import java.util.*;

/*
	https://leetcode.com/problems/sudoku-solver/
*/
class SudokuSolver {
	public static void main(String[] args) {
		char[][] board = {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};

		new Solution().solveSudoku(board);
		for(char[] row : board) {
			System.out.println(Arrays.toString(row));
		}

	}
}

class Solution {

    Set<String> set = new HashSet<>();

    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    add(i, j, board[i][j]);
            }
        }
        // System.out.println(set);
        solve(0, 0);
    }

    boolean solve(int start_i, int start_j) {

        int[] cell = nextEmptyCell(start_i, start_j);

        int r = cell[0];
        int c = cell[1];

        // System.out.println("cell: " + Arrays.toString(cell));
        // for(char[] row : board)
        //     System.out.println(Arrays.toString(row));

        if (r == -1 && c == -1) return true;

        for(int num = 1; num <= 9; num++) {

            char ch = (char)('0' + num);

            if (add(r, c, ch)) {
                board[r][c] = ch;
                if (solve(r, c))
                    return true;
                board[r][c] = '.';
                remove(r, c, ch);
            }
        }

        return false;
    }

    boolean add(int r, int c, char ch) {
        String[] keys = getKeys(r, c, ch);

        for(String key : keys) {
            if (set.contains(key))
                return false;
        }

        for(String key : keys) {
            set.add(key);
        }

        return true;
    }

    String[] getKeys(int r, int c, char ch) {
        String[] keys = new String[3];

        // String rowKey = "row:" + r + ":" + ch;
        // String colKey = "col:" + c + ":" + ch;
        // String boxKey = "box:" + (r / 3) + ":" + (c / 3) + ":" + ch;

        keys[0] = "row:" + r + ":" + ch;
        keys[1] = "col:" + c + ":" + ch;
        keys[2] = "box:" + (r / 3) + ":" + (c / 3) + ":" + ch;
        return keys;
    }

    void remove(int r, int c, char ch) {
        String[] keys = getKeys(r, c, ch);

        for(String key : keys) {
            set.remove(key);
        }
    }


    int[] nextEmptyCell(int start_i, int start_j) {
        // int j = start_j;
        for(int i = start_i; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    return new int[] {i, j};
            }
        }
        return new int[] { -1, -1};
    }
}
