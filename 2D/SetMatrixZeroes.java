import java.util.*;

/*
    https://leetcode.com/problems/set-matrix-zeroes/
*/
class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] m = {{1,1,1}, {1,0,1}, {1,1,1}};
        System.out.println("Original matrix: ");
        printMatrix(m);

        Solution sol = new Solution();
        sol.setZeroes(m);

        System.out.println("Final matrix: ");
        printMatrix(m);
    }

    static void printMatrix(int[][] m) {
        for(int[] row : m) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        boolean rowHasZero = false;
        for(int item : matrix[0]) {
            if(item == 0) {
                rowHasZero = true;
                break;
            }
        }

        boolean colHasZero = false;
        for(int i = 0; i < R; i++) {
            if(matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        for(int r = 1; r < R; r++) {
            for(int c = 1; c < C; c++) {
                if(matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }
        for(int r = 1; r < R; r++) {
            for(int c = 1; c < C; c++) {
                if(matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if(rowHasZero) {
            for(int i = 0; i < C; i++)
                matrix[0][i] = 0;
        }
        if(colHasZero) {
            for(int i = 0; i < R; i++)
                matrix[i][0] = 0;
        }
    }
}
