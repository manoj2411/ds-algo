import java.util.*;
/*
    https://leetcode.com/problems/next-permutation/
*/
class NextPermutation {
    public static void main(String[] args) {
        int[][] input = {
            {1,2,3},
            {3,2,1},
            {1},
            {1,5,6,5,4},
            {1,5,6,4,2},
            {3,0,3,3,1,1},
            {3,2,3,3,1,1}
        };
        for(int[] nums : input) {
            System.out.println("nums: " + Arrays.toString(nums));
            new Solution().nextPermutation(nums);
            System.out.println("next permutation: " + Arrays.toString(nums));
            System.out.println();
        }
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int index = findFirstDecreasingFromRight(nums);

        if(index == -1) {
            Arrays.sort(nums);
            return;
        }

        int g = findGreaterThanKfromRight(nums, nums[index]);
        int tmp = nums[g];
        nums[g] = nums[index];
        nums[index] = tmp;

        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int j) {
        for(int i = nums.length - 1; i > j; i--, j++) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }

    private int findGreaterThanKfromRight(int[] nums, int k) {
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > k) return i;
        }
        return -1;
    }

    private int findFirstDecreasingFromRight(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i-1] < nums[i])
                return i-1;
        }
        return -1;
    }
}
