import java.util.*;
/*
    https://leetcode.com/problems/arithmetic-slices/
*/
class ArithmeticSlices {
    public static void main(String[] args) {

        int[][] inputs = {
            {1,2,3,4}, // 3
            {1,2,3,6,9}, // 2
            {1,3,5,7,9}, // 6
            {}, // 0
            {1, 1, 2, 5, 7}, // 0
        };

        for(int[] arr : inputs) {
            System.out.println("A: " + Arrays.toString(arr));
            System.out.println("Arithmetic slices: " +
                new Solution().numberOfArithmeticSlices(arr));
            System.out.println();
        }
    }
}

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int[] counts = new int[A.length];

        for(int i = 2; i < A.length; i++) {
            int diff1 = A[i] - A[i-1];
            int diff2 = A[i-1] - A[i-2];

            if(diff1 == diff2) {
                counts[i] = counts[i-1] + 1;
                res += counts[i];
            }
        }

        return res;
    }
}
