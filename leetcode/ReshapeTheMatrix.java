import java.util.*;
/*
	https://leetcode.com/problems/reshape-the-matrix/
*/
class ReshapeTheMatrix {
	public static void main(String[] args) {
		int[][] mat = {{1,2}, {3,4}};
		int r = 1;
		int c = 4;

		for(int[] row : new Solution().matrixReshape(mat, r, c)) {
			System.out.println(Arrays.toString(row));
		} // [1,2,3,4]
	}
}

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int M = mat.length;
        int N = mat[0].length;

        if (M * N != r * c) return mat;

        int[][] res = new int[r][c];

        int k = 0;
        int l = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                res[k][l++] = mat[i][j];

                if (l == c) {
                    l = 0;
                    k++;
                }
            }
        }
        return res;
    }
}
