/*
	https://leetcode.com/problems/combination-sum-iv/
*/
class CombinationSumIV {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int target = 4;
		System.out.println(new Solution().combinationSum4(nums, target)); // 7
	}
}

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        for(int i = 0; i <= target; i++) cache[i] = -1;

        return helper(nums, target, cache);
    }

    private int helper(int[] nums, int target, int[] cache) {
        if(target == 0) {
            return 1;
        } else if ( cache[target] != -1) {
            return cache[target];
        } else {

            int res = 0;
            for(int num : nums) {
                if (target >= num) {
                    res += helper(nums, target - num, cache);
                }
            }
            cache[target] = res;
            return res;
        }
    }
}
