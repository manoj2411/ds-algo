import java.util.*;

/*
	https://leetcode.com/problems/rotate-image/
*/
class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

		new Solution().rotate(matrix);

		for(int[] row : matrix)
			System.out.println(Arrays.toString(row));

		// expected res: [[7,4,1],[8,5,2],[9,6,3]]
	}
}


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int[] tmp = new int[n];
        int first = 0;
        int last = n - 1;

        while (first < last) {

            // copy first col to tmp;
            for(int row = last, i = 0; row > first; row--, i++)
                tmp[i] = matrix[row][first];

            // System.out.println("copy first col to tmp: " + Arrays.toString(tmp));

            // set first row
            for(int col = first, i = 0; col < last; col++, i++) {
                int t = matrix[first][col];
                matrix[first][col] = tmp[i];
                tmp[i] = t;
            }
            // System.out.println("first row: " + Arrays.toString(tmp));

            // set last col
            for(int row = first, i = 0; row < last; row++, i++) {
                int t = matrix[row][last];
                matrix[row][last] = tmp[i];
                tmp[i] = t;
            }
            // System.out.println("last col: " + Arrays.toString(tmp));

            // set last row
            for(int col = last, i = 0; col > first; col--, i++) {
                int t = matrix[last][col];
                matrix[last][col] = tmp[i];
                tmp[i] = t;
            }
            // System.out.println("last row: " + Arrays.toString(tmp));

            //set first col
            for(int row = last, i = 0; row > first; row--, i++) {
                int t = matrix[row][first];
                matrix[row][first] = tmp[i];
                tmp[i] = t;
            }
            // System.out.println("first col: " + Arrays.toString(tmp));

            // shrink first & last
            first++;
            last--;

        }

    }
}
