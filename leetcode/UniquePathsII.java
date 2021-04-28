/*
	https://leetcode.com/problems/unique-paths-ii/
*/
class UniquePathsII {
	public static void main(String[] args) {
		int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(new Solution().uniquePathsWithObstacles(grid)); // 2

		grid = new int[][] {{0,1},{0,0}};
		System.out.println(new Solution().uniquePathsWithObstacles(grid)); // 1
	}
}

class Solution {

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];

        // set first row
        for(int c = 0; c < n; c++) {
            if (grid[0][c] == 1) break;
            result[0][c] = 1;
        }

        // set first col
        for(int r = 0; r < m; r++) {
            if(grid[r][0] == 1) break;
            result[r][0] = 1;
        }

        for(int r = 1; r < m; r++) {
            for(int c = 1; c < n; c++) {

                if (grid[r][c] == 1) continue;

                if (result[r-1][c] > 0 && result[r][c-1] > 0)
                    result[r][c] = result[r-1][c] + result[r][c-1];
                else if (result[r-1][c] > 0)
                    result[r][c] = result[r-1][c];
                else
                    result[r][c] = result[r][c-1];
            }
        }

        return result[m-1][n-1];
    }

}
