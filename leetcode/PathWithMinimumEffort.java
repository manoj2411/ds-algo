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
    private int[][] DIR = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    private record Cell(int row, int col, int effort) {};

    public int minimumEffortPath(int[][] heights) {
        int rlen = heights.length;
        int clen = heights[0].length;

        int[][] effort = new int[rlen][clen];
        for(int[] row : effort ) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.effort, b.effort));
        pq.offer(new Cell(0, 0, 0));
        effort[0][0] = 0;

        while(pq.size() > 0) {
            Cell cell = pq.poll();

            if (effort[cell.row][cell.col] < cell.effort) continue;

            for(int[] d : DIR) {
                int row = d[0] + cell.row;
                int col = d[1] + cell.col;

                if (row >= 0 && col >= 0 && row < rlen && col < clen) {
                    int diff = Math.abs(heights[row][col] - heights[cell.row][cell.col]);
                    diff = Math.max(cell.effort, diff);
                    if (effort[row][col] > diff) {
                        effort[row][col] = diff;
                        pq.add(new Cell(row, col, diff));
                    }
                }
            }
        }

        return effort[rlen-1][clen-1];
    }
}
/*

	idea : init effort with max effort. then do bfs or dfs iif new distance is < stored distance.
		DFS was very slow, bfs worked well, can replaced queue with priority queue to make it more fast

*/
