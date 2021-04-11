import java.util.*;

/*
	https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
*/
class LongestIncreasingPathInMatrix {
	public static void main(String[] args) {
		int[][] matrix = { {3,4,5}, {3,2,6}, {2,2,1}};
		System.out.println(new Solution().longestIncreasingPath(matrix)); // 4
	}
}

class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] count = new int[m][n];

        int longestPath = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (count[i][j] == 0) {
                    dfs(i, j, count, matrix);
                }
                longestPath = Math.max(longestPath, count[i][j]);
            }
        }

        return longestPath;
    }

    private void dfs(int i, int j, int[][] count, int[][] matrix) {
        int largestNeighbor = 0;

        for(int[] next : largeNeighbors(i, j, matrix)) {
            int r = next[0];
            int c = next[1];

            if (count[r][c] == 0) {
                dfs(r, c, count, matrix);
            }

            largestNeighbor = Math.max(largestNeighbor, count[r][c]);
        }
        count[i][j] = largestNeighbor + 1;

    }

    private List<int[]> largeNeighbors(int i, int j, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<int[]> neighbors = new LinkedList<>();
        for(int[] d : directions) {
            int r = i + d[0];
            int c = j + d[1];

            if(r < m && r >= 0 && c < n && c >= 0 && matrix[r][c] > matrix[i][j])
                neighbors.add(new int[] { r, c});
        }

        return neighbors;
    }
}
