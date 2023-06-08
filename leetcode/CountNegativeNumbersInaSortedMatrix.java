/*
	https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
*/
class CountNegativeNumbersInaSortedMatrix {
	public static void main(String[] args) {
		int[][] grid = {
			{4,3,2,-1},
			{3,2,1,-1},
			{1,1,-1,-2},
			{-1,-1,-2,-3}};
		System.out.println(new Solution().countNegatives(grid)); // 8
	}
}


class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int col = n - 1;
        int totalNegatives = 0;
        for(int row = 0; row < m; row++) {
            while(canMoveRight(grid, row, col)) {
                col--;
            }
            totalNegatives += calculateNegativesInRow(grid, row, col);
        }

        return totalNegatives;
    }

    private int calculateNegativesInRow(int[][] grid, int row, int col) {
        int n = grid[0].length;

        if (grid[row][col] >= 0) {
            return 0;
        }

        return n - col;
    }

    private boolean canMoveRight(int[][] grid, int row, int col) {
        if (col == 0 || grid[row][col] >= 0 || grid[row][col-1] >= 0) {
            return false;
        }

        return true;
    }
}
