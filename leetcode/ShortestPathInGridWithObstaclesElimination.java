import java.util.*;

/*
	https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
*/
class ShortestPathInGridWithObstaclesElimination {
	public static void main(String[] args) {
		int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		int k = 1;
		System.out.println(new Solution().shortestPath(grid, k)); // 6

		grid = new int[][] {{0,0,0},{1,1,0},{0,0,0},{1,1,1},{0,1,1},{0,0,0}};
		k = 1;
		System.out.println(new Solution().shortestPath(grid, k)); // 11

		grid = new int[][] {{0,1,1}, {1,1,1}, {1,0,0}};
		k = 1;
		System.out.println(new Solution().shortestPath(grid, k)); // -1

	}
}


class Solution {

    private static final int[][] DIRECTIONS = { {0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) return 0;

        boolean[][][] visited = new boolean[m][n][k + 1];

        Queue<Node> que = new LinkedList<>();

        que.add(new Node(0, 0, k, 0));

        while(!que.isEmpty()) {

            Node curr = que.poll();

            for(int[] dir : DIRECTIONS) {
                int r = curr.r + dir[0];
                int c = curr.c + dir[1];

                if (r < 0 || r == m || c < 0 || c == n) continue;

                if (r == m - 1 && c == n - 1) return curr.dist + 1;


                if(grid[r][c] == 0 && !visited[r][c][curr.k]) {
                    que.add(new Node(r, c, curr.k, curr.dist + 1));
                    visited[r][c][curr.k] = true;
                } else if (curr.k > 0 && !visited[r][c][curr.k-1]) {
                    que.add(new Node(r, c, curr.k - 1, curr.dist + 1));
                    visited[r][c][curr.k-1] = true;
                }

            }

        }

        return -1;
    }

    class Node {
        int r;
        int c;
        int k;
        int dist;
        Node(int r, int c, int k, int dist) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.dist = dist;
        }
    }
}
