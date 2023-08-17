import java.util.*;

/*
	https://leetcode.com/problems/01-matrix/
*/
class ZeroOneMatrix {
	public static void main(String[] args) {
		int[][] mat = { {0,0,0}, {0,1,0}, {1,1,1} };
		int[][] result = new Solution().updateMatrix(mat);

		for(int[] row : result)
			System.out.println(Arrays.toString(row));
		// Output:
		// [0,0,0]
		// [0,1,0]
		// [1,2,1]

	}
}

class Solution {
    private static final int[][] DIR = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    private record Cell(int row, int col) {}

    public int[][] updateMatrix(int[][] mat) {

        int M = mat.length;
        int N = mat[0].length;

        int[][] dist = new int[M][N];
        Queue<Cell> que = new LinkedList<>();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    que.add(new Cell(i, j));
                    dist[i][j] = 0;
                } else {
                    // -1 means not visited
                    dist[i][j] = -1;
                }
            }
        }


        while (!que.isEmpty()) {
            Cell cell = que.poll();

            for(int[] dir : DIR) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];

                if ( row >= 0 && row < M && col >= 0 && col < N && dist[row][col] == -1) {
                    dist[row][col] = dist[cell.row][cell.col] + 1;
                    que.add(new Cell(row, col));
                }
            }
        }

        return dist;
    }
}

