import java.util.Arrays;
/*
	https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/
class TwoSumIIWithArrSorted {
	public static void main(String[] args) {
		int[] numbers = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(
			new Solution().twoSum(numbers, target))); // [1,2]
	}
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }

        return new int[] {};
    }
}
