import java.util.*;

/*
	https://leetcode.com/problems/path-with-minimum-effort/
*/
class PathWithMinimumEffort {
	public static void main(String[] args) {
		int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
		System.out.println(new Solution().minimumEffortPath(heights)); // 2
		heights = new int [][] {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		System.out.println(new Solution().minimumEffortPath(heights)); // 0
	}
}

class Solution {
    private static int[][] DIRECTION = { {0,1}, {1,0}, {-1, 0}, {0, -1}};

    private int[][] effort;
    private int[][] heights;
    private int rows;
    private int cols;

    public int minimumEffortPath(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;
        this.heights = heights;

        effort = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            Arrays.fill(effort[i], 1000_000 + 1);
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[2], a2[2]));


        que.add(new int[] {0, 0, 0});
        effort[0][0] = 0;

        while(!que.isEmpty()) {
            int[] tuple = que.poll();

            int r = tuple[0];
            int c = tuple[1];
            int maxPathEffort = tuple[2];

            for(int[] dir : DIRECTION) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int curr = Math.abs(heights[r][c] - heights[nr][nc]);
                    curr = Math.max(curr, maxPathEffort);
                    if (curr < effort[nr][nc]) {
                        effort[nr][nc] = curr;
                        que.add(new int[] {nr, nc, curr});
                    }
                }

            }
        }

        return effort[rows-1][cols-1];
    }

}
/*

	idea : init effort with max effort. then do bfs or dfs iif new distance is < stored distance.
		DFS was very slow, bfs worked well, can replaced queue with priority queue to make it more fast

*/
