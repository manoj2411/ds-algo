import java.util.*;

/*
	https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
*/
class MinimizeTheMaximumDifferenceOfPairs {
	public static void main(String[] args) {
		int[] input1 = {0,5,3,4};
		System.out.println(new Solution().minimizeMax(input1, 0)); // 0

		int[] input2 = {1,5,3,3};
		System.out.println(new Solution().minimizeMax(input2, 2)); // 2

		int[] input3 = {1,6,3,3};
		System.out.println(new Solution().minimizeMax(input3, 1)); // 0

		int[] input4 = {10,1,2,7,1,3};
		System.out.println(new Solution().minimizeMax(input4, 2)); // 1

	}
}


class Solution {

    public int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int low = 0;
        int high = findMax(nums);

        while(low < high) {
            int mid = low + ((high - low) / 2);

            if (canSolve(nums, p, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int findMax(int[] nums) {
        int max = 0;
        for(int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }

    private boolean canSolve(int[] nums, int p, int target) {
        int count = 0;

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] <= target) {
                i++;
                count++;
                if (count == p) {
                    return true;
                }
            }
        }
        return false;
    }
}
