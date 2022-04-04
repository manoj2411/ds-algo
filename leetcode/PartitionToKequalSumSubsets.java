/*
	https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
*/
class PartitionToKequalSumSubsets {
	public static void main(String[] args) {
		int[] nums = {85,35,40,64,86,45,63,16,5364,110,5653,97,95};
		int k = 7;
		System.out.println(new Solution().canPartitionKSubsets(nums, k)); // false

		nums = new int[] {4,3,2,3,5,2,1};
		k = 4;
		System.out.println(new Solution().canPartitionKSubsets(nums, k)); // true

	}
}


class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = findSum(nums);

        if (sum % k != 0) return false;

        int targetSum = sum / k;

        int[] groups = new int[k];

        return canSolve(nums, groups, 0, targetSum);
    }

	/*
		The idea is to create a k groups, and try to fit in the current element
		with existing non-empty groups or put in the current element in one of the
		empty group. If groups[i] is 0 means it is an empty group.
	*/
    boolean canSolve(int[] nums, int[] groups, int index, int target) {

        if (index == nums.length) {
            for(int sum : groups) {
                if (sum != target) return false;
            }
            return true;
        }


        for(int i = 0; i < groups.length; i++) {
            // try to fit current element with every group
            if (groups[i] + nums[index] <= target) {
                groups[i] += nums[index];
                if (canSolve(nums, groups, index + 1, target))
                    return true;
                groups[i] -= nums[index];

                // if groups[i] is 0 means it was an empty group and all next groups
                // will be empty also and the answer will not change
                if(groups[i] == 0) break;
            }
        }

        return false;
    }

    int findSum(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        return sum;
    }
}
