/*
	https://leetcode.com/problems/minimum-size-subarray-sum/description/
*/

class MinimumSizeSubarraySum {
	public static void main(String... args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(new Solution().minSubArrayLen(7, nums)); // 2

		nums = new int[] {1,1,1,1,1,1,1,1};
		System.out.println(new Solution().minSubArrayLen(11, nums)); // 0

		System.out.println(new Solution().minSubArrayLen(1, nums)); // 1
	}
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int first = 0;
        int last = 0;
        int curr =   nums[first];
        int min = Integer.MAX_VALUE;

        if (curr >= target) return 1;

        while(last < nums.length) {
            if (curr >= target) {
                curr -= nums[first++];
            } else {
                if (last + 1 < nums.length) {
                    curr += nums[++last];
                } else {
                    last++;
                }
            }

            if (curr >= target) {
                min = Math.min(last - first + 1, min);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
