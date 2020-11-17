import java.util.*;

/*
        https://leetcode.com/problems/longest-mountain-in-array/
*/
class LongestMountainInArray {
    public static void main(String[] args) {
        int[][] inputs = {
            {2,1,4,7,3,2,5}, // 5
            {875,884,239,731,723,685}, // 4
            {2,1,4,7,3,25,5}, // 4
            {3,3}, // 0
            {1,3}, // 0
            {11,3}, // 0
        };
        for(int[] arr : inputs) {
            Solution sol = new Solution();
            System.out.println(Arrays.toString(arr));
            System.out.println(sol.longestMountain(arr));
        }
    }
}

class Solution {
    public int longestMountain(int[] A) {
        int result = 0;

        for(int i = 1; i < A.length; i++) {
            if(A[i] <= A[i-1]) {
                continue;
            }

            // Here we have increasing subarray now, so get its length
            int incrLen = 0;
            while(i < A.length && A[i] > A[i-1]) {
                incrLen++;
                i++;
            }

            // Now we want to find length of decreasing subarray
            int decrLen = 0;
            for(int j = i; j < A.length && A[j - 1] > A[j]; j++) {
                decrLen++;
                result = Math.max(result, incrLen + decrLen + 1);
                i = j; // change i because we included this item now in the result.
            }
        }

        return result;
    }
}
