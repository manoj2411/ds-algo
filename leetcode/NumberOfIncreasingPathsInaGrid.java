import java.util.*;

/*
    https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/description/
*/

class NumberOfIncreasingPathsInaGrid {
    public static void main(String ...args) {
        int[][] grid = { {1, 1}, {3, 4}};
        System.out.println(new Solution().countPaths(grid)); // 8

    }
}

class Solution {

    private static final int[][] DIRECTIONS = { {0,1}, {0,-1}, {1,0}, {-1,0}};
    private static final int MAX = 1000000007;

    record Cell(int row, int col, int val) {};

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] paths = new int[grid.length][grid[0].length];
        Cell[] cells = new Cell[m*n];

        for(int r = 0, i = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++, i++) {
                cells[i] = new Cell(r, c, grid[r][c]);
                paths[r][c] = 1;
            }
        }

        Arrays.sort(cells, (a, b) -> Integer.compare(a.val(), b.val()));

        for(Cell cell : cells) {
            process(cell, paths, grid);
        }

        int res = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                res = (res + paths[r][c]) % MAX ;
            }
        }
        return res;
    }

    private void process(Cell cell, int[][] paths, int[][] grid) {
        int m = paths.length;
        int n = paths[0].length;
        int currRow = cell.row();
        int currCol = cell.col();

        for(int[] dir : DIRECTIONS) {
            int r = currRow + dir[0];
            int c = currCol + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] < grid[currRow][currCol]) {
                paths[currRow][currCol] = (paths[currRow][currCol] + paths[r][c]) % MAX;
            }
        }
    }
}
