import java.util.*;
/*
		https://leetcode.com/problems/game-of-life/
*/
class GameOfLife {
	public static void main(String[] args) {
		int[][] board = { {0,1,0}, {0,0,1}, {1,1,1}, {0,0,0} };

		System.out.println("Current state: ");
		for(int[] row : board)
			System.out.println(Arrays.toString(row));

		new Solution().gameOfLife(board);

		System.out.println("\nNext generation state: ");
		for(int[] row : board)
			System.out.println(Arrays.toString(row));

	}
}

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] next = new int[m][n];

        for(int i = 0; i < m; i++) {
            for( int j = 0; j < n; j++) {
                int livingNeighbors = findLivingNeighbors(board, i, j, m, n);

                if(board[i][j] == 0) {
                    next[i][j] = (livingNeighbors == 3) ? 1 : 0;
                } else {
                    next[i][j] = (livingNeighbors < 2 || livingNeighbors > 3) ? 0 : 1 ;
                }

            }
        }

        for(int i = 0; i < m; i++)
            for( int j = 0; j < n; j++)
                board[i][j] = next[i][j];

    }

    int findLivingNeighbors(int[][] board, int r, int c, int m, int n) {
        int livingNeighbors = 0;

        if(r+1 < m && board[r+1][c] == 1) livingNeighbors++;
        if(r-1 >= 0 && board[r-1][c] == 1) livingNeighbors++;
        if(c+1 < n && board[r][c+1] == 1) livingNeighbors++;
        if(c-1 >= 0 && board[r][c-1] == 1) livingNeighbors++;
        if(r-1 >= 0 && c-1 >= 0 && board[r-1][c-1] == 1) livingNeighbors++;
        if(r+1 < m && c+1 < n && board[r+1][c+1] == 1) livingNeighbors++;
        if(r+1 < m && c-1 >= 0 && board[r+1][c-1] == 1) livingNeighbors++;
        if(r-1 >= 0 && c+1 < n && board[r-1][c+1] == 1) livingNeighbors++;

        return livingNeighbors;
    }

}