/*
	https://leetcode.com/problems/partition-array-into-disjoint-intervals/
*/
class PartitionArrayIntoDisjointIntervals {
	public static void main(String[] args) {
		int[] nums = {5,0,3,8,6};
		System.out.println(new Solution().partitionDisjoint(nums)); // 3

		nums = new int[] {1,1,1,0,6,12};
		System.out.println(new Solution().partitionDisjoint(nums)); // 4

	}
}

class Solution {
    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];

        int max = -1;
        for(int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            leftMax[i] = max;
        }

        int min = 1000001;
        for(int i = len - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            rightMin[i] = min;
        }

        for(int i = 1; i < len; i++)
            if(leftMax[i-1] <= rightMin[i])
                return i;

        return 1;

    }

}
