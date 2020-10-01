import java.util.*;

/*
        https://leetcode.com/problems/first-missing-positive/
*/

class FirstMissingPositive {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] inputs = {
            {1,2,0},
            {1,2,3},
            {3,4,-1,1},
            {7,8,9,11,12}
        };
        for(int[] nums : inputs) {
            System.out.println(Arrays.toString(nums));
            System.out.println("firstMissingPositive: " + sol.firstMissingPositive(nums));
        }
    }

}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0) min = Math.min(min, nums[i]);

        if(min > 1) return 1;

        for(int i = 0; i < nums.length; i++)
            if(nums[i] < 1) nums[i] = 1;

        for(int i = 0; i < nums.length; i++) {
            int indx = Math.abs(nums[i]) - 1;
            if(indx < nums.length && nums[indx] > 0)
                nums[indx] = -nums[indx];
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                return i + 1;
        }
        return nums.length + 1;
    }
}
