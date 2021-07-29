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

    public int[][] updateMatrix(int[][] mat) {

        int M = mat.length;
        int N = mat[0].length;

        int[][] dist = new int[M][N];
        Queue<Cell> que = new LinkedList<>();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    que.add(new Cell(i, j, 0));
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
                int r = cell.r + dir[0];
                int c = cell.c + dir[1];

                if ( r >= 0 && r < M && c >= 0 && c < N && dist[r][c] == -1) {
                    dist[r][c] = cell.distance + 1;
                    que.add(new Cell(r, c, cell.distance + 1));
                }
            }
        }

        return dist;
    }
}

class Cell {
    int r;
    int c;
    int distance;
    Cell(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}
