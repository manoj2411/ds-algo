/*
	https://leetcode.com/problems/longest-increasing-subsequence/
*/
class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(new Solution().lengthOfLIS(nums)); // 4

		nums = new int[] {0,1,0,3,2,3};
		System.out.println(new Solution().lengthOfLIS(nums)); // 4
	}
}

class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;

        int res = 1;

        for(int i = 1; i < nums.length; i++) {
            int max_lis = 0;

            for(int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i])
                    max_lis = Math.max(max_lis, lis[j]);
            }

            lis[i] = max_lis + 1;
            res = Math.max(res, lis[i]);
        }

        return res;
    }

}
