import java.util.*;

/*
		https://leetcode.com/problems/n-queens/
*/

class NQueens {
	public static void main(String[] args) {
		System.out.println(new Solution().solveNQueens(4));
		// [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

		System.out.println(new Solution().solveNQueens(1));
		// [["Q"]]

		System.out.println(new Solution().solveNQueens(3));
		// []
	}
}

class Solution {

    List<List<String>> result;
    boolean[][] chessboard;

    public List<List<String>> solveNQueens(final int n) {
        result = new ArrayList<>();
        chessboard = new boolean[n][n];

        placeQueenAtRow(0, n);

        return result;
    }

    private void placeQueenAtRow(final int row, final int n) {

        if (row == n) {
            result.add(buildSnapshot(n));
            return;
        }

        for(int i = 0; i < n; i++) {
            if (canPlaceQueenAt(row, i, n)) {
                chessboard[row][i] = true;
                placeQueenAtRow(row + 1, n);
                chessboard[row][i] = false;
            }
        }
    }

    private boolean canPlaceQueenAt(final int row, final int col, final int n) {

        // check in same row
        for(int r = row - 1; r >= 0; r--)
            if (chessboard[r][col]) return false;

        // check left diagonally
        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--)
            if(chessboard[r][c]) return false;

        // check right diagonally
        for(int r = row-1, c = col + 1; c < n && r >= 0; r--, c++)
            if(chessboard[r][c]) return false;

        return true;
    }

    private List<String> buildSnapshot(int n) {
        List<String> snapshot = new ArrayList<>();

        for(int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();

            for(int c = 0; c < n; c++) {
                sb.append(chessboard[r][c] ? 'Q' : '.');
            }
            snapshot.add(sb.toString());
        }
        return snapshot;
    }
}
