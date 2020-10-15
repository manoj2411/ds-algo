import java.util.*;

/*
        https://leetcode.com/problems/house-robber-ii/
*/
class HouseRobberII {

    public static void main(String[] args) {
        int[][] inputs = {
            {2,3,2},
            {10,20},
            {10},
            {1,3,2,4},
            {1,2,3,1}
        };
        for(int[] nums : inputs) {
            Solution sol = new Solution();
            System.out.println("Nums: " + Arrays.toString(nums));
            System.out.println("Result: " + sol.rob(nums));
        }

    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int result1 = rob_util(nums, 0, nums.length - 2);
        int result2 = rob_util(nums, 1, nums.length - 1);
        return Math.max(result1, result2);
    }

    int rob_util(int[] nums, int start, int end) {
        int prev2 = nums[start];
        int prev1 = Math.max(prev2, nums[start + 1]);
        for(int i = start + 2; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
