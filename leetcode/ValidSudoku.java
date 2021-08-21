/*
	https://leetcode.com/problems/valid-sudoku/
*/
class ValidSudoku {
	public static void main(String[] args) {
		char[][] board = {
			 {'8','3','.','.','7','.','.','.','.'}
			,{'6','.','.','1','9','5','.','.','.'}
			,{'.','9','8','.','.','.','.','6','.'}
			,{'8','.','.','.','6','.','.','.','3'}
			,{'4','.','.','8','.','3','.','.','1'}
			,{'7','.','.','.','2','.','.','.','6'}
			,{'.','6','.','.','.','.','2','8','.'}
			,{'.','.','.','4','1','9','.','.','5'}
			,{'.','.','.','.','8','.','.','7','9'}
		};

		System.out.println(new Solution().isValidSudoku(board)); // false
	}
}

class Solution {

    private char[][] board;

    public boolean isValidSudoku(char[][] board) {
        this.board = board;

        for(int i = 0; i < 9; i++) {
            if (!isRowValid(i)) return false;
            if (!isColValid(i)) return false;
        }

        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                if (!isBoxValid(i, j)) return false;
            }
        }

        return true;
    }

    private boolean isRowValid(int r) {
        boolean[] present = new boolean[10];

        for(int c = 0; c < 9; c++) {
            if (isDuplicate(present, board[r][c]))
                    return false;
        }
        return true;
    }

    private boolean isColValid(int c) {
        boolean[] present = new boolean[10];

        for(int r = 0; r < 9; r++) {
            if (isDuplicate(present, board[r][c]))
                    return false;
        }
        return true;
    }

    private boolean isBoxValid(int i, int j) {
        boolean[] present = new boolean[10];

        for(int r = i; r < (i + 3); r++) {
            for(int c = j; c < (j + 3); c++) {
                if (isDuplicate(present, board[r][c]))
                    return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(boolean[] present, char ch) {
        if (ch == '.') return false;
        if(present[ch - '0']) return true;

        present[ch - '0'] = true;
        return false;
    }
}
