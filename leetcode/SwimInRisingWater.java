import java.util.*;

/*
		https://leetcode.com/problems/swim-in-rising-water/
*/
class SwimInRisingWater {
	public static void main(String[] args) {
		int[][] grid = { {0,2}, {1,3}};
		System.out.println(new Solution().swimInWater(grid)); // 3

		grid = new int[][] {
			{0, 1, 2, 3, 4},
			{24, 23, 22, 21, 5},
			{12, 13, 14, 15, 16},
			{11, 17, 18, 19, 20},
			{10, 9, 8, 7, 6},
		};

		System.out.println(new Solution().swimInWater(grid)); // 16
	}
}


class Solution {

    static private int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int[][] grid;
    int len;

    /*
		Intuition
		 - Take all grid value in an array
		 - sort this array
		 - check all values from low to high if it is the minimum time to reach
		    at the bottom.
		 - the check part is simply doing DFS with squares that has value less or equal
		    to the given time for which we are checking
		 - In worst case is 50 * 50 * 50 which is reasonably acceptable
		  	- we can improve on time by doing binary search while picking the time from
		  		the sorted array.
    */
    public int swimInWater(int[][] grid) {
        this.len = grid.length;
        this.grid = grid;

        int[] vals = new int[len * len];
        int k = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++)
                vals[k++] = grid[i][j];
        }

        Arrays.sort(vals);

        // TODO : make it fast by doing binary search instead of liner search to find min time
        for(int time : vals)
            if (canReachToBottom(time))
                return time;


        return vals[(len * len) - 1];
    }

    private boolean canReachToBottom(int time) {
        boolean[][] visited = new boolean[len][len];
        visited[0][0] = true;
        return dfs(0, 0, time, visited);
    }

    private boolean dfs(int r, int c, int time, boolean[][] visited) {
        if (r == len - 1 && c == len - 1) return grid[r][c] <= time;
        else if (grid[r][c] > time) return false;

        for(int[] dir : DIRECTIONS) {
            int i = r + dir[0];
            int j = c + dir[1];

            if (i >= 0 && j >= 0 && i < len && j < len && !visited[i][j]) {
                visited[i][j] = true;
                if (dfs(i, j, time, visited))
                    return true;
            }
        }

        return false;
    }
}
