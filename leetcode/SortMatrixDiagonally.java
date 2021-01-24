import java.util.*;
/*
    https://leetcode.com/problems/sort-the-matrix-diagonally/
*/
class SortMatrixDiagonally {
    public static void main(String[] args) {
        int[][] m = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};

        m = new Solution().diagonalSort(m);
        System.out.println("Diagonally sorted matrix: ");
        for(int[] row : m) {
            System.out.println(Arrays.toString(row));
        }
        /* Solution :
            [1,1,1,1]
            [1,2,2,2]
            [1,2,3,3]
        */
    }
}

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for(int r = 0; r < m; r++)
            sortThisDiagnal(mat, r, 0, m, n);

        for(int c = 1; c < n; c++)
            sortThisDiagnal(mat, 0, c, m, n);

        return mat;
    }

    void sortThisDiagnal(int[][]mat, int r, int c, int m, int n) {

        List<Integer> list = new ArrayList<>();

        for(int i = r, j = c; i < m && j < n; i++, j++)
            list.add(mat[i][j]);

        Collections.sort(list);
        for(int i = r, j = c, k = 0; i < m && j < n; i++, j++, k++)
            mat[i][j] = list.get(k);

    }
}
