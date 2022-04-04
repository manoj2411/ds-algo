import java.util.*;

/*
	https://leetcode.com/problems/subarray-sum-equals-k/
*/
class SubarraySumEqualsK {
	public static void main(String[] args) {
		int[] nums = {1,1,1};
		int k = 2;
		System.out.println(new Solution().subarraySum(nums, k)); // 2

		nums = new int[] {1,2,3};
		k = 3;
		System.out.println(new Solution().subarraySum(nums, k)); // 2

		nums = new int[] {1,2,4,-2,-1,3,0,2};
		k = 2;
		System.out.println(new Solution().subarraySum(nums, k)); // 7
	}
}

class Solution {
    public int subarraySum(int[] nums, int k) {

        int result = 0;
        int sum = 0;

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for(int num : nums) {
            sum += num;

            result += prefixSumCount.getOrDefault(sum - k, 0);
            prefixSumCount.put(sum, 1 + prefixSumCount.getOrDefault(sum, 0));
        }

        return result;

    }
}
