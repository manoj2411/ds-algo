import java.util.*;

/*
	https://leetcode.com/problems/max-area-of-island/
*/
class MaxAreaOfIsland {
	public static void main(String[] args) {
		int[][] grid = { {0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0}, {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}, };

		System.out.println(new Solution().maxAreaOfIsland(grid)); // 6

	}
}


class Solution {

    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    int area = findArea(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int findArea(int[][] grid, int i, int j) {
        int M = grid.length;
        int N = grid[0].length;
        int area = 0;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {i, j});
        grid[i][j] = 2;

        while(que.size() > 0) {
            var cell = que.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : DIRECTIONS) {
                int nextr = r + dir[0];
                int nextc = c + dir[1];

                if( nextr >= 0 && nextr < M && nextc >= 0 && nextc < N && grid[nextr][nextc] == 1) {
                    grid[nextr][nextc] = 2;
                    que.add(new int[]{ nextr, nextc});
                }
            }
            area++;
        }

        return area;
    }
}
