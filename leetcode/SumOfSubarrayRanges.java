/*
	https://leetcode.com/problems/sum-of-subarray-ranges/
*/
class SumOfSubarrayRanges {
	public static void main(String[] args) {
		int[] nums = {1,3,2};
		System.out.println(new Solution().subArrayRanges(nums)); // 5
	}
}

class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;

        for(int i = 0; i < nums.length; i++) {

            int low = nums[i];
            int high = nums[i];

            for(int j = i; j < nums.length; j++) {
                low = Math.min(low, nums[j]);
                high = Math.max(high, nums[j]);
                sum += high - low;
            }
        }

        return sum;
    }
}
