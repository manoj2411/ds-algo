/*
        https://leetcode.com/problems/maximal-rectangle/
*/
class MaximalRectangle {
    public static void main(String[] args) {
        char[][] mat = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'},
        };

        System.out.println(new Solution().maximalRectangle(mat)); // 6

    }
}

/*
    intuition :
     make rowWidth matrix that contains info about each col of curr row,
     it answers the question :
      what is the max width/length of one's ending at curr col ?
    Calculate this for each row.

    Then for cell try include each previous rows to build the result
*/

class Solution {
    int R;
    int C;
    int[][] widths;

    public int maximalRectangle(char[][] matrix) {
        R = matrix.length;
        if ( R  == 0 ) return 0;
        C = matrix[0].length;

        widths = getWidthsMatrix(matrix);

        int max = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (widths[i][j] > 0) {
                    max = Math.max(max, maxArea(i, j));
                }
            }
        }

        return max;
    }

    private int[][] getWidthsMatrix(char[][] mat) {
        int[][] rowWidth = new int[R][C];

        for(int i = 0; i < R; i++) {

            rowWidth[i][0] = (mat[i][0] == '0') ? 0 : 1 ;

            for(int j = 1; j < C; j++)
                if (mat[i][j] == '1')
                rowWidth[i][j] = rowWidth[i][j - 1] + 1;
        }

        return rowWidth;
    }

    private int maxArea(int row, int col) {
        int height = 1;
        int width = widths[row][col];
        int max = 0;

        for(int i = row; i >= 0; i--, height++) {
            width = Math.min(width, widths[i][col]);
            max = Math.max(max, width * height);
        }
        return max;
    }
}
