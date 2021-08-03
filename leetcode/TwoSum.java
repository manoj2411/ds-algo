import java.util.*;

/*
	https://leetcode.com/problems/two-sum/
*/
class TwoSum {
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;

		System.out.println(Arrays.toString(
			new Solution().twoSum(nums, target))); // 0, 1

		nums = new int[] {1,3,8,10,3,1};
		target = 6;
		System.out.println(Arrays.toString(
			new Solution().twoSum(nums, target))); // 1, 4
	}
}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> index = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            if (index.containsKey(target - nums[i]))
                return new int[] { index.get(target - nums[i]), i};

            index.put(nums[i], i);
        }

        return null;
    }
}
