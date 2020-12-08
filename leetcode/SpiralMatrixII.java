import java.util.*;

/*
		https://leetcode.com/problems/spiral-matrix-ii/
*/
class SpiralMatrixII {

	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println("Generate spiral matric for 3: ");
		int[][] result = sol.generateMatrix(3);
		print(result);

		System.out.println("Generate spiral matric for 2: ");
		result = sol.generateMatrix(2);
		print(result);
	}

	private static void print(int[][] m) {
		for(int[] row : m) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int start = 0;
        int end = n - 1;
        int num = 1;

        while(start < end) {

            for(int c = start; c < end; c++)
                m[start][c] = num++;

            for(int r = start; r < end; r++)
                m[r][end] = num++;

            for(int c = end; c > start; c--)
                m[end][c] = num++;

            for(int r = end; r > start; r--)
                m[r][start] = num++;

            start++;
            end--;
        }

        if(start == end)
            m[start][end] = num++;

        return m;
    }
}