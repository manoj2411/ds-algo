/*
	https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
*/
class MinValueToGetPositiveStepByStepSum {
	public static void main(String[] args) {
		int[] nums = {-3,2,-3,4,2};
		System.out.println(new Solution().minStartValue(nums)); // 5

		nums = new int[] {1,-2,-3};
		System.out.println(new Solution().minStartValue(nums)); // 5

		nums = new int[] {2,4};
		System.out.println(new Solution().minStartValue(nums)); // 1

	}
}

class Solution {
    public int minStartValue(int[] nums) {
        int min = nums[0];
        int currSum = min;
        for(int i = 1; i < nums.length; i++) {
            currSum = currSum + nums[i];
            min = Math.min(min, currSum);
        }

        if (min > 0) return 1;

        return Math.abs(min) + 1;
    }
}
