/*
    https://leetcode.com/problems/number-of-enclaves/description/
*/
class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(new Solution().numEnclaves(grid)); // 3
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int rowsLength = grid.length;
        int colsLength = grid[0].length;

        for(int row = 0; row < rowsLength; row++) {
            if (grid[row][0] == 1) {
                floodFill(grid, row, 0);
            }

            if (grid[row][colsLength - 1] == 1) {
                floodFill(grid, row, colsLength - 1);
            }
        }

        for(int col = 0; col < colsLength; col++) {
            if (grid[0][col] == 1) {
                floodFill(grid, 0, col);
            }

            if (grid[rowsLength - 1][col] == 1) {
                floodFill(grid, rowsLength - 1, col);
            }
        }

        int landCells = 0;

        for(int row = 1; row < rowsLength; row++) {
            for(int col = 1; col < colsLength; col++) {
                if (grid[row][col] == 1) {
                    landCells++;
                }
            }
        }
        return landCells;
    }

    private static final int[][] DIRECTIONS = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void floodFill(int[][] grid, int row, int col) {
        int rowsLength = grid.length;
        int colsLength = grid[0].length;

        if (row == rowsLength || row < 0 ||
            col == colsLength || col < 0 || grid[row][col] == 0) {
                return;
            }

        grid[row][col] = 0;
        for(int[] direction : DIRECTIONS) {
            int r = row + direction[0];
            int c = col + direction[1];
            floodFill(grid, r, c);
        }
    }
}
