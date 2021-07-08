/*
	https://leetcode.com/problems/maximum-length-of-repeated-subarray/
*/
class MaximumLengthOfRepeatedSubarray {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,2,1};
		int[] nums2 = {3,2,1,4,7};

		System.out.println(new Solution().findLength(nums1, nums2)); // 3
	}
}

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        int max = 0;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                if(nums1[i] == nums2[j]) dp[i+1][j+1] = dp[i][j] + 1;

                max = Math.max(dp[i+1][j+1], max);
            }
        }
        return max;

    }
}
