import java.util.*;

/*
    https://leetcode.com/problems/number-of-longest-increasing-subsequence/
*/
class CountLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[][] inputs = {
            {1,3,5,4,7}, //2
            {2,2,2,2,2} //5
        };

        for(int[] arr : inputs) {
            Solution sol = new Solution();
            System.out.println("Input: " + Arrays.toString(arr));
            System.out.println("Res: " + sol.findNumberOfLIS(arr));
        }
    }
}

class Solution {
    public int findNumberOfLIS(int[] nums) {

        int len = nums.length;

        if(len <= 1) {
            return len;
        }

        int[] sizes = new int[len];
        int[] count = new int[len];
        int longestSubSeq = 0;

        for(int i = 0; i < len; i++) {
            int currCount = 1;
            int subSeqSize = 0;

            for(int j = i - 1; j >= 0; j--) {

                if(nums[j] < nums[i]) {

                    if(sizes[j] > subSeqSize) { // set new subSeqSize
                        subSeqSize = sizes[j];
                        currCount = count[j];
                    } else if(sizes[j] == subSeqSize) {
                        currCount += count[j];
                    }

                }
            }
            count[i] = currCount;
            sizes[i] = subSeqSize + 1;
            if(sizes[i] > longestSubSeq) {
                longestSubSeq = sizes[i];
            }

        }
        // System.out.println("sizes: " + Arrays.toString(sizes));
        // System.out.println("count: " + Arrays.toString(count));

        int result = 0;
        for(int i = 0; i < len; i++) {
            if(sizes[i] == longestSubSeq) {
                result += count[i];
            }
        }
        return result;
    }
}
