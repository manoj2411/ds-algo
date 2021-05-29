import java.util.*;

/*
	https://leetcode.com/problems/maximum-erasure-value/
*/
class MaximumErasureValue {
	public static void main(String[] args) {
		int[][] input = {
			{3, 10, 10, 2, 1, 3, 1, 4, 3, 10}, // 18
			{4,2,4,5,6}, // 17
			{5,2,1,2,5,2,1,2,5}, // 8
		};

		for(int[] nums : input)
			System.out.println(new Solution().maximumUniqueSubarray(nums));

	}
}

class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        int start = 0;
        int currSum = nums[0];

        Map<Integer, Integer> lastIndex = new HashMap<>();
        lastIndex.put(nums[0], 0);

        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {

            int num = nums[i];
            currSum += num;

            if (lastIndex.containsKey(num) && lastIndex.get(num) >= start) {
                int newStart = lastIndex.get(num) + 1;
                for(int j = start; j < newStart; j++ ) currSum -= nums[j];
                start = newStart;
            }

            lastIndex.put(num, i);
            max = Math.max(currSum, max);

        }

        return max;
    }

}
