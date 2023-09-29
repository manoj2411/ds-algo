/*
	https://leetcode.com/problems/monotonic-array/description
*/
class MonotonicArray {
	public static void main(String... args) {
		int[] input1 = {1,2,2,3};
		System.out.println(new Solution().isMonotonic(input1)); // true

		int[] input2 = {6,5,4,4};
		System.out.println(new Solution().isMonotonic(input2)); // true

		int[] input3 = {1,3,2};
		System.out.println(new Solution().isMonotonic(input3)); // false
	}
}

class Solution {
    public boolean isMonotonic(int[] nums) {
        return  isIncreasing(nums) || isDecreasing(nums);
    }

    private boolean isIncreasing(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isDecreasing(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                return false;
            }
        }

        return true;
    }
}
