/*
	https://leetcode.com/problems/search-a-2d-matrix-ii/
*/
class Search2DMatrixII {
	public static void main(String[] args) {
		int[][] matrix = {
			{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}
		};

		System.out.println(new Solution().searchMatrix(matrix, 26)); // true
		System.out.println(new Solution().searchMatrix(matrix, 27)); // false
	}
}

class Solution {
    int maxr;
    int maxc;

    public boolean searchMatrix(int[][] matrix, int target) {
        maxr = matrix.length - 1;
        maxc = matrix[0].length - 1;

        int minr = 0, minc = 0;

        while(minr <= maxr && minc <= maxc) {

            if(searchRow(matrix, minr, target)) return true;

            if(searchCol(matrix, minc, target)) return true;

            minr++;
            minc++;

        }

        return false;
    }

    private boolean searchRow(int[][] matrix, int r, int target) {
        int left = 0;
        int right = maxc;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(matrix[r][mid] < target) {
                left = mid + 1;
            } else if (matrix[r][mid] > target) {
                right = mid - 1;
                maxc = right;
            }
            else {
                return true;
            }
        }

        return false;
    }

    private boolean searchCol(int[][] matrix, int c, int target) {
        int left = 0;
        int right = maxr;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(matrix[mid][c] < target) {
                left = mid + 1;
            } else if (matrix[mid][c] > target) {
                right = mid - 1;
                maxr = right;
            } else {
                return true;
            }
        }

        return false;
    }
}
