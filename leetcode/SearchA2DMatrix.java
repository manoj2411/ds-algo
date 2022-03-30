/*
        https://leetcode.com/problems/search-a-2d-matrix/
*/
class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] m = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,50}
        };
        Solution sol = new Solution();

        System.out.println(sol.searchMatrix(m, 3));  // true
        System.out.println(sol.searchMatrix(m, 13)); // false
        System.out.println(sol.searchMatrix(m, 10)); // true
        System.out.println(sol.searchMatrix(m, 1));  // true
        System.out.println(sol.searchMatrix(m, 23)); // true
        System.out.println(sol.searchMatrix(m, 50)); // true
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = findRow(matrix, target);
        // System.out.println("row: " + row);

        return isExistsInRow(matrix, row, target);
    }

    boolean isExistsInRow(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[row].length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(matrix[row][mid] > target) {
                right = mid - 1;
            } else if(matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while(right - left > 1) {
            int mid = (left + right) / 2;

            if(matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return target >= matrix[right][0] ? right : left;
    }
}

class AlternateSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lastCol = matrix[0].length - 1;

        int row = 0;

        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][lastCol] >= target) {
                row = i;
                break;
            }
        }

        return Arrays.binarySearch(matrix[row], target) >= 0;
    }
}
